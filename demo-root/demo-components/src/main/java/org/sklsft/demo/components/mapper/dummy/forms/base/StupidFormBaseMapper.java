package org.sklsft.demo.components.mapper.dummy.forms.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.demo.model.dummy.Stupid;
import org.sklsft.demo.persistence.interfaces.dummy.FoolDao;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidFormBaseMapper extends BasicMapperImpl<StupidForm, Stupid> {

public StupidFormBaseMapper() {
super(StupidForm.class, Stupid.class);
}

/*
 * properties
 */
@Inject
protected FoolDao foolDao;

/**
 * mapping form from object
 */
@Override
public StupidForm mapFrom(StupidForm stupidForm, Stupid stupid) {
stupidForm = super.mapFrom(stupidForm, stupid);
stupidForm.setFoolCode(stupid.getFool().getCode());
return stupidForm;
}

/**
 * mapping view to object
 */
@Override
public Stupid mapTo(StupidForm stupidForm, Stupid stupid) {
stupid = super.mapTo(stupidForm, stupid);
stupid.setFool(foolDao.find(stupidForm.getFoolCode()));
return stupid;
}

}
