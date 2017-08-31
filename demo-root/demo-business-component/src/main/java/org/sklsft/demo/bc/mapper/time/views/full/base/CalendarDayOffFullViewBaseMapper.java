package org.sklsft.demo.bc.mapper.time.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.time.views.full.CalendarDayOffFullView;
import org.sklsft.demo.bc.rightsmanager.time.CalendarRightsManager;
import org.sklsft.demo.bc.statemanager.time.CalendarStateManager;
import org.sklsft.demo.model.time.CalendarDayOff;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class CalendarDayOffFullViewBaseMapper extends FullViewMapper<CalendarDayOffFullView, Long, CalendarDayOffForm, CalendarDayOff> {

@Inject
protected CalendarRightsManager calendarRightsManager;
@Inject
protected CalendarStateManager calendarStateManager;

public CalendarDayOffFullViewBaseMapper() {
super(CalendarDayOffFullView.class, CalendarDayOff.class);
}

@Override
public CalendarDayOffFullView mapFrom(CalendarDayOffFullView calendarDayOffFullView, CalendarDayOff calendarDayOff) {
calendarDayOffFullView = super.mapFrom(calendarDayOffFullView, calendarDayOff);
calendarDayOffFullView.setCanUpdate(calendarRightsManager.canUpdateCalendarDayOff(calendarDayOff) && calendarStateManager.canUpdateCalendarDayOff(calendarDayOff));
return calendarDayOffFullView;
}

}
