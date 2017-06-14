package org.sklsft.demo.mvc.filter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sklsft.commons.text.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomFilter {

	private SimpleDateFormat dateFormat;
	
	public CustomFilter() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public boolean filterDate(Date value, String filter) {
		if (StringUtils.isEmpty(filter)) {
			return true;
		}
		if (value == null) {
			return false;
		}
		return dateFormat.format(value).toLowerCase().contains(filter.toLowerCase());
	}
	
	public boolean filterBoolean(Boolean value, String filter) {
		if (StringUtils.isEmpty(filter)) {
			return true;
		}
		if (value == null) {
			return false;
		}
		return value.toString().toLowerCase().contains(filter.toLowerCase());
	}			
}