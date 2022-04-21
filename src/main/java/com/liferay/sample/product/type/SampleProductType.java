package com.liferay.sample.product.type;

import com.liferay.commerce.product.type.CPType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Argil DX
 */
@Component(
	immediate = true,
	property = {
			  "commerce.product.type.display.order:Integer=16",
			   "commerce.product.type.name=example"
	},
	service = CPType.class
)
public class SampleProductType implements CPType {

	@Override
	public void deleteCPDefinition(long cpDefinitionId) throws PortalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLabel(Locale locale) {
		// TODO Auto-generated method stub
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

			return LanguageUtil.get(resourceBundle, "example-commerce-product-type");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "example";
	}

	// TODO enter required service methods

}