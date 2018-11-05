package org.sklsft.demo.rest.controller.organizations.base;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.organizations.OrganizationService;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * auto generated base rest controller file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseController {

/*
 * services injected by spring
 */
@Inject
protected OrganizationService organizationService;

/**
 * search options
 */
@RequestMapping(value = {OrganizationService.SEARCH_OPTIONS_URL }, method = RequestMethod.POST)
public @ResponseBody List<SelectItem> searchOptions(@RequestBody String arg) {
return organizationService.searchOptions(arg);
}

/**
 * load object list
 */
@RequestMapping(value = {OrganizationService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<OrganizationBasicView> loadList() {
return organizationService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {OrganizationService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<OrganizationBasicView> scroll(@RequestBody ScrollForm<OrganizationFilter, OrganizationSorting> form) {
return organizationService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {OrganizationService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody OrganizationFullView load(@PathVariable("id") Long id) {
return organizationService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {OrganizationService.FIND_URL}, method = RequestMethod.GET)
@ResponseBody OrganizationFullView find(@RequestParam("code") String code) {
return organizationService.find(code);
}

/**
 * load one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.GET_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.GET)
public @ResponseBody OrganizationCertificationFullView loadOrganizationCertification(@PathVariable("id") Long id) {
return organizationService.loadOrganizationCertification(id);
}

/**
 * create object
 */
@RequestMapping(value = {OrganizationService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody OrganizationFullView create() {
return organizationService.create();
}

/**
 * save object
 */
@RequestMapping(value = {OrganizationService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@RequestBody OrganizationForm form) {
return organizationService.save(form);
}

/**
 * save one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.SAVE_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.POST)
@ResponseBody public void saveOrganizationCertification(@PathVariable("id") Long id, @RequestBody OrganizationCertificationForm form) {
organizationService.saveOrganizationCertification(id, form);
}

/**
 * update object
 */
@RequestMapping(value = {OrganizationService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @RequestBody OrganizationForm form) {
organizationService.update(id, form);
}

/**
 * update one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.UPDATE_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.PUT)
void updateOrganizationCertification(Long id, OrganizationCertificationForm form) {
organizationService.updateOrganizationCertification(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {OrganizationService.DELETE_URL}, method = RequestMethod.DELETE)
void delete(@PathVariable("id") Long id) {
organizationService.delete(id);
}

/**
 * delete one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.DELETE_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.DELETE)
public void deleteOrganizationCertification(@PathVariable("id")Long id) {
organizationService.deleteOrganizationCertification(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {OrganizationService.DELETE_LIST_URL}, method = RequestMethod.POST)
@ResponseBody void deleteList(@RequestBody List<Long> idList) {
organizationService.deleteList(idList);
}

}
