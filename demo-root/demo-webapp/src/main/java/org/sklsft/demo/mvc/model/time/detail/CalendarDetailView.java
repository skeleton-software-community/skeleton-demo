package org.sklsft.demo.mvc.model.time.detail;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.time.sortings.CalendarDayOffSorting;
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

protected ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> calendarDayOffScrollForm = new ScrollForm<>();
protected ScrollView<CalendarDayOffBasicView> calendarDayOffScrollView = new ScrollView<>();
private CalendarDayOffFullView selectedCalendarDayOff = new CalendarDayOffFullView();

/*
 * getters and setters
 */
public CalendarFullView getSelectedCalendar() {
return selectedCalendar;
}
public void setSelectedCalendar(CalendarFullView selectedCalendar) {
this.selectedCalendar = selectedCalendar;
}

public ScrollView<CalendarDayOffBasicView> getCalendarDayOffScrollView() {
return calendarDayOffScrollView;
}
public void setCalendarDayOffScrollView(ScrollView<CalendarDayOffBasicView> calendarDayOffScrollView) {
this.calendarDayOffScrollView = calendarDayOffScrollView;
}

public ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> getCalendarDayOffScrollForm() {
return calendarDayOffScrollForm;
}
public void setCalendarDayOffScrollForm(ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> calendarDayOffScrollForm) {
this.calendarDayOffScrollForm = calendarDayOffScrollForm;
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
