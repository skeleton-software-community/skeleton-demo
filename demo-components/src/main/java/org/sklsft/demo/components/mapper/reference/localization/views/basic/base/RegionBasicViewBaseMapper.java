package org.sklsft.demo.components.mapper.reference.localization.views.basic.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.sklsft.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.sklsft.demo.components.statemanager.reference.localization.RegionStateManager;
import org.sklsft.demo.model.reference.localization.Region;
import org.sklsft.demo.persistence.interfaces.reference.localization.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBasicViewBaseMapper extends BasicMapperImpl<RegionBasicView, Region> {

public RegionBasicViewBaseMapper() {
super(RegionBasicView.class, Region.class);
}

/*
 * properties
 */
@Autowired
protected CountryDao countryDao;

@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
protected RegionStateManager regionStateManager;

/**
 * mapping view from object
 */
@Override
public RegionBasicView mapFrom(RegionBasicView regionBasicView, Region region) {
regionBasicView = super.mapFrom(regionBasicView, region);
regionBasicView.setSelected(false);
regionBasicView.setCanDelete(regionRightsManager.canDelete(region) && regionStateManager.canDelete(region));
regionBasicView.setCountryCode(region.getCountry().getCode());
return regionBasicView;
}

/**
 * mapping view to object
 */
@Override
public Region mapTo(RegionBasicView regionBasicView, Region region) {
region = super.mapTo(regionBasicView, region);
region.setCountry(countryDao.find(regionBasicView.getCountryCode()));
return region;
}

}
