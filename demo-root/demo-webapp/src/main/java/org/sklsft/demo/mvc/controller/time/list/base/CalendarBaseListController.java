package org.sklsft.demo.mvc.controller.time.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.time.CalendarService;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.sortings.CalendarSorting;
import org.sklsft.demo.api.model.time.views.basic.CalendarBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.time.list.CalendarListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseListController extends BaseController {

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
protected CalendarListView calendarListView;

/*
 * getters and setters
 */
public CalendarListView getCalendarListView() {
return calendarListView;
}
public void setCalendarListView(CalendarListView calendarListView) {
this.calendarListView = calendarListView;
}

/**
 * load object list
 */
public void load() {
this.reset();
}

/**
 * refresh object list
 */
public void refresh() {
calendarListView.setScrollView(calendarService.scroll(calendarListView.getScrollForm()));
calendarListView.getScrollForm().setPage(calendarListView.getScrollView().getCurrentPage());
}

/**
 * create object
 */
public void createCalendar() {
try {
this.calendarListView.setSelectedCalendar(this.calendarService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
public void save() {
executeAjaxMethod("Calendar.save", new AjaxMethodTemplate() {
@Override
public Object execute() {
return calendarService.save(calendarListView.getSelectedCalendar().getForm());
}
@Override
public void redirectOnComplete(Object result) {
redirect("/sections/time/calendar/details.jsf?id=" + result);
}
});
}
/**
 * edit object
 */
public void editCalendar(Long id) {
calendarListView.setSelectedCalendar(calendarService.load(id));
}

/**
 * update object
 */
@AjaxMethod("Calendar.update")
public void update() {
calendarService.update(this.calendarListView.getSelectedCalendar().getId(), this.calendarListView.getSelectedCalendar().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("Calendar.delete")
public void delete(Long id) {
calendarService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("Calendar.deleteList")
public void deleteList() {
List<Long> ids = new ArrayList<>();
for (CalendarBasicView calendar:calendarListView.getScrollView().getElements()) {
if (calendar.getSelected()) {
ids.add(calendar.getId());
}
}
calendarService.deleteList(ids);
this.refresh();
}

/**
 * reset filters and sortings
 */
public void reset() {
this.calendarListView.setScrollForm(new ScrollForm<>());
this.calendarListView.getScrollForm().setFilter(new CalendarFilter());
this.calendarListView.getScrollForm().setSorting(new CalendarSorting());
refresh();
}

}
