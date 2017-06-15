package org.sklsft.demo.repository.dao.impl.localization.base;

import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.interfaces.localization.base.CityBaseDao;

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
return criteria.list();
}

/**
 * load filtered object list eagerly
 */
@Override
@SuppressWarnings("unchecked")
public List<City> loadListEagerly(CityFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(regionCountryCriteria, "{alias}.code", filter.getRegionCountryCode());
addStringContainsRestriction(regionCriteria, "{alias}.code", filter.getRegionCode());
addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());
return criteria.list();
}

/**
 * load object list from region
 */
@Override
@SuppressWarnings("unchecked")
public List<City> loadListFromRegion(Long regionId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
return criteria.list();
}

/**
 * load object list eagerly from region
 */
@Override
@SuppressWarnings("unchecked")
public List<City> loadListEagerlyFromRegion(Long regionId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
if (regionId == null){
criteria.add(Restrictions.isNull("region.id"));
} else {
criteria.add(Restrictions.eq("region.id", regionId));
}
criteria.setFetchMode("region",FetchMode.JOIN);
criteria.setFetchMode("region.country",FetchMode.JOIN);
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