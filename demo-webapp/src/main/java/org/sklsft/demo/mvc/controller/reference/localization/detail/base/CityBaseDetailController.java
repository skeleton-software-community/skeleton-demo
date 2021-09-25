package org.sklsft.demo.mvc.controller.reference.localization.detail.base;

import javax.inject.Inject;

import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.commons.mvc.annotations.PageLoad;
import org.sklsft.demo.api.interfaces.reference.localization.CityService;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.reference.localization.detail.CityDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseDetailController extends BaseController {

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
protected CityDetailView cityDetailView;

/**
 * load object
 */
@PageLoad
public void load() {
this.commonController.loadCountryOptions();
cityDetailView.setSelectedCity(this.cityService.load(this.cityDetailView.getSelectedCity().getId()));
}


/**
 * update object
 */
@AjaxMethod("City.update")
public void update() {
cityService.update(cityDetailView.getSelectedCity().getId(), cityDetailView.getSelectedCity().getForm());
load();
}

}
