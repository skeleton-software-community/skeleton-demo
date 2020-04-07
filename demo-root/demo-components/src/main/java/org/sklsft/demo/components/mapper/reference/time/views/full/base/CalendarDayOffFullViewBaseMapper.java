package org.sklsft.demo.components.mapper.reference.time.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.reference.time.views.full.CalendarDayOffFullView;
import org.sklsft.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.sklsft.demo.components.statemanager.reference.time.CalendarStateManager;
import org.sklsft.demo.model.reference.time.CalendarDayOff;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class CalendarDayOffFullViewBaseMapper extends FullViewMapper<CalendarDayOffFullView, Integer, CalendarDayOffForm, CalendarDayOff> {

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
