package org.sklsft.demo.repository.dao.impl.localization.base;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.orderings.RegionOrdering;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.base.RegionBaseDao;
import org.springframework.stereotype.Repository;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.*;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseDaoImpl extends BaseDaoImpl<Region, Long> implements RegionBaseDao {

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
return criteria.list();
}

/**
 * load object list from country
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> loadListFromCountry(Long countryId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
return criteria.list();
}

/**
 * load object list eagerly from country
 */
@Override
@SuppressWarnings("unchecked")
public List<Region> loadListEagerlyFromCountry(Long countryId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
if (countryId == null){
criteria.add(Restrictions.isNull("country.id"));
} else {
criteria.add(Restrictions.eq("country.id", countryId));
}
criteria.setFetchMode("country",FetchMode.JOIN);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(RegionFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class).setProjection(Projections.rowCount());
Criteria countryCriteria = criteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(countryCriteria, "{alias}.code", filter.getCountryCode());
addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
public List<Region> scroll(RegionFilter filter, RegionOrdering ordering, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Region.class);
Criteria countryCriteria = criteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(countryCriteria, "{alias}.code", filter.getCountryCode());
addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());
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