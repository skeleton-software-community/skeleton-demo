package org.sklsft.demo.mvc.controller.organizations.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.organizations.OrganizationService;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.organizations.list.OrganizationListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseListController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected OrganizationService organizationService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected OrganizationListView organizationListView;

/*
 * getters and setters
 */
public OrganizationListView getOrganizationListView() {
return organizationListView;
}
public void setOrganizationListView(OrganizationListView organizationListView) {
this.organizationListView = organizationListView;
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
organizationListView.setScrollView(organizationService.scroll(organizationListView.getScrollForm()));
organizationListView.getScrollForm().setPage(organizationListView.getScrollView().getCurrentPage());
}

/**
 * create object
 */
public void createOrganization() {
try {
this.organizationListView.setSelectedOrganization(this.organizationService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
public void save() {
executeAjaxMethod("Organization.save", new AjaxMethodTemplate() {
@Override
public Object execute() {
return organizationService.save(organizationListView.getSelectedOrganization().getForm());
}
@Override
public void redirectOnComplete(Object result) {
redirect("/sections/organizations/organization/details.jsf?id=" + result);
}
});
}
/**
 * edit object
 */
public void editOrganization(Long id) {
organizationListView.setSelectedOrganization(organizationService.load(id));
}

/**
 * update object
 */
@AjaxMethod("Organization.update")
public void update() {
organizationService.update(this.organizationListView.getSelectedOrganization().getId(), this.organizationListView.getSelectedOrganization().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("Organization.delete")
public void delete(Long id) {
organizationService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("Organization.deleteList")
public void deleteList() {
List<Long> ids = new ArrayList<>();
for (OrganizationBasicView organization:organizationListView.getScrollView().getElements()) {
if (organization.getSelected()) {
ids.add(organization.getId());
}
}
organizationService.deleteList(ids);
this.refresh();
}

/**
 * reset filters and sortings
 */
public void reset() {
this.organizationListView.setScrollForm(new ScrollForm<>());
this.organizationListView.getScrollForm().setFilter(new OrganizationFilter());
this.organizationListView.getScrollForm().setSorting(new OrganizationSorting());
refresh();
}

}
