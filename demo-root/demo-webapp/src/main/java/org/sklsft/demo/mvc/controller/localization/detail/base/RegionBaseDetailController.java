package org.sklsft.demo.mvc.controller.localization.detail.base;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.localization.CityService;
import org.sklsft.demo.api.interfaces.localization.RegionService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.localization.views.full.CityFullView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.localization.detail.RegionDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseDetailController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected RegionService regionService;
@Inject
protected CityService cityService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected RegionDetailView regionDetailView;

/**
 * load object
 */
public void load() {
this.commonController.loadCountryOptions();
regionDetailView.setSelectedRegion(this.regionService.load(this.regionDetailView.getSelectedRegion().getId()));
}


/**
 * load one to many city list
 */
public void loadCityList() {
this.resetCityFilter();
regionDetailView.setCityList(this.cityService.loadListFromRegion(this.regionDetailView.getSelectedRegion().getId()));
}

/**
 * create one to many city
 */
public void createCity() {
try {
regionDetailView.setSelectedCity(this.cityService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save one to many city
 */
@AjaxMethod("City.save")
public void saveCity() {
cityService.saveFromRegion(this.regionDetailView.getSelectedRegion().getId(), regionDetailView.getSelectedCity().getForm());
loadCityList();
}

/**
 * update object
 */
@AjaxMethod("Region.update")
public void update() {
regionService.update(regionDetailView.getSelectedRegion().getId(), regionDetailView.getSelectedRegion().getForm());
load();
}

/**
 * edit one to many city
 */
public void editCity(Long id) {
regionDetailView.setSelectedCity(cityService.load(id));
}

/**
 * update one to many city
 */
@AjaxMethod("City.update")
public void updateCity() {
cityService.update(regionDetailView.getSelectedCity().getId(), regionDetailView.getSelectedCity().getForm());
loadCityList();
}

/**
 * delete one to many city
 */
@AjaxMethod("City.delete")
public void deleteCity(Long id) {
cityService.delete(id);
loadCityList();
}

/**
 * delete one to many city list
 */
@AjaxMethod("City.deleteList")
public void deleteCityList() {
List<Long> ids = new ArrayList<>();
for (CityBasicView city:regionDetailView.getCityList()) {
if (city.getSelected()) {
ids.add(city.getId());
}
}
cityService.deleteList(ids);
loadCityList();
}

/**
 * reset one to many CityFilter datatable filter
 */
public void resetCityFilter() {
regionDetailView.setCityFilter(new CityFilter());
}

}
