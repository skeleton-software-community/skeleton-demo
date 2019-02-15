package org.sklsft.demo.mvc.controller.dummy.detail.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.api.interfaces.dummy.StupidService;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
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
protected StupidService stupidService;
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
 * load one to many stupid list
 */
public void loadStupidList() {
this.resetStupidFilter();
}

/**
 * refresh one to many stupid list
 */
public void refreshStupidList() {
foolDetailView.setStupidScrollView(stupidService.scrollFromFool(foolDetailView.getSelectedFool().getId(), foolDetailView.getStupidScrollForm()));
foolDetailView.getStupidScrollForm().setPage(foolDetailView.getStupidScrollView().getCurrentPage());
}

/**
 * create one to many stupid
 */
public void createStupid() {
try {
foolDetailView.setSelectedStupid(this.stupidService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save one to many stupid
 */
@AjaxMethod("Stupid.save")
public void saveStupid() {
stupidService.saveFromFool(this.foolDetailView.getSelectedFool().getId(), foolDetailView.getSelectedStupid().getForm());
refreshStupidList();
}

/**
 * update object
 */
@AjaxMethod("Fool.update")
public void update() {
foolService.update(foolDetailView.getSelectedFool().getId(), foolDetailView.getSelectedFool().getForm());
load();
}

/**
 * edit one to many stupid
 */
public void editStupid(Long id) {
foolDetailView.setSelectedStupid(stupidService.load(id));
}

/**
 * update one to many stupid
 */
@AjaxMethod("Stupid.update")
public void updateStupid() {
stupidService.update(foolDetailView.getSelectedStupid().getId(), foolDetailView.getSelectedStupid().getForm());
refreshStupidList();
}

/**
 * delete one to many stupid
 */
@AjaxMethod("Stupid.delete")
public void deleteStupid(Long id) {
stupidService.delete(id);
refreshStupidList();
}

/**
 * delete one to many stupid list
 */
@AjaxMethod("Stupid.deleteList")
public void deleteStupidList() {
List<Long> ids = new ArrayList<>();
for (StupidBasicView stupid:foolDetailView.getStupidScrollView().getElements()) {
if (stupid.getSelected()) {
ids.add(stupid.getId());
}
}
stupidService.deleteList(ids);
refreshStupidList();
}

/**
 * reset one to many StupidFilter datatable filter and sorting
 */
public void resetStupidFilter() {
this.foolDetailView.setStupidScrollForm(new ScrollForm<>());
this.foolDetailView.getStupidScrollForm().setFilter(new StupidFilter());
this.foolDetailView.getStupidScrollForm().setSorting(new StupidSorting());
refreshStupidList();
}

}
