package org.sklsft.demo.bc.mapper.dummy.views.basic.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.bc.rightsmanager.dummy.StupidRightsManager;
import org.sklsft.demo.bc.statemanager.dummy.StupidStateManager;
import org.sklsft.demo.model.dummy.Stupid;
import org.sklsft.demo.repository.dao.interfaces.dummy.FoolDao;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBasicViewBaseMapper extends BasicMapperImpl<StupidBasicView, Stupid> {

public StupidBasicViewBaseMapper() {
super(StupidBasicView.class, Stupid.class);
}

/*
 * properties
 */
@Inject
protected FoolDao foolDao;

@Inject
protected StupidRightsManager stupidRightsManager;
@Inject
protected StupidStateManager stupidStateManager;

/**
 * mapping view from object
 */
@Override
public StupidBasicView mapFrom(StupidBasicView stupidBasicView, Stupid stupid) {
stupidBasicView = super.mapFrom(stupidBasicView, stupid);
stupidBasicView.setSelected(false);
stupidBasicView.setCanDelete(stupidRightsManager.canDelete(stupid) && stupidStateManager.canDelete(stupid));
stupidBasicView.setFoolCode(stupid.getFool().getCode());
return stupidBasicView;
}

/**
 * mapping view to object
 */
@Override
public Stupid mapTo(StupidBasicView stupidBasicView, Stupid stupid) {
stupid = super.mapTo(stupidBasicView, stupid);
stupid.setFool(foolDao.find(stupidBasicView.getFoolCode()));
return stupid;
}

}
