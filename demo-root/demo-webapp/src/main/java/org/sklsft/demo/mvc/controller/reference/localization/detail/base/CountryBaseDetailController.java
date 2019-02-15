package org.sklsft.demo.mvc.controller.reference.localization.detail.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.reference.localization.CountryService;
import org.sklsft.demo.api.interfaces.reference.localization.RegionService;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.reference.localization.detail.CountryDetailView;

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
}

/**
 * refresh one to many region list
 */
public void refreshRegionList() {
countryDetailView.setRegionScrollView(regionService.scrollFromCountry(countryDetailView.getSelectedCountry().getId(), countryDetailView.getRegionScrollForm()));
countryDetailView.getRegionScrollForm().setPage(countryDetailView.getRegionScrollView().getCurrentPage());
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
redirect("/sections/reference/localization/region/details.jsf?id=" + result);
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
public void editRegion(Integer id) {
countryDetailView.setSelectedRegion(regionService.load(id));
}

/**
 * update one to many region
 */
@AjaxMethod("Region.update")
public void updateRegion() {
regionService.update(countryDetailView.getSelectedRegion().getId(), countryDetailView.getSelectedRegion().getForm());
refreshRegionList();
}

/**
 * delete one to many region
 */
@AjaxMethod("Region.delete")
public void deleteRegion(Integer id) {
regionService.delete(id);
refreshRegionList();
}

/**
 * delete one to many region list
 */
@AjaxMethod("Region.deleteList")
public void deleteRegionList() {
List<Integer> ids = new ArrayList<>();
for (RegionBasicView region:countryDetailView.getRegionScrollView().getElements()) {
if (region.getSelected()) {
ids.add(region.getId());
}
}
regionService.deleteList(ids);
refreshRegionList();
}

/**
 * reset one to many RegionFilter datatable filter and sorting
 */
public void resetRegionFilter() {
this.countryDetailView.setRegionScrollForm(new ScrollForm<>());
this.countryDetailView.getRegionScrollForm().setFilter(new RegionFilter());
this.countryDetailView.getRegionScrollForm().setSorting(new RegionSorting());
refreshRegionList();
}

}
