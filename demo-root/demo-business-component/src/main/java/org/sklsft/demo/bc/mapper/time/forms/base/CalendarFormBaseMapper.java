package org.sklsft.demo.bc.mapper.time.forms.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.time.forms.CalendarForm;
import org.sklsft.demo.model.time.Calendar;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarFormBaseMapper extends BasicMapperImpl<CalendarForm, Calendar> {

public CalendarFormBaseMapper() {
super(CalendarForm.class, Calendar.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public CalendarForm mapFrom(CalendarForm calendarForm, Calendar calendar) {
calendarForm = super.mapFrom(calendarForm, calendar);
return calendarForm;
}

/**
 * mapping view to object
 */
@Override
public Calendar mapTo(CalendarForm calendarForm, Calendar calendar) {
calendar = super.mapTo(calendarForm, calendar);
return calendar;
}

}
