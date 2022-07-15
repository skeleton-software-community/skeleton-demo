package org.sklsft.demo.persistence.impl.dummy.base;

import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addBetweenRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addBooleanRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.getStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.OrderType;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.model.dummy.Fool;
import org.sklsft.demo.model.dummy.Fool_;
import org.sklsft.demo.persistence.interfaces.dummy.base.FoolBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseDaoImpl extends BaseDaoImpl<Fool, String> implements FoolBaseDao {

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
@SuppressWarnings({"unused","unchecked"})
public List<Fool> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Fool> criteria = builder.createQuery(Fool.class);

Root<Fool> root = criteria.from(Fool.class);

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Fool_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(FoolFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Fool> root = criteria.from(Fool.class);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Fool_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Fool_.description), filter.getDescription());
addBetweenRestriction(builder, predicates, root.get(Fool_.longField), filter.getLongFieldMinValue(), filter.getLongFieldMaxValue());
addBooleanRestriction(builder, predicates, root.get(Fool_.booleanField), filter.getBooleanField());
addBetweenRestriction(builder, predicates, root.get(Fool_.doubleField), filter.getDoubleFieldMinValue(), filter.getDoubleFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get(Fool_.decimalField), filter.getDecimalFieldMinValue(), filter.getDecimalFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get(Fool_.dateField), filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get(Fool_.datetimeField), filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Fool> scroll(FoolFilter filter, FoolSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Fool> criteria = builder.createQuery(Fool.class);

Root<Fool> root = criteria.from(Fool.class);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Fool_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Fool_.description), filter.getDescription());
addBetweenRestriction(builder, predicates, root.get(Fool_.longField), filter.getLongFieldMinValue(), filter.getLongFieldMaxValue());
addBooleanRestriction(builder, predicates, root.get(Fool_.booleanField), filter.getBooleanField());
addBetweenRestriction(builder, predicates, root.get(Fool_.doubleField), filter.getDoubleFieldMinValue(), filter.getDoubleFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get(Fool_.decimalField), filter.getDecimalFieldMinValue(), filter.getDecimalFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get(Fool_.dateField), filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get(Fool_.datetimeField), filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Fool_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(Fool_.description), sorting.getDescriptionOrderType());
addOrder(builder, orders, root.get(Fool_.longField), sorting.getLongFieldOrderType());
addOrder(builder, orders, root.get(Fool_.booleanField), sorting.getBooleanFieldOrderType());
addOrder(builder, orders, root.get(Fool_.doubleField), sorting.getDoubleFieldOrderType());
addOrder(builder, orders, root.get(Fool_.decimalField), sorting.getDecimalFieldOrderType());
addOrder(builder, orders, root.get(Fool_.dateField), sorting.getDateFieldOrderType());
addOrder(builder, orders, root.get(Fool_.datetimeField), sorting.getDatetimeFieldOrderType());
addOrder(builder, orders, root.get(Fool_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Fool> query = session.createQuery(criteria);
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
public Fool findOrNull(String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Fool> criteria = builder.createQuery(Fool.class);

Root<Fool> root = criteria.from(Fool.class);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, root.get(Fool_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).uniqueResult();
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

/**
 * exists object
 */
@Override
public boolean exists(String code) {
if (code == null) {
return false;
}
Fool fool = findOrNull(code);
return fool != null;
}

/**
 * search
 */
@Override
public List<Fool> search(String arg) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Fool> criteria = builder.createQuery(Fool.class);

Root<Fool> root = criteria.from(Fool.class);

Predicate predicate = getStringStartsWithRestriction(builder, root.get(Fool_.code), arg);
if (predicate!=null){
criteria.where(predicate);
}

criteria.select(root);

Query<Fool> query = session.createQuery(criteria);
query.setMaxResults(20);
return query.getResultList();
}

}