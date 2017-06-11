package org.sklsft.demo.repository.dao.impl.localization.base;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.base.RegionBaseDao;

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
 * exists object
 */
@Override
public boolean exists(String countryCode, String code) {
if (countryCode == null && code == null) {
return false;
}
Region region = (Region)this.sessionFactory.getCurrentSession().createCriteria(Region.class)
.createAlias("country","Country")
.add(Restrictions.eq("Country.code",countryCode))
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
.createAlias("country","Country")
.add(Restrictions.eq("Country.code",countryCode))
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