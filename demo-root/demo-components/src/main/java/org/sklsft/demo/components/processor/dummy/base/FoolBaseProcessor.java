package org.sklsft.demo.components.processor.dummy.base;

import javax.inject.Inject;

import org.sklsft.demo.model.dummy.Fool;
import org.sklsft.demo.persistence.interfaces.dummy.FoolDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseProcessor {

/*
 * properties injected by spring
 */
@Inject
protected FoolDao foolDao;

/**
 * process save
 */
public String save(Fool fool) {
return foolDao.save(fool);
}

/**
 * process update
 */
public void update(Fool fool) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Fool fool) {
foolDao.delete(fool);
}

}
