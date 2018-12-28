package org.sklsft.demo.bc.statemanager.reference.localization.base;

import org.sklsft.commons.api.exception.state.InvalidStateException;
import org.sklsft.commons.model.patterns.StateManager;
import org.sklsft.demo.model.reference.localization.Country;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseStateManager implements StateManager<Country, Long> {

/**
 * can save
 */
public boolean canSave(Country country) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Country country) {
if (!canSave(country)) {
throw new InvalidStateException("Country.save.invalidState");
}
}

/**
 * can update
 */
public boolean canUpdate(Country country) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Country country) {
if (!canUpdate(country)) {
throw new InvalidStateException("Country.update.invalidState");
}
}

/**
 * can delete
 */
public boolean canDelete(Country country) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Country country) {
if (!canDelete(country)) {
throw new InvalidStateException("Country.delete.invalidState");
}
}

}
