package org.sklsft.demo.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.api.interfaces.localization.CountryService;
import org.sklsft.demo.api.interfaces.organizations.OrganizationService;
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
private OrganizationService organizationService;
@Inject
private FoolService foolService;

/**
 * load options for Country
 */
public void loadCountryOptions() {
List<SelectItem> options = this.countryService.getOptions();
this.commonView.setCountryOptions(options);
}

/**
 * load options for Calendar
 */
public void loadCalendarOptions() {
List<SelectItem> options = this.calendarService.getOptions();
this.commonView.setCalendarOptions(options);
}

/**
 * search options for Organization
 */
public List<String> searchOrganizationOptions(String arg) {
List<SelectItem> options = this.organizationService.searchOptions(arg);
List<String> result = new ArrayList<>(options.size());
for (SelectItem option : options) {
result.add(option.getKey());
}
return result;
}

/**
 * search options for Fool
 */
public List<String> searchFoolOptions(String arg) {
List<SelectItem> options = this.foolService.searchOptions(arg);
List<String> result = new ArrayList<>(options.size());
for (SelectItem option : options) {
result.add(option.getKey());
}
return result;
}

/* Specific Code Start */
/* Specific Code End */
}
