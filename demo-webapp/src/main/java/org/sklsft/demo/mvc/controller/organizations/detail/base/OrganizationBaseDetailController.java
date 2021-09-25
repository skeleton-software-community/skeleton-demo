package org.sklsft.demo.mvc.controller.organizations.detail.base;

import javax.inject.Inject;

import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.commons.mvc.annotations.PageLoad;
import org.sklsft.demo.api.interfaces.organizations.OrganizationService;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.organizations.detail.OrganizationDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseDetailController extends BaseController {

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
protected OrganizationDetailView organizationDetailView;

/**
 * load object
 */
@PageLoad
public void load() {
organizationDetailView.setSelectedOrganization(this.organizationService.load(this.organizationDetailView.getSelectedOrganization().getId()));
}


/**
 * load one to one component organizationCertification
 */
@PageLoad
public void loadOrganizationCertification() {
organizationDetailView.setSelectedOrganizationCertification(this.organizationService.loadOrganizationCertification(this.organizationDetailView.getSelectedOrganization().getId()));
}

/**
 * save one to one component organizationCertification
 */
@AjaxMethod("OrganizationCertification.save")
public void saveOrganizationCertification() {
organizationService.saveOrganizationCertification(this.organizationDetailView.getSelectedOrganization().getId(), organizationDetailView.getSelectedOrganizationCertification().getForm());
loadOrganizationCertification();
}

/**
 * update object
 */
@AjaxMethod("Organization.update")
public void update() {
organizationService.update(organizationDetailView.getSelectedOrganization().getId(), organizationDetailView.getSelectedOrganization().getForm());
load();
}

/**
 * update one to one component organizationCertification
 */
@AjaxMethod("OrganizationCertification.update")
public void updateOrganizationCertification() {
organizationService.updateOrganizationCertification(this.organizationDetailView.getSelectedOrganization().getId(), organizationDetailView.getSelectedOrganizationCertification().getForm());
loadOrganizationCertification();
}

/**
 * delete one to one component organizationCertification
 */
@AjaxMethod("OrganizationCertification.delete")
public void deleteOrganizationCertification() {
organizationService.deleteOrganizationCertification(this.organizationDetailView.getSelectedOrganization().getId());
loadOrganizationCertification();
}

}
