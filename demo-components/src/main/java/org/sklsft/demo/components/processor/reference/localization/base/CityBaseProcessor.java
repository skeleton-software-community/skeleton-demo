package org.sklsft.demo.components.processor.reference.localization.base;

import org.sklsft.demo.model.reference.localization.City;
import org.sklsft.demo.persistence.interfaces.reference.localization.CityDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
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
