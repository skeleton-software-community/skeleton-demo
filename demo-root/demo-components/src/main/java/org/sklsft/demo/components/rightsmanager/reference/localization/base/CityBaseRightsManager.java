package org.sklsft.demo.components.rightsmanager.reference.localization.base;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.model.patterns.RightsManager;
import org.sklsft.demo.model.reference.localization.City;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseRightsManager implements RightsManager<City, Long> {

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
throw new AccessDeniedException("City.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(City city) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(City city) {
if (!canAccess(city)) {
throw new AccessDeniedException("City.accessDenied");
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
throw new OperationDeniedException("City.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(City city) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(City city) {
if (!canSave(city)) {
throw new OperationDeniedException("City.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(City city) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(City city) {
if (!canUpdate(city)) {
throw new OperationDeniedException("City.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(City city) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(City city) {
if (!canDelete(city)) {
throw new OperationDeniedException("City.delete.operationDenied");
}
}

}
