package com.liferay.sample.product.type.frontend;

import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationCategory;
import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    property = {
	    "screen.navigation.category.order:Integer=11",
	    "screen.navigation.entry.order:Integer=11"
	    },
	    service = {ScreenNavigationCategory.class, ScreenNavigationEntry.class})

public class ExampleScreenNavigationEntry implements ScreenNavigationCategory, ScreenNavigationEntry<CPDefinition> {

	@Override
	public String getEntryKey() {
		// TODO Auto-generated method stub
		return "example";
	}

	@Override
	public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		
		_jspRenderer.renderJSP(
				_servletContext, httpServletRequest, httpServletResponse,
				"/example.jsp");
		
	}

	@Override
	public String getCategoryKey() {
		// TODO Auto-generated method stub
		return "example";
	}

	@Override
	public String getLabel(Locale locale) {
		// TODO Auto-generated method stub
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", locale, getClass());

			return LanguageUtil.get(resourceBundle, "example-screen-navigation-entry");
	}

	@Override
	public String getScreenNavigationKey() {
		// TODO Auto-generated method stub
		return "cp.definition.general";
	}
	
	@Override
	public boolean isVisible(User user, CPDefinition cpDefinition) {
	    if (cpDefinition == null) {
	        return false;
	    }

	    return Objects.equals(
	        cpDefinition.getProductTypeName(), getCategoryKey());
	}
	
	@Reference
	private JSPRenderer _jspRenderer;
	
	@Reference(target = "(osgi.web.symbolicname=com.liferay.sample.product.type)")
	private ServletContext _servletContext;

} 
