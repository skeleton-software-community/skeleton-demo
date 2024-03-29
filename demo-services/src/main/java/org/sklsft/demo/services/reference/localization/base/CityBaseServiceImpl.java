package org.sklsft.demo.services.reference.localization.base;

import java.util.ArrayList;
import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.reference.localization.base.CityBaseService;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.forms.CityForm;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CityFullView;
import org.sklsft.demo.components.mapper.reference.localization.forms.CityFormMapper;
import org.sklsft.demo.components.mapper.reference.localization.views.basic.CityBasicViewMapper;
import org.sklsft.demo.components.mapper.reference.localization.views.full.CityFullViewMapper;
import org.sklsft.demo.components.processor.reference.localization.CityProcessor;
import org.sklsft.demo.components.rightsmanager.reference.localization.CityRightsManager;
import org.sklsft.demo.components.statemanager.reference.localization.CityStateManager;
import org.sklsft.demo.model.reference.localization.City;
import org.sklsft.demo.persistence.interfaces.reference.localization.CityDao;
import org.sklsft.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseServiceImpl implements CityBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected CityDao cityDao;
@Autowired
protected RegionDao regionDao;
@Autowired
protected CityFullViewMapper cityFullViewMapper;
@Autowired
protected CityBasicViewMapper cityBasicViewMapper;
@Autowired
protected CityFormMapper cityFormMapper;
@Autowired
protected CityStateManager cityStateManager;
@Autowired
protected CityRightsManager cityRightsManager;
@Autowired
protected CityProcessor cityProcessor;

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<CityBasicView> loadList() {
cityRightsManager.checkCanAccess();
List<City> cityList = cityDao.loadListEagerly();
List<CityBasicView> result = new ArrayList<>(cityList.size());
for (City city : cityList) {
result.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(),city));
}
return result;
}

/**
 * load object list from region
 */
@Override
@Transactional(readOnly=true)
public List<CityBasicView> loadListFromRegion (Integer regionId) {
cityRightsManager.checkCanAccess();
List<City> cityList = cityDao.loadListEagerlyFromRegion(regionId);
List<CityBasicView> result = new ArrayList<>(cityList.size());
for (City city : cityList) {
result.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(),city));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CityBasicView> scroll(ScrollForm<CityFilter, CitySorting> form) {
cityRightsManager.checkCanAccess();
ScrollView<CityBasicView> result = new ScrollView<>();
result.setSize(cityDao.count());
Long count = cityDao.count(form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<City> list = cityDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<CityBasicView> elements = new ArrayList<>(list.size());
for (City city : list) {
elements.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(),city));
}
result.setElements(elements);
return result;
}

/**
 * scroll object list from region
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CityBasicView> scrollFromRegion (Integer regionId, ScrollForm<CityFilter, CitySorting> form) {
cityRightsManager.checkCanAccess();
ScrollView<CityBasicView> result = new ScrollView<>();
result.setSize(cityDao.countFromRegion(regionId));
Long count = cityDao.countFromRegion(regionId, form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<City> list = cityDao.scrollFromRegion(regionId, form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<CityBasicView> elements = new ArrayList<>(list.size());
for (City city : list) {
elements.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(),city));
}
result.setElements(elements);
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public CityFullView load(Long id) {
City city = cityDao.load(id);
cityRightsManager.checkCanAccess(city);
return this.cityFullViewMapper.mapFrom(new CityFullView(),city);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public CityFullView find(String regionCountryCode, String regionCode, String code) {
City city = cityDao.find(regionCountryCode, regionCode, code);
cityRightsManager.checkCanAccess(city);
return this.cityFullViewMapper.mapFrom(new CityFullView(), city);
}

/**
 * create object
 */
@Override
public CityFullView create() {
cityRightsManager.checkCanCreate();
return new CityFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(CityForm cityForm) {
City city = this.cityFormMapper.mapTo(cityForm, new City());
cityRightsManager.checkCanSave(city);
cityStateManager.checkCanSave(city);
return cityProcessor.save(city);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, CityForm cityForm) {
City city = this.cityDao.load(id);
cityRightsManager.checkCanUpdate(city);
cityStateManager.checkCanUpdate(city);
city = this.cityFormMapper.mapTo(cityForm, city);
cityProcessor.update(city);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
City city = cityDao.load(id);
cityRightsManager.checkCanDelete(city);
cityStateManager.checkCanDelete(city);
cityProcessor.delete(city);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Long> idList) {
City city;
if (idList != null){
for (Long id:idList){
city = cityDao.load(id);
cityRightsManager.checkCanDelete(city);
cityStateManager.checkCanDelete(city);
cityProcessor.delete(city);
}
}
}

}
