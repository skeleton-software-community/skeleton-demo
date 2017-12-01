package org.sklsft.demo.repository.dao.impl.dummy.base;

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
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.model.dummy.Stupid;
import org.sklsft.demo.repository.dao.interfaces.dummy.base.StupidBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseDaoImpl extends BaseDaoImpl<Stupid, Long> implements StupidBaseDao {

/**
 * constructor
 */
public StupidBaseDaoImpl() {
super(Stupid.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unchecked")
public List<Stupid> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Stupid.class);
criteria.setFetchMode("fool",FetchMode.JOIN);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(StupidFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Stupid.class).setProjection(Projections.rowCount());
Criteria foolCriteria = criteria.createCriteria("fool", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(foolCriteria, "{alias}.CODE", filter.getFoolCode());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Stupid> scroll(StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Stupid.class);
Criteria foolCriteria = criteria.createCriteria("fool", JoinType.LEFT_OUTER_JOIN);
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(foolCriteria, "{alias}.CODE", filter.getFoolCode());
addOrder(criteria, "code", sorting.getCodeOrderType());
addOrder(foolCriteria, "code", sorting.getFoolCodeOrderType());
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
Stupid stupid = (Stupid)this.sessionFactory.getCurrentSession().createCriteria(Stupid.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return stupid != null;
}

/**
 * find object or null
 */
@Override
public Stupid findOrNull(String code) {
Stupid stupid = (Stupid)this.sessionFactory.getCurrentSession().createCriteria(Stupid.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return stupid;
}

/**
 * find object
 */
@Override
public Stupid find(String code) {
if (code == null) {
return null;
}
Stupid stupid = findOrNull(code);
if (stupid == null) {
throw new ObjectNotFoundException("Stupid.notFound");
} else {
return stupid;
}
}

}