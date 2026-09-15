package com.ejada.telemoney.web.props;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
		property={
				"language.id =ar_SA",
		},
		service=ResourceBundle.class
	)
public class ArabicProperties extends ResourceBundle{
	private final ResourceBundle resource= ResourceBundle.getBundle("props.language_ar",UTF8Control.INSTANCE);
	@Override
	public Enumeration<String> getKeys() {
		return resource.getKeys();
	}

	@Override
	protected Object handleGetObject(String key) {
		return resource.getObject(key);
	}

}
