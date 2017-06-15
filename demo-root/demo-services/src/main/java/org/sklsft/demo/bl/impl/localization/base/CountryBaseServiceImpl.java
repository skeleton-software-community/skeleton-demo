package org.sklsft.demo.bl.impl.localization.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.demo.api.interfaces.localization.base.CountryBaseService;
import org.sklsft.demo.api.model.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.localization.forms.CountryForm;
import org.sklsft.demo.api.model.localization.views.basic.CountryBasicView;
import org.sklsft.demo.api.model.localization.views.full.CountryFullView;
import org.sklsft.demo.bc.mapper.localization.forms.CountryFormMapper;
import org.sklsft.demo.bc.mapper.localization.views.basic.CountryBasicViewMapper;
import org.sklsft.demo.bc.mapper.localization.views.full.CountryFullViewMapper;
import org.sklsft.demo.bc.processor.localization.CountryProcessor;
import org.sklsft.demo.bc.rightsmanager.localization.CountryRightsManager;
import org.sklsft.demo.bc.statemanager.localization.CountryStateManager;
import org.sklsft.demo.model.localization.Country;
import org.sklsft.demo.repository.dao.interfaces.localization.CountryDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseServiceImpl implements CountryBaseService {

/*
 * properties injected by spring
 */
@Inject
protected CountryDao countryDao;
@Inject
protected CountryFullViewMapper countryFullViewMapper;
@Inject
protected CountryBasicViewMapper countryBasicViewMapper;
@Inject
protected CountryFormMapper countryFormMapper;
@Inject
protected CountryStateManager countryStateManager;
@Inject
protected CountryRightsManager countryRightsManager;
@Inject
protected CountryProcessor countryProcessor;

/**
 * get options
 */
@Override
@Transactional(readOnly=true)
public List<String> getOptions() {
List<Country> countryList = countryDao.loadList();
List<String> countryCodeList = new ArrayList<>(countryList.size());
for (Country country : countryList) {
countryCodeList.add(country.getCode());
}
return countryCodeList;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<CountryBasicView> loadList() {
countryRightsManager.checkCanAccess();
List<Country> countryList = countryDao.loadListEagerly();
List<CountryBasicView> result = new ArrayList<>(countryList.size());
for (Country country : countryList) {
result.add(this.countryBasicViewMapper.mapFrom(new CountryBasicView(),country));
}
return result;
}

/**
 * load filtered object list
 */
@Override
@Transactional(readOnly=true)
public List<CountryBasicView> loadList(CountryFilter filter) {
countryRightsManager.checkCanAccess();
List<Country> countryList = countryDao.loadListEagerly(filter);
List<CountryBasicView> result = new ArrayList<>(countryList.size());
for (Country country : countryList) {
result.add(this.countryBasicViewMapper.mapFrom(new CountryBasicView(),country));
}
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public CountryFullView load(Long id) {
Country country = countryDao.load(id);
countryRightsManager.checkCanAccess(country);
return this.countryFullViewMapper.mapFrom(new CountryFullView(),country);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public CountryFullView find(String code) {
Country country = countryDao.find(code);
countryRightsManager.checkCanAccess(country);
return this.countryFullViewMapper.mapFrom(new CountryFullView(), country);
}

/**
 * create object
 */
@Override
public CountryFullView create() {
countryRightsManager.checkCanCreate();
return new CountryFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(CountryForm countryForm) {
Country country = this.countryFormMapper.mapTo(countryForm, new Country());
countryRightsManager.checkCanSave(country);
countryStateManager.checkCanSave(country);
return countryProcessor.save(country);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, CountryForm countryForm) {
Country country = this.countryDao.load(id);
countryRightsManager.checkCanUpdate(country);
countryStateManager.checkCanUpdate(country);
country = this.countryFormMapper.mapTo(countryForm, country);
countryProcessor.update(country);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
Country country = countryDao.load(id);
countryRightsManager.checkCanDelete(country);
countryStateManager.checkCanDelete(country);
countryProcessor.delete(country);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Long> idList) {
Country country;
if (idList != null){
for (Long id:idList){
country = countryDao.load(id);
countryRightsManager.checkCanDelete(country);
countryStateManager.checkCanDelete(country);
countryProcessor.delete(country);
}
}
}

}
