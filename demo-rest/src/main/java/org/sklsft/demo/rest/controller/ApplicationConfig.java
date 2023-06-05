package org.sklsft.demo.rest.controller;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.log.AccessLogger;
import org.sklsft.commons.log.ErrorLogger;
import org.sklsft.commons.rest.aspect.correlation.RestRequestAspect;
import org.sklsft.commons.rest.aspect.logging.RestLoggingAspect;
import org.sklsft.commons.rest.exception.RestExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig implements WebMvcConfigurer {
	
	@Inject
	private Environment env;
	
	@Inject
	private ObjectMapper objectMapper;
 
	@Inject
	private AccessLogger accessLogger;
 
	@Inject
	private ErrorLogger errorLogger;
	
	@Bean
	public RestExceptionHandler restExceptionHandler() {
		RestExceptionHandler result = new RestExceptionHandler();
		result.setPrintErrorStackInRootLogger(env.getRequiredProperty("accessLog.printErrorStack", Boolean.class));
		return result;
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
		result.setTraceRequestBody(Boolean.valueOf(env.getRequiredProperty("accessLog.traceRequestBody", Boolean.class)));
		result.setTraceResponseBody(Boolean.valueOf(env.getRequiredProperty("accessLog.traceResponseBody", Boolean.class)));
		return result;
	}
	
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		converters.removeIf(e -> e instanceof StringHttpMessageConverter);
		
		for (HttpMessageConverter<?> converter:converters) {
			if (converter instanceof MappingJackson2HttpMessageConverter) {
				((MappingJackson2HttpMessageConverter) converter).setObjectMapper(objectMapper);
			}
		}
	}
}