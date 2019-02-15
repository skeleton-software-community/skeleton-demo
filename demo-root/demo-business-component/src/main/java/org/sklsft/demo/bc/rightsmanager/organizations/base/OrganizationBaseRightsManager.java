package org.sklsft.demo.bc.rightsmanager.organizations.base;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.model.patterns.RightsManager;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationCertification;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBaseRightsManager implements RightsManager<Organization, Integer> {

/**
 * can access all
 */
public boolean canAccess() {
return true;
}

/**
 * check can access all
 */
public void checkCanAccess() {
if (!canAccess()) {
throw new AccessDeniedException("Organization.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Organization organization) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Organization organization) {
if (!canAccess(organization)) {
throw new AccessDeniedException("Organization.accessDenied");
}
}

/**
 * can access one to one component OrganizationCertification
 */
public boolean canAccessOrganizationCertification(Organization organization) {
return canAccess(organization);
}

/**
 * check can access one to one component OrganizationCertification
 */
public void checkCanAccessOrganizationCertification(Organization organization) {
if (!canAccessOrganizationCertification(organization)) {
throw new AccessDeniedException("OrganizationCertification.accessDenied");
}
}

/**
 * can create
 */
public boolean canCreate() {
return true;
}

/**
 * check can create
 */
public void checkCanCreate() {
if (!canCreate()) {
throw new OperationDeniedException("Organization.create.operationDenied");
}
}

/**
 * can create one to one component OrganizationCertification
 */
public boolean canCreateOrganizationCertification(Organization organization) {
return canUpdate(organization);
}

/**
 * check can create one to one component OrganizationCertification
 */
public void checkCanCreateOrganizationCertification(Organization organization) {
if (!canCreateOrganizationCertification(organization)) {
throw new OperationDeniedException("OrganizationCertification.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Organization organization) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Organization organization) {
if (!canSave(organization)) {
throw new OperationDeniedException("Organization.save.operationDenied");
}
}

/**
 * can save one to one component OrganizationCertification
 */
public boolean canSaveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
return canUpdate(organization);
}

/**
 * check can save one to one component OrganizationCertification
 */
public void checkCanSaveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
if (!canSaveOrganizationCertification(organizationCertification, organization)) {
throw new OperationDeniedException("OrganizationCertification.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Organization organization) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Organization organization) {
if (!canUpdate(organization)) {
throw new OperationDeniedException("Organization.update.operationDenied");
}
}

/**
 * can update one to one component OrganizationCertification
 */
public boolean canUpdateOrganizationCertification(OrganizationCertification organizationCertification) {
return canUpdate(organizationCertification.getOrganization());
}

/**
 * check can update one to one component OrganizationCertification
 */
public void checkCanUpdateOrganizationCertification(OrganizationCertification organizationCertification) {
if (!canUpdateOrganizationCertification(organizationCertification)) {
throw new OperationDeniedException("OrganizationCertification.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Organization organization) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Organization organization) {
if (!canDelete(organization)) {
throw new OperationDeniedException("Organization.delete.operationDenied");
}
}

/**
 * can delete one to one component OrganizationCertification
 */
public boolean canDeleteOrganizationCertification(OrganizationCertification organizationCertification) {
return canUpdate(organizationCertification.getOrganization());
}

/**
 * check can delete one to one component OrganizationCertification
 */
public void checkCanDeleteOrganizationCertification(OrganizationCertification organizationCertification) {
if (!canDeleteOrganizationCertification(organizationCertification)) {
throw new OperationDeniedException("OrganizationCertification.delete.operationDenied");
}
}

}
