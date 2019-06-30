package org.sklsft.demo.rest.client.organizations.base;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.organizations.base.OrganizationBaseService;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseRestClient implements OrganizationBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
/**
 * search options
 */
@Override
public List<SelectItem> searchOptions(String arg) {
return Arrays.asList(restClient.postForObject(SEARCH_OPTIONS_URL, arg, SelectItem[].class));
}

/**
 * load object list
 */
@Override
public List<OrganizationBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, OrganizationBasicView[].class));
}

/**
 * scroll object list
 */
@Override
public ScrollView<OrganizationBasicView> scroll(ScrollForm<OrganizationFilter, OrganizationSorting> form) {
return null;
}

/**
 * load object
 */
@Override
public OrganizationFullView load(Integer id) {
return null;
}

/**
 * find object
 */
@Override
public OrganizationFullView find(String code) {
return null;
}

/**
 * load one to one component organizationCertification
 */
@Override
public OrganizationCertificationFullView loadOrganizationCertification(Integer id) {
return null;
}

/**
 * create object
 */
@Override
public OrganizationFullView create() {
return null;
}

/**
 * save object
 */
@Override
public Integer save(OrganizationForm organizationForm) {
return null;
}

/**
 * save one to one component organizationCertification
 */
@Override
public void saveOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm) {
}

/**
 * update object
 */
@Override
public void update(Integer id, OrganizationForm organizationForm) {
}

/**
 * update one to one component organizationCertification
 */
@Override
public void updateOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm) {
}

/**
 * delete object
 */
@Override
public void delete(Integer id) {
}

/**
 * delete one to one component organizationCertification
 */
@Override
public void deleteOrganizationCertification(Integer id) {
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Integer> idList) {
}

}
