package org.sklsft.demo.bl.impl.time.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.time.base.CalendarBaseService;
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
import org.sklsft.demo.bc.mapper.time.forms.CalendarDayOffFormMapper;
import org.sklsft.demo.bc.mapper.time.forms.CalendarFormMapper;
import org.sklsft.demo.bc.mapper.time.views.basic.CalendarBasicViewMapper;
import org.sklsft.demo.bc.mapper.time.views.basic.CalendarDayOffBasicViewMapper;
import org.sklsft.demo.bc.mapper.time.views.full.CalendarDayOffFullViewMapper;
import org.sklsft.demo.bc.mapper.time.views.full.CalendarFullViewMapper;
import org.sklsft.demo.bc.processor.time.CalendarProcessor;
import org.sklsft.demo.bc.rightsmanager.time.CalendarRightsManager;
import org.sklsft.demo.bc.statemanager.time.CalendarStateManager;
import org.sklsft.demo.model.time.Calendar;
import org.sklsft.demo.model.time.CalendarDayOff;
import org.sklsft.demo.repository.dao.interfaces.time.CalendarDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CalendarBaseServiceImpl implements CalendarBaseService {

/*
 * properties injected by spring
 */
@Inject
protected CalendarDao calendarDao;
@Inject
protected CalendarFullViewMapper calendarFullViewMapper;
@Inject
protected CalendarBasicViewMapper calendarBasicViewMapper;
@Inject
protected CalendarFormMapper calendarFormMapper;
@Inject
protected CalendarDayOffFullViewMapper calendarDayOffFullViewMapper;
@Inject
protected CalendarDayOffBasicViewMapper calendarDayOffBasicViewMapper;
@Inject
protected CalendarDayOffFormMapper calendarDayOffFormMapper;
@Inject
protected CalendarStateManager calendarStateManager;
@Inject
protected CalendarRightsManager calendarRightsManager;
@Inject
protected CalendarProcessor calendarProcessor;

/**
 * get options
 */
@Override
@Transactional(readOnly=true)
public List<String> getOptions() {
List<Calendar> calendarList = calendarDao.loadList();
List<String> calendarCodeList = new ArrayList<>(calendarList.size());
for (Calendar calendar : calendarList) {
calendarCodeList.add(calendar.getCode());
}
return calendarCodeList;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<CalendarBasicView> loadList() {
calendarRightsManager.checkCanAccess();
List<Calendar> calendarList = calendarDao.loadListEagerly();
List<CalendarBasicView> result = new ArrayList<>(calendarList.size());
for (Calendar calendar : calendarList) {
result.add(this.calendarBasicViewMapper.mapFrom(new CalendarBasicView(),calendar));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CalendarBasicView> scroll(ScrollForm<CalendarFilter, CalendarSorting> form) {
calendarRightsManager.checkCanAccess();
ScrollView<CalendarBasicView> result = new ScrollView<>();
result.setSize(calendarDao.count());
Long count = calendarDao.count(form.getFilter());
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Calendar> list = calendarDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<CalendarBasicView> elements = new ArrayList<>(list.size());
for (Calendar calendar : list) {
elements.add(this.calendarBasicViewMapper.mapFrom(new CalendarBasicView(),calendar));
}
result.setElements(elements);
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public CalendarFullView load(Long id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanAccess(calendar);
return this.calendarFullViewMapper.mapFrom(new CalendarFullView(),calendar);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public CalendarFullView find(String code) {
Calendar calendar = calendarDao.find(code);
calendarRightsManager.checkCanAccess(calendar);
return this.calendarFullViewMapper.mapFrom(new CalendarFullView(), calendar);
}

/**
 * load one to many component calendarDayOff list
 */
@Override
@Transactional(readOnly=true)
public List<CalendarDayOffBasicView> loadCalendarDayOffList(Long id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanAccessCalendarDayOff(calendar);
List<CalendarDayOff> calendarDayOffList = calendarDao.loadCalendarDayOffList(id);
List<CalendarDayOffBasicView> result = new ArrayList<>(calendarDayOffList.size());
for (CalendarDayOff calendarDayOff:calendarDayOffList){
result.add(this.calendarDayOffBasicViewMapper.mapFrom(new CalendarDayOffBasicView(),calendarDayOff));
}
return result;
}

/**
 * scroll one to many component calendarDayOff
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (Long calendarId, ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form) {
Calendar calendar = calendarDao.load(calendarId);
calendarRightsManager.checkCanAccessCalendarDayOff(calendar);
ScrollView<CalendarDayOffBasicView> result = new ScrollView<>();
result.setSize(calendarDao.countCalendarDayOff(calendarId));
Long count = calendarDao.countCalendarDayOff(calendarId, form.getFilter());
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<CalendarDayOff> list = calendarDao.scrollCalendarDayOff(calendarId, form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<CalendarDayOffBasicView> elements = new ArrayList<>(list.size());
for (CalendarDayOff calendarDayOff : list) {
elements.add(this.calendarDayOffBasicViewMapper.mapFrom(new CalendarDayOffBasicView(),calendarDayOff));
}
result.setElements(elements);
return result;
}

/**
 * load one to many component calendarDayOff
 */
@Override
@Transactional(readOnly=true)
public CalendarDayOffFullView loadCalendarDayOff(Long calendarDayOffId,Long id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanAccessCalendarDayOff(calendar);
for (CalendarDayOff collectionCalendarDayOff : calendar.getCalendarDayOffCollection()){
if (collectionCalendarDayOff.getId().equals(calendarDayOffId)){
return this.calendarDayOffFullViewMapper.mapFrom(new CalendarDayOffFullView(),collectionCalendarDayOff);
}
}
throw new ObjectNotFoundException("Invalid one to many component id");
}

/**
 * create object
 */
@Override
public CalendarFullView create() {
calendarRightsManager.checkCanCreate();
return new CalendarFullView();
}

/**
 * create one to many component calendarDayOff
 */
@Override
@Transactional(readOnly=true)
public CalendarDayOffFullView createCalendarDayOff(Long id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanCreateCalendarDayOff(calendar);
return new CalendarDayOffFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(CalendarForm calendarForm) {
Calendar calendar = this.calendarFormMapper.mapTo(calendarForm, new Calendar());
calendarRightsManager.checkCanSave(calendar);
calendarStateManager.checkCanSave(calendar);
return calendarProcessor.save(calendar);
}

/**
 * save one to many component calendarDayOff
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void saveCalendarDayOff(Long id, CalendarDayOffForm calendarDayOffForm) {
Calendar calendar = this.calendarDao.load(id);
CalendarDayOff calendarDayOff = this.calendarDayOffFormMapper.mapTo(calendarDayOffForm, new CalendarDayOff());
calendarRightsManager.checkCanSaveCalendarDayOff(calendarDayOff,calendar);
calendarStateManager.checkCanSaveCalendarDayOff(calendarDayOff,calendar);
calendarProcessor.saveCalendarDayOff(calendarDayOff,calendar);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, CalendarForm calendarForm) {
Calendar calendar = this.calendarDao.load(id);
calendarRightsManager.checkCanUpdate(calendar);
calendarStateManager.checkCanUpdate(calendar);
calendar = this.calendarFormMapper.mapTo(calendarForm, calendar);
calendarProcessor.update(calendar);
}

/**
 * update one to many component calendarDayOff
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void updateCalendarDayOff(Long id, CalendarDayOffForm calendarDayOffForm) {
CalendarDayOff calendarDayOff = this.calendarDao.loadCalendarDayOff(id);
calendarRightsManager.checkCanUpdateCalendarDayOff(calendarDayOff);
calendarStateManager.checkCanUpdateCalendarDayOff(calendarDayOff);
calendarDayOff = this.calendarDayOffFormMapper.mapTo(calendarDayOffForm, calendarDayOff);
calendarProcessor.updateCalendarDayOff(calendarDayOff);
}


/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanDelete(calendar);
calendarStateManager.checkCanDelete(calendar);
calendarProcessor.delete(calendar);
}

/**
 * delete one to many component calendarDayOff
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteCalendarDayOff(Long id) {
CalendarDayOff calendarDayOff = calendarDao.loadCalendarDayOff(id);
calendarRightsManager.checkCanDeleteCalendarDayOff(calendarDayOff);
calendarStateManager.checkCanDeleteCalendarDayOff(calendarDayOff);
this.calendarProcessor.deleteCalendarDayOff(calendarDayOff);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Long> idList) {
Calendar calendar;
if (idList != null){
for (Long id:idList){
calendar = calendarDao.load(id);
calendarRightsManager.checkCanDelete(calendar);
calendarStateManager.checkCanDelete(calendar);
calendarProcessor.delete(calendar);
}
}
}

/**
 * delete one to many component calendarDayOff list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteCalendarDayOffList(List<Long> idList) {
CalendarDayOff calendarDayOff;
if (idList != null){
for (Long i:idList){
calendarDayOff = calendarDao.loadCalendarDayOff(i);
calendarRightsManager.checkCanDeleteCalendarDayOff(calendarDayOff);
calendarStateManager.checkCanDeleteCalendarDayOff(calendarDayOff);
this.calendarProcessor.deleteCalendarDayOff(calendarDayOff);
}
}
}

}
