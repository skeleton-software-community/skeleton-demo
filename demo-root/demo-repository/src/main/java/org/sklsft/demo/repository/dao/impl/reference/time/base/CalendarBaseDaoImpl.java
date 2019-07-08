package org.sklsft.demo.repository.dao.impl.reference.time.base;

import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addBetweenRestriction;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addOrder;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.OrderType;
import org.sklsft.commons.model.patterns.BaseDaoImpl;
import org.sklsft.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.reference.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.sklsft.demo.api.model.reference.time.sortings.CalendarSorting;
import org.sklsft.demo.model.reference.time.Calendar;
import org.sklsft.demo.model.reference.time.CalendarDayOff;
import org.sklsft.demo.repository.dao.interfaces.reference.time.base.CalendarBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseDaoImpl extends BaseDaoImpl<Calendar, Integer> implements CalendarBaseDao {

/**
 * constructor
 */
public CalendarBaseDaoImpl() {
super(Calendar.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings("unchecked")
public List<Calendar> loadListEagerly() {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Calendar.class);
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * count filtered object list
 */
@Override
public Long count(CalendarFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Calendar.class).setProjection(Projections.rowCount());
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Calendar> scroll(CalendarFilter filter, CalendarSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Calendar.class);
addStringContainsRestriction(criteria, "{alias}.CODE", filter.getCode());
addStringContainsRestriction(criteria, "{alias}.LABEL", filter.getLabel());
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
 * load one to many component CalendarDayOff list
 */
@Override
@SuppressWarnings("unchecked")
public List<CalendarDayOff> loadCalendarDayOffList(Integer calendarId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CalendarDayOff.class);
if (calendarId == null){
criteria.add(Restrictions.isNull("calendar.id"));
} else {
criteria.add(Restrictions.eq("calendar.id", calendarId));
}
addOrder(criteria, "id", OrderType.DESC);
return criteria.list();
}

/**
 * count one to many component CalendarDayOff
 */
@Override
public Long countCalendarDayOff(Integer calendarId) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CalendarDayOff.class).setProjection(Projections.rowCount());
if (calendarId == null){
criteria.add(Restrictions.isNull("calendar.id"));
} else {
criteria.add(Restrictions.eq("calendar.id", calendarId));
}
return (Long) criteria.uniqueResult();
}

/**
@Override
 * count filtered one to many component CalendarDayOff
 */
public Long countCalendarDayOff(Integer calendarId, CalendarDayOffFilter filter) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CalendarDayOff.class).setProjection(Projections.rowCount());
if (calendarId == null){
criteria.add(Restrictions.isNull("calendar.id"));
} else {
criteria.add(Restrictions.eq("calendar.id", calendarId));
}
addBetweenRestriction(criteria, "dayOffDate", filter.getDayOffDateMinValue(), filter.getDayOffDateMaxValue());
addStringContainsRestriction(criteria, "{alias}.DAY_OFF_LABEL", filter.getDayOffLabel());
return (Long) criteria.uniqueResult();
}

/**
 * scroll filtered one to many component CalendarDayOff
 */
@Override
@SuppressWarnings("unchecked")
public List<CalendarDayOff> scrollCalendarDayOff(Integer calendarId, CalendarDayOffFilter filter, CalendarDayOffSorting sorting, Long firstResult, Long maxResults) {
Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CalendarDayOff.class);
if (calendarId == null){
criteria.add(Restrictions.isNull("calendar.id"));
} else {
criteria.add(Restrictions.eq("calendar.id", calendarId));
}
addBetweenRestriction(criteria, "dayOffDate", filter.getDayOffDateMinValue(), filter.getDayOffDateMaxValue());
addStringContainsRestriction(criteria, "{alias}.DAY_OFF_LABEL", filter.getDayOffLabel());
addOrder(criteria, "dayOffDate", sorting.getDayOffDateOrderType());
addOrder(criteria, "dayOffLabel", sorting.getDayOffLabelOrderType());
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
 * load one to many component CalendarDayOff
 */
@Override
public CalendarDayOff loadCalendarDayOff(Integer id) {
CalendarDayOff calendarDayOff = (CalendarDayOff)this.sessionFactory.getCurrentSession().get(CalendarDayOff.class,id);
if (calendarDayOff == null) {
throw new ObjectNotFoundException("CalendarDayOff.notFound");
} else {
return calendarDayOff;
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
Calendar calendar = (Calendar)this.sessionFactory.getCurrentSession().createCriteria(Calendar.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return calendar != null;
}

/**
 * find object or null
 */
@Override
public Calendar findOrNull(String code) {
Calendar calendar = (Calendar)this.sessionFactory.getCurrentSession().createCriteria(Calendar.class)
.add(Restrictions.eq("code",code))
.uniqueResult();
return calendar;
}

/**
 * find object
 */
@Override
public Calendar find(String code) {
if (code == null) {
return null;
}
Calendar calendar = findOrNull(code);
if (calendar == null) {
throw new ObjectNotFoundException("Calendar.notFound");
} else {
return calendar;
}
}

/**
 * save one to many component CalendarDayOff
 */
@Override
public void saveCalendarDayOff(Calendar calendar, CalendarDayOff calendarDayOff) {
calendarDayOff.setCalendar(calendar);
this.sessionFactory.getCurrentSession().save(calendarDayOff);
}

/**
 * delete one to many component CalendarDayOff
 */
@Override
public void deleteCalendarDayOff(CalendarDayOff calendarDayOff) {
calendarDayOff.getCalendar().getCalendarDayOffCollection().remove(calendarDayOff);
this.sessionFactory.getCurrentSession().delete(calendarDayOff);
}

}