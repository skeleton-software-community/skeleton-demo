package org.sklsft.demo.components.mapper.reference.localization.views.basic.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.sklsft.demo.components.rightsmanager.reference.localization.CityRightsManager;
import org.sklsft.demo.components.statemanager.reference.localization.CityStateManager;
import org.sklsft.demo.model.reference.localization.City;
import org.sklsft.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;

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
@Autowired
protected RegionDao regionDao;

@Autowired
protected CityRightsManager cityRightsManager;
@Autowired
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
city.setRegion(regionDao.find(cityBasicView.getRegionCountryCode(), cityBasicView.getRegionCode()));
return city;
}

}
