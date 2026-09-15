package com.ejada.telemoney.banners.utils;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileValidatorUtil {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB

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

    private static void validateFile(
        UploadPortletRequest uploadRequest,
        String fieldName,
        List<String> allowedExtensions,
        List<String> allowedMimeTypes
    ) throws Exception {

        File file = uploadRequest.getFile(fieldName);
        String fileName = uploadRequest.getFileName(fieldName);
        String mimeType = uploadRequest.getContentType(fieldName);

        if (file == null || !file.exists() || fileName == null || mimeType == null) {
            throw new Exception("Uploaded file is missing or invalid.");
        }
        
        String lowerFileName = fileName.toLowerCase();

        int dotCount = lowerFileName.length() - lowerFileName.replace(".", "").length();
        if (dotCount != 1) {
            throw new Exception("Filename must contain exactly one '.' character.");
        }
        
        if (fileName.contains("\0")) {
            throw new Exception("Invalid file name. Null byte detected.");
        }

        String extension = StringUtil.extractLast(fileName.toLowerCase(), '.');

        if (!allowedExtensions.contains(extension)) {
            throw new Exception("File extension not allowed: " + extension);
        }

        if (!allowedMimeTypes.contains(mimeType)) {
            throw new Exception("MIME type not allowed: " + mimeType);
        }

        if (file.length() > MAX_FILE_SIZE) {
            throw new Exception("File size exceeds the maximum allowed limit (10 MB).");
        }

        if (fileName.matches(".*\\.(exe|jsp|php|asp|aspx|sh|bat|dll)(\\..+)?$")) {
            throw new Exception("File with disallowed double extension detected.");
        }
    }
}
