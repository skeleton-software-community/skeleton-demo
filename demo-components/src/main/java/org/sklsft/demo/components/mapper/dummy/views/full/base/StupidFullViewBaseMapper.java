package org.sklsft.demo.components.mapper.dummy.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;
import org.sklsft.demo.components.rightsmanager.dummy.StupidRightsManager;
import org.sklsft.demo.components.statemanager.dummy.StupidStateManager;
import org.sklsft.demo.model.dummy.Stupid;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class StupidFullViewBaseMapper extends FullViewMapper<StupidFullView, Long, StupidForm, Stupid> {

@Inject
protected StupidRightsManager stupidRightsManager;
@Inject
protected StupidStateManager stupidStateManager;

public StupidFullViewBaseMapper() {
super(StupidFullView.class, Stupid.class);
}

@Override
public StupidFullView mapFrom(StupidFullView stupidFullView, Stupid stupid) {
stupidFullView = super.mapFrom(stupidFullView, stupid);
stupidFullView.setCanUpdate(stupidRightsManager.canUpdate(stupid) && stupidStateManager.canUpdate(stupid));
stupidFullView.setCanDelete(stupidRightsManager.canDelete(stupid) && stupidStateManager.canDelete(stupid));
return stupidFullView;
}

}
