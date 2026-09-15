package com.ejada.telemony.db.constants;

/**
 * User Story 5 - Global Component Versioning.
 *
 * <p>
 * Identifies the component whose approved configuration version is tracked in
 * the {@code GlobalVersion} table. The value stored in the
 * {@code componentName} column is the {@link #name()} of one of these
 * constants.
 * </p>
 */
public enum ComponentType {

	APP_VERSION,
	THEME,
	LANGUAGE,
	LOCALIZATION,
	FEATURE_TOGGLE,
	LOV,
	ASSET_MANAGEMENT,
	RESOURCE

}

