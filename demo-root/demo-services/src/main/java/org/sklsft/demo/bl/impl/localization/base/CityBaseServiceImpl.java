package org.sklsft.demo.bl.impl.localization.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.demo.api.interfaces.localization.base.CityBaseService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.forms.CityForm;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.localization.views.full.CityFullView;
import org.sklsft.demo.bc.mapper.localization.forms.CityFormMapper;
import org.sklsft.demo.bc.mapper.localization.views.basic.CityBasicViewMapper;
import org.sklsft.demo.bc.mapper.localization.views.full.CityFullViewMapper;
import org.sklsft.demo.bc.processor.localization.CityProcessor;
import org.sklsft.demo.bc.rightsmanager.localization.CityRightsManager;
import org.sklsft.demo.bc.statemanager.localization.CityStateManager;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.CityDao;
import org.sklsft.demo.repository.dao.interfaces.localization.RegionDao;
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
@Inject
protected CityDao cityDao;
@Inject
protected RegionDao regionDao;
@Inject
protected CityFullViewMapper cityFullViewMapper;
@Inject
protected CityBasicViewMapper cityBasicViewMapper;
@Inject
protected CityFormMapper cityFormMapper;
@Inject
protected CityStateManager cityStateManager;
@Inject
protected CityRightsManager cityRightsManager;
@Inject
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
 * load filtered object list
 */
@Override
@Transactional(readOnly=true)
public List<CityBasicView> loadList(CityFilter filter) {
cityRightsManager.checkCanAccess();
List<City> cityList = cityDao.loadListEagerly(filter);
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
public List<CityBasicView> loadListFromRegion (Long regionId) {
cityRightsManager.checkCanAccess();
List<City> cityList = cityDao.loadListEagerlyFromRegion(regionId);
List<CityBasicView> result = new ArrayList<>(cityList.size());
for (City city : cityList) {
result.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(),city));
}
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
 * save object from parent Region
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long saveFromRegion(Long regionId, CityForm cityForm) {
City city = this.cityFormMapper.mapTo(cityForm, new City());
Region region = this.regionDao.load(regionId);
city.setRegion(region);
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
