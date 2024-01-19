package org.sklsft.demo.components.processor.reference.localization.base;

import org.sklsft.demo.model.reference.localization.Region;
import org.sklsft.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected RegionDao regionDao;

/**
 * process save
 */
public Integer save(Region region) {
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
