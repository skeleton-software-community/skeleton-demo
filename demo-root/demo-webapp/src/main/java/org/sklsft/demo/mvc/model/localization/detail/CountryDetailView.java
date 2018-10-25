package org.sklsft.demo.mvc.model.localization.detail;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.localization.views.full.CountryFullView;
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
public class CountryDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private CountryFullView selectedCountry = new CountryFullView();

protected ScrollForm<RegionFilter, RegionSorting> regionScrollForm = new ScrollForm<>();
protected ScrollView<RegionBasicView> regionScrollView = new ScrollView<>();
private RegionFullView selectedRegion = new RegionFullView();

/*
 * getters and setters
 */
public CountryFullView getSelectedCountry() {
return selectedCountry;
}
public void setSelectedCountry(CountryFullView selectedCountry) {
this.selectedCountry = selectedCountry;
}

public ScrollView<RegionBasicView> getRegionScrollView() {
return regionScrollView;
}
public void setRegionScrollView(ScrollView<RegionBasicView> regionScrollView) {
this.regionScrollView = regionScrollView;
}

public ScrollForm<RegionFilter, RegionSorting> getRegionScrollForm() {
return regionScrollForm;
}
public void setRegionScrollForm(ScrollForm<RegionFilter, RegionSorting> regionScrollForm) {
this.regionScrollForm = regionScrollForm;
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
