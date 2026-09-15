package com.ejada.telemoney.biller.portlet;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "productivity",
						scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE)
@Meta.OCD(id = "com.ejada.telemoney.biller.portlet.ViewBillerConfiguration")
public interface ViewBillerConfiguration {
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/biller-details",
		    name = "getAllBillers",
		    required = false
		)
    String getAllBillers();

	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/biller-modification",
		    name = "updateBiller",
		    required = false
		)
    String updateBiller();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/biller-creation",
		    name = "addBiller",
		    required = false
		)
    String addBiller();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/payment-type-inq",
		    name = "getAllPaymentTypes",
		    required = false
		)
    String getAllPaymentTypes();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/biller-deletion",
		    name = "deleteBiller",
		    required = false
		)
    String deleteBiller();
	
	@Meta.AD(
		    deflt = "",
		    name = "defaultBillerId",
		    required = false
		)
    String defaultBillerId();
	
	@Meta.AD(
		    deflt = "",
		    name = "defaultBillerName",
		    required = false
		)
    String defaultBillerName();
	
	@Meta.AD(
		    deflt = "1",
		    name = "defaultBillerCategoryId",
		    required = false
		)
    String defaultBillerCategoryId();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/category-inq",
		    name = "getAllBillerCategory",
		    required = false
		)
    String getAllBillerCategory();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/category-creation",
		    name = "addBillerCategory",
		    required = false
		)
    String addBillerCategory();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/configuration/category-modification",
		    name = "updateBillerCategory",
		    required = false
		)
    String updateBillerCategory();
	
	@Meta.AD(
		    deflt = "http://192.168.215.114:17434/api/v1/category-deletion",
		    name = "deleteBillerCategory",
		    required = false
		)
    String deleteBillerCategory();
	
	@Meta.AD(
		    deflt = "http://localhost:3000/body",
		    name = "getAllBillerCategoryTest",
		    required = false
		)
    String getAllBillerCategoryTest();
}

