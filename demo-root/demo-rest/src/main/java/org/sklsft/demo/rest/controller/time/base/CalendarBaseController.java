package org.sklsft.demo.rest.controller.time.base;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.time.CalendarService;
import org.sklsft.demo.api.model.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.time.forms.CalendarForm;
import org.sklsft.demo.api.model.time.sortings.CalendarDayOffSorting;
import org.sklsft.demo.api.model.time.sortings.CalendarSorting;
import org.sklsft.demo.api.model.time.views.basic.CalendarBasicView;
import org.sklsft.demo.api.model.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.api.model.time.views.full.CalendarDayOffFullView;
import org.sklsft.demo.api.model.time.views.full.CalendarFullView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * auto generated base rest controller file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Controller
public class CalendarBaseController {

/*
 * services injected by spring
 */
@Inject
protected CalendarService calendarService;

/**
 * get options
 */
@RequestMapping(value = {CalendarService.GET_OPTIONS_URL}, method = RequestMethod.GET)
public @ResponseBody List<SelectItem> getOptions() {
return calendarService.getOptions();
}

/**
 * load object list
 */
@RequestMapping(value = {CalendarService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<CalendarBasicView> loadList() {
return calendarService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {CalendarService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<CalendarBasicView> scroll(@RequestBody ScrollForm<CalendarFilter, CalendarSorting> form) {
return calendarService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {CalendarService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody CalendarFullView load(@PathVariable("id") Long id) {
return calendarService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {CalendarService.FIND_URL}, method = RequestMethod.GET)
@ResponseBody CalendarFullView find(@RequestParam("code") String code) {
return calendarService.find(code);
}

/**
 * load one to many component calendarDayOff list
 */
@RequestMapping(value = {CalendarService.GET_CALENDAR_DAY_OFF_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<CalendarDayOffBasicView> loadCalendarDayOffList(@PathVariable("id") Long id) {
return calendarService.loadCalendarDayOffList(id);
}

/**
 * scroll one to many component calendarDayOff
 */
@RequestMapping(value = {CalendarService.SCROLL_CALENDAR_DAY_OFF_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (@PathVariable("calendarId") Long calendarId, @RequestBody ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form) {
return calendarService.scrollCalendarDayOff(calendarId, form);
}

/**
 * load one to many component calendarDayOff
 */
@RequestMapping(value = {CalendarService.GET_CALENDAR_DAY_OFF_URL}, method = RequestMethod.GET)
public @ResponseBody CalendarDayOffFullView loadCalendarDayOff(@PathVariable("id") Long id) {
return calendarService.loadCalendarDayOff(id);
}

/**
 * create object
 */
@RequestMapping(value = {CalendarService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody CalendarFullView create() {
return calendarService.create();
}

/**
 * create one to many component calendarDayOff
 */
@RequestMapping(value = {CalendarService.GET_NEW_CALENDAR_DAY_OFF_URL}, method = RequestMethod.GET)
public @ResponseBody CalendarDayOffFullView createCalendarDayOff(@PathVariable("id") Long id) {
return calendarService.createCalendarDayOff(id);
}

/**
 * save object
 */
@RequestMapping(value = {CalendarService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@RequestBody CalendarForm form) {
return calendarService.save(form);
}

/**
 * save one to many component calendarDayOff
 */
@RequestMapping(value = {CalendarService.SAVE_CALENDAR_DAY_OFF_URL}, method = RequestMethod.POST)
@ResponseBody public void saveCalendarDayOff(@PathVariable("id") Long id, @RequestBody CalendarDayOffForm form) {
calendarService.saveCalendarDayOff(id, form);
}

/**
 * update object
 */
@RequestMapping(value = {CalendarService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @RequestBody CalendarForm form) {
calendarService.update(id, form);
}

/**
 * update one to many component calendarDayOff
 */
@RequestMapping(value = {CalendarService.UPDATE_CALENDAR_DAY_OFF_URL}, method = RequestMethod.PUT)
void updateCalendarDayOff(Long id, CalendarDayOffForm form) {
calendarService.updateCalendarDayOff(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {CalendarService.DELETE_URL}, method = RequestMethod.DELETE)
void delete(@PathVariable("id") Long id) {
calendarService.delete(id);
}

/**
 * delete one to many component calendarDayOff
 */
@RequestMapping(value = {CalendarService.DELETE_CALENDAR_DAY_OFF_URL}, method = RequestMethod.DELETE)
public void deleteCalendarDayOff(@PathVariable("id")Long id) {
calendarService.deleteCalendarDayOff(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {CalendarService.DELETE_LIST_URL}, method = RequestMethod.POST)
@ResponseBody void deleteList(@RequestBody List<Long> idList) {
calendarService.deleteList(idList);
}

/**
 * delete one to many component calendarDayOff list
 */
@RequestMapping(value = {CalendarService.DELETE_CALENDAR_DAY_OFF_LIST_URL}, method = RequestMethod.POST)
@ResponseBody void deleteCalendarDayOffList(List<Long> idList) {
calendarService.deleteCalendarDayOffList(idList);
}

}
