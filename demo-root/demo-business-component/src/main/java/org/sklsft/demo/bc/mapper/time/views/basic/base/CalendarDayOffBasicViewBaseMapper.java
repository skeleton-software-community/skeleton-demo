package org.sklsft.demo.bc.mapper.time.views.basic.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.bc.rightsmanager.time.CalendarRightsManager;
import org.sklsft.demo.bc.statemanager.time.CalendarStateManager;
import org.sklsft.demo.model.time.CalendarDayOff;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarDayOffBasicViewBaseMapper extends BasicMapperImpl<CalendarDayOffBasicView, CalendarDayOff> {

public CalendarDayOffBasicViewBaseMapper() {
super(CalendarDayOffBasicView.class, CalendarDayOff.class);
}

/*
 * properties
 */

@Inject
protected CalendarRightsManager calendarRightsManager;
@Inject
protected CalendarStateManager calendarStateManager;

/**
 * mapping view from object
 */
@Override
public CalendarDayOffBasicView mapFrom(CalendarDayOffBasicView calendarDayOffBasicView, CalendarDayOff calendarDayOff) {
calendarDayOffBasicView = super.mapFrom(calendarDayOffBasicView, calendarDayOff);
calendarDayOffBasicView.setSelected(false);
calendarDayOffBasicView.setCanDelete(calendarRightsManager.canDeleteCalendarDayOff(calendarDayOff) && calendarStateManager.canDeleteCalendarDayOff(calendarDayOff));
return calendarDayOffBasicView;
}

/**
 * mapping view to object
 */
@Override
public CalendarDayOff mapTo(CalendarDayOffBasicView calendarDayOffBasicView, CalendarDayOff calendarDayOff) {
calendarDayOff = super.mapTo(calendarDayOffBasicView, calendarDayOff);
return calendarDayOff;
}

}
