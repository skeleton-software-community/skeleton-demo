package org.sklsft.demo.components.mapper.reference.localization.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.reference.localization.forms.CountryForm;
import org.sklsft.demo.api.model.reference.localization.views.full.CountryFullView;
import org.sklsft.demo.components.rightsmanager.reference.localization.CountryRightsManager;
import org.sklsft.demo.components.statemanager.reference.localization.CountryStateManager;
import org.sklsft.demo.model.reference.localization.Country;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class CountryFullViewBaseMapper extends FullViewMapper<CountryFullView, Short, CountryForm, Country> {

@Inject
protected CountryRightsManager countryRightsManager;
@Inject
protected CountryStateManager countryStateManager;

public CountryFullViewBaseMapper() {
super(CountryFullView.class, Country.class);
}

@Override
public CountryFullView mapFrom(CountryFullView countryFullView, Country country) {
countryFullView = super.mapFrom(countryFullView, country);
countryFullView.setCanUpdate(countryRightsManager.canUpdate(country) && countryStateManager.canUpdate(country));
return countryFullView;
}

}
