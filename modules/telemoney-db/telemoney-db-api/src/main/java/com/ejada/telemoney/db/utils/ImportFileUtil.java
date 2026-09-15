package com.ejada.telemoney.db.utils;

import com.ejada.telemoney.db.dto.importDtos.ChangeLogDTO;
import com.ejada.telemoney.db.dto.importDtos.ComponentEntryDto;
import com.ejada.telemoney.db.dto.importDtos.ImportResultDTO;
import com.ejada.telemoney.db.dto.importDtos.MetadataDTO;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class ImportFileUtil {

    private static final Log LOG = LogFactoryUtil.getLog(ImportFileUtil.class);

    public static ImportResultDTO parseZip(ActionRequest actionRequest,String type) throws IOException, JSONException {
        LOG.info("Import started: expectedType=" + type);
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile("importFile");

        if (file == null || file.length() == 0) {
            LOG.error("Import failed: no file uploaded or file is empty, expectedType=" + type);
            throw new IOException("No file uploaded or file is empty.");
        }

        LOG.info("Import file received: name=" + file.getName() + ", size=" + file.length() + " bytes");

        String changeLogContent = null;
        String metadataContent = null;
        String dataContent = null;
        Map<String, byte[]> attachmentFiles = new HashMap<>();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().startsWith("attachments/") && !entry.isDirectory()) {
                    // Read binary attachment file
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        baos.write(buffer, 0, len);
                    }
                    attachmentFiles.put(entry.getName(), baos.toByteArray());
                } else {
                    String content = readEntryContent(zis);

                    switch (entry.getName()) {
                        case "changeLog.json":
                            changeLogContent = content;
                            break;
                        case "metadata.json":
                            metadataContent = content;
                            break;
                        case "data.json":
                            dataContent = content;
                            break;
                        default:
                            LOG.warn("Unknown entry in ZIP: " + entry.getName());
                            break;
                    }
                }
                zis.closeEntry();
            }
        }

        LOG.info("ZIP extracted: attachmentCount=" + attachmentFiles.size() + ", hasChangeLog=" + (changeLogContent != null) + ", hasMetadata=" + (metadataContent != null) + ", hasData=" + (dataContent != null));

        validateRequiredFiles(changeLogContent, metadataContent, dataContent);

        ChangeLogDTO changeLog = parseChangeLog(changeLogContent);
        MetadataDTO metadata = parseMetadata(metadataContent);
        List<ComponentEntryDto> components = parseComponents(dataContent);

        if (metadata.getComponent().getType() == null || !metadata.getComponent().getType().equals(type)) {
            LOG.error("Import failed: type mismatch — expected=" + type + ", found=" + metadata.getComponent().getType() + ", packageId=" + metadata.getPackageId());
            throw new IOException("Component type mismatch. Expected: " + type + ", found: " + metadata.getComponent().getType());
        }

        if (metadata != null) {
            validateChecksum(metadata.getChecksum(), changeLogContent, metadataContent, dataContent);
        }

        ImportResultDTO result = new ImportResultDTO(changeLog, metadata, components);
        result.setAttachmentFiles(attachmentFiles);

        LOG.info("Import completed: type=" + type + ", packageId=" + metadata.getPackageId() + ", componentCount=" + components.size() + ", attachmentCount=" + attachmentFiles.size());
        return result;
    }

    private static void validateRequiredFiles(
            String changeLogContent,
            String metadataContent,
            String dataContent) throws IOException {

        if (changeLogContent == null) {
            LOG.error("Import validation failed: changeLog.json is missing from ZIP");
            throw new IOException("Required file 'changeLog.json' is missing from the ZIP archive.");
        }

        if (metadataContent == null) {
            LOG.error("Import validation failed: metadata.json is missing from ZIP");
            throw new IOException("Required file 'metadata.json' is missing from the ZIP archive.");
        }

        if (dataContent == null) {
            LOG.error("Import validation failed: data.json is missing from ZIP");
            throw new IOException("Required file 'data.json' is missing from the ZIP archive.");
        }
    }

    private static void validateChecksum(String expectedChecksum, String changeLogContent, String metadataContent, String dataContent) throws IOException, JSONException {
        if (expectedChecksum == null ) {
            LOG.error("Import validation failed: checksum is missing from metadata");
            throw new IOException("Checksum is missing from metadata.");
        }

        JSONObject changeLogJson = JSONFactoryUtil.createJSONObject(changeLogContent);
        JSONObject metadataJson = JSONFactoryUtil.createJSONObject(metadataContent);
        JSONArray dataJson = JSONFactoryUtil.createJSONArray(dataContent);

        String actualChecksum = ExportFileUtil.computeChecksum(changeLogJson, metadataJson, dataJson);

            if (!actualChecksum.equals(expectedChecksum)) {
                LOG.error("Import validation failed: checksum mismatch — expected=" + expectedChecksum + ", actual=" + actualChecksum);
                throw new IOException("Checksum validation failed. The file may be corrupted or tampered with.");
            }

        LOG.info("Checksum validation passed: checksum=" + expectedChecksum);
    }

    private static String readEntryContent(ZipInputStream zis) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = zis.read(buffer)) > 0) {
            baos.write(buffer, 0, len);
        }
        return baos.toString("UTF-8");
    }

    private static ChangeLogDTO parseChangeLog(String content) throws JSONException {
        if (content == null) {
            return null;
        }
        JSONObject json = JSONFactoryUtil.createJSONObject(content);
        ChangeLogDTO changeLog = new ChangeLogDTO();
        changeLog.setSummary(json.getString("summary", null));
        changeLog.setExportedAt(json.has("exportedAt") ? LocalDateTime.parse((json.getString("exportedAt"))) : null);

        if (json.has("exportedBy")) {
            JSONObject exportedByJson = json.getJSONObject("exportedBy");
            ChangeLogDTO.ExportedBy exportedBy = new ChangeLogDTO.ExportedBy();
            exportedBy.setUserId(exportedByJson.getLong("userId"));
            exportedBy.setUserName(exportedByJson.getString("userName", null));
            changeLog.setExportedBy(exportedBy);
        }
        return changeLog;
    }

    private static MetadataDTO parseMetadata(String content) throws JSONException {
        if (content == null) {
            return null;
        }
        JSONObject json = JSONFactoryUtil.createJSONObject(content);;
        MetadataDTO metadata = new MetadataDTO();
        metadata.setPackageId(json.getString("packageId", null));
        metadata.setChecksum(json.getString("checksum", null));

        if (json.has("component")) {
            JSONObject compJson = json.getJSONObject("component");
            MetadataDTO.Component component = new MetadataDTO.Component();
            component.setType(compJson.getString("type", null));
            component.setCount(compJson.getLong("count"));
            metadata.setComponent(component);
        }
        return metadata;
    }

    private static List<ComponentEntryDto> parseComponents(String content) throws JSONException {
        if (content == null) {
            return new ArrayList<>();
        }
        JSONArray array = JSONFactoryUtil.createJSONArray(content);
        List<ComponentEntryDto> components = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            ComponentEntryDto dto = new ComponentEntryDto();
            dto.setData(obj.has("data") ? obj.getJSONObject("data") : null);
            dto.setChannelId(obj.getLong("channelId"));
            dto.setAction(obj.getString("action", null));
            dto.setAffectedEntityId(obj.getLong("affectedEntityId"));
            components.add(dto);
        }
        return components;
    }
}

