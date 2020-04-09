package org.sklsft.demo.components;

import org.sklsft.commons.log.AccessLogger;
import org.sklsft.commons.log.ErrorLogger;
import org.sklsft.commons.text.serialization.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ComponentsConfig {

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
}