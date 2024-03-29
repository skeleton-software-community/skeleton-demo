package org.sklsft.demo.components.statemanager.reference.localization.base;

import org.sklsft.commons.api.exception.state.InvalidStateException;
import org.sklsft.demo.model.reference.localization.Region;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseStateManager {

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
throw new InvalidStateException("Region.save.invalidState");
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
throw new InvalidStateException("Region.update.invalidState");
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
throw new InvalidStateException("Region.delete.invalidState");
}
}

}
