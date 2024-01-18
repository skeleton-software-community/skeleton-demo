package org.sklsft.demo.components.mapper.reference.time.views.full.base;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.reference.time.forms.CalendarForm;
import org.sklsft.demo.api.model.reference.time.views.full.CalendarFullView;
import org.sklsft.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.sklsft.demo.components.statemanager.reference.time.CalendarStateManager;
import org.sklsft.demo.model.reference.time.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class CalendarFullViewBaseMapper extends FullViewMapper<CalendarFullView, Integer, CalendarForm, Calendar> {

@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarStateManager calendarStateManager;

public CalendarFullViewBaseMapper() {
super(CalendarFullView.class, Calendar.class);
}

@Override
public CalendarFullView mapFrom(CalendarFullView calendarFullView, Calendar calendar) {
calendarFullView = super.mapFrom(calendarFullView, calendar);
calendarFullView.setCanUpdate(calendarRightsManager.canUpdate(calendar) && calendarStateManager.canUpdate(calendar));
calendarFullView.setCanDelete(calendarRightsManager.canDelete(calendar) && calendarStateManager.canDelete(calendar));
return calendarFullView;
}

}
