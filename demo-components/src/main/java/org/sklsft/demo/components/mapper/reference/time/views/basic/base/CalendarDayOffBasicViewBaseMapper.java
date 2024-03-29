package org.sklsft.demo.components.mapper.reference.time.views.basic.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.reference.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.sklsft.demo.components.statemanager.reference.time.CalendarStateManager;
import org.sklsft.demo.model.reference.time.CalendarDayOff;
import org.springframework.beans.factory.annotation.Autowired;

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

@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
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
