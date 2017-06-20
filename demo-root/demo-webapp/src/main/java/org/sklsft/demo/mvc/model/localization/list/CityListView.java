package org.sklsft.demo.mvc.model.localization.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.sortings.CitySorting;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.localization.views.full.CityFullView;
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
public class CityListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected ScrollForm<CityFilter, CitySorting> scrollForm = new ScrollForm<>();
protected ScrollView<CityBasicView> scrollView = new ScrollView<>();
protected CityFullView selectedCity;

/*
 * getters and setters
 */
public ScrollView<CityBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<CityBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<CityFilter, CitySorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<CityFilter, CitySorting> scrollForm) {
this.scrollForm = scrollForm;
}

public CityFullView getSelectedCity() {
return selectedCity;
}
public void setSelectedCity(CityFullView selectedCity) {
this.selectedCity = selectedCity;
}

/* Specific Code Start */
/* Specific Code End */
}
