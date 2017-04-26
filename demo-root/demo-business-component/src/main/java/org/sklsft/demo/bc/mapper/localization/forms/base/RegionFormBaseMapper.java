package org.sklsft.demo.bc.mapper.localization.forms.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.localization.forms.RegionForm;
import org.sklsft.demo.model.localization.Region;
import org.sklsft.demo.repository.dao.interfaces.localization.CountryDao;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionFormBaseMapper extends BasicMapperImpl<RegionForm, Region> {

public RegionFormBaseMapper() {
super(RegionForm.class, Region.class);
}

/*
 * properties
 */
@Inject
protected CountryDao countryDao;

/**
 * mapping form from object
 */
@Override
public RegionForm mapFrom(RegionForm regionForm, Region region) {
regionForm = super.mapFrom(regionForm, region);
regionForm.setCountryCode(region.getCountry().getCode());
return regionForm;
}

/**
 * mapping view to object
 */
@Override
public Region mapTo(RegionForm regionForm, Region region) {
region = super.mapTo(regionForm, region);
region.setCountry(countryDao.find(
regionForm.getCountryCode()
));
return region;
}

}
