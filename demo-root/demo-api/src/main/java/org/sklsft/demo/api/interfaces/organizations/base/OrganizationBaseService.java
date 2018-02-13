package org.sklsft.demo.api.interfaces.organizations.base;

import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface OrganizationBaseService {

/**
 * search options
 */
List<SelectItem> searchOptions(String arg);
public static final String SEARCH_OPTIONS_URL = "/organization/options/search";

/**
 * load object list
 */
List<OrganizationBasicView> loadList();
public static final String GET_LIST_URL = "/organization/list";

/**
 * scroll object list
 */
ScrollView<OrganizationBasicView> scroll(ScrollForm<OrganizationFilter, OrganizationSorting> form);
public static final String SCROLL_URL = "/organization/scroll";

/**
 * load object
 */
OrganizationFullView load(Long id);
public static final String GET_URL = "/organization/{id}";

/**
 * find object
 */
OrganizationFullView find(String code);

/**
 * load one to one component organizationCertification
 */
OrganizationCertificationFullView loadOrganizationCertification(Long id);
public static final String GET_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * create object
 */
OrganizationFullView create();
public static final String GET_NEW_URL = "/organization/new";

/**
 * save object
 */
Long save(OrganizationForm organizationForm);
public static final String SAVE_URL = "/organization";

/**
 * save one to one component organizationCertification
 */
public void saveOrganizationCertification(Long id, OrganizationCertificationForm organizationCertificationForm);
public static final String SAVE_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * update object
 */
void update(Long id, OrganizationForm organizationForm);
public static final String UPDATE_URL = "/organization/{id}";

/**
 * update one to one component organizationCertification
 */
void updateOrganizationCertification(Long id, OrganizationCertificationForm organizationCertificationForm);
public static final String UPDATE_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * delete object
 */
void delete(Long id);
public static final String DELETE_URL = "/organization/{id}";

/**
 * delete one to one component organizationCertification
 */
public void deleteOrganizationCertification(Long id);
public static final String DELETE_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * delete object list
 */
void deleteList(List<Long> idList);

}
