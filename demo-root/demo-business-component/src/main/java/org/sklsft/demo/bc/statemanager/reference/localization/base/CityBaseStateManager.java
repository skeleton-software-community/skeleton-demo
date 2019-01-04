package org.sklsft.demo.bc.statemanager.reference.localization.base;

import org.sklsft.commons.api.exception.state.InvalidStateException;
import org.sklsft.commons.model.patterns.StateManager;
import org.sklsft.demo.model.reference.localization.City;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseStateManager implements StateManager<City, Long> {

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
throw new InvalidStateException("City.save.invalidState");
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
throw new InvalidStateException("City.update.invalidState");
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
throw new InvalidStateException("City.delete.invalidState");
}
}

}
