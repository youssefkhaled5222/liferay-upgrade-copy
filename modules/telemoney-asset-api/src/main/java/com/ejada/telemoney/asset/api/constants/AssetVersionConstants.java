package com.ejada.telemoney.asset.api.constants;

/**
 * User Story 7.2 - Folder and Global Versions.
 *
 * <p>
 * The assets returned by the asset API are the Blue App attachments managed by
 * the Resources module. An approved Blue App resource change bumps the
 * {@code ASSET_MANAGEMENT} version of the channel, which is what the API
 * returns as {@code "Version"}. Draft, pending, rejected and cancelled changes
 * never bump it.
 * </p>
 */
public final class AssetVersionConstants {

	public static final String GLOBAL_COMPONENT_NAME = "ASSET_MANAGEMENT";

	private AssetVersionConstants() {
	}

}
