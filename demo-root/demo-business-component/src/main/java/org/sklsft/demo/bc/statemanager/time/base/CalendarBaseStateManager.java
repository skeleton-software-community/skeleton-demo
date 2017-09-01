package org.sklsft.demo.bc.statemanager.time.base;

import org.sklsft.commons.api.exception.state.InvalidStateException;
import org.sklsft.commons.model.patterns.StateManager;
import org.sklsft.demo.model.time.Calendar;
import org.sklsft.demo.model.time.CalendarDayOff;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseStateManager implements StateManager<Calendar, Long> {

/**
 * can save
 */
public boolean canSave(Calendar calendar) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Calendar calendar) {
if (!canSave(calendar)) {
throw new InvalidStateException("Calendar.save.invalidState");
}
}

/**
 * can save one to many component CalendarDayOff
 */
public boolean canSaveCalendarDayOff(CalendarDayOff calendarDayOff,Calendar calendar) {
return true;
}

/**
 * check can save one to many component CalendarDayOff
 */
public void checkCanSaveCalendarDayOff(CalendarDayOff calendarDayOff,Calendar calendar) {
if (!canSaveCalendarDayOff(calendarDayOff, calendar)) {
throw new InvalidStateException("CalendarDayOff.save.invalidState");
}
}

/**
 * can update
 */
public boolean canUpdate(Calendar calendar) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Calendar calendar) {
if (!canUpdate(calendar)) {
throw new InvalidStateException("Calendar.update.invalidState");
}
}

/**
 * can update one to many component CalendarDayOff
 */
public boolean canUpdateCalendarDayOff(CalendarDayOff calendarDayOff) {
return true;
}

/**
 * check can update one to many component CalendarDayOff
 */
public void checkCanUpdateCalendarDayOff(CalendarDayOff calendarDayOff) {
if (!canUpdateCalendarDayOff(calendarDayOff)) {
throw new InvalidStateException("CalendarDayOff.update.invalidState");
}
}

/**
 * can delete
 */
public boolean canDelete(Calendar calendar) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Calendar calendar) {
if (!canDelete(calendar)) {
throw new InvalidStateException("Calendar.delete.invalidState");
}
}

/**
 * can delete one to many component CalendarDayOff
 */
public boolean canDeleteCalendarDayOff(CalendarDayOff calendarDayOff) {
return true;
}

/**
 * check can delete one to many component CalendarDayOff
 */
public void checkCanDeleteCalendarDayOff(CalendarDayOff calendarDayOff) {
if (!canDeleteCalendarDayOff(calendarDayOff)) {
throw new InvalidStateException("CalendarDayOff.delete.invalidState");
}
}

}
