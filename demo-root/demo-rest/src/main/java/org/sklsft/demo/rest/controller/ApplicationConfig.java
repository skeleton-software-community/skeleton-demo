package org.sklsft.demo.rest.controller;

import javax.inject.Inject;

import org.sklsft.commons.log.AccessLogger;
import org.sklsft.commons.log.ErrorLogger;
import org.sklsft.commons.rest.aspect.correlation.RestRequestAspect;
import org.sklsft.commons.rest.aspect.logging.RestLoggingAspect;
import org.sklsft.commons.rest.exception.RestExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "org.sklsft.demo")
@EnableWebMvc
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class ApplicationConfig implements WebMvcConfigurer {

	@Bean
	public JndiTemplate jndiTemplate() {
		return new JndiTemplate();
	}
	
	@Inject
	private Environment env;
	
	@Inject
	private AccessLogger accessLogger;
	
	@Inject
	private ErrorLogger errorLogger;
	
	@Bean
	public RestExceptionHandler restExceptionHandler() {
		return new RestExceptionHandler();
	}
	
	@Bean
	public RestRequestAspect restRequestAspect() {
		return new RestRequestAspect();
	}
	
	@Bean
	public RestLoggingAspect restLoggingAspect() {
		RestLoggingAspect result = new RestLoggingAspect();
		result.setAccessLogger(accessLogger);
		result.setErrorLogger(errorLogger);
		result.setTraceRequestBody(Boolean.valueOf(env.getProperty("accessLog.traceRequestBody")));
		result.setTraceResponseBody(Boolean.valueOf(env.getProperty("accessLog.traceResponseBody")));
		return result;
	}
}