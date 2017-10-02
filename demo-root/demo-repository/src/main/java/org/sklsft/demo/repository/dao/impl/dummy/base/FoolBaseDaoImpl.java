package org.sklsft.demo.repository.dao.impl.dummy.base;

import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addBetweenRestriction;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addBooleanRestriction;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.model.dummy.Fool;
import org.sklsft.demo.repository.dao.interfaces.dummy.base.FoolBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseDaoImpl extends BaseDaoImpl<Fool, Long> implements FoolBaseDao {

/**
 * constructor
 */
public FoolBaseDaoImpl() {
super(Fool.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unchecked")
public List<Fool> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Fool.class);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(FoolFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Fool.class).setProjection(Projections.rowCount());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.DESCRIPTION", filter.getDescription());
addBetweenRestriction(criteria, "longField", filter.getLongFieldMinValue(), filter.getLongFieldMaxValue());
addBooleanRestriction(criteria, "booleanField", filter.getBooleanField());
addBetweenRestriction(criteria, "doubleField2", filter.getDoubleField2MinValue(), filter.getDoubleField2MaxValue());
addBetweenRestriction(criteria, "doubleField4", filter.getDoubleField4MinValue(), filter.getDoubleField4MaxValue());
addBetweenRestriction(criteria, "dateField", filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
addBetweenRestriction(criteria, "datetimeField", filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Fool> scroll(FoolFilter filter, FoolSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Fool.class);
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.DESCRIPTION", filter.getDescription());
addBetweenRestriction(criteria, "longField", filter.getLongFieldMinValue(), filter.getLongFieldMaxValue());
addBooleanRestriction(criteria, "booleanField", filter.getBooleanField());
addBetweenRestriction(criteria, "doubleField2", filter.getDoubleField2MinValue(), filter.getDoubleField2MaxValue());
addBetweenRestriction(criteria, "doubleField4", filter.getDoubleField4MinValue(), filter.getDoubleField4MaxValue());
addBetweenRestriction(criteria, "dateField", filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
addBetweenRestriction(criteria, "datetimeField", filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
addOrder(criteria, "code", sorting.getCodeOrderType());
addOrder(criteria, "description", sorting.getDescriptionOrderType());
addOrder(criteria, "longField", sorting.getLongFieldOrderType());
addOrder(criteria, "booleanField", sorting.getBooleanFieldOrderType());
addOrder(criteria, "doubleField2", sorting.getDoubleField2OrderType());
addOrder(criteria, "doubleField4", sorting.getDoubleField4OrderType());
addOrder(criteria, "dateField", sorting.getDateFieldOrderType());
addOrder(criteria, "datetimeField", sorting.getDatetimeFieldOrderType());
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
Fool fool = (Fool)this.sessionFactory.getCurrentSession().createCriteria(Fool.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return fool != null;
}

/**
 * find object or null
 */
@Override
public Fool findOrNull(String code) {
Fool fool = (Fool)this.sessionFactory.getCurrentSession().createCriteria(Fool.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return fool;
}

/**
 * find object
 */
@Override
public Fool find(String code) {
if (code == null) {
return null;
}
Fool fool = findOrNull(code);
if (fool == null) {
throw new ObjectNotFoundException("Fool.notFound");
} else {
return fool;
}
}

}