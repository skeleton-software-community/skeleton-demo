package org.sklsft.demo.bl.impl.dummy.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.dummy.base.StupidBaseService;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;
import org.sklsft.demo.bc.mapper.dummy.forms.StupidFormMapper;
import org.sklsft.demo.bc.mapper.dummy.views.basic.StupidBasicViewMapper;
import org.sklsft.demo.bc.mapper.dummy.views.full.StupidFullViewMapper;
import org.sklsft.demo.bc.processor.dummy.StupidProcessor;
import org.sklsft.demo.bc.rightsmanager.dummy.StupidRightsManager;
import org.sklsft.demo.bc.statemanager.dummy.StupidStateManager;
import org.sklsft.demo.model.dummy.Stupid;
import org.sklsft.demo.repository.dao.interfaces.dummy.FoolDao;
import org.sklsft.demo.repository.dao.interfaces.dummy.StupidDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseServiceImpl implements StupidBaseService {

/*
 * properties injected by spring
 */
@Inject
protected StupidDao stupidDao;
@Inject
protected FoolDao foolDao;
@Inject
protected StupidFullViewMapper stupidFullViewMapper;
@Inject
protected StupidBasicViewMapper stupidBasicViewMapper;
@Inject
protected StupidFormMapper stupidFormMapper;
@Inject
protected StupidStateManager stupidStateManager;
@Inject
protected StupidRightsManager stupidRightsManager;
@Inject
protected StupidProcessor stupidProcessor;

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<StupidBasicView> loadList() {
stupidRightsManager.checkCanAccess();
List<Stupid> stupidList = stupidDao.loadListEagerly();
List<StupidBasicView> result = new ArrayList<>(stupidList.size());
for (Stupid stupid : stupidList) {
result.add(this.stupidBasicViewMapper.mapFrom(new StupidBasicView(),stupid));
}
return result;
}

/**
 * load object list from fool
 */
@Override
@Transactional(readOnly=true)
public List<StupidBasicView> loadListFromFool (String foolId) {
stupidRightsManager.checkCanAccess();
List<Stupid> stupidList = stupidDao.loadListEagerlyFromFool(foolId);
List<StupidBasicView> result = new ArrayList<>(stupidList.size());
for (Stupid stupid : stupidList) {
result.add(this.stupidBasicViewMapper.mapFrom(new StupidBasicView(),stupid));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<StupidBasicView> scroll(ScrollForm<StupidFilter, StupidSorting> form) {
stupidRightsManager.checkCanAccess();
ScrollView<StupidBasicView> result = new ScrollView<>();
result.setSize(stupidDao.count());
Long count = stupidDao.count(form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Stupid> list = stupidDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<StupidBasicView> elements = new ArrayList<>(list.size());
for (Stupid stupid : list) {
elements.add(this.stupidBasicViewMapper.mapFrom(new StupidBasicView(),stupid));
}
result.setElements(elements);
return result;
}

/**
 * scroll object list from fool
 */
@Override
@Transactional(readOnly=true)
public ScrollView<StupidBasicView> scrollFromFool (String foolId, ScrollForm<StupidFilter, StupidSorting> form) {
stupidRightsManager.checkCanAccess();
ScrollView<StupidBasicView> result = new ScrollView<>();
result.setSize(stupidDao.countFromFool(foolId));
Long count = stupidDao.countFromFool(foolId, form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Stupid> list = stupidDao.scrollFromFool(foolId, form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<StupidBasicView> elements = new ArrayList<>(list.size());
for (Stupid stupid : list) {
elements.add(this.stupidBasicViewMapper.mapFrom(new StupidBasicView(),stupid));
}
result.setElements(elements);
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public StupidFullView load(Long id) {
Stupid stupid = stupidDao.load(id);
stupidRightsManager.checkCanAccess(stupid);
return this.stupidFullViewMapper.mapFrom(new StupidFullView(),stupid);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public StupidFullView find(String code) {
Stupid stupid = stupidDao.find(code);
stupidRightsManager.checkCanAccess(stupid);
return this.stupidFullViewMapper.mapFrom(new StupidFullView(), stupid);
}

/**
 * create object
 */
@Override
public StupidFullView create() {
stupidRightsManager.checkCanCreate();
return new StupidFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(StupidForm stupidForm) {
Stupid stupid = this.stupidFormMapper.mapTo(stupidForm, new Stupid());
stupidRightsManager.checkCanSave(stupid);
stupidStateManager.checkCanSave(stupid);
return stupidProcessor.save(stupid);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, StupidForm stupidForm) {
Stupid stupid = this.stupidDao.load(id);
stupidRightsManager.checkCanUpdate(stupid);
stupidStateManager.checkCanUpdate(stupid);
stupid = this.stupidFormMapper.mapTo(stupidForm, stupid);
stupidProcessor.update(stupid);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
Stupid stupid = stupidDao.load(id);
stupidRightsManager.checkCanDelete(stupid);
stupidStateManager.checkCanDelete(stupid);
stupidProcessor.delete(stupid);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Long> idList) {
Stupid stupid;
if (idList != null){
for (Long id:idList){
stupid = stupidDao.load(id);
stupidRightsManager.checkCanDelete(stupid);
stupidStateManager.checkCanDelete(stupid);
stupidProcessor.delete(stupid);
}
}
}

}
