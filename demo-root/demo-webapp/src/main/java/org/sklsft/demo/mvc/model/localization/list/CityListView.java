package org.sklsft.demo.mvc.model.localization.list;

import java.io.Serializable;
import java.util.List;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.ordering.CityOrdering;
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
protected List<CityBasicView> cityList;
protected CityFilter cityFilter = new CityFilter();
protected CityFullView selectedCity;

/*
 * getters and setters
 */
public List<CityBasicView> getCityList() {
return cityList;
}
public void setCityList(List<CityBasicView> cityList) {
this.cityList = cityList;
}

public CityFilter getCityFilter() {
return cityFilter;
}
public void setCityFilter(CityFilter cityFilter) {
this.cityFilter = cityFilter;
}

public CityFullView getSelectedCity() {
return selectedCity;
}
public void setSelectedCity(CityFullView selectedCity) {
this.selectedCity = selectedCity;
}

/* Specific Code Start */

private ScrollForm<CityFilter, CityOrdering> scrollForm = new ScrollForm<>();
private ScrollView<CityBasicView> scrollView = new ScrollView<>();

public ScrollForm<CityFilter, CityOrdering> getScrollForm() {
	return scrollForm;
}
public void setScrollForm(ScrollForm<CityFilter, CityOrdering> scrollForm) {
	this.scrollForm = scrollForm;
}
public ScrollView<CityBasicView> getScrollView() {
	return scrollView;
}
public void setScrollView(ScrollView<CityBasicView> scrollView) {
	this.scrollView = scrollView;
}

/* Specific Code End */
}
