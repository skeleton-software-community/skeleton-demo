package org.sklsft.demo.services.reference.localization.base;

import java.util.ArrayList;
import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.reference.localization.base.RegionBaseService;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.forms.RegionForm;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.RegionFullView;
import org.sklsft.demo.components.mapper.reference.localization.forms.RegionFormMapper;
import org.sklsft.demo.components.mapper.reference.localization.views.basic.RegionBasicViewMapper;
import org.sklsft.demo.components.mapper.reference.localization.views.full.RegionFullViewMapper;
import org.sklsft.demo.components.processor.reference.localization.RegionProcessor;
import org.sklsft.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.sklsft.demo.components.statemanager.reference.localization.RegionStateManager;
import org.sklsft.demo.model.reference.localization.Region;
import org.sklsft.demo.persistence.interfaces.reference.localization.CountryDao;
import org.sklsft.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
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
@Autowired
protected RegionDao regionDao;
@Autowired
protected CountryDao countryDao;
@Autowired
protected RegionFullViewMapper regionFullViewMapper;
@Autowired
protected RegionBasicViewMapper regionBasicViewMapper;
@Autowired
protected RegionFormMapper regionFormMapper;
@Autowired
protected RegionStateManager regionStateManager;
@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
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
 * load object list from country
 */
@Override
@Transactional(readOnly=true)
public List<RegionBasicView> loadListFromCountry (Short countryId) {
regionRightsManager.checkCanAccess();
List<Region> regionList = regionDao.loadListEagerlyFromCountry(countryId);
List<RegionBasicView> result = new ArrayList<>(regionList.size());
for (Region region : regionList) {
result.add(this.regionBasicViewMapper.mapFrom(new RegionBasicView(),region));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<RegionBasicView> scroll(ScrollForm<RegionFilter, RegionSorting> form) {
regionRightsManager.checkCanAccess();
ScrollView<RegionBasicView> result = new ScrollView<>();
result.setSize(regionDao.count());
Long count = regionDao.count(form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Region> list = regionDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<RegionBasicView> elements = new ArrayList<>(list.size());
for (Region region : list) {
elements.add(this.regionBasicViewMapper.mapFrom(new RegionBasicView(),region));
}
result.setElements(elements);
return result;
}

/**
 * scroll object list from country
 */
@Override
@Transactional(readOnly=true)
public ScrollView<RegionBasicView> scrollFromCountry (Short countryId, ScrollForm<RegionFilter, RegionSorting> form) {
regionRightsManager.checkCanAccess();
ScrollView<RegionBasicView> result = new ScrollView<>();
result.setSize(regionDao.countFromCountry(countryId));
Long count = regionDao.countFromCountry(countryId, form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Region> list = regionDao.scrollFromCountry(countryId, form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<RegionBasicView> elements = new ArrayList<>(list.size());
for (Region region : list) {
elements.add(this.regionBasicViewMapper.mapFrom(new RegionBasicView(),region));
}
result.setElements(elements);
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public RegionFullView load(Integer id) {
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
public Integer save(RegionForm regionForm) {
Region region = this.regionFormMapper.mapTo(regionForm, new Region());
regionRightsManager.checkCanSave(region);
regionStateManager.checkCanSave(region);
return regionProcessor.save(region);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Integer id, RegionForm regionForm) {
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
public void delete(Integer id) {
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
public void deleteList(List<Integer> idList) {
Region region;
if (idList != null){
for (Integer id:idList){
region = regionDao.load(id);
regionRightsManager.checkCanDelete(region);
regionStateManager.checkCanDelete(region);
regionProcessor.delete(region);
}
}
}

}
