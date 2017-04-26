package org.sklsft.demo.bc.mapper.localization.views.basic.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.bc.rightsmanager.localization.RegionRightsManager;
import org.sklsft.demo.bc.statemanager.localization.RegionStateManager;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.CountryDao;

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
@Inject
protected CountryDao countryDao;

@Inject
protected RegionRightsManager regionRightsManager;
@Inject
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
region.setCountry(countryDao.find(
regionBasicView.getCountryCode()
));
return region;
}

}
