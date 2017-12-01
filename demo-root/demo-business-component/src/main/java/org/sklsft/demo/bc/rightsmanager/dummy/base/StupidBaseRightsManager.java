package org.sklsft.demo.bc.rightsmanager.dummy.base;

import org.sklsft.commons.api.exception.rights.AccessDeniedException;
import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.model.patterns.RightsManager;
import org.sklsft.demo.model.dummy.Stupid;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseRightsManager implements RightsManager<Stupid, Long> {

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
throw new AccessDeniedException("Stupid.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Stupid stupid) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Stupid stupid) {
if (!canAccess(stupid)) {
throw new AccessDeniedException("Stupid.accessDenied");
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
throw new OperationDeniedException("Stupid.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Stupid stupid) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Stupid stupid) {
if (!canSave(stupid)) {
throw new OperationDeniedException("Stupid.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Stupid stupid) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Stupid stupid) {
if (!canUpdate(stupid)) {
throw new OperationDeniedException("Stupid.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Stupid stupid) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Stupid stupid) {
if (!canDelete(stupid)) {
throw new OperationDeniedException("Stupid.delete.operationDenied");
}
}

}
