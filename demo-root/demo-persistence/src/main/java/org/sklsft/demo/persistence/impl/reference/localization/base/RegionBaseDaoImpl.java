package org.sklsft.demo.persistence.impl.reference.localization.base;

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
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.model.reference.localization.Region;
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
@SuppressWarnings("unchecked")
public List<Region> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
criteria.setFetchMode("country",FetchMode.JOIN);
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * load object list from country
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> loadListFromCountry(Short countryId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * load object list eagerly from country
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> loadListEagerlyFromCountry(Short countryId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
criteria.setFetchMode("country",FetchMode.JOIN);
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(RegionFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class).setProjection(Projections.rowCount());
Criteria countryCriteria = criteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(countryCriteria, "{alias}.CODE", filter.getCountryCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * count object list from country
 */
public Long countFromCountry(Short countryId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class).setProjection(Projections.rowCount());
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
return (Long) criteria.uniqueResult();
}

/**
 * count filtered object list from country
 */
public Long countFromCountry(Short countryId, RegionFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class).setProjection(Projections.rowCount());
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
Criteria countryCriteria = criteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(countryCriteria, "{alias}.CODE", filter.getCountryCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> scroll(RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
Criteria countryCriteria = criteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(countryCriteria, "{alias}.CODE", filter.getCountryCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
addOrder(countryCriteria, "code", sorting.getCountryCodeOrderType());
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
 * scroll filtered object list from country
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> scrollFromCountry(Short countryId, RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
Criteria countryCriteria = criteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(countryCriteria, "{alias}.CODE", filter.getCountryCode());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
addOrder(countryCriteria, "code", sorting.getCountryCodeOrderType());
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
public boolean exists(String countryCode, String code) {
if (countryCode == null && code == null) {
return false;
}
Region region = (Region)this.sessionFactory.getCurrentSession().createCriteria(Region.class)
.createAlias("country","country")
.add(Restrictions.eq("country.code",countryCode))
.add(Restrictions.eq("code",code))
.uniqueResult();
return region != null;
}

/**
 * find object or null
 */
@Override
public Region findOrNull(String countryCode, String code) {
Region region = (Region)this.sessionFactory.getCurrentSession().createCriteria(Region.class)
.createAlias("country","country")
.add(Restrictions.eq("country.code",countryCode))
.add(Restrictions.eq("code",code))
.uniqueResult();
return region;
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

}