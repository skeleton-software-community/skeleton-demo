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
import org.sklsft.demo.api.model.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.localization.orderings.CountryOrdering;
import org.sklsft.demo.model.localization.Country;
import org.sklsft.demo.repository.dao.interfaces.localization.base.CountryBaseDao;
import org.springframework.stereotype.Repository;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.*;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseDaoImpl extends BaseDaoImpl<Country, Long> implements CountryBaseDao {

/**
 * constructor
 */
public CountryBaseDaoImpl() {
super(Country.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unchecked")
public List<Country> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Country.class);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(CountryFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Country.class).setProjection(Projections.rowCount());
addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
public List<Country> scroll(CountryFilter filter, CountryOrdering ordering, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Country.class);
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
public boolean exists(String code) {
if (code == null) {
return false;
}
Country country = (Country)this.sessionFactory.getCurrentSession().createCriteria(Country.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return country != null;
}

/**
 * find object or null
 */
@Override
public Country findOrNull(String code) {
Country country = (Country)this.sessionFactory.getCurrentSession().createCriteria(Country.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return country;
}

/**
 * find object
 */
@Override
public Country find(String code) {
if (code == null) {
return null;
}
Country country = findOrNull(code);
if (country == null) {
throw new ObjectNotFoundException("Country.notFound");
} else {
return country;
}
}

}