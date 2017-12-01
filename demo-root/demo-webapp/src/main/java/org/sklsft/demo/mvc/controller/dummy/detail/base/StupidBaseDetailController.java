package org.sklsft.demo.mvc.controller.dummy.detail.base;

import javax.inject.Inject;

import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.dummy.StupidService;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.dummy.detail.StupidDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseDetailController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected StupidService stupidService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected StupidDetailView stupidDetailView;

/**
 * load object
 */
public void load() {
stupidDetailView.setSelectedStupid(this.stupidService.load(this.stupidDetailView.getSelectedStupid().getId()));
}


/**
 * update object
 */
@AjaxMethod("Stupid.update")
public void update() {
stupidService.update(stupidDetailView.getSelectedStupid().getId(), stupidDetailView.getSelectedStupid().getForm());
load();
}

}
