package org.sklsft.demo.bc.processor.localization.base;

import javax.inject.Inject;
import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.localization.Country;
import org.sklsft.demo.repository.dao.interfaces.localization.CountryDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseProcessor implements Processor<Country, Long> {

/*
 * properties injected by spring
 */
@Inject
protected CountryDao countryDao;

/**
 * process save
 */
public Long save(Country country) {
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
