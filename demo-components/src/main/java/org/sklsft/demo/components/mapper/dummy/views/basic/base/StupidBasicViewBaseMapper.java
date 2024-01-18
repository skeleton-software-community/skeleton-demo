package org.sklsft.demo.components.mapper.dummy.views.basic.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.components.rightsmanager.dummy.StupidRightsManager;
import org.sklsft.demo.components.statemanager.dummy.StupidStateManager;
import org.sklsft.demo.model.dummy.Stupid;
import org.sklsft.demo.persistence.interfaces.dummy.FoolDao;
import org.springframework.beans.factory.annotation.Autowired;

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
@Autowired
protected FoolDao foolDao;

@Autowired
protected StupidRightsManager stupidRightsManager;
@Autowired
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
