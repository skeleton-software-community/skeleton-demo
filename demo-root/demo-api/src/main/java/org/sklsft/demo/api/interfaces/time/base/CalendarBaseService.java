package org.sklsft.demo.api.interfaces.time.base;

import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.time.forms.CalendarForm;
import org.sklsft.demo.api.model.time.sortings.CalendarSorting;
import org.sklsft.demo.api.model.time.views.basic.CalendarBasicView;
import org.sklsft.demo.api.model.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.api.model.time.views.full.CalendarDayOffFullView;
import org.sklsft.demo.api.model.time.views.full.CalendarFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CalendarBaseService {

/**
 * get options
 */
List<String> getOptions();

/**
 * load object list
 */
List<CalendarBasicView> loadList();

/**
 * scroll object list
 */
ScrollView<CalendarBasicView> scroll(ScrollForm<CalendarFilter, CalendarSorting> form);

/**
 * load object
 */
CalendarFullView load(Long id);

/**
 * find object
 */
CalendarFullView find(String code);

/**
 * load one to many component calendarDayOff list
 */
List<CalendarDayOffBasicView> loadCalendarDayOffList(Long id);

/**
 * load one to many component calendarDayOff
 */
CalendarDayOffFullView loadCalendarDayOff(Long calendarDayOffId,Long id);

/**
 * create object
 */
CalendarFullView create();

/**
 * create one to many component calendarDayOff
 */
CalendarDayOffFullView createCalendarDayOff(Long id);

/**
 * save object
 */
Long save(CalendarForm calendarForm);

/**
 * save one to many component calendarDayOff
 */
void saveCalendarDayOff(Long id, CalendarDayOffForm calendarDayOffForm);

/**
 * update object
 */
void update(Long id, CalendarForm calendarForm);

/**
 * update one to many component calendarDayOff
 */
void updateCalendarDayOff(Long id, CalendarDayOffForm calendarDayOffForm);

/**
 * delete object
 */
void delete(Long id);

/**
 * delete one to many component calendarDayOff
 */
void deleteCalendarDayOff(Long id);

/**
 * delete object list
 */
void deleteList(List<Long> idList);

/**
 * delete one to many component calendarDayOff list
 */
void deleteCalendarDayOffList(List<Long> idList);

}
