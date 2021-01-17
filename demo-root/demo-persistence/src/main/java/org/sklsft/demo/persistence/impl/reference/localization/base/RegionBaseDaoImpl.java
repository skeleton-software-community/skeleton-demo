package org.sklsft.demo.persistence.impl.reference.localization.base;

import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addStringContainsRestriction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.OrderType;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.model.reference.localization.Country;
import org.sklsft.demo.model.reference.localization.Country_;
import org.sklsft.demo.model.reference.localization.Region;
import org.sklsft.demo.model.reference.localization.Region_;
import org.sklsft.demo.persistence.interfaces.reference.localization.base.RegionBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseDaoImpl extends BaseDaoImpl<Region, Integer> implements RegionBaseDao {

/**
 * constructor
 */
public RegionBaseDaoImpl() {
super(Region.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unused")
public List<Region> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch("country", JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list from country
 */
@Override
public List<Region> loadListFromCountry(Short countryId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

if (countryId == null){
criteria.where(builder.isNull(country.get(Country_.id)));
} else {
criteria.where(builder.equal(country.get(Country_.id), countryId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list eagerly from country
 */
@Override
@SuppressWarnings({"unused","unchecked"})
public List<Region> loadListEagerlyFromCountry(Short countryId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch("country", JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

if (countryId == null){
criteria.where(builder.isNull(country.get(Country_.id)));
} else {
criteria.where(builder.equal(country.get(Country_.id), countryId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(RegionFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, country.get("code"), filter.getCountryCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count object list from country
 */
public Long countFromCountry(Short countryId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

if (countryId == null){
criteria.where(builder.isNull(country.get(Country_.id)));
} else {
criteria.where(builder.equal(country.get(Country_.id), countryId));
}

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count filtered object list from country
 */
public Long countFromCountry(Short countryId, RegionFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, country.get("code"), filter.getCountryCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
if (countryId == null){
predicates.add(builder.isNull(country.get(Country_.id)));
} else {
predicates.add(builder.equal(country.get(Country_.id), countryId));
}

criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> scroll(RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, country.get("code"), filter.getCountryCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, country.get(Country_.code), sorting.getCountryCodeOrderType());
addOrder(builder, orders, root.get(Region_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(Region_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Region> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * scroll filtered object list from country
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> scrollFromCountry(Short countryId, RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, country.get("code"), filter.getCountryCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
if (countryId == null){
predicates.add(builder.isNull(country.get(Country_.id)));
} else {
predicates.add(builder.equal(country.get(Country_.id), countryId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, country.get("code"), sorting.getCountryCodeOrderType());
addOrder(builder, orders, root.get("code"), sorting.getCodeOrderType());
addOrder(builder, orders, root.get("label"), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Region> query = session.createQuery(criteria);
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
public Region findOrNull(String countryCode, String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Join<Country, Region> country = root.join("country", JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, country.get("code"), countryCode);
addEqualsRestriction(builder, predicates, root.get("code"), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).uniqueResult();
}

/**
 * find object
 */
@Override
public Region find(String countryCode, String code) {
if (countryCode == null && code == null) {
return null;
}
Region region = findOrNull(countryCode, code);
if (region == null) {
throw new ObjectNotFoundException("Region.notFound");
} else {
return region;
}
}

/**
 * exists object
 */
@Override
public boolean exists(String countryCode, String code) {
if (countryCode == null && code == null) {
return false;
}
Region region = findOrNull(countryCode, code);
return region != null;
}

}