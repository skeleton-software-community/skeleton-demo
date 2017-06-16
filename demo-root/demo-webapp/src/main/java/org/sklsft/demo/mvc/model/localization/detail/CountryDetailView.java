package org.sklsft.demo.mvc.model.localization.detail;

import java.io.Serializable;
import java.util.List;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.localization.views.full.CountryFullView;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class CountryDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private CountryFullView selectedCountry = new CountryFullView();

private List<RegionBasicView> regionList;
private RegionFilter regionFilter = new RegionFilter();
private RegionFullView selectedRegion;

/*
 * getters and setters
 */
public CountryFullView getSelectedCountry() {
return selectedCountry;
}
public void setSelectedCountry(CountryFullView selectedCountry) {
this.selectedCountry = selectedCountry;
}

public List<RegionBasicView> getRegionList() {
return regionList;
}
public void setRegionList(List<RegionBasicView> regionList) {
this.regionList = regionList;
}

public RegionFilter getRegionFilter() {
return regionFilter;
}
public void setRegionFilter(RegionFilter regionFilter) {
this.regionFilter = regionFilter;
}

public RegionFullView getSelectedRegion() {
return selectedRegion;
}
public void setSelectedRegion(RegionFullView selectedRegion) {
this.selectedRegion = selectedRegion;
}

/* Specific Code Start */
/* Specific Code End */
}
