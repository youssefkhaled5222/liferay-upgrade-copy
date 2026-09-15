package com.ejada.telemoney.db.utils;

import com.ejada.telemoney.db.dto.importDtos.ChangeLogDTO;
import com.ejada.telemoney.db.dto.importDtos.ComponentEntryDto;
import com.ejada.telemoney.db.dto.importDtos.MetadataDTO;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletResponse;

public  final class ExportFileUtil {
    private static final Log LOG = LogFactoryUtil.getLog(ExportFileUtil.class);

    private static final String EXPORT_DIR = "export-packages";

    public static Path saveZipToServer(byte[] zipBytes, String componentType, String fileName) {
        try {
            String liferayHome = PropsUtil.get(PropsKeys.LIFERAY_HOME);
            Path exportDir = Paths.get(liferayHome, EXPORT_DIR, componentType);
            Files.createDirectories(exportDir);

            Path filePath = exportDir.resolve(fileName);
            Files.write(filePath, zipBytes);

            LOG.info("Export saved: path=" + filePath.toAbsolutePath() + ", size=" + zipBytes.length + " bytes, type=" + componentType);
            return filePath;
        } catch (IOException e) {
            LOG.error("Failed to save zip to server: fileName=" + fileName + ", componentType=" + componentType, e);
            throw new RuntimeException("Failed to save export zip to server", e);
        }
    }



    public static byte[]  exportToZip(String summary, List<ComponentEntryDto> components, User user, String type, String packageId) {
        LOG.info("Export started: type=" + type + ", packageId=" + packageId + ", componentCount=" + components.size() + ", userId=" + user.getUserId());

        ChangeLogDTO changeLog = buildChangeLog(summary, user);
        MetadataDTO metadata = buildMetadata(type, components, packageId);

        JSONObject changeLogJson = changeLogToJson(changeLog);
        JSONObject metadataJson  = metadataToJson(metadata);
        JSONArray dataJson = componentsToJson(components);

        String checksum = computeChecksum(changeLogJson, metadataJson, dataJson);
        metadataJson.put("checksum", checksum);
        metadata.setChecksum(checksum);

        byte[] zipBytes = buildZip(changeLogJson, metadataJson, dataJson);
        LOG.info("Export completed: type=" + type + ", packageId=" + packageId + ", checksum=" + checksum + ", zipSize=" + zipBytes.length + " bytes");
        return zipBytes;
    }

    private static ChangeLogDTO buildChangeLog(String summary, User user) {
        ChangeLogDTO changeLog = new ChangeLogDTO();
        changeLog.setSummary(summary);
        changeLog.setExportedAt(LocalDateTime.now(ZoneId.of("Asia/Riyadh")));
        changeLog.setExportedBy(buildExportedBy(user));
        return changeLog;
    }

    private static ChangeLogDTO.ExportedBy buildExportedBy(User user) {
        ChangeLogDTO.ExportedBy exportedBy = new ChangeLogDTO.ExportedBy();
        exportedBy.setUserId(user.getUserId());
        exportedBy.setUserName(user.getFullName());
        return exportedBy;
    }

    private static MetadataDTO buildMetadata(String type, List<ComponentEntryDto> components, String packageId) {
        MetadataDTO metadata = new MetadataDTO();
        metadata.setPackageId(packageId);
        metadata.setComponent(buildComponentMetadata(type, components.size()));
        return metadata;
    }

    private static MetadataDTO.Component buildComponentMetadata(String type, int componentCount) {
        MetadataDTO.Component componentMetadata = new MetadataDTO.Component();
        componentMetadata.setType(type);
        componentMetadata.setCount((long) componentCount);
        return componentMetadata;
    }



    public static JSONObject changeLogToJson(ChangeLogDTO changeLog) {
        JSONObject exportedBy = JSONFactoryUtil.createJSONObject();
        exportedBy.put("userId",   changeLog.getExportedBy().getUserId());
        exportedBy.put("userName", changeLog.getExportedBy().getUserName());

        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("summary",    changeLog.getSummary());
        json.put("exportedAt", changeLog.getExportedAt().toString());
        json.put("exportedBy", exportedBy);
        return json;
    }

    public static JSONObject metadataToJson(MetadataDTO metadata) {
        JSONObject component = JSONFactoryUtil.createJSONObject();
        component.put("type",  metadata.getComponent().getType());
        component.put("count", metadata.getComponent().getCount());

        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("packageId", metadata.getPackageId());
        json.put("checksum",  metadata.getChecksum());
        json.put("component", component);
        return json;
    }

    public static JSONArray componentsToJson(List<ComponentEntryDto> components) {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        for (ComponentEntryDto entry : components) {
            JSONObject obj = JSONFactoryUtil.createJSONObject();
            obj.put("data", entry.getData());
            obj.put("channelId",entry.getChannelId());
            obj.put("action", entry.getAction() != null ? entry.getAction() : "");
            obj.put("affectedEntityId",entry.getAffectedEntityId());
            array.put(obj);
        }
        return array;
    }

    public static byte[] buildZip(JSONObject changeLogJson, JSONObject metadataJson, JSONArray dataJson) {
        return buildZipWithAttachments(changeLogJson, metadataJson, dataJson, null);
    }

    public static byte[] buildZipWithAttachments(JSONObject changeLogJson, JSONObject metadataJson, JSONArray dataJson,
                                                  Map<String, byte[]> attachments) {
        int attachmentCount = attachments != null ? attachments.size() : 0;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ZipOutputStream zos = new ZipOutputStream(baos)) {

            addJsonEntry(zos, "changeLog.json", changeLogJson.toString());
            addJsonEntry(zos, "metadata.json",  metadataJson.toString());
            addJsonEntry(zos, "data.json",      dataJson.toString());

            if (attachments != null) {
                for (Map.Entry<String, byte[]> entry : attachments.entrySet()) {
                    addBinaryEntry(zos, entry.getKey(), entry.getValue());
                }
            }

            zos.finish();
            byte[] result = baos.toByteArray();

            return result;

        } catch (IOException e) {
            LOG.error("Failed to build ZIP: attachmentCount=" + attachmentCount, e);
            throw new RuntimeException("Failed to build export ZIP", e);
        }
    }

    private static void addBinaryEntry(ZipOutputStream zos, String entryPath, byte[] data) throws IOException {
        ZipEntry entry = new ZipEntry(entryPath);
        entry.setSize(data.length);
        zos.putNextEntry(entry);
        zos.write(data);
        zos.closeEntry();
    }

    private static void addJsonEntry(ZipOutputStream zos, String fileName, String jsonContent) throws IOException {
        byte[] jsonBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        ZipEntry entry = new ZipEntry(fileName);
        entry.setSize(jsonBytes.length);
        zos.putNextEntry(entry);
        zos.write(jsonBytes);
        zos.closeEntry();
    }

    public static void downloadZip(String summary, List<ComponentEntryDto> components, User user, String componentType,
                                   ActionRequest actionRequest, ActionResponse actionResponse) {
        downloadZipWithAttachments(summary, components, user, componentType, actionRequest, actionResponse, null);
    }

    public static void downloadZipWithAttachments(String summary, List<ComponentEntryDto> components, User user,
                                                   String componentType, ActionRequest actionRequest,
                                                   ActionResponse actionResponse, Map<String, byte[]> attachments) {

        String packageId = renameFile(componentType);
        LOG.info("Download started: type=" + componentType + ", packageId=" + packageId + ", componentCount=" + components.size() + ", userId=" + user.getUserId());
        byte[] zipBytes = exportToZipWithAttachments(summary, components, user, componentType, packageId, attachments);

        String fileName = packageId + ".zip";

        int maxSizeBytes = 15 * 1024 * 1024; // 15MB

        if (zipBytes.length > maxSizeBytes) {
            LOG.error("ZIP exceeds size limit: size=" + zipBytes.length + " bytes, limit=" + maxSizeBytes + " bytes, packageId=" + packageId);
            throw new IllegalStateException("ZIP file size exceeds the 10MB limit");
        }

        try {
            HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(actionResponse);
            httpResponse.setContentType("application/zip");
            httpResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            httpResponse.setContentLength(zipBytes.length);
            httpResponse.getOutputStream().write(zipBytes);
            httpResponse.getOutputStream().flush();
            LOG.info("Download completed: fileName=" + fileName + ", size=" + zipBytes.length + " bytes");
        } catch (IOException e) {
            LOG.error("Failed to write ZIP to response: fileName=" + fileName, e);
        }
        catch (IllegalStateException e) {
            LOG.error("Failed to download ZIP due to size limit: fileName=" + fileName, e);
            throw e;
        }
    }

    public static byte[] exportToZipWithAttachments(String summary, List<ComponentEntryDto> components, User user,
                                                     String type, String packageId, Map<String, byte[]> attachments) {
        int attachmentCount = attachments != null ? attachments.size() : 0;
        LOG.info("Export with attachments started: type=" + type + ", packageId=" + packageId + ", componentCount=" + components.size() + ", attachmentCount=" + attachmentCount + ", userId=" + user.getUserId());

        ChangeLogDTO changeLog = buildChangeLog(summary, user);
        MetadataDTO metadata = buildMetadata(type, components, packageId);

        JSONObject changeLogJson = changeLogToJson(changeLog);
        JSONObject metadataJson  = metadataToJson(metadata);
        JSONArray dataJson = componentsToJson(components);

        String checksum = computeChecksum(changeLogJson, metadataJson, dataJson);
        metadataJson.put("checksum", checksum);
        metadata.setChecksum(checksum);

        byte[] zipBytes = buildZipWithAttachments(changeLogJson, metadataJson, dataJson, attachments);
        LOG.info("Export with attachments completed: type=" + type + ", packageId=" + packageId + ", checksum=" + checksum + ", zipSize=" + zipBytes.length + " bytes");
        return zipBytes;
    }

    public static Map<String, byte[]> readAttachmentsFromZip(Path zipFilePath) {
        LOG.info("Reading attachments from zip: " + zipFilePath);
        Map<String, byte[]> attachments = new HashMap<>();
        try {
            byte[] zipBytes = Files.readAllBytes(zipFilePath);
            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().startsWith("attachments/") && !entry.isDirectory()) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        attachments.put(entry.getName(), baos.toByteArray());
                    }
                    zis.closeEntry();
                }
            }
            LOG.info("Attachments read: count=" + attachments.size() + ", zipPath=" + zipFilePath);
        } catch (IOException e) {
            LOG.error("Failed to read attachments from zip: " + zipFilePath, e);
        }
        return attachments;
    }

    public static JSONObject readMetadataJsonFromZip(Path zipFilePath) {
        LOG.info("Reading metadata.json from zip: " + zipFilePath);
        try {
            byte[] zipBytes = Files.readAllBytes(zipFilePath);
            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if ("metadata.json".equals(entry.getName())) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        String jsonContent = baos.toString(StandardCharsets.UTF_8.name());
                        return  JSONFactoryUtil.createJSONObject(jsonContent);
                    }
                    zis.closeEntry();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("metadata.json not found in zip: " + zipFilePath);
        } catch (IOException e) {
            LOG.error("Failed to read metadata.json from zip: " + zipFilePath, e);
            throw new RuntimeException("Failed to read metadata.json from zip", e);
        }
    }

    public static JSONObject readChangeLogJsonFromZip(Path zipFilePath) {
        LOG.info("Reading changeLog.json from zip: " + zipFilePath);
        try {
            byte[] zipBytes = Files.readAllBytes(zipFilePath);
            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if ("changeLog.json".equals(entry.getName())) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        String jsonContent = baos.toString(StandardCharsets.UTF_8.name());
                        return JSONFactoryUtil.createJSONObject(jsonContent);
                    }
                    zis.closeEntry();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("changeLog.json not found in zip: " + zipFilePath);
        } catch (IOException e) {
            LOG.error("Failed to read changeLog.json from zip: " + zipFilePath, e);
            throw new RuntimeException("Failed to read changeLog.json from zip", e);
        }
    }

    public static JSONArray readDataJsonFromZip(Path zipFilePath) {
        LOG.info("Reading data.json from zip: " + zipFilePath);
        try {
            byte[] zipBytes = Files.readAllBytes(zipFilePath);
            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if ("data.json".equals(entry.getName())) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[4096];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        String jsonContent = baos.toString(StandardCharsets.UTF_8.name());
                        JSONArray result = JSONFactoryUtil.createJSONArray(jsonContent);
                        LOG.info("data.json parsed: entryCount=" + result.length() + ", zipPath=" + zipFilePath);
                        return result;
                    }
                    zis.closeEntry();
                }
            } catch (JSONException e) {
                LOG.error("Failed to parse data.json content from zip: " + zipFilePath, e);
                throw new RuntimeException(e);
            }
            throw new RuntimeException("data.json not found in zip: " + zipFilePath);
        } catch (IOException e) {
            LOG.error("Failed to read data.json from zip: " + zipFilePath, e);
            throw new RuntimeException("Failed to read data.json from zip", e);
        }
    }

    public static String renameFile(String componentType) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Riyadh"));
        String timestamp = now.format(formatter);
        return componentType + "-EXPORT-" + timestamp;
    }
    public static String computeChecksum(JSONObject changeLogJson, JSONObject metadataJson, JSONArray dataJson) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            digest.update(changeLogJson.toString().getBytes(StandardCharsets.UTF_8));

            JSONObject metadataForHash = JSONFactoryUtil.createJSONObject(metadataJson.toString());
            metadataForHash.remove("checksum");
            digest.update(metadataForHash.toString().getBytes(StandardCharsets.UTF_8));
            digest.update(dataJson.toString().getBytes(StandardCharsets.UTF_8));
            byte[] hashBytes = digest.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            LOG.error("SHA-256 algorithm not available for checksum computation", e);
            throw new RuntimeException("Failed to compute checksum", e);
        } catch (JSONException e) {
            LOG.error("Failed to parse metadata JSON during checksum computation", e);
            throw new RuntimeException(e);
        }
    }

}