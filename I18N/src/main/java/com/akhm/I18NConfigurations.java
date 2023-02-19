package com.akhm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;

@Configuration
public class I18NConfigurations {
	@Bean
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("message");
		return resourceBundleMessageSource;
	}
	@Bean
	public LocaleChangeInterceptor getLocaleChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	//@Bean
	public ControllerClassNameHandlerMapping getControllerClassNameHandlerMapping() {
		ControllerClassNameHandlerMapping controllerClassNameHandlerMapping=new ControllerClassNameHandlerMapping();
		Object[] interceptors=new Object[1];
		interceptors[0]=getLocaleChangeInterceptor();
		controllerClassNameHandlerMapping.setInterceptors(interceptors);
		return controllerClassNameHandlerMapping;
	}
}
