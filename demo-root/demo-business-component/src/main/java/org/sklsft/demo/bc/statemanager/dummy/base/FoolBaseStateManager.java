package org.sklsft.demo.bc.statemanager.dummy.base;

import org.sklsft.commons.api.exception.state.InvalidStateException;
import org.sklsft.commons.model.patterns.StateManager;
import org.sklsft.demo.model.dummy.Fool;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseStateManager implements StateManager<Fool, Long> {

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
throw new InvalidStateException("Fool.save.invalidState");
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
throw new InvalidStateException("Fool.update.invalidState");
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
throw new InvalidStateException("Fool.delete.invalidState");
}
}

}
