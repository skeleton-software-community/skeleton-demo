package org.sklsft.demo.mvc.controller.localization.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.localization.CityService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.localization.list.CityListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseListController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected CityService cityService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected CityListView cityListView;

/*
 * getters and setters
 */
public CityListView getCityListView() {
return cityListView;
}
public void setCityListView(CityListView cityListView) {
this.cityListView = cityListView;
}

/**
 * load object list
 */
public void load() {
this.resetCityFilter();
this.refresh();
}

/**
 * refresh object list
 */
public void refresh() {
this.cityListView.setCityList(this.cityService.loadList());
}

/**
 * create object
 */
public void createCity() {
this.commonController.loadCountryOptions();
try {
this.cityListView.setSelectedCity(this.cityService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
@AjaxMethod("City.save")
public void save() {
cityService.save(this.cityListView.getSelectedCity().getForm());
this.refresh();
}

/**
 * edit object
 */
public void editCity(Long id) {
this.commonController.loadCountryOptions();
cityListView.setSelectedCity(cityService.load(id));
}

/**
 * update object
 */
@AjaxMethod("City.update")
public void update() {
cityService.update(this.cityListView.getSelectedCity().getId(), this.cityListView.getSelectedCity().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("City.delete")
public void delete(Long id) {
cityService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("City.deleteList")
public void deleteList() {
List<Long> ids = new ArrayList<>();
for (CityBasicView city:cityListView.getCityList()) {
if (city.getSelected()) {
ids.add(city.getId());
}
}
cityService.deleteList(ids);
this.refresh();
}

/**
 * reset object datatable filter
 */
public void resetCityFilter() {
this.cityListView.setCityFilter(new CityFilter());
}

}
