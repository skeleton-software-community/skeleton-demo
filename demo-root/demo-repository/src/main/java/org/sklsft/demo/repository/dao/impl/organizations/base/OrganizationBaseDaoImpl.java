package org.sklsft.demo.repository.dao.impl.organizations.base;

import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationCertification;
import org.sklsft.demo.repository.dao.interfaces.organizations.base.OrganizationBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseDaoImpl extends BaseDaoImpl<Organization, Long> implements OrganizationBaseDao {

/**
 * constructor
 */
public OrganizationBaseDaoImpl() {
super(Organization.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unchecked")
public List<Organization> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Organization.class);
criteria.setFetchMode("organizationDescription",FetchMode.JOIN);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(OrganizationFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Organization.class).setProjection(Projections.rowCount());
Criteria organizationDescriptionCriteria = criteria.createCriteria("organizationDescription", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(organizationDescriptionCriteria, "{alias}.DESCRIPTION", filter.getDescription());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Organization> scroll(OrganizationFilter filter, OrganizationSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Organization.class);
Criteria organizationDescriptionCriteria = criteria.createCriteria("organizationDescription", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(organizationDescriptionCriteria, "{alias}.DESCRIPTION", filter.getDescription());
addOrder(criteria, "code", sorting.getCodeOrderType());
addOrder(organizationDescriptionCriteria, "description", sorting.getDescriptionOrderType());
if (firstResult != null){
criteria.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
criteria.setMaxResults(maxResults.intValue());
}
return criteria.list();
}

/**
 * exists object
 */
@Override
public boolean exists(String code) {
if (code == null) {
return false;
}
Organization organization = (Organization)this.sessionFactory.getCurrentSession().createCriteria(Organization.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return organization != null;
}

/**
 * find object or null
 */
@Override
public Organization findOrNull(String code) {
Organization organization = (Organization)this.sessionFactory.getCurrentSession().createCriteria(Organization.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return organization;
}

/**
 * find object
 */
@Override
public Organization find(String code) {
if (code == null) {
return null;
}
Organization organization = findOrNull(code);
if (organization == null) {
throw new ObjectNotFoundException("Organization.notFound");
} else {
return organization;
}
}

/**
 * search
 */
@Override
public List<Organization> search(String arg) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Organization.class);
addStringContainsRestriction(criteria, "{alias}.CODE", arg);
criteria.setMaxResults(20);
return criteria.list();
}

/**
 * save one to one component OrganizationCertification
 */
@Override
public void saveOrganizationCertification(Organization organization, OrganizationCertification organizationCertification) {
organizationCertification.setOrganization(organization);
this.sessionFactory.getCurrentSession().save(organizationCertification);
}

/**
 * delete one to one component OrganizationCertification
 */
@Override
public void deleteOrganizationCertification(OrganizationCertification organizationCertification) {
Organization organization = organizationCertification.getOrganization();
organization.setOrganizationCertification(null);
this.sessionFactory.getCurrentSession().delete(organizationCertification);
}

}