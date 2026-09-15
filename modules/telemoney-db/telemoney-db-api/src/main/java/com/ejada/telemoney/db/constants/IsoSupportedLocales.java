package com.ejada.telemoney.db.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.NotFoundException;

public enum IsoSupportedLocales {
	AR_SA(new Locale("ar", "SA"), "Arabic"),
	EU_ES(new Locale("eu", "ES"), "Basque"),
	BN_IN(new Locale("bn", "IN"), "Bengal"),
	BG_BG(new Locale("bg", "BG"), "Bulgarian"),
	CA_AD(new Locale("ca", "AD"), "Catalan (Andorra)"),
	CA_ES(new Locale("ca", "ES"), "Catalan (Spain)"),
	ZH_CN(Locale.SIMPLIFIED_CHINESE, "Chinese (Simplified)"),
	ZH_TW(Locale.TRADITIONAL_CHINESE, "Chinese (Traditional)"),
	HR_HR(new Locale("hr", "HR"), "Croatian"),
	CS_CZ(new Locale("cs", "CZ"), "Czech"),
	DA_DK(new Locale("da", "DK"), "Danish"),
	NL_NL(Locale.forLanguageTag("nl-NL"), "Dutch (Netherlands)"),
	NL_BE(new Locale("nl", "BE"), "Dutch (Belgium)"),
	EN_US(Locale.US, "English"),
	EN_GB(Locale.UK, "English (United Kingdom)"),
	EN_AU(new Locale("en", "AU"), "English (Australia)"),
	ET_EE(new Locale("et", "EE"), "Estonian"),
	FI_FI(new Locale("fi", "FI"), "Finnish"),
	FR_FR(new Locale("fr","FR"), "French (France)"),
	FR_CA(Locale.CANADA_FRENCH, "French (Canada)"),
	GL_ES(new Locale("gl", "ES"), "Galician"),
	DE_DE(Locale.GERMANY, "German (Germany)"),
	EL_GR(new Locale("el", "GR"), "Greek"),
	IW_IL(new Locale("iw", "IL"), "Hebrew"),
	HI_IN(new Locale("hi", "IN"), "Hindi"),
	HU_HU(new Locale("hu", "HU"), "Hungarian"),
	IN_ID(new Locale("in", "ID"), "Indonesian"),
	IT_IT(Locale.ITALY, "Italian (Italy)"),
	JA_JP(Locale.JAPAN, "Japanese"), KO_KR(Locale.KOREA, "Korean"),
	LO_LA(new Locale("lo", "LA"), "Lao"),
	LT_LT(new Locale("lt", "LT"), "Lithuanian"),
	ML_IN(new Locale("ml", "IN"), "Malayalam"),
	NE_IN(new Locale("ne", "IN"), "Nepal"),
	NB_NO(new Locale("nb", "NO"), "Norwegian Bokm�l"),
	FA_IR(new Locale("fa", "IR"), "Persian"),
	PL_PL(new Locale("pl", "PL"), "Polish"),
	PT_BR(new Locale("pt", "BR"), "Portuguese (Brazil)"),
	PT_PT(new Locale("pt", "PT"), "Portuguese (Portugal)"),
	RO_RO(new Locale("ro", "RO"), "Romanian"),
	RU_RU(new Locale("ru", "RU"), "Russian"),
	SR_RS(new Locale("sr", "RS"), "Serbian"),
	SR_RS_LATIN(new Locale("sr", "RS", "latin"), "Serbian (Latin)"),
	SL_SI(new Locale("sl", "SI"), "Slovenian"),
	SK_SK(new Locale("sk", "SK"), "Slovak"),
	ES_ES(new Locale("es", "ES"), "Spanish (Spain)"),
	SV_SE(new Locale("sv", "SE"), "Swedish"),
	TR_TR(new Locale("tr", "TR"), "Turkish"),
	UK_UA(new Locale("uk", "UA"), "Ukrainian"),
	UR_PK(new Locale("ur", "PK"), "Urdu"),
	VI_VN(new Locale("vi", "VN"), "Vietnamese"),
	TL_PH(new Locale("tl", "PH"), "Tagalog"),
	SI_LK(new Locale("si", "LK"), "Sinhala");


	private final Locale locale;
	private final String languageName;

	IsoSupportedLocales(Locale locale, String languageName) {
		this.locale = locale;
		this.languageName = languageName;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLanguageName() {
		return languageName;
	}

	public static Locale getLocaleByLanguageName(String languageName) {
		for (IsoSupportedLocales supportedLocale : IsoSupportedLocales.values()) {
			if (supportedLocale.getLanguageName().equalsIgnoreCase(languageName)
					|| supportedLocale.getLanguageName().contains(languageName)) {
				return supportedLocale.getLocale();
			}
		}

		throw new NotFoundException("Language name was not found within the supported languages.");
	}

	public static List<String> getAllLanguageNames() {
		List<String> languageNames = new ArrayList<>();
		for (IsoSupportedLocales supportedLocale : IsoSupportedLocales.values()) {
			languageNames.add(supportedLocale.getLanguageName());
		}
		return languageNames;
	}

	public static String getLanguageName(Locale locale) {
		for (IsoSupportedLocales supportedLocale : IsoSupportedLocales.values()) {
			if (supportedLocale.getLocale().equals(locale)){
				return supportedLocale.getLanguageName();
			}
		}
		throw new NotFoundException("Language name was not found within the supported languages.");

	}

}
