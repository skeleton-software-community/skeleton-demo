package org.sklsft.demo.persistence.impl.dummy.base;

import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addBetweenRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addBooleanRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.addStringContainsRestriction;
import static org.sklsft.commons.model.patterns.JpaCriteriaUtils.getStringContainsRestriction;

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
@SuppressWarnings("unused")
public List<Fool> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Fool> criteria = builder.createQuery(Fool.class);

Root<Fool> root = criteria.from(Fool.class);

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
public Long count(FoolFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Fool> root = criteria.from(Fool.class);

List<Predicate> predicates = new ArrayList<>();
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("description"), filter.getDescription());
addBetweenRestriction(builder, predicates, root.get("longField"), filter.getLongFieldMinValue(), filter.getLongFieldMaxValue());
addBooleanRestriction(builder, predicates, root.get("booleanField"), filter.getBooleanField());
addBetweenRestriction(builder, predicates, root.get("doubleField"), filter.getDoubleFieldMinValue(), filter.getDoubleFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get("decimalField"), filter.getDecimalFieldMinValue(), filter.getDecimalFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get("dateField"), filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get("datetimeField"), filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
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
addStringContainsRestriction(builder, predicates, root.get("code"), filter.getCode());
addStringContainsRestriction(builder, predicates, root.get("description"), filter.getDescription());
addBetweenRestriction(builder, predicates, root.get("longField"), filter.getLongFieldMinValue(), filter.getLongFieldMaxValue());
addBooleanRestriction(builder, predicates, root.get("booleanField"), filter.getBooleanField());
addBetweenRestriction(builder, predicates, root.get("doubleField"), filter.getDoubleFieldMinValue(), filter.getDoubleFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get("decimalField"), filter.getDecimalFieldMinValue(), filter.getDecimalFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get("dateField"), filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
addBetweenRestriction(builder, predicates, root.get("datetimeField"), filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get("code"), sorting.getCodeOrderType());
addOrder(builder, orders, root.get("description"), sorting.getDescriptionOrderType());
addOrder(builder, orders, root.get("longField"), sorting.getLongFieldOrderType());
addOrder(builder, orders, root.get("booleanField"), sorting.getBooleanFieldOrderType());
addOrder(builder, orders, root.get("doubleField"), sorting.getDoubleFieldOrderType());
addOrder(builder, orders, root.get("decimalField"), sorting.getDecimalFieldOrderType());
addOrder(builder, orders, root.get("dateField"), sorting.getDateFieldOrderType());
addOrder(builder, orders, root.get("datetimeField"), sorting.getDatetimeFieldOrderType());
addOrder(builder, orders, root.get("id"), OrderType.DESC);
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
addEqualsRestriction(builder, predicates, root.get("code"), code);
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

Predicate predicate = getStringContainsRestriction(builder, root.get("code"), arg);
if (predicate!=null){
criteria.where(predicate);
}

criteria.select(root);

Query<Fool> query = session.createQuery(criteria);
query.setMaxResults(20);
return query.getResultList();
}

}