/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.telemony.db.service.impl;

import com.ejada.telemoney.db.constants.TelemoneyConstants;
import com.ejada.telemony.db.service.base.CustomWebContentLocalServiceBaseImpl;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * The implementation of the custom web content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ejada.telemony.db.service.CustomWebContentLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomWebContentLocalServiceBaseImpl
 */
public class CustomWebContentLocalServiceImpl extends CustomWebContentLocalServiceBaseImpl {
	private static final Log LOG = LogFactoryUtil.getLog(CustomWebContentLocalServiceImpl.class);

	public JSONArray getWebContentByTagName(String tagName, String language) throws Exception {
		JSONArray body = JSONFactoryUtil.createJSONArray();
		long[] tagIds = AssetTagLocalServiceUtil.getTagIds(tagName);
		if (tagIds == null || tagIds.length == 0)
			throw new Exception("the tag name does not exist");
		long tagId = tagIds[0];
		List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil.getAssetTagAssetEntries(tagId);
		if (assetEntries == null || assetEntries.size() == 0)
			throw new Exception("the tag name is not assigned to any web contents");
		for (AssetEntry assetEntry : assetEntries) {
			try {
				JournalArticle webContent = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
				String contentXml = webContent.getContentByLocale(language);
				Document xml = SAXReaderUtil.read(contentXml);
				Element root = xml.getRootElement();
				List<Element> elementsList = root.elements("dynamic-element");
				convertXMLtoJSON(elementsList, body);
			} catch (Exception e) {
				LOG.warn("Skipping asset entry with classPK=" + assetEntry.getClassPK() + ": " + e.getMessage());
			}
		}
		return body;
	}

	private void convertXMLtoJSON(List<Element> elements, JSONArray body) throws Exception {
		int displayIndex = 0;
		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);
			String type = element.attribute("type").getValue();

			if ("fieldset".equals(type)) {
				List<Element> fieldsetChildren = element.elements("dynamic-element");
				if (fieldsetChildren == null || fieldsetChildren.isEmpty()) {
					continue;
				}

				List<Element> nonFieldsetChildren = new java.util.ArrayList<>();
				List<Element> fieldsetChildElements = new java.util.ArrayList<>();
				for (Element child : fieldsetChildren) {
					if ("fieldset".equals(child.attribute("type").getValue())) {
						fieldsetChildElements.add(child);
					} else {
						nonFieldsetChildren.add(child);
					}
				}

				if (nonFieldsetChildren.size() == 1 && !fieldsetChildElements.isEmpty()) {
					Element parentElement = nonFieldsetChildren.get(0);
					JSONObject obj = buildElementJSON(parentElement, displayIndex);

					JSONArray childsArray = JSONFactoryUtil.createJSONArray();
					for (Element fs : fieldsetChildElements) {
						List<Element> fsChildren = fs.elements("dynamic-element");
						if (fsChildren != null && !fsChildren.isEmpty()) {
							convertXMLtoJSON(fsChildren, childsArray);
						}
					}
					if (childsArray.length() > 0) {
						obj.put("childs", childsArray);
					}
					body.put(obj);
					displayIndex++;
				} else {
					convertXMLtoJSON(fieldsetChildren, body);
				}
				continue;
			}

			JSONObject obj = buildElementJSON(element, displayIndex);
			body.put(obj);
			displayIndex++;
		}
	}

	private JSONObject buildElementJSON(Element element, int displayIndex) throws Exception {
		String type = element.attribute("type").getValue();
		// Use field-reference attribute if available, otherwise fall back to name
		String fieldReference = element.attributeValue("field-reference");
		String name = element.attribute("name").getValue();
		String effectiveName = (fieldReference != null && !fieldReference.isEmpty()) ? fieldReference : name;

		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("type", type);

		if (effectiveName.equals("componentName")) {
			obj.put("value", element.element("dynamic-content").getText().trim());
		} else if (type.equals(TelemoneyConstants.WEBCONTENT_SEPERATOR_TYPE)) {
			obj.put("value", effectiveName);
			obj.put("index", displayIndex);
		} else {
			obj.put("displayValue", element.element("dynamic-content").getText().trim());
			obj.put("index", displayIndex);
		}

		if (obj.get("type").equals(TelemoneyConstants.WEBCONTENT_IMAGE_TYPE)
				&& !obj.getString("displayValue").isEmpty()) {
			try {
				JSONObject img = JSONFactoryUtil.createJSONObject(obj.getString("displayValue"));
				long fileEntryId = img.getLong("fileEntryId");
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
				InputStream inputStream = fileEntry.getContentStream();
				byte[] bytes = IOUtils.toByteArray(inputStream);
				String img64 = Base64.getEncoder().encodeToString(bytes);
				obj.put("displayValue", img64);
				obj.put("mimeType", fileEntry.getMimeType());
			} catch (Exception e) {
				LOG.info("--------------- ERROR IN CONVERTING IMAGE INTO BASE64 ---------------");
				LOG.error(e.getMessage());
				obj.put("displayValue", "");
				obj.put("mimeType", "");
			}
		}

		return obj;
	}

}