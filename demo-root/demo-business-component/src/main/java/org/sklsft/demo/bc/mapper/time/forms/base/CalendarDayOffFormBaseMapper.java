package org.sklsft.demo.bc.mapper.time.forms.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.time.forms.CalendarDayOffForm;
import org.sklsft.demo.model.time.CalendarDayOff;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarDayOffFormBaseMapper extends BasicMapperImpl<CalendarDayOffForm, CalendarDayOff> {

public CalendarDayOffFormBaseMapper() {
super(CalendarDayOffForm.class, CalendarDayOff.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public CalendarDayOffForm mapFrom(CalendarDayOffForm calendarDayOffForm, CalendarDayOff calendarDayOff) {
calendarDayOffForm = super.mapFrom(calendarDayOffForm, calendarDayOff);
return calendarDayOffForm;
}

/**
 * mapping view to object
 */
@Override
public CalendarDayOff mapTo(CalendarDayOffForm calendarDayOffForm, CalendarDayOff calendarDayOff) {
calendarDayOff = super.mapTo(calendarDayOffForm, calendarDayOff);
return calendarDayOff;
}

}
