package org.sklsft.demo.bc.mapper.dummy.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.dummy.forms.FoolForm;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
import org.sklsft.demo.bc.rightsmanager.dummy.FoolRightsManager;
import org.sklsft.demo.bc.statemanager.dummy.FoolStateManager;
import org.sklsft.demo.model.dummy.Fool;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class FoolFullViewBaseMapper extends FullViewMapper<FoolFullView, Long, FoolForm, Fool> {

@Inject
protected FoolRightsManager foolRightsManager;
@Inject
protected FoolStateManager foolStateManager;

public FoolFullViewBaseMapper() {
super(FoolFullView.class, Fool.class);
}

@Override
public FoolFullView mapFrom(FoolFullView foolFullView, Fool fool) {
foolFullView = super.mapFrom(foolFullView, fool);
foolFullView.setCanUpdate(foolRightsManager.canUpdate(fool) && foolStateManager.canUpdate(fool));
return foolFullView;
}

}
