package org.sklsft.demo.mvc.controller.localization.detail.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.localization.CountryService;
import org.sklsft.demo.api.interfaces.localization.RegionService;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.localization.detail.CountryDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseDetailController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected CountryService countryService;
@Inject
protected RegionService regionService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected CountryDetailView countryDetailView;

/**
 * load object
 */
public void load() {
countryDetailView.setSelectedCountry(this.countryService.load(this.countryDetailView.getSelectedCountry().getId()));
}


/**
 * load one to many region list
 */
public void loadRegionList() {
this.resetRegionFilter();
countryDetailView.setRegionList(this.regionService.loadListFromCountry(this.countryDetailView.getSelectedCountry().getId()));
}

/**
 * create one to many region
 */
public void createRegion() {
try {
countryDetailView.setSelectedRegion(this.regionService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save one to many region
 */
public void saveRegion() {
executeAjaxMethod("Region.save", new AjaxMethodTemplate() {
@Override
public Object execute() {
return regionService.saveFromCountry( countryDetailView.getSelectedCountry().getId(), countryDetailView.getSelectedRegion().getForm());
}
@Override
public void redirectOnComplete(Object result) {
redirect("/sections/localization/region/RegionDetails.jsf?id=" + result);
}
});
}
/**
 * update object
 */
@AjaxMethod("Country.update")
public void update() {
countryService.update(countryDetailView.getSelectedCountry().getId(), countryDetailView.getSelectedCountry().getForm());
load();
}

/**
 * edit one to many region
 */
public void editRegion(Long id) {
countryDetailView.setSelectedRegion(regionService.load(id));
}

/**
 * update one to many region
 */
@AjaxMethod("Region.update")
public void updateRegion() {
regionService.update(countryDetailView.getSelectedRegion().getId(), countryDetailView.getSelectedRegion().getForm());
loadRegionList();
}

/**
 * delete one to many region
 */
@AjaxMethod("Region.delete")
public void deleteRegion(Long id) {
regionService.delete(id);
loadRegionList();
}

/**
 * delete one to many region list
 */
@AjaxMethod("Region.deleteList")
public void deleteRegionList() {
List<Long> ids = new ArrayList<>();
for (RegionBasicView region:countryDetailView.getRegionList()) {
if (region.getSelected()) {
ids.add(region.getId());
}
}
regionService.deleteList(ids);
loadRegionList();
}

/**
 * reset one to many RegionFilter datatable filter
 */
public void resetRegionFilter() {
countryDetailView.setRegionFilter(new RegionFilter());
}

}
