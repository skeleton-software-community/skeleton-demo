package org.sklsft.demo.bc.mapper.localization.views.full.base;

import javax.inject.Inject;
import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.localization.forms.RegionForm;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;
import org.sklsft.demo.bc.rightsmanager.localization.RegionRightsManager;
import org.sklsft.demo.bc.statemanager.localization.RegionStateManager;
import org.sklsft.demo.model.localization.Region;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class RegionFullViewBaseMapper extends FullViewMapper<RegionFullView, Long, RegionForm, Region> {

@Inject
protected RegionRightsManager regionRightsManager;
@Inject
protected RegionStateManager regionStateManager;

public RegionFullViewBaseMapper() {
super(RegionFullView.class, Region.class);
}

@Override
public RegionFullView mapFrom(RegionFullView regionFullView, Region region) {
regionFullView = super.mapFrom(regionFullView, region);
regionFullView.setCanUpdate(regionRightsManager.canUpdate(region) && regionStateManager.canUpdate(region));
return regionFullView;
}

}
