package com.ejada.telemoney.web.props;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
		property={
				"language.id =en_US",
		},
		service=ResourceBundle.class
	)
public class EnglishProperties extends ResourceBundle{
	private final ResourceBundle resource= ResourceBundle.getBundle("props.language_en",UTF8Control.INSTANCE);
	@Override
	public Enumeration<String> getKeys() {
		return resource.getKeys();
	}
	

	@Override
	protected Object handleGetObject(String key) {
		return resource.getObject(key);
	}
}
