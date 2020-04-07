package org.sklsft.demo.components.rightsmanager.reference.localization.base;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.model.patterns.RightsManager;
import org.sklsft.demo.model.reference.localization.Region;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseRightsManager implements RightsManager<Region, Integer> {

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
throw new AccessDeniedException("Region.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Region region) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Region region) {
if (!canAccess(region)) {
throw new AccessDeniedException("Region.accessDenied");
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
throw new OperationDeniedException("Region.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Region region) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Region region) {
if (!canSave(region)) {
throw new OperationDeniedException("Region.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Region region) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Region region) {
if (!canUpdate(region)) {
throw new OperationDeniedException("Region.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Region region) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Region region) {
if (!canDelete(region)) {
throw new OperationDeniedException("Region.delete.operationDenied");
}
}

}
