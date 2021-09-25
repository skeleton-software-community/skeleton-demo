package org.sklsft.demo.components.processor.reference.localization.base;

import javax.inject.Inject;

import org.sklsft.demo.model.reference.localization.Country;
import org.sklsft.demo.persistence.interfaces.reference.localization.CountryDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseProcessor {

/*
 * properties injected by spring
 */
@Inject
protected CountryDao countryDao;

/**
 * process save
 */
public Short save(Country country) {
return countryDao.save(country);
}

/**
 * process update
 */
public void update(Country country) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Country country) {
countryDao.delete(country);
}

}
