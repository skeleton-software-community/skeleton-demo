package org.sklsft.demo.mvc.model;

import java.io.Serializable;
import java.util.List;

import org.sklsft.commons.api.model.SelectItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * auto generated common view class file
 * <br/>used for select items
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class CommonView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private List<SelectItem>countryOptions;
private List<SelectItem>calendarOptions;

/*
 * getters and setters
 */
public List<SelectItem> getCountryOptions() {
return countryOptions;
}
public void setCountryOptions(List<SelectItem> countryOptions) {
this.countryOptions = countryOptions;
}

public List<SelectItem> getCalendarOptions() {
return calendarOptions;
}
public void setCalendarOptions(List<SelectItem> calendarOptions) {
this.calendarOptions = calendarOptions;
}

/* Specific Code Start */
/* Specific Code End */
}
