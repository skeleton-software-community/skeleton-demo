package org.sklsft.demo.mvc.controller.reference.time.detail.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.reference.time.CalendarService;
import org.sklsft.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.sklsft.demo.api.model.reference.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.reference.time.detail.CalendarDetailView;

/**
 * auto generated base detail controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseDetailController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected CalendarService calendarService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected CalendarDetailView calendarDetailView;

/**
 * load object
 */
public void load() {
calendarDetailView.setSelectedCalendar(this.calendarService.load(this.calendarDetailView.getSelectedCalendar().getId()));
}


/**
 * load one to many component calendarDayOff list
 */
public void loadCalendarDayOffList() {
this.resetCalendarDayOffFilter();
}

/**
 * refresh one to many calendarDayOff list
 */
public void refreshCalendarDayOffList() {
calendarDetailView.setCalendarDayOffScrollView(calendarService.scrollCalendarDayOff(calendarDetailView.getSelectedCalendar().getId(), calendarDetailView.getCalendarDayOffScrollForm()));
calendarDetailView.getCalendarDayOffScrollForm().setPage(calendarDetailView.getCalendarDayOffScrollView().getCurrentPage());
}

/**
 * create one to many component calendarDayOff
 */
public void createCalendarDayOff() {
try {
calendarDetailView.setSelectedCalendarDayOff(this.calendarService.createCalendarDayOff(this.calendarDetailView.getSelectedCalendar().getId()));
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save one to many component calendarDayOff
 */
@AjaxMethod("CalendarDayOff.save")
public void saveCalendarDayOff() {
calendarService.saveCalendarDayOff(this.calendarDetailView.getSelectedCalendar().getId(), calendarDetailView.getSelectedCalendarDayOff().getForm());
loadCalendarDayOffList();
}

/**
 * update object
 */
@AjaxMethod("Calendar.update")
public void update() {
calendarService.update(calendarDetailView.getSelectedCalendar().getId(), calendarDetailView.getSelectedCalendar().getForm());
load();
}

/**
 * edit one to many component calendarDayOff
 */
public void editCalendarDayOff(Integer id) {
calendarDetailView.setSelectedCalendarDayOff(calendarService.loadCalendarDayOff(id));
}

/**
 * update one to many component calendarDayOff
 */
@AjaxMethod("CalendarDayOff.update")
public void updateCalendarDayOff() {
calendarService.updateCalendarDayOff(calendarDetailView.getSelectedCalendarDayOff().getId(), calendarDetailView.getSelectedCalendarDayOff().getForm());
loadCalendarDayOffList();
}

/**
 * delete one to many component calendarDayOff
 */
@AjaxMethod("CalendarDayOff.delete")
public void deleteCalendarDayOff(Integer id) {
calendarService.deleteCalendarDayOff(id);
loadCalendarDayOffList();
}

/**
 * delete one to many component calendarDayOff list
 */
@AjaxMethod("CalendarDayOff.deleteList")
public void deleteCalendarDayOffList() {
List<Integer> ids = new ArrayList<>();
for (CalendarDayOffBasicView calendarDayOff:calendarDetailView.getCalendarDayOffScrollView().getElements()) {
if (calendarDayOff.getSelected()) {
ids.add(calendarDayOff.getId());
}
}
calendarService.deleteCalendarDayOffList(ids);
loadCalendarDayOffList();
}

/**
 * reset one to many component CalendarDayOffFilter datatable filter
 */
public void resetCalendarDayOffFilter() {
this.calendarDetailView.setCalendarDayOffScrollForm(new ScrollForm<>());
this.calendarDetailView.getCalendarDayOffScrollForm().setFilter(new CalendarDayOffFilter());
this.calendarDetailView.getCalendarDayOffScrollForm().setSorting(new CalendarDayOffSorting());
refreshCalendarDayOffList();
}

}
