package org.sklsft.demo.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.api.interfaces.localization.CountryService;
import org.sklsft.demo.api.interfaces.time.CalendarService;
import org.sklsft.demo.mvc.model.CommonView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * auto generated common controller class file
 * <br/>used for loading select items
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CommonController {

/*
 * the view handled by the controller
 */
@Inject
private CommonView commonView;

/*
 * the services used by the controller
 */
@Inject
private CountryService countryService;
@Inject
private CalendarService calendarService;
@Inject
private FoolService foolService;

/**
 * load combobox items for Country
 */
public void loadCountryOptions() {
List<SelectItem> result = new ArrayList<>();
result.add(new SelectItem(null,""));
List<String> options = this.countryService.getOptions();
if (options != null){
for (String option:options){
result.add(new SelectItem(option));
}
}
this.commonView.setCountryOptions(result);
}

/**
 * load combobox items for Calendar
 */
public void loadCalendarOptions() {
List<SelectItem> result = new ArrayList<>();
result.add(new SelectItem(null,""));
List<String> options = this.calendarService.getOptions();
if (options != null){
for (String option:options){
result.add(new SelectItem(option));
}
}
this.commonView.setCalendarOptions(result);
}

/**
 * load combobox items for Fool
 */
public void loadFoolOptions() {
List<SelectItem> result = new ArrayList<>();
result.add(new SelectItem(null,""));
List<String> options = this.foolService.getOptions();
if (options != null){
for (String option:options){
result.add(new SelectItem(option));
}
}
this.commonView.setFoolOptions(result);
}

/* Specific Code Start */
/* Specific Code End */
}
