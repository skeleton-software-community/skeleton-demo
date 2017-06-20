package org.sklsft.demo.bc.processor.localization.base;

import javax.inject.Inject;

import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.RegionDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseProcessor implements Processor<Region, Long> {

/*
 * properties injected by spring
 */
@Inject
protected RegionDao regionDao;

/**
 * process save
 */
public Long save(Region region) {
return regionDao.save(region);
}

/**
 * process update
 */
public void update(Region region) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Region region) {
regionDao.delete(region);
}

}
