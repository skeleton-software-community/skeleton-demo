package org.sklsft.demo.mvc.model.localization.list;

import java.io.Serializable;
import java.util.List;
import org.sklsft.demo.api.model.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.localization.views.basic.CountryBasicView;
import org.sklsft.demo.api.model.localization.views.full.CountryFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * auto generated list view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class CountryListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected List<CountryBasicView> countryList;
protected CountryFilter countryFilter = new CountryFilter();
protected CountryFullView selectedCountry;

/*
 * getters and setters
 */
public List<CountryBasicView> getCountryList() {
return countryList;
}
public void setCountryList(List<CountryBasicView> countryList) {
this.countryList = countryList;
}

public CountryFilter getCountryFilter() {
return countryFilter;
}
public void setCountryFilter(CountryFilter countryFilter) {
this.countryFilter = countryFilter;
}

public CountryFullView getSelectedCountry() {
return selectedCountry;
}
public void setSelectedCountry(CountryFullView selectedCountry) {
this.selectedCountry = selectedCountry;
}

/* Specific Code Start */
/* Specific Code End */
}
