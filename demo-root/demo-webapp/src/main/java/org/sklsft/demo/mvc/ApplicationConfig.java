package org.sklsft.demo.mvc;

import java.util.HashMap;
import java.util.Map;

import org.sklsft.commons.log.AccessLogger;
import org.sklsft.commons.log.ErrorLogger;
import org.sklsft.commons.mvc.ajax.AjaxMethodAspect;
import org.sklsft.commons.mvc.ajax.AjaxMethodExecutor;
import org.sklsft.commons.mvc.i18n.JsfLocaleManager;
import org.sklsft.commons.mvc.messages.JsfMessageHandler;
import org.sklsft.commons.mvc.redirection.JsfRedirectionHandler;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.commons.text.serialization.JsonSerializer;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "org.sklsft.demo")
@EnableWebMvc
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	@Bean
	public JndiTemplate jndiTemplate() {
		return new JndiTemplate();
	}
	
	
	@Bean
	public CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer result = new CustomScopeConfigurer();
		Map<String, Object> scopes = new HashMap<>();
		scopes.put(ViewScope.NAME, new ViewScope());
		result.setScopes(scopes);
		return result;
	}
	
	@Bean
	@SessionScope
	public JsfLocaleManager localeManager() {
		return new JsfLocaleManager();
	}

	@Bean
	public JsfMessageHandler messageHandler() {
		return new JsfMessageHandler();
	}

	@Bean
	public JsfRedirectionHandler redirectionHandler() {
		return new JsfRedirectionHandler();
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper result = new ObjectMapper();
		result.setSerializationInclusion(Include.NON_NULL);
		return result;
	}
	
	@Bean
	public JsonSerializer jsonSerializer() {
		JsonSerializer result = new JsonSerializer(objectMapper());
		return result;
	}
	
	@Bean
	public AccessLogger accessLogger() {
		AccessLogger result = new AccessLogger(jsonSerializer());
		return result;
	}
	
	@Bean
	public ErrorLogger errorLogger() {
		ErrorLogger result = new ErrorLogger(jsonSerializer());
		return result;
	}
	
	@Bean
	public AjaxMethodExecutor ajaxMethodExecutor() {
		AjaxMethodExecutor result = new AjaxMethodExecutor();
		result.setAccessLogger(accessLogger());
		result.setErrorLogger(errorLogger());
		result.setMessageHandler(messageHandler());
		return result;
	}
	
	@Bean
	public AjaxMethodAspect ajaxMethodAspect() {
		AjaxMethodAspect result = new AjaxMethodAspect();
		result.setExecutor(ajaxMethodExecutor());
		return result;
	}
}