package org.sklsft.demo.bc.mapper.localization.views.basic.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.bc.rightsmanager.localization.CityRightsManager;
import org.sklsft.demo.bc.statemanager.localization.CityStateManager;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.interfaces.localization.RegionDao;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBasicViewBaseMapper extends BasicMapperImpl<CityBasicView, City> {

public CityBasicViewBaseMapper() {
super(CityBasicView.class, City.class);
}

/*
 * properties
 */
@Inject
protected RegionDao regionDao;

@Inject
protected CityRightsManager cityRightsManager;
@Inject
protected CityStateManager cityStateManager;

/**
 * mapping view from object
 */
@Override
public CityBasicView mapFrom(CityBasicView cityBasicView, City city) {
cityBasicView = super.mapFrom(cityBasicView, city);
cityBasicView.setSelected(false);
cityBasicView.setCanDelete(cityRightsManager.canDelete(city) && cityStateManager.canDelete(city));
cityBasicView.setRegionCountryCode(city.getRegion().getCountry().getCode());
cityBasicView.setRegionCode(city.getRegion().getCode());
return cityBasicView;
}

/**
 * mapping view to object
 */
@Override
public City mapTo(CityBasicView cityBasicView, City city) {
city = super.mapTo(cityBasicView, city);
city.setRegion(regionDao.find(
cityBasicView.getRegionCountryCode()
,cityBasicView.getRegionCode()
));
return city;
}

}
