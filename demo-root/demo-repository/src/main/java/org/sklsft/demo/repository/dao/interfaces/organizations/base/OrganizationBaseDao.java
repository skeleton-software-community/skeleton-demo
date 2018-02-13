package org.sklsft.demo.repository.dao.interfaces.organizations.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationCertification;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface OrganizationBaseDao extends BaseDao<Organization, Long> {

/**
 * count filtered object list
 */
Long count(OrganizationFilter filter);

/**
 * scroll filtered object list
 */
List<Organization> scroll(OrganizationFilter filter, OrganizationSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Organization findOrNull(String code);

/**
 * find object
 */
Organization find(String code);

/**
 * search
 */
List<Organization> search(String arg);

/**
 * save one to one component OrganizationCertification
 */
void saveOrganizationCertification(Organization organization, OrganizationCertification organizationCertification);

/**
 * delete one to one component OrganizationCertification
 */
void deleteOrganizationCertification(OrganizationCertification organizationCertification);

}
