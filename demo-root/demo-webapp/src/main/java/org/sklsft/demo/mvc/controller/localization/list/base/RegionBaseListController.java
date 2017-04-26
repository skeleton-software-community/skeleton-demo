package org.sklsft.demo.mvc.controller.localization.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.localization.RegionService;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.localization.list.RegionListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseListController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected RegionService regionService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected RegionListView regionListView;

/*
 * getters and setters
 */
public RegionListView getRegionListView() {
return regionListView;
}
public void setRegionListView(RegionListView regionListView) {
this.regionListView = regionListView;
}

/**
 * load object list
 */
public void load() {
this.resetRegionFilter();
this.refresh();
}

/**
 * refresh object list
 */
public void refresh() {
this.regionListView.setRegionList(this.regionService.loadList());
}

/**
 * create object
 */
public void createRegion() {
this.commonController.loadCountryOptions();
try {
this.regionListView.setSelectedRegion(this.regionService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
public void save() {
executeAjaxMethod("Region.save", new AjaxMethodTemplate() {
@Override
public Object execute() {
return regionService.save(regionListView.getSelectedRegion().getForm());
}
@Override
public void redirectOnComplete(Object result) {
redirect("/sections/localization/region/RegionDetails.jsf?id=" + result);
}
});
}
/**
 * edit object
 */
public void editRegion(Long id) {
this.commonController.loadCountryOptions();
regionListView.setSelectedRegion(regionService.load(id));
}

/**
 * update object
 */
@AjaxMethod("Region.update")
public void update() {
regionService.update(this.regionListView.getSelectedRegion().getId(), this.regionListView.getSelectedRegion().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("Region.delete")
public void delete(Long id) {
regionService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("Region.deleteList")
public void deleteList() {
List<Long> ids = new ArrayList<>();
for (RegionBasicView region:regionListView.getRegionList()) {
if (region.getSelected()) {
ids.add(region.getId());
}
}
regionService.deleteList(ids);
this.refresh();
}

/**
 * reset object datatable filter
 */
public void resetRegionFilter() {
this.regionListView.setRegionFilter(new RegionFilter());
}

}
