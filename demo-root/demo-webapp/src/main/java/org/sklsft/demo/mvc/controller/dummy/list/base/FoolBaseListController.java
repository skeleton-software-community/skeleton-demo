package org.sklsft.demo.mvc.controller.dummy.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.commons.mvc.annotations.PageLoad;
import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.dummy.list.FoolListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseListController extends BaseController {

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
protected FoolListView foolListView;

/*
 * getters and setters
 */
public FoolListView getFoolListView() {
return foolListView;
}
public void setFoolListView(FoolListView foolListView) {
this.foolListView = foolListView;
}

/**
 * load object list
 */
@PageLoad
public void load() {
this.reset();
}

/**
 * refresh object list
 */
public void refresh() {
foolListView.setScrollView(foolService.scroll(foolListView.getScrollForm()));
foolListView.getScrollForm().setPage(foolListView.getScrollView().getCurrentPage());
}

/**
 * create object
 */
public void createFool() {
try {
this.foolListView.setSelectedFool(this.foolService.create());
} catch (AccessDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
public void save() {
executeAjaxMethod("Fool.save", new AjaxMethodTemplate() {
@Override
public Object execute() {
return foolService.save(foolListView.getSelectedFool().getForm());
}
@Override
public void redirectOnComplete(Object result) {
redirect("/sections/dummy/fool/details.jsf?id=" + result);
}
});
}
/**
 * edit object
 */
public void editFool(String id) {
foolListView.setSelectedFool(foolService.load(id));
}

/**
 * update object
 */
@AjaxMethod("Fool.update")
public void update() {
foolService.update(this.foolListView.getSelectedFool().getId(), this.foolListView.getSelectedFool().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("Fool.delete")
public void delete(String id) {
foolService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("Fool.deleteList")
public void deleteList() {
List<String> ids = new ArrayList<>();
for (FoolBasicView fool:foolListView.getScrollView().getElements()) {
if (fool.getSelected()) {
ids.add(fool.getId());
}
}
foolService.deleteList(ids);
this.refresh();
}

/**
 * reset filters and sortings
 */
public void reset() {
this.foolListView.setScrollForm(new ScrollForm<>());
this.foolListView.getScrollForm().setFilter(new FoolFilter());
this.foolListView.getScrollForm().setSorting(new FoolSorting());
refresh();
}

}
