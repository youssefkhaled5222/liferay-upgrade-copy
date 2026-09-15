package com.ejada.telemoney.db.constants;

import java.util.HashMap;
import java.util.Map;

public class TelemoneyConstants {

	public static final String USER_ACTION_ADD = "Add new ";
	public static final String USER_ACTION_UPDATE = "Update ";
	public static final String USER_ACTION_DELETE = "Delete ";
	public static final String USER_LOGS_RESOURCE = " resourse";
	public static final String USER_LOGS_Banner = " banner";
	public static final String USER_LOGS_BLOCK = " block";
	public static final String USER_LOGS_FEATURE_TOGGILING = " feature toggiling";
	public static final String USER_LOGS_LANGUAGE = " feature toggiling";
	public static final String USER_LOGS_LOCALIZATION = " localization";
	public static final String USER_LOGS_LISTOFVALUE = " list of value";
	public static final String USER_LOGS_PERSONA = " persona";
	public static final String USER_LOGS_THEME = " theme";
	public static final String USER_LOGS_APP_VERSION = " App Version ";
	public static Map<String, String> resourceTypeValue;

	private static void initializeResourceMap() {
		if (resourceTypeValue == null || resourceTypeValue.isEmpty()) {
			resourceTypeValue = new HashMap<String, String>();
			resourceTypeValue.put("1", "URL");
			resourceTypeValue.put("2", "Attatchment");
			resourceTypeValue.put("3", "terms and condition");
		}
	}

	public static String getResourceTypeValue(String resourceType) {
		initializeResourceMap();
		return resourceTypeValue.get(resourceType);
	}

	public static String LANGUAGE_ENGLISH_ID = "EN";
	public static String LANGUAGE_ENGLISH_NAME = "English";
	public static String LANGUAGE_ENGLISH_LOCAL = "en_US";
	public static String LANGUAGE_ARABIC_ID = "AR";
	public static String LANGUAGE_ARABIC_NAME = "Arabic";
	public static String LANGUAGE_ARABIC_LOCAL = "ar_SA";
	public static String STATUS_CODE_SUCCESS = "LR0000";
	public static String STATUS_DESC_SUCCESS = "Success";
	public static String STATUS_CODE_MISSING_PARAMETERS = "LR0001";
	public static String STATUS_DESC_MISSING_PARAMETERS = "Missing parameters in body";
	public static String STATUS_DESC_MISSING_QUERY_PARAM = "Missing Query Parameters";
	public static String STATUS_CODE_MISSING_LANGUAGE = "LR0002";
	public static String STATUS_DESC_MISSING_LANGUAGE = "Missing language in header";
	public static String STATUS_CODE_INVALID_PARAMETERS = "LR0003";
	public static String STATUS_DESC_INVALID_PARAMETERS = "Invalid parameters in body";
	public static String STATUS_CODE_INVALID_BODY = "LR0004";
	public static String STATUS_DESC_INVALID_BODY = "Invalid body json format";
	public static String STATUS_CODE_ERROR = "LR0005";
	public static String STATUS_DESC_GENERIC_ERROR = "Something went wrong";
	public static String STATUS_CODE_INVALID_HEADERS = "LR0006";
	public static String STATUS_DESC_INVALID_HEADERS = "Invalid Header Parameters";
	public static String STATUS_CODE_MISSING_CHANNEL = "LR0008";
	public static String STATUS_DESC_MISSING_CHANNEL = "Missing channel in header";
	public static String STATUS_CODE_UNKNOWN_LANGUAGE = "LR0009";
	public static String STATUS_DESC_UNKNOWN_LANGUAGE = "No Language exists called ";
	public static String STATUS_CODE_UNKNOWN_CHANNEL = "LR0010";
	public static String STATUS_DESC_UNKNOWN_CHANNEL = "No Channel exists with id ";
	public static String STATUS_CODE_UNKNOWN_RESOURCE_CODE = "LR0011";
	public static String STATUS_DESC_UNKNOWN_RESOURCE_CODE = "No Resource exists with id ";
	public static String STATUS_CODE_UNKNOWN_APP_VERSION_CODE = "LR0012";
	public static String STATUS_DESC_UNKNOWN_APP_VERSION_CODE = "No App Version exists with id ";
	public static String STATUS_CODE_UNKNOWN_APP_CONFIG_CODE = "LR0013";
	public static String STATUS_DESC_UNKNOWN_APP_CONFIG_CODE = "No App Config exists with environment ";
	public static String[] SEGMENT_NAMES = { "TAMAS", "Telemoney Express", "House Hold", "Ratibi", "Current Account",
			"Guest" };
	public static String DEFAULT_OFF_FEATURE_METHOD = "1"; // =>Disabled
	public static final String LANG_CODE = "001";
	public static final String NATIONALITY_CODE = "004";
	public static final String WEBCONTENT_IMAGE_TYPE = "image";
	public static final String WEBCONTENT_TEXT_TYPE = "text";
	public static final String WEBCONTENT_SEPERATOR_TYPE = "separator";

	public static final String WHITELIST_CODE = "Whitelist";
	public static final String SEGMENTS_CODE = "Segments";

}
