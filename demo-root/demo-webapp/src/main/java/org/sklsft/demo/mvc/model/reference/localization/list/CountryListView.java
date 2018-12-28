package org.sklsft.demo.mvc.model.reference.localization.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.reference.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.CountrySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CountryBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CountryFullView;
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
protected ScrollForm<CountryFilter, CountrySorting> scrollForm = new ScrollForm<>();
protected ScrollView<CountryBasicView> scrollView = new ScrollView<>();
protected CountryFullView selectedCountry = new CountryFullView();

/*
 * getters and setters
 */
public ScrollView<CountryBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<CountryBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<CountryFilter, CountrySorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<CountryFilter, CountrySorting> scrollForm) {
this.scrollForm = scrollForm;
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
