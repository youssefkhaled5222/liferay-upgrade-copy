package com.ejada.telemoney.resources.utils;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class FileValidatorUtil {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB

    /**
     * Content types that {@link MimeTypesUtil} (Tika) may legitimately report
     * for each allowed extension, when the file is detected from its bytes.
     *
     * <p>
     * Container based formats cannot always be narrowed down: an OLE2 document
     * may be reported as {@code application/x-tika-msoffice} and an OOXML
     * document as {@code application/x-tika-ooxml} or {@code application/zip},
     * so those generic types are accepted too. What matters is that the bytes
     * are of the expected family and never an executable or a script.
     * </p>
     */
    private static final Map<String, List<String>> EXPECTED_CONTENT_TYPES =
        buildExpectedContentTypes();

    private static final Pattern SVG_ROOT_PATTERN = Pattern.compile(
        "<svg[\\s>]", Pattern.CASE_INSENSITIVE);

    private static final Pattern SVG_UNSAFE_PATTERN = Pattern.compile(
        "<script|<foreignobject|<!entity|javascript:|\\son\\w+\\s*=",
        Pattern.CASE_INSENSITIVE);

    private static Map<String, List<String>> buildExpectedContentTypes() {
        Map<String, List<String>> expectedContentTypes = new HashMap<>();

        expectedContentTypes.put("pdf", Collections.singletonList("application/pdf"));
        expectedContentTypes.put(
            "doc",
            Arrays.asList(
                "application/msword", "application/x-tika-msoffice",
                "application/x-ole-storage"));
        expectedContentTypes.put(
            "docx",
            Arrays.asList(
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                "application/x-tika-ooxml", "application/zip"));
        expectedContentTypes.put("jpg", Collections.singletonList("image/jpeg"));
        expectedContentTypes.put("jpeg", Collections.singletonList("image/jpeg"));
        expectedContentTypes.put("png", Collections.singletonList("image/png"));
        expectedContentTypes.put(
            "svg",
            Arrays.asList(
                "image/svg+xml", "application/xml", "text/xml", "text/plain"));
        expectedContentTypes.put(
            "csv", Arrays.asList("text/csv", "text/plain"));
        expectedContentTypes.put(
            "xlsx",
            Arrays.asList(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                "application/x-tika-ooxml", "application/zip"));

        return Collections.unmodifiableMap(expectedContentTypes);
    }

    public static void validateImageFile(UploadPortletRequest uploadRequest, String fieldName) throws Exception {
        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png");
        List<String> allowedMimeTypes = Arrays.asList("image/jpeg", "image/png");

        validateFile(uploadRequest, fieldName, allowedExtensions, allowedMimeTypes);
    }

    public static void validateCSVorExcelFile(UploadPortletRequest uploadRequest, String fieldName) throws Exception {
        List<String> allowedExtensions = Arrays.asList("csv", "xlsx");
        List<String> allowedMimeTypes = Arrays.asList(
            "text/csv",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
        );

        validateFile(uploadRequest, fieldName, allowedExtensions, allowedMimeTypes);
    }

    public static void validateDocumentFile(UploadPortletRequest uploadRequest, String fieldName) throws Exception {
        List<String> allowedExtensions = Arrays.asList("pdf", "doc", "docx");
        List<String> allowedMimeTypes = Arrays.asList(
            "application/pdf",
            "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
        );

        validateFile(uploadRequest, fieldName, allowedExtensions, allowedMimeTypes);
    }

    /**
     * Validates an attachment uploaded for the "Blue App" channel.
     *
     * <p>
     * Blue App resources are always attachments and only accept the following
     * file types: pdf, doc, docx, jpg, jpeg and svg.
     * </p>
     */
    public static void validateBlueAppAttachmentFile(UploadPortletRequest uploadRequest, String fieldName)
        throws Exception {

        List<String> allowedExtensions = Arrays.asList("pdf", "doc", "docx", "jpg", "jpeg", "svg");
        List<String> allowedMimeTypes = Arrays.asList(
            "application/pdf",
            "application/msword",
            "application/x-msword",
            "application/vnd.ms-word",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "image/jpeg",
            "image/pjpeg",
            "image/svg+xml"
        );

        validateFile(uploadRequest, fieldName, allowedExtensions, allowedMimeTypes);
    }

    private static void validateFile(
        UploadPortletRequest uploadRequest,
        String fieldName,
        List<String> allowedExtensions,
        List<String> allowedMimeTypes
    ) throws Exception {

        File file = uploadRequest.getFile(fieldName);
        String fileName = uploadRequest.getFileName(fieldName);
        String mimeType = uploadRequest.getContentType(fieldName);

        String allowedTypesMessage = "Allowed file types: " + String.join(", ", allowedExtensions) + ".";

        if (file == null || !file.exists() || fileName == null || mimeType == null) {
            throw new Exception("The uploaded file is missing or invalid. " + allowedTypesMessage);
        }

        String lowerFileName = fileName.toLowerCase();

        int dotCount = lowerFileName.length() - lowerFileName.replace(".", "").length();
        if (dotCount != 1) {
            throw new Exception(
                "The file name \"" + fileName + "\" must contain exactly one '.' character.");
        }

        if (fileName.contains("\0")) {
            throw new Exception("Invalid file name: null byte detected.");
        }

        String extension = StringUtil.extractLast(fileName.toLowerCase(), '.');

        if (!allowedExtensions.contains(extension)) {
            throw new Exception(
                "The file type \"." + extension + "\" is not allowed. " + allowedTypesMessage);
        }

        if (!allowedMimeTypes.contains(mimeType)) {
            throw new Exception(
                "The file content type \"" + mimeType + "\" is not allowed. " + allowedTypesMessage);
        }

        if (file.length() > MAX_FILE_SIZE) {
            throw new Exception("The file size exceeds the maximum allowed limit (10 MB).");
        }

        if (lowerFileName.matches(".*\\.(exe|jsp|php|asp|aspx|sh|bat|dll)(\\..+)?$")) {
            throw new Exception("The file has a disallowed double extension. " + allowedTypesMessage);
        }

        // The extension and the content type above are both supplied by the
        // client and can be forged: the real content is checked last.
        validateFileContent(file, extension, allowedTypesMessage);
    }

    /**
     * Detects the type from the bytes of the file and makes sure it matches the
     * declared extension, so a renamed executable or script is rejected.
     */
    private static void validateFileContent(
        File file, String extension, String allowedTypesMessage
    ) throws Exception {

        List<String> expectedContentTypes = EXPECTED_CONTENT_TYPES.get(extension);

        if (expectedContentTypes == null) {
            return;
        }

        String detectedContentType = MimeTypesUtil.getContentType(file);

        if (detectedContentType != null) {
            detectedContentType = detectedContentType.toLowerCase();
        }

        if ((detectedContentType == null) || !expectedContentTypes.contains(detectedContentType)) {
            throw new Exception(
                "The file content does not match its \"." + extension + "\" extension. " +
                    allowedTypesMessage);
        }

        if ("svg".equals(extension)) {
            validateSvgContent(file);
        }
    }

    /**
     * An SVG is an XML document that the browser executes: scripts, event
     * handlers, external entities and embedded HTML are rejected.
     */
    private static void validateSvgContent(File file) throws Exception {
        String content = new String(
            Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

        if (!SVG_ROOT_PATTERN.matcher(content).find()) {
            throw new Exception("The SVG file does not contain a valid <svg> element.");
        }

        if (SVG_UNSAFE_PATTERN.matcher(content).find()) {
            throw new Exception(
                "The SVG file contains scripts or external references and cannot be uploaded.");
        }
    }
}
