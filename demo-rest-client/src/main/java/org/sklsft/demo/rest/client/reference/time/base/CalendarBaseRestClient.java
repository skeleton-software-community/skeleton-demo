package org.sklsft.demo.rest.client.reference.time.base;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
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
import org.springframework.core.ParameterizedTypeReference;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseRestClient implements CalendarBaseService {

/*
 * properties injected by spring
 */
@Resource(name="demoRestClient")
protected RestClient restClient;
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
return restClient.postForObject(SCROLL_URL, form, new ParameterizedTypeReference<ScrollView<CalendarBasicView>>(){});
}

/**
 * load object
 */
@Override
public CalendarFullView load(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.getForObject(GET_URL, CalendarFullView.class, vars);
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
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return Arrays.asList(restClient.getForObject(GET_CALENDAR_DAY_OFF_LIST_URL, CalendarDayOffBasicView[].class, vars));
}

/**
 * scroll one to many component calendarDayOff
 */
@Override
public ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (Integer id, ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.postForObject(SCROLL_CALENDAR_DAY_OFF_URL, form, new ParameterizedTypeReference<ScrollView<CalendarDayOffBasicView>>(){}, vars);
}

/**
 * load one to many component calendarDayOff
 */
@Override
public CalendarDayOffFullView loadCalendarDayOff(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.getForObject(GET_CALENDAR_DAY_OFF_URL, CalendarDayOffFullView.class, vars);
}

/**
 * create object
 */
@Override
public CalendarFullView create() {
return restClient.getForObject(GET_NEW_URL, CalendarFullView.class);
}

/**
 * create one to many component calendarDayOff
 */
@Override
public CalendarDayOffFullView createCalendarDayOff(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.getForObject(GET_NEW_CALENDAR_DAY_OFF_URL, CalendarDayOffFullView.class, vars);
}

/**
 * save object
 */
@Override
public Integer save(CalendarForm calendarForm) {
return restClient.postForObject(SAVE_URL, calendarForm, Integer.class);
}

/**
 * save one to many component calendarDayOff
 */
@Override
public void saveCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.postForObject(SAVE_CALENDAR_DAY_OFF_URL, calendarDayOffForm, Void.class, vars);
}

/**
 * update object
 */
@Override
public void update(Integer id, CalendarForm calendarForm) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.put(UPDATE_URL, calendarForm, vars);
}

/**
 * update one to many component calendarDayOff
 */
@Override
public void updateCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.put(UPDATE_CALENDAR_DAY_OFF_URL, calendarDayOffForm, vars);
}


/**
 * delete object
 */
@Override
public void delete(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.delete(DELETE_URL, vars);
}

/**
 * delete one to many component calendarDayOff
 */
@Override
public void deleteCalendarDayOff(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.delete(DELETE_CALENDAR_DAY_OFF_URL, vars);
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Integer> idList) {
restClient.postForObject(DELETE_LIST_URL, idList, Void.class);
}

/**
 * delete one to many component calendarDayOff list
 */
@Override
public void deleteCalendarDayOffList(List<Integer> idList) {
restClient.postForObject(DELETE_CALENDAR_DAY_OFF_LIST_URL, idList, Void.class);
}

}
