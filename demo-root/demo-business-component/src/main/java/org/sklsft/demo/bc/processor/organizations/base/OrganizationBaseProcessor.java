package org.sklsft.demo.bc.processor.organizations.base;

import javax.inject.Inject;

import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationCertification;
import org.sklsft.demo.repository.dao.interfaces.organizations.OrganizationDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseProcessor implements Processor<Organization, Integer> {

/*
 * properties injected by spring
 */
@Inject
protected OrganizationDao organizationDao;

/**
 * process save
 */
public Integer save(Organization organization) {
return organizationDao.save(organization);
}

/**
 * process save one to one component OrganizationCertification
 */
public void saveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
organizationDao.saveOrganizationCertification(organization, organizationCertification);
}

/**
 * process update
 */
public void update(Organization organization) {
// Empty by default. Can be overridden
}

/**
 * process update one to one component OrganizationCertification
 */
public void updateOrganizationCertification(OrganizationCertification organizationCertification) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Organization organization) {
organizationDao.delete(organization);
}

/**
 * process delete one to one component OrganizationCertification
 */
public void deleteOrganizationCertification(OrganizationCertification organizationCertification) {
organizationDao.deleteOrganizationCertification(organizationCertification);
}

}
