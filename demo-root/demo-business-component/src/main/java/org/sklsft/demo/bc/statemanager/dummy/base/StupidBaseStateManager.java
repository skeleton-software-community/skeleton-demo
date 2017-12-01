package org.sklsft.demo.bc.statemanager.dummy.base;

import org.sklsft.commons.api.exception.state.InvalidStateException;
import org.sklsft.commons.model.patterns.StateManager;
import org.sklsft.demo.model.dummy.Stupid;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseStateManager implements StateManager<Stupid, Long> {

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
throw new InvalidStateException("Stupid.save.invalidState");
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
throw new InvalidStateException("Stupid.update.invalidState");
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
throw new InvalidStateException("Stupid.delete.invalidState");
}
}

}
