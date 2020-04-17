package org.sklsft.demo.persistence.impl.reference.localization.base;

import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addStringContainsRestriction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.OrderType;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.model.reference.localization.City;
import org.sklsft.demo.model.reference.localization.Country;
import org.sklsft.demo.model.reference.localization.Region;
import org.sklsft.demo.persistence.interfaces.reference.localization.base.CityBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseDaoImpl extends BaseDaoImpl<City, Long> implements CityBaseDao {

/**
 * constructor
 */
public CityBaseDaoImpl() {
super(City.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unused")
public List<City> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
root.fetch("region");
Join<Country, Region> regionCountry = region.join("country");
region.fetch("country");

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get("id"), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list from region
 */
@Override
public List<City> loadListFromRegion(Integer regionId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");

if (regionId == null){
criteria.where(builder.isNull(region.get("id")));
} else {
criteria.where(builder.equal(region.get("id"), regionId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get("id"), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list eagerly from region
 */
@Override
@SuppressWarnings("unused")
public List<City> loadListEagerlyFromRegion(Integer regionId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
root.fetch("region");
Join<Country, Region> regionCountry = region.join("country");
region.fetch("country");

if (regionId == null){
criteria.where(builder.isNull(region.get("id")));
} else {
criteria.where(builder.equal(region.get("id"), regionId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get("id"), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(CityFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
Join<Country, Region> regionCountry = region.join("country");

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, regionCountry.get("code"), filter.getRegionCountryCode());
addStringContainsRestriction(builder, predicates, region.get("code"), filter.getRegionCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count object list from region
 */
public Long countFromRegion(Integer regionId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");

if (regionId == null){
criteria.where(builder.isNull(region.get("id")));
} else {
criteria.where(builder.equal(region.get("id"), regionId));
}

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count filtered object list from region
 */
public Long countFromRegion(Integer regionId, CityFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
Join<Country, Region> regionCountry = region.join("country");

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, regionCountry.get("code"), filter.getRegionCountryCode());
addStringContainsRestriction(builder, predicates, region.get("code"), filter.getRegionCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
if (regionId == null){
predicates.add(builder.isNull(region.get("id")));
} else {
predicates.add(builder.equal(region.get("id"), regionId));
}

criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unused")
public List<City> scroll(CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
root.fetch("region");
Join<Country, Region> regionCountry = region.join("country");
region.fetch("country");

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, regionCountry.get("code"), filter.getRegionCountryCode());
addStringContainsRestriction(builder, predicates, region.get("code"), filter.getRegionCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, regionCountry.get("code"), sorting.getRegionCountryCodeOrderType());
addOrder(builder, orders, region.get("code"), sorting.getRegionCodeOrderType());
addOrder(builder, orders, root.get("code"), sorting.getCodeOrderType());
addOrder(builder, orders, root.get("label"), sorting.getLabelOrderType());
addOrder(builder, orders, root.get("id"), OrderType.DESC);
criteria.orderBy(orders);

Query<City> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * scroll filtered object list from region
 */
@Override
public List<City> scrollFromRegion(Integer regionId, CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
root.fetch("region");
Join<Country, Region> regionCountry = region.join("country");
region.fetch("country");

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, regionCountry.get("code"), filter.getRegionCountryCode());
addStringContainsRestriction(builder, predicates, region.get("code"), filter.getRegionCode());
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("label"), filter.getLabel());
if (regionId == null){
predicates.add(builder.isNull(region.get("id")));
} else {
predicates.add(builder.equal(region.get("id"), regionId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, regionCountry.get("code"), sorting.getRegionCountryCodeOrderType());
addOrder(builder, orders, region.get("code"), sorting.getRegionCodeOrderType());
addOrder(builder, orders, root.get("code"), sorting.getCodeOrderType());
addOrder(builder, orders, root.get("label"), sorting.getLabelOrderType());
addOrder(builder, orders, root.get("id"), OrderType.DESC);
criteria.orderBy(orders);

Query<City> query = session.createQuery(criteria);
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
public City findOrNull(String regionCountryCode, String regionCode, String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<Region, City> region = root.join("region");
Join<Country, Region> regionCountry = region.join("country");

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, regionCountry.get("code"), regionCountryCode);
addEqualsRestriction(builder, predicates, region.get("code"), regionCode);
addEqualsRestriction(builder, predicates, root.get("code"), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).getSingleResult();
}

/**
 * find object
 */
@Override
public City find(String regionCountryCode, String regionCode, String code) {
if (regionCountryCode == null && regionCode == null && code == null) {
return null;
}
City city = findOrNull(regionCountryCode, regionCode, code);
if (city == null) {
throw new ObjectNotFoundException("City.notFound");
} else {
return city;
}
}

/**
 * exists object
 */
@Override
public boolean exists(String regionCountryCode, String regionCode, String code) {
if (regionCountryCode == null && regionCode == null && code == null) {
return false;
}
City city = findOrNull(regionCountryCode, regionCode, code);
return city != null;
}

}