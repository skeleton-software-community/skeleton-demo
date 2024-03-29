package org.sklsft.demo.components.mapper.dummy.views.basic.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.components.rightsmanager.dummy.FoolRightsManager;
import org.sklsft.demo.components.statemanager.dummy.FoolStateManager;
import org.sklsft.demo.model.dummy.Fool;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBasicViewBaseMapper extends BasicMapperImpl<FoolBasicView, Fool> {

public FoolBasicViewBaseMapper() {
super(FoolBasicView.class, Fool.class);
}

/*
 * properties
 */

@Autowired
protected FoolRightsManager foolRightsManager;
@Autowired
protected FoolStateManager foolStateManager;

/**
 * mapping view from object
 */
@Override
public FoolBasicView mapFrom(FoolBasicView foolBasicView, Fool fool) {
foolBasicView = super.mapFrom(foolBasicView, fool);
foolBasicView.setSelected(false);
foolBasicView.setCanDelete(foolRightsManager.canDelete(fool) && foolStateManager.canDelete(fool));
return foolBasicView;
}

/**
 * mapping view to object
 */
@Override
public Fool mapTo(FoolBasicView foolBasicView, Fool fool) {
fool = super.mapTo(foolBasicView, fool);
return fool;
}

}
