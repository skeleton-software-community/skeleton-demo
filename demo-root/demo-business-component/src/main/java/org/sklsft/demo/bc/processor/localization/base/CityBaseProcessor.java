package org.sklsft.demo.bc.processor.localization.base;

import javax.inject.Inject;
import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.interfaces.localization.CityDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseProcessor implements Processor<City, Long> {

/*
 * properties injected by spring
 */
@Inject
protected CityDao cityDao;

/**
 * process save
 */
public Long save(City city) {
return cityDao.save(city);
}

/**
 * process update
 */
public void update(City city) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(City city) {
cityDao.delete(city);
}

}
