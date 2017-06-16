package org.sklsft.demo.bc.mapper.localization.forms.base;

import javax.inject.Inject;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.localization.forms.CityForm;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.interfaces.localization.RegionDao;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityFormBaseMapper extends BasicMapperImpl<CityForm, City> {

public CityFormBaseMapper() {
super(CityForm.class, City.class);
}

/*
 * properties
 */
@Inject
protected RegionDao regionDao;

/**
 * mapping form from object
 */
@Override
public CityForm mapFrom(CityForm cityForm, City city) {
cityForm = super.mapFrom(cityForm, city);
cityForm.setRegionCountryCode(city.getRegion().getCountry().getCode());
cityForm.setRegionCode(city.getRegion().getCode());
return cityForm;
}

/**
 * mapping view to object
 */
@Override
public City mapTo(CityForm cityForm, City city) {
city = super.mapTo(cityForm, city);
city.setRegion(regionDao.find(cityForm.getRegionCountryCode(), cityForm.getRegionCode()));
return city;
}

}
