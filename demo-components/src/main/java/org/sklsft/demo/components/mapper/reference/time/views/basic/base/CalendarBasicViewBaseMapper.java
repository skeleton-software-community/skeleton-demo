package org.sklsft.demo.components.mapper.reference.time.views.basic.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.reference.time.views.basic.CalendarBasicView;
import org.sklsft.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.sklsft.demo.components.statemanager.reference.time.CalendarStateManager;
import org.sklsft.demo.model.reference.time.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBasicViewBaseMapper extends BasicMapperImpl<CalendarBasicView, Calendar> {

public CalendarBasicViewBaseMapper() {
super(CalendarBasicView.class, Calendar.class);
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
public CalendarBasicView mapFrom(CalendarBasicView calendarBasicView, Calendar calendar) {
calendarBasicView = super.mapFrom(calendarBasicView, calendar);
calendarBasicView.setSelected(false);
calendarBasicView.setCanDelete(calendarRightsManager.canDelete(calendar) && calendarStateManager.canDelete(calendar));
return calendarBasicView;
}

/**
 * mapping view to object
 */
@Override
public Calendar mapTo(CalendarBasicView calendarBasicView, Calendar calendar) {
calendar = super.mapTo(calendarBasicView, calendar);
return calendar;
}

}
