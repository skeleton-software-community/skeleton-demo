package org.sklsft.demo.bl.impl.localization.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.demo.api.interfaces.localization.base.RegionBaseService;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.forms.RegionForm;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;
import org.sklsft.demo.bc.mapper.localization.forms.RegionFormMapper;
import org.sklsft.demo.bc.mapper.localization.views.basic.RegionBasicViewMapper;
import org.sklsft.demo.bc.mapper.localization.views.full.RegionFullViewMapper;
import org.sklsft.demo.bc.processor.localization.RegionProcessor;
import org.sklsft.demo.bc.rightsmanager.localization.RegionRightsManager;
import org.sklsft.demo.bc.statemanager.localization.RegionStateManager;
import org.sklsft.demo.model.localization.Country;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.CountryDao;
import org.sklsft.demo.repository.dao.interfaces.localization.RegionDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseServiceImpl implements RegionBaseService {

/*
 * properties injected by spring
 */
@Inject
protected RegionDao regionDao;
@Inject
protected CountryDao countryDao;
@Inject
protected RegionFullViewMapper regionFullViewMapper;
@Inject
protected RegionBasicViewMapper regionBasicViewMapper;
@Inject
protected RegionFormMapper regionFormMapper;
@Inject
protected RegionStateManager regionStateManager;
@Inject
protected RegionRightsManager regionRightsManager;
@Inject
protected RegionProcessor regionProcessor;

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<RegionBasicView> loadList() {
regionRightsManager.checkCanAccess();
List<Region> regionList = regionDao.loadListEagerly();
List<RegionBasicView> result = new ArrayList<>(regionList.size());
for (Region region : regionList) {
result.add(this.regionBasicViewMapper.mapFrom(new RegionBasicView(),region));
}
return result;
}

/**
 * load filtered object list
 */
@Override
@Transactional(readOnly=true)
public List<RegionBasicView> loadList(RegionFilter filter) {
regionRightsManager.checkCanAccess();
List<Region> regionList = regionDao.loadListEagerly(filter);
List<RegionBasicView> result = new ArrayList<>(regionList.size());
for (Region region : regionList) {
result.add(this.regionBasicViewMapper.mapFrom(new RegionBasicView(),region));
}
return result;
}

/**
 * load object list from country
 */
@Override
@Transactional(readOnly=true)
public List<RegionBasicView> loadListFromCountry (Long countryId) {
regionRightsManager.checkCanAccess();
List<Region> regionList = regionDao.loadListEagerlyFromCountry(countryId);
List<RegionBasicView> result = new ArrayList<>(regionList.size());
for (Region region : regionList) {
result.add(this.regionBasicViewMapper.mapFrom(new RegionBasicView(),region));
}
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public RegionFullView load(Long id) {
Region region = regionDao.load(id);
regionRightsManager.checkCanAccess(region);
return this.regionFullViewMapper.mapFrom(new RegionFullView(),region);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public RegionFullView find(String countryCode, String code) {
Region region = regionDao.find(countryCode, code);
regionRightsManager.checkCanAccess(region);
return this.regionFullViewMapper.mapFrom(new RegionFullView(), region);
}

/**
 * create object
 */
@Override
public RegionFullView create() {
regionRightsManager.checkCanCreate();
return new RegionFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(RegionForm regionForm) {
Region region = this.regionFormMapper.mapTo(regionForm, new Region());
regionRightsManager.checkCanSave(region);
regionStateManager.checkCanSave(region);
return regionProcessor.save(region);
}

/**
 * save object from parent Country
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long saveFromCountry(Long countryId, RegionForm regionForm) {
Region region = this.regionFormMapper.mapTo(regionForm, new Region());
Country country = this.countryDao.load(countryId);
region.setCountry(country);
regionRightsManager.checkCanSave(region);
regionStateManager.checkCanSave(region);
return regionProcessor.save(region);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, RegionForm regionForm) {
Region region = this.regionDao.load(id);
regionRightsManager.checkCanUpdate(region);
regionStateManager.checkCanUpdate(region);
region = this.regionFormMapper.mapTo(regionForm, region);
regionProcessor.update(region);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
Region region = regionDao.load(id);
regionRightsManager.checkCanDelete(region);
regionStateManager.checkCanDelete(region);
regionProcessor.delete(region);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Long> idList) {
Region region;
if (idList != null){
for (Long id:idList){
region = regionDao.load(id);
regionRightsManager.checkCanDelete(region);
regionStateManager.checkCanDelete(region);
regionProcessor.delete(region);
}
}
}

}
