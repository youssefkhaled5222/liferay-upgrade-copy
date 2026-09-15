package com.ejada.telemoney.db.constants;

import java.util.Locale;

//TL_PH(new Locale("tl", "PH"), "Tagalog"),
//SI_LK(new Locale("si", "LK"), "Sinhala");
//IN_ID(new Locale("in", "ID"), "Indonesian")
public enum LanguageValues {
	EN("English", "en_US"), AR("Arabic", "ar_SA"), MA("Malayalam", "ml_IN"), HI("Hindi", "hi_IN"), UR("Urdu", "ur_PK"),
	NE("Nepal", "ne_IN"), BE("Bengal", "bn_IN"),TL("Tagalog","tl_ph"),SI("Sinhala","si_lk"),ID("Indonesian","IN_ID");
	private final String language;
	private String languageID;

	private LanguageValues(String language, String languageID) {
		this.language = language;
		this.languageID = languageID;
	}

	public String getLanguage() {
		return this.language;
	}

	public String getLanguageID() {
		return this.languageID;
	}
}
