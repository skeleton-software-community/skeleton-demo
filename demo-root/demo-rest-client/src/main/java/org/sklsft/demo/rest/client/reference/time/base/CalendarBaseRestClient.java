package org.sklsft.demo.rest.client.reference.time.base;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.reference.time.base.CalendarBaseService;
import org.sklsft.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.sklsft.demo.api.model.reference.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.sklsft.demo.api.model.reference.time.forms.CalendarForm;
import org.sklsft.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.sklsft.demo.api.model.reference.time.sortings.CalendarSorting;
import org.sklsft.demo.api.model.reference.time.views.basic.CalendarBasicView;
import org.sklsft.demo.api.model.reference.time.views.basic.CalendarDayOffBasicView;
import org.sklsft.demo.api.model.reference.time.views.full.CalendarDayOffFullView;
import org.sklsft.demo.api.model.reference.time.views.full.CalendarFullView;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseRestClient implements CalendarBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
/**
 * get options
 */
@Override
public List<SelectItem> getOptions() {
return Arrays.asList(restClient.getForObject(GET_OPTIONS_URL, SelectItem[].class));
}

/**
 * load object list
 */
@Override
public List<CalendarBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, CalendarBasicView[].class));
}

/**
 * scroll object list
 */
@Override
public ScrollView<CalendarBasicView> scroll(ScrollForm<CalendarFilter, CalendarSorting> form) {
return null;
}

/**
 * load object
 */
@Override
public CalendarFullView load(Integer id) {
return null;
}

/**
 * find object
 */
@Override
public CalendarFullView find(String code) {
return null;
}

/**
 * load one to many component calendarDayOff list
 */
@Override
public List<CalendarDayOffBasicView> loadCalendarDayOffList(Integer id) {
return null;
}

/**
 * scroll one to many component calendarDayOff
 */
@Override
public ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (Integer calendarId, ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form) {
return null;
}

/**
 * load one to many component calendarDayOff
 */
@Override
public CalendarDayOffFullView loadCalendarDayOff(Integer id) {
return null;
}

/**
 * create object
 */
@Override
public CalendarFullView create() {
return null;
}

/**
 * create one to many component calendarDayOff
 */
@Override
public CalendarDayOffFullView createCalendarDayOff(Integer id) {
return null;
}

/**
 * save object
 */
@Override
public Integer save(CalendarForm calendarForm) {
return null;
}

/**
 * save one to many component calendarDayOff
 */
@Override
public void saveCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm) {
}

/**
 * update object
 */
@Override
public void update(Integer id, CalendarForm calendarForm) {
}

/**
 * update one to many component calendarDayOff
 */
@Override
public void updateCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm) {
}


/**
 * delete object
 */
@Override
public void delete(Integer id) {
}

/**
 * delete one to many component calendarDayOff
 */
@Override
public void deleteCalendarDayOff(Integer id) {
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Integer> idList) {
}

/**
 * delete one to many component calendarDayOff list
 */
@Override
public void deleteCalendarDayOffList(List<Integer> idList) {
}

}
