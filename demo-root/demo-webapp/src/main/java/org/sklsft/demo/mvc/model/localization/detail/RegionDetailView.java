package org.sklsft.demo.mvc.model.localization.detail;

import java.io.Serializable;
import java.util.List;

import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.localization.views.full.CityFullView;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;
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

private List<CityBasicView> cityList;
private CityFilter cityFilter = new CityFilter();
private CityFullView selectedCity;

/*
 * getters and setters
 */
public RegionFullView getSelectedRegion() {
return selectedRegion;
}
public void setSelectedRegion(RegionFullView selectedRegion) {
this.selectedRegion = selectedRegion;
}

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
/* Specific Code End */
}
