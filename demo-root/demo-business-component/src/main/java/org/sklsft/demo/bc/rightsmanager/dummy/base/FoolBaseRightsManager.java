package org.sklsft.demo.bc.rightsmanager.dummy.base;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.model.patterns.RightsManager;
import org.sklsft.demo.model.dummy.Fool;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseRightsManager implements RightsManager<Fool, String> {

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
throw new AccessDeniedException("Fool.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Fool fool) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Fool fool) {
if (!canAccess(fool)) {
throw new AccessDeniedException("Fool.accessDenied");
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
throw new OperationDeniedException("Fool.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Fool fool) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Fool fool) {
if (!canSave(fool)) {
throw new OperationDeniedException("Fool.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Fool fool) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Fool fool) {
if (!canUpdate(fool)) {
throw new OperationDeniedException("Fool.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Fool fool) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Fool fool) {
if (!canDelete(fool)) {
throw new OperationDeniedException("Fool.delete.operationDenied");
}
}

}
