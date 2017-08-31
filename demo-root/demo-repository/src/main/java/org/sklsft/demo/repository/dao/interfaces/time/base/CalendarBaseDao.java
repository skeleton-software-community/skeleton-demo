package org.sklsft.demo.repository.dao.interfaces.time.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.sortings.CalendarSorting;
import org.sklsft.demo.model.time.Calendar;
import org.sklsft.demo.model.time.CalendarDayOff;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CalendarBaseDao extends BaseDao<Calendar, Long> {

/**
 * count filtered object list
 */
Long count(CalendarFilter filter);

/**
 * scroll filtered object list
 */
List<Calendar> scroll(CalendarFilter filter, CalendarSorting ordering, Long firstResult, Long maxResults);

/**
 * load one to many component CalendarDayOff list
 */
List<CalendarDayOff> loadCalendarDayOffList(Long calendarId);

/**
 * count one to many component CalendarDayOff
 */
Long countCalendarDayOff(Long calendarId);

/**
 * count filtered one to many component CalendarDayOff
 */
Long countCalendarDayOff(Long calendarId, CalendarDayOffFilter filter);

/**
 * load one to many component CalendarDayOff
 */
CalendarDayOff loadCalendarDayOff(Long id);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Calendar findOrNull(String code);

/**
 * find object
 */
Calendar find(String code);

/**
 * save one to many component CalendarDayOff
 */
void saveCalendarDayOff(Calendar calendar, CalendarDayOff calendarDayOff);

/**
 * delete one to many component CalendarDayOff
 */
void deleteCalendarDayOff(CalendarDayOff calendarDayOff);

}
