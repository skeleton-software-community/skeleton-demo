package org.sklsft.demo.bc.mapper.localization.forms.base;

import javax.inject.Inject;
import org.sklsft.commons.api.exception.repository.ObjectNotFoundException;
import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.localization.forms.CountryForm;
import org.sklsft.demo.model.localization.Country;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryFormBaseMapper extends BasicMapperImpl<CountryForm, Country> {

public CountryFormBaseMapper() {
super(CountryForm.class, Country.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public CountryForm mapFrom(CountryForm countryForm, Country country) {
countryForm = super.mapFrom(countryForm, country);
return countryForm;
}

/**
 * mapping view to object
 */
@Override
public Country mapTo(CountryForm countryForm, Country country) {
country = super.mapTo(countryForm, country);
return country;
}

}
