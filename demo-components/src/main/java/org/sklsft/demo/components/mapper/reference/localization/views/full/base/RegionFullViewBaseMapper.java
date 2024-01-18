package org.sklsft.demo.components.mapper.reference.localization.views.full.base;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.reference.localization.forms.RegionForm;
import org.sklsft.demo.api.model.reference.localization.views.full.RegionFullView;
import org.sklsft.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.sklsft.demo.components.statemanager.reference.localization.RegionStateManager;
import org.sklsft.demo.model.reference.localization.Region;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class RegionFullViewBaseMapper extends FullViewMapper<RegionFullView, Integer, RegionForm, Region> {

@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
protected RegionStateManager regionStateManager;

public RegionFullViewBaseMapper() {
super(RegionFullView.class, Region.class);
}

@Override
public RegionFullView mapFrom(RegionFullView regionFullView, Region region) {
regionFullView = super.mapFrom(regionFullView, region);
regionFullView.setCanUpdate(regionRightsManager.canUpdate(region) && regionStateManager.canUpdate(region));
regionFullView.setCanDelete(regionRightsManager.canDelete(region) && regionStateManager.canDelete(region));
return regionFullView;
}

}
