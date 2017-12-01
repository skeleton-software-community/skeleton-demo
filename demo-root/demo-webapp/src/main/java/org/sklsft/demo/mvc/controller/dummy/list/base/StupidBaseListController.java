package org.sklsft.demo.mvc.controller.dummy.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.dummy.StupidService;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.dummy.list.StupidListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseListController extends BaseController {

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
protected StupidListView stupidListView;

/*
 * getters and setters
 */
public StupidListView getStupidListView() {
return stupidListView;
}
public void setStupidListView(StupidListView stupidListView) {
this.stupidListView = stupidListView;
}

/**
 * load object list
 */
public void load() {
this.reset();
}

/**
 * refresh object list
 */
public void refresh() {
stupidListView.setScrollView(stupidService.scroll(stupidListView.getScrollForm()));
stupidListView.getScrollForm().setPage(stupidListView.getScrollView().getCurrentPage());
}

/**
 * create object
 */
public void createStupid() {
try {
this.stupidListView.setSelectedStupid(this.stupidService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
@AjaxMethod("Stupid.save")
public void save() {
stupidService.save(this.stupidListView.getSelectedStupid().getForm());
this.refresh();
}

/**
 * edit object
 */
public void editStupid(Long id) {
stupidListView.setSelectedStupid(stupidService.load(id));
}

/**
 * update object
 */
@AjaxMethod("Stupid.update")
public void update() {
stupidService.update(this.stupidListView.getSelectedStupid().getId(), this.stupidListView.getSelectedStupid().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("Stupid.delete")
public void delete(Long id) {
stupidService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("Stupid.deleteList")
public void deleteList() {
List<Long> ids = new ArrayList<>();
for (StupidBasicView stupid:stupidListView.getScrollView().getElements()) {
if (stupid.getSelected()) {
ids.add(stupid.getId());
}
}
stupidService.deleteList(ids);
this.refresh();
}

/**
 * reset filters and sortings
 */
public void reset() {
this.stupidListView.setScrollForm(new ScrollForm<>());
this.stupidListView.getScrollForm().setFilter(new StupidFilter());
this.stupidListView.getScrollForm().setSorting(new StupidSorting());
refresh();
}

}
