package org.sklsft.demo.components;

import javax.inject.Inject;

import org.sklsft.commons.log.AccessLogger;
import org.sklsft.commons.log.ErrorLogger;
import org.sklsft.commons.text.serialization.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ComponentsConfig {

	@Inject
	private Environment env;

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper result = new ObjectMapper();
		result.setSerializationInclusion(Include.NON_NULL);
		result.registerModule(new JavaTimeModule());
		result.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
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
		ErrorLogger result = new ErrorLogger();
		result.setSerializer(jsonSerializer());
		result.setPrintErrorStackInRootLogger(env.getRequiredProperty("log.errorLogsInRootLogger", Boolean.class));
		return result;
	}
}
