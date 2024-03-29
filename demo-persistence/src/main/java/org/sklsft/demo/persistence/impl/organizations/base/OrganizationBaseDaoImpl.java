package org.sklsft.demo.persistence.impl.organizations.base;

import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.getStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.OrderType;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationCertification;
import org.sklsft.demo.model.organizations.OrganizationDescription;
import org.sklsft.demo.model.organizations.OrganizationDescription_;
import org.sklsft.demo.model.organizations.Organization_;
import org.sklsft.demo.persistence.interfaces.organizations.base.OrganizationBaseDao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseDaoImpl extends BaseDaoImpl<Organization, Integer> implements OrganizationBaseDao {

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
@SuppressWarnings({"unused","unchecked"})
public List<Organization> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

Root<Organization> root = criteria.from(Organization.class);
Fetch<Organization, OrganizationDescription> organizationDescriptionFetch = root.fetch(Organization_.organizationDescription, JoinType.LEFT);
Join<Organization, OrganizationDescription> organizationDescription = (Join<Organization, OrganizationDescription>)organizationDescriptionFetch;

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Organization_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(OrganizationFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Organization> root = criteria.from(Organization.class);
Join<Organization, OrganizationDescription> organizationDescription = root.join(Organization_.organizationDescription, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Organization_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, organizationDescription.get(OrganizationDescription_.description), filter.getDescription());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Organization> scroll(OrganizationFilter filter, OrganizationSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

Root<Organization> root = criteria.from(Organization.class);
Fetch<Organization, OrganizationDescription> organizationDescriptionFetch = root.fetch(Organization_.organizationDescription, JoinType.LEFT);
Join<Organization, OrganizationDescription> organizationDescription = (Join<Organization, OrganizationDescription>)organizationDescriptionFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Organization_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, organizationDescription.get(OrganizationDescription_.description), filter.getDescription());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Organization_.code), sorting.getCodeOrderType());
addOrder(builder, orders, organizationDescription.get(OrganizationDescription_.description), sorting.getDescriptionOrderType());
addOrder(builder, orders, root.get(Organization_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Organization> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * find object or null
 */
@Override
public Organization findOrNull(String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

Root<Organization> root = criteria.from(Organization.class);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, root.get(Organization_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).uniqueResult();
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
 * exists object
 */
@Override
public boolean exists(String code) {
if (code == null) {
return false;
}
Organization organization = findOrNull(code);
return organization != null;
}

/**
 * search
 */
@Override
public List<Organization> search(String arg) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

Root<Organization> root = criteria.from(Organization.class);

Predicate predicate = getStringStartsWithRestriction(builder, root.get(Organization_.code), arg);
if (predicate!=null){
criteria.where(predicate);
}

criteria.select(root);

Query<Organization> query = session.createQuery(criteria);
query.setMaxResults(20);
return query.getResultList();
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