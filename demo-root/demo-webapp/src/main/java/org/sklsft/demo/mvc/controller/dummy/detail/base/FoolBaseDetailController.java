package org.sklsft.demo.mvc.controller.dummy.detail.base;

import javax.inject.Inject;

import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.dummy.detail.FoolDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseDetailController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected FoolService foolService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected FoolDetailView foolDetailView;

/**
 * load object
 */
public void load() {
foolDetailView.setSelectedFool(this.foolService.load(this.foolDetailView.getSelectedFool().getId()));
}


/**
 * update object
 */
@AjaxMethod("Fool.update")
public void update() {
foolService.update(foolDetailView.getSelectedFool().getId(), foolDetailView.getSelectedFool().getForm());
load();
}

}
