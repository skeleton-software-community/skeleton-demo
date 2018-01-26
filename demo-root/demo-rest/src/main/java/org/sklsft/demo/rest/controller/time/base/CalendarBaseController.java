package org.sklsft.demo.rest.controller.time.base;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.time.CalendarService;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.forms.CalendarForm;
import org.sklsft.demo.api.model.time.sortings.CalendarSorting;
import org.sklsft.demo.api.model.time.views.basic.CalendarBasicView;
import org.sklsft.demo.api.model.time.views.full.CalendarFullView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * create object
 */
@RequestMapping(value = {CalendarService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody CalendarFullView create() {
return calendarService.create();
}

/**
 * save object
 */
@RequestMapping(value = {CalendarService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@RequestBody CalendarForm calendarForm) {
return calendarService.save(calendarForm);
}

/**
 * update object
 */
@RequestMapping(value = {CalendarService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @RequestBody CalendarForm calendarForm) {
calendarService.update(id, calendarForm);
}

/**
 * delete object
 */
@RequestMapping(value = {CalendarService.DELETE_URL}, method = RequestMethod.DELETE)
void delete(@PathVariable("id") Long id) {
calendarService.delete(id);
}

}
