package org.sklsft.demo.bc.processor.time.base;

import javax.inject.Inject;

import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.time.Calendar;
import org.sklsft.demo.model.time.CalendarDayOff;
import org.sklsft.demo.repository.dao.interfaces.time.CalendarDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseProcessor implements Processor<Calendar, Long> {

/*
 * properties injected by spring
 */
@Inject
protected CalendarDao calendarDao;

/**
 * process save
 */
public Long save(Calendar calendar) {
return calendarDao.save(calendar);
}

/**
 * process save one to many component CalendarDayOff
 */
public void saveCalendarDayOff(CalendarDayOff calendarDayOff,Calendar calendar) {
calendarDao.saveCalendarDayOff(calendar, calendarDayOff);
}

/**
 * process update
 */
public void update(Calendar calendar) {
// Empty by default. Can be overridden
}

/**
 * process update one to many component CalendarDayOff
 */
public void updateCalendarDayOff(CalendarDayOff calendarDayOff) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Calendar calendar) {
calendarDao.delete(calendar);
}

/**
 * process delete one to many component CalendarDayOff
 */
public void deleteCalendarDayOff(CalendarDayOff calendarDayOff) {
calendarDao.deleteCalendarDayOff(calendarDayOff);
}

}
