package org.sklsft.demo.bc.processor.dummy.base;

import javax.inject.Inject;

import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.dummy.Fool;
import org.sklsft.demo.repository.dao.interfaces.dummy.FoolDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseProcessor implements Processor<Fool, String> {

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
