package org.sklsft.demo.mvc.controller.reference.localization.detail.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.commons.mvc.annotations.PageLoad;
import org.sklsft.demo.api.interfaces.reference.localization.CityService;
import org.sklsft.demo.api.interfaces.reference.localization.RegionService;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.forms.CityForm;
import org.sklsft.demo.api.model.reference.localization.forms.RegionForm;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.reference.localization.detail.RegionDetailView;

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
@PageLoad
public void load() {
this.commonController.loadCountryOptions();
regionDetailView.setSelectedRegion(this.regionService.load(this.regionDetailView.getSelectedRegion().getId()));
}


/**
 * load one to many city list
 */
@PageLoad
public void loadCityList() {
this.resetCityFilter();
}

/**
 * refresh one to many city list
 */
public void refreshCityList() {
regionDetailView.setCityScrollView(cityService.scrollFromRegion(regionDetailView.getSelectedRegion().getId(), regionDetailView.getCityScrollForm()));
regionDetailView.getCityScrollForm().setPage(regionDetailView.getCityScrollView().getCurrentPage());
}

/**
 * create one to many city
 */
public void createCity() {
try {
regionDetailView.setSelectedCity(this.cityService.create());
} catch (AccessDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save one to many city
 */
@AjaxMethod("City.save")
public void saveCity() {
load();
CityForm form = regionDetailView.getSelectedCity().getForm();
RegionForm regionForm = regionDetailView.getSelectedRegion().getForm();
form.setRegionCountryCode(regionForm.getCountryCode());
form.setRegionCode(regionForm.getCode());
cityService.save(form);
refreshCityList();
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
refreshCityList();
}

/**
 * delete one to many city
 */
@AjaxMethod("City.delete")
public void deleteCity(Long id) {
cityService.delete(id);
refreshCityList();
}

/**
 * delete one to many city list
 */
@AjaxMethod("City.deleteList")
public void deleteCityList() {
List<Long> ids = new ArrayList<>();
for (CityBasicView city:regionDetailView.getCityScrollView().getElements()) {
if (city.getSelected()) {
ids.add(city.getId());
}
}
cityService.deleteList(ids);
refreshCityList();
}

/**
 * reset one to many CityFilter datatable filter and sorting
 */
public void resetCityFilter() {
this.regionDetailView.setCityScrollForm(new ScrollForm<>());
this.regionDetailView.getCityScrollForm().setFilter(new CityFilter());
this.regionDetailView.getCityScrollForm().setSorting(new CitySorting());
refreshCityList();
}

}
