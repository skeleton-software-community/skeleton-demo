package org.sklsft.demo.repository.dao.impl.reference.localization.base;

import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.OrderType;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.model.reference.localization.City;
import org.sklsft.demo.repository.dao.interfaces.reference.localization.base.CityBaseDao;

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
@SuppressWarnings("unchecked")
public List<City> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
criteria.setFetchMode("region",FetchMode.JOIN);
criteria.setFetchMode("region.country",FetchMode.JOIN);
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * load object list from region
 */
@Override
@SuppressWarnings("unchecked")
public List<City> loadListFromRegion(Integer regionId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * load object list eagerly from region
 */
@Override
@SuppressWarnings("unchecked")
public List<City> loadListEagerlyFromRegion(Integer regionId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
criteria.setFetchMode("region",FetchMode.JOIN);
criteria.setFetchMode("region.country",FetchMode.JOIN);
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(CityFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class).setProjection(Projections.rowCount());
Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(regionCountryCriteria, "{alias}.CODE", filter.getRegionCountryCode());
addStringContainsRestriction(regionCriteria, "{alias}.CODE", filter.getRegionCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * count object list from region
 */
public Long countFromRegion(Integer regionId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class).setProjection(Projections.rowCount());
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
return (Long) criteria.uniqueResult();
}

/**
 * count filtered object list from region
 */
public Long countFromRegion(Integer regionId, CityFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class).setProjection(Projections.rowCount());
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(regionCountryCriteria, "{alias}.CODE", filter.getRegionCountryCode());
addStringContainsRestriction(regionCriteria, "{alias}.CODE", filter.getRegionCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<City> scroll(CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(regionCountryCriteria, "{alias}.CODE", filter.getRegionCountryCode());
addStringContainsRestriction(regionCriteria, "{alias}.CODE", filter.getRegionCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
addOrder(regionCountryCriteria, "code", sorting.getRegionCountryCodeOrderType());
addOrder(regionCriteria, "code", sorting.getRegionCodeOrderType());
addOrder(criteria, "code", sorting.getCodeOrderType());
addOrder(criteria, "label", sorting.getLabelOrderType());
if (firstResult != null){
criteria.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
criteria.setMaxResults(maxResults.intValue());
}
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * scroll filtered object list from region
 */
@Override
@SuppressWarnings("unchecked")
public List<City> scrollFromRegion(Integer regionId, CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(regionCountryCriteria, "{alias}.CODE", filter.getRegionCountryCode());
addStringContainsRestriction(regionCriteria, "{alias}.CODE", filter.getRegionCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
addOrder(regionCountryCriteria, "code", sorting.getRegionCountryCodeOrderType());
addOrder(regionCriteria, "code", sorting.getRegionCodeOrderType());
addOrder(criteria, "code", sorting.getCodeOrderType());
addOrder(criteria, "label", sorting.getLabelOrderType());
if (firstResult != null){
criteria.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
criteria.setMaxResults(maxResults.intValue());
}
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * exists object
 */
@Override
public boolean exists(String regionCountryCode, String regionCode, String code) {
if (regionCountryCode == null && regionCode == null && code == null) {
return false;
}
City city = (City)this.sessionFactory.getCurrentSession().createCriteria(City.class)
.createAlias("region","region")
.createAlias("region.country","regionCountry")
.add(Restrictions.eq("regionCountry.code",regionCountryCode))
.add(Restrictions.eq("region.code",regionCode))
.add(Restrictions.eq("code",code))
.uniqueResult();
return city != null;
}

/**
 * find object or null
 */
@Override
public City findOrNull(String regionCountryCode, String regionCode, String code) {
City city = (City)this.sessionFactory.getCurrentSession().createCriteria(City.class)
.createAlias("region","region")
.createAlias("region.country","regionCountry")
.add(Restrictions.eq("regionCountry.code",regionCountryCode))
.add(Restrictions.eq("region.code",regionCode))
.add(Restrictions.eq("code",code))
.uniqueResult();
return city;
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

}