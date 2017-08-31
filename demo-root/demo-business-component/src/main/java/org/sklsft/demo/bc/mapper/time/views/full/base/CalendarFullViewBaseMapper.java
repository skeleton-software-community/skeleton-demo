package org.sklsft.demo.bc.mapper.time.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.time.forms.CalendarForm;
import org.sklsft.demo.api.model.time.views.full.CalendarFullView;
import org.sklsft.demo.bc.rightsmanager.time.CalendarRightsManager;
import org.sklsft.demo.bc.statemanager.time.CalendarStateManager;
import org.sklsft.demo.model.time.Calendar;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class CalendarFullViewBaseMapper extends FullViewMapper<CalendarFullView, Long, CalendarForm, Calendar> {

@Inject
protected CalendarRightsManager calendarRightsManager;
@Inject
protected CalendarStateManager calendarStateManager;

public CalendarFullViewBaseMapper() {
super(CalendarFullView.class, Calendar.class);
}

@Override
public CalendarFullView mapFrom(CalendarFullView calendarFullView, Calendar calendar) {
calendarFullView = super.mapFrom(calendarFullView, calendar);
calendarFullView.setCanUpdate(calendarRightsManager.canUpdate(calendar) && calendarStateManager.canUpdate(calendar));
return calendarFullView;
}

}
