package org.sklsft.demo.mvc.model.reference.localization.detail;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CityFullView;
import org.sklsft.demo.api.model.reference.localization.views.full.RegionFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class RegionDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private RegionFullView selectedRegion = new RegionFullView();

protected ScrollForm<CityFilter, CitySorting> cityScrollForm = new ScrollForm<>();
protected ScrollView<CityBasicView> cityScrollView = new ScrollView<>();
private CityFullView selectedCity = new CityFullView();

/*
 * getters and setters
 */
public RegionFullView getSelectedRegion() {
return selectedRegion;
}
public void setSelectedRegion(RegionFullView selectedRegion) {
this.selectedRegion = selectedRegion;
}

public ScrollView<CityBasicView> getCityScrollView() {
return cityScrollView;
}
public void setCityScrollView(ScrollView<CityBasicView> cityScrollView) {
this.cityScrollView = cityScrollView;
}

public ScrollForm<CityFilter, CitySorting> getCityScrollForm() {
return cityScrollForm;
}
public void setCityScrollForm(ScrollForm<CityFilter, CitySorting> cityScrollForm) {
this.cityScrollForm = cityScrollForm;
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
