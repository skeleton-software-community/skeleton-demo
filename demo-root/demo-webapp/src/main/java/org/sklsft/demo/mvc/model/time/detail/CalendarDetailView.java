package org.sklsft.demo.mvc.model.time.detail;

import java.io.Serializable;
import java.util.List;

import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.api.model.time.views.full.CalendarDayOffFullView;
import org.sklsft.demo.api.model.time.views.full.CalendarFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class CalendarDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private CalendarFullView selectedCalendar = new CalendarFullView();

private List<CalendarDayOffBasicView> calendarDayOffList;
private CalendarDayOffFilter calendarDayOffFilter = new CalendarDayOffFilter();
private CalendarDayOffFullView selectedCalendarDayOff;

/*
 * getters and setters
 */
public CalendarFullView getSelectedCalendar() {
return selectedCalendar;
}
public void setSelectedCalendar(CalendarFullView selectedCalendar) {
this.selectedCalendar = selectedCalendar;
}

public List<CalendarDayOffBasicView> getCalendarDayOffList() {
return calendarDayOffList;
}
public void setCalendarDayOffList(List<CalendarDayOffBasicView> calendarDayOffList) {
this.calendarDayOffList = calendarDayOffList;
}

public CalendarDayOffFilter getCalendarDayOffFilter() {
return calendarDayOffFilter;
}
public void setCalendarDayOffFilter(CalendarDayOffFilter calendarDayOffFilter) {
this.calendarDayOffFilter = calendarDayOffFilter;
}

public CalendarDayOffFullView getSelectedCalendarDayOff() {
return selectedCalendarDayOff;
}
public void setSelectedCalendarDayOff(CalendarDayOffFullView selectedCalendarDayOff) {
this.selectedCalendarDayOff = selectedCalendarDayOff;
}

/* Specific Code Start */
/* Specific Code End */
}
