package org.sklsft.demo.components.processor.dummy.base;

import javax.inject.Inject;

import org.sklsft.commons.model.patterns.Processor;
import org.sklsft.demo.model.dummy.Stupid;
import org.sklsft.demo.persistence.interfaces.dummy.StupidDao;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseProcessor implements Processor<Stupid, Long> {

/*
 * properties injected by spring
 */
@Inject
protected StupidDao stupidDao;

/**
 * process save
 */
public Long save(Stupid stupid) {
return stupidDao.save(stupid);
}

/**
 * process update
 */
public void update(Stupid stupid) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Stupid stupid) {
stupidDao.delete(stupid);
}

}
