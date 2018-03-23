package org.sklsft.demo.api.interfaces.time.base;

import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.model.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.time.forms.CalendarForm;
import org.sklsft.demo.api.model.time.sortings.CalendarDayOffSorting;
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
List<SelectItem> getOptions();
public static final String GET_OPTIONS_URL = "/calendar/options";

/**
 * load object list
 */
List<CalendarBasicView> loadList();
public static final String GET_LIST_URL = "/calendar/list";

/**
 * scroll object list
 */
ScrollView<CalendarBasicView> scroll(ScrollForm<CalendarFilter, CalendarSorting> form);
public static final String SCROLL_URL = "/calendar/scroll";

/**
 * load object
 */
CalendarFullView load(Long id);
public static final String GET_URL = "/calendar/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/calendar/find";
CalendarFullView find(String code);

/**
 * load one to many component calendarDayOff list
 */
List<CalendarDayOffBasicView> loadCalendarDayOffList(Long id);
public static final String GET_CALENDAR_DAY_OFF_LIST_URL = "/calendar/{id}/calendar-day-off/list";

/**
 * scroll one to many component calendarDayOff
 */
ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (Long calendarId, ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form);
public static final String SCROLL_CALENDAR_DAY_OFF_URL = "/calendar/{id}/calendar-day-off/scroll";

/**
 * load one to many component calendarDayOff
 */
CalendarDayOffFullView loadCalendarDayOff(Long id);
public static final String GET_CALENDAR_DAY_OFF_URL = "/calendar-day-off/{id}";

/**
 * create object
 */
CalendarFullView create();
public static final String GET_NEW_URL = "/calendar/new";

/**
 * create one to many component calendarDayOff
 */
CalendarDayOffFullView createCalendarDayOff(Long id);
public static final String GET_NEW_CALENDAR_DAY_OFF_URL = "/calendar/{id}/calendar-day-off/new";

/**
 * save object
 */
Long save(CalendarForm calendarForm);
public static final String SAVE_URL = "/calendar";

/**
 * save one to many component calendarDayOff
 */
void saveCalendarDayOff(Long id, CalendarDayOffForm calendarDayOffForm);
public static final String SAVE_CALENDAR_DAY_OFF_URL = "/calendar/{id}/calendar-day-off";

/**
 * update object
 */
void update(Long id, CalendarForm calendarForm);
public static final String UPDATE_URL = "/calendar/{id}";

/**
 * update one to many component calendarDayOff
 */
void updateCalendarDayOff(Long id, CalendarDayOffForm calendarDayOffForm);
public static final String UPDATE_CALENDAR_DAY_OFF_URL = "/calendar-day-off/{id}";

/**
 * delete object
 */
void delete(Long id);
public static final String DELETE_URL = "/calendar/{id}";

/**
 * delete one to many component calendarDayOff
 */
void deleteCalendarDayOff(Long id);
public static final String DELETE_CALENDAR_DAY_OFF_URL = "/calendar-day-off/{id}";

/**
 * delete object list
 */
void deleteList(List<Long> idList);
public static final String DELETE_LIST_URL = "/calendar/delete";

/**
 * delete one to many component calendarDayOff list
 */
void deleteCalendarDayOffList(List<Long> idList);
public static final String DELETE_CALENDAR_DAY_OFF_LIST_URL = "/calendar-day-off/delete";

}
