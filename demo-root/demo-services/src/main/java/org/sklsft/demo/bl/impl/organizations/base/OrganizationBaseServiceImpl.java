package org.sklsft.demo.bl.impl.organizations.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.organizations.base.OrganizationBaseService;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;
import org.sklsft.demo.bc.mapper.organizations.forms.OrganizationCertificationFormMapper;
import org.sklsft.demo.bc.mapper.organizations.forms.OrganizationFormMapper;
import org.sklsft.demo.bc.mapper.organizations.views.basic.OrganizationBasicViewMapper;
import org.sklsft.demo.bc.mapper.organizations.views.full.OrganizationCertificationFullViewMapper;
import org.sklsft.demo.bc.mapper.organizations.views.full.OrganizationFullViewMapper;
import org.sklsft.demo.bc.processor.organizations.OrganizationProcessor;
import org.sklsft.demo.bc.rightsmanager.organizations.OrganizationRightsManager;
import org.sklsft.demo.bc.statemanager.organizations.OrganizationStateManager;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationCertification;
import org.sklsft.demo.repository.dao.interfaces.organizations.OrganizationDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseServiceImpl implements OrganizationBaseService {

/*
 * properties injected by spring
 */
@Inject
protected OrganizationDao organizationDao;
@Inject
protected OrganizationFullViewMapper organizationFullViewMapper;
@Inject
protected OrganizationBasicViewMapper organizationBasicViewMapper;
@Inject
protected OrganizationFormMapper organizationFormMapper;
@Inject
protected OrganizationCertificationFullViewMapper organizationCertificationFullViewMapper;
@Inject
protected OrganizationCertificationFormMapper organizationCertificationFormMapper;
@Inject
protected OrganizationStateManager organizationStateManager;
@Inject
protected OrganizationRightsManager organizationRightsManager;
@Inject
protected OrganizationProcessor organizationProcessor;

/**
 * search options
 */
@Override
@Transactional(readOnly=true)
public List<SelectItem> searchOptions(String arg) {
List<Organization> organizationList = organizationDao.search(arg);
List<SelectItem> result = new ArrayList<>(organizationList.size());
for (Organization organization : organizationList) {
result.add(new SelectItem(organization.getCode(), organization.getCode()));
}
return result;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<OrganizationBasicView> loadList() {
organizationRightsManager.checkCanAccess();
List<Organization> organizationList = organizationDao.loadListEagerly();
List<OrganizationBasicView> result = new ArrayList<>(organizationList.size());
for (Organization organization : organizationList) {
result.add(this.organizationBasicViewMapper.mapFrom(new OrganizationBasicView(),organization));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<OrganizationBasicView> scroll(ScrollForm<OrganizationFilter, OrganizationSorting> form) {
organizationRightsManager.checkCanAccess();
ScrollView<OrganizationBasicView> result = new ScrollView<>();
result.setSize(organizationDao.count());
Long count = organizationDao.count(form.getFilter());
result.setCount(count);
result.setNumberOfPages(count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L));
result.setCurrentPage(Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages())));
List<Organization> list = organizationDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<OrganizationBasicView> elements = new ArrayList<>(list.size());
for (Organization organization : list) {
elements.add(this.organizationBasicViewMapper.mapFrom(new OrganizationBasicView(),organization));
}
result.setElements(elements);
return result;
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public OrganizationFullView load(Integer id) {
Organization organization = organizationDao.load(id);
organizationRightsManager.checkCanAccess(organization);
return this.organizationFullViewMapper.mapFrom(new OrganizationFullView(),organization);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public OrganizationFullView find(String code) {
Organization organization = organizationDao.find(code);
organizationRightsManager.checkCanAccess(organization);
return this.organizationFullViewMapper.mapFrom(new OrganizationFullView(), organization);
}

/**
 * load one to one component organizationCertification
 */
@Override
@Transactional(readOnly=true)
public OrganizationCertificationFullView loadOrganizationCertification(Integer id) {
Organization organization = organizationDao.load(id);
organizationRightsManager.checkCanAccessOrganizationCertification(organization);
OrganizationCertification organizationCertification = organization.getOrganizationCertification();
if (organizationCertification==null) {
return new OrganizationCertificationFullView();
} else {
return this.organizationCertificationFullViewMapper.mapFrom(new OrganizationCertificationFullView(), organizationCertification);
}
}

/**
 * create object
 */
@Override
public OrganizationFullView create() {
organizationRightsManager.checkCanCreate();
return new OrganizationFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Integer save(OrganizationForm organizationForm) {
Organization organization = this.organizationFormMapper.mapTo(organizationForm, new Organization());
organizationRightsManager.checkCanSave(organization);
organizationStateManager.checkCanSave(organization);
return organizationProcessor.save(organization);
}

/**
 * save one to one component organizationCertification
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void saveOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm) {
Organization organization = this.organizationDao.load(id);
OrganizationCertification organizationCertification = this.organizationCertificationFormMapper.mapTo(organizationCertificationForm, new OrganizationCertification());
organizationRightsManager.checkCanSaveOrganizationCertification(organizationCertification,organization);
organizationStateManager.checkCanSaveOrganizationCertification(organizationCertification,organization);
organizationProcessor.saveOrganizationCertification(organizationCertification, organization);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Integer id, OrganizationForm organizationForm) {
Organization organization = this.organizationDao.load(id);
organizationRightsManager.checkCanUpdate(organization);
organizationStateManager.checkCanUpdate(organization);
organization = this.organizationFormMapper.mapTo(organizationForm, organization);
organizationProcessor.update(organization);
}

/**
 * update one to one component organizationCertification
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void updateOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm) {
Organization organization = this.organizationDao.load(id);
OrganizationCertification organizationCertification = organization.getOrganizationCertification();
organizationRightsManager.checkCanUpdateOrganizationCertification(organizationCertification);
organizationStateManager.checkCanUpdateOrganizationCertification(organizationCertification);
organization.setOrganizationCertification(this.organizationCertificationFormMapper.mapTo(organizationCertificationForm, organizationCertification));
organizationProcessor.updateOrganizationCertification(organizationCertification);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Integer id) {
Organization organization = organizationDao.load(id);
organizationRightsManager.checkCanDelete(organization);
organizationStateManager.checkCanDelete(organization);
organizationProcessor.delete(organization);
}

/**
 * delete one to one component organizationCertification
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteOrganizationCertification(Integer id) {
Organization organization = this.organizationDao.load(id);
OrganizationCertification organizationCertification = organization.getOrganizationCertification();
organizationRightsManager.checkCanDeleteOrganizationCertification(organizationCertification);
organizationStateManager.checkCanDeleteOrganizationCertification(organizationCertification);
this.organizationProcessor.deleteOrganizationCertification(organizationCertification);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Integer> idList) {
Organization organization;
if (idList != null){
for (Integer id:idList){
organization = organizationDao.load(id);
organizationRightsManager.checkCanDelete(organization);
organizationStateManager.checkCanDelete(organization);
organizationProcessor.delete(organization);
}
}
}

}
