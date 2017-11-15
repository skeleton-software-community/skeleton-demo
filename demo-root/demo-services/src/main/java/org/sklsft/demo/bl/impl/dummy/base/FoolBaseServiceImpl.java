package org.sklsft.demo.bl.impl.dummy.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.dummy.base.FoolBaseService;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.forms.FoolForm;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
import org.sklsft.demo.bc.mapper.dummy.forms.FoolFormMapper;
import org.sklsft.demo.bc.mapper.dummy.views.basic.FoolBasicViewMapper;
import org.sklsft.demo.bc.mapper.dummy.views.full.FoolFullViewMapper;
import org.sklsft.demo.bc.processor.dummy.FoolProcessor;
import org.sklsft.demo.bc.rightsmanager.dummy.FoolRightsManager;
import org.sklsft.demo.bc.statemanager.dummy.FoolStateManager;
import org.sklsft.demo.model.dummy.Fool;
import org.sklsft.demo.repository.dao.interfaces.dummy.FoolDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseServiceImpl implements FoolBaseService {

/*
 * properties injected by spring
 */
@Inject
protected FoolDao foolDao;
@Inject
protected FoolFullViewMapper foolFullViewMapper;
@Inject
protected FoolBasicViewMapper foolBasicViewMapper;
@Inject
protected FoolFormMapper foolFormMapper;
@Inject
protected FoolStateManager foolStateManager;
@Inject
protected FoolRightsManager foolRightsManager;
@Inject
protected FoolProcessor foolProcessor;

/**
 * search options
 */
@Override
@Transactional(readOnly=true)
public List<SelectItem> searchOptions(String arg) {
List<Fool> foolList = foolDao.search(arg);
List<SelectItem> result = new ArrayList<>(foolList.size());
for (Fool fool : foolList) {
result.add(new SelectItem(fool.getCode(), fool.getCode()));
}
return result;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<FoolBasicView> loadList() {
foolRightsManager.checkCanAccess();
List<Fool> foolList = foolDao.loadListEagerly();
List<FoolBasicView> result = new ArrayList<>(foolList.size());
for (Fool fool : foolList) {
result.add(this.foolBasicViewMapper.mapFrom(new FoolBasicView(),fool));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form) {
foolRightsManager.checkCanAccess();
ScrollView<FoolBasicView> result = new ScrollView<>();
result.setSize(foolDao.count());
Long count = foolDao.count(form.getFilter());
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Fool> list = foolDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<FoolBasicView> elements = new ArrayList<>(list.size());
for (Fool fool : list) {
elements.add(this.foolBasicViewMapper.mapFrom(new FoolBasicView(),fool));
}
result.setElements(elements);
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public FoolFullView load(Long id) {
Fool fool = foolDao.load(id);
foolRightsManager.checkCanAccess(fool);
return this.foolFullViewMapper.mapFrom(new FoolFullView(),fool);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public FoolFullView find(String code) {
Fool fool = foolDao.find(code);
foolRightsManager.checkCanAccess(fool);
return this.foolFullViewMapper.mapFrom(new FoolFullView(), fool);
}

/**
 * create object
 */
@Override
public FoolFullView create() {
foolRightsManager.checkCanCreate();
return new FoolFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(FoolForm foolForm) {
Fool fool = this.foolFormMapper.mapTo(foolForm, new Fool());
foolRightsManager.checkCanSave(fool);
foolStateManager.checkCanSave(fool);
return foolProcessor.save(fool);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, FoolForm foolForm) {
Fool fool = this.foolDao.load(id);
foolRightsManager.checkCanUpdate(fool);
foolStateManager.checkCanUpdate(fool);
fool = this.foolFormMapper.mapTo(foolForm, fool);
foolProcessor.update(fool);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
Fool fool = foolDao.load(id);
foolRightsManager.checkCanDelete(fool);
foolStateManager.checkCanDelete(fool);
foolProcessor.delete(fool);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Long> idList) {
Fool fool;
if (idList != null){
for (Long id:idList){
fool = foolDao.load(id);
foolRightsManager.checkCanDelete(fool);
foolStateManager.checkCanDelete(fool);
foolProcessor.delete(fool);
}
}
}

}
