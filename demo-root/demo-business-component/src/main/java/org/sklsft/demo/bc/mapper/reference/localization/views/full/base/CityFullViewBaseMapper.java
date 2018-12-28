package org.sklsft.demo.bc.mapper.reference.localization.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.reference.localization.forms.CityForm;
import org.sklsft.demo.api.model.reference.localization.views.full.CityFullView;
import org.sklsft.demo.bc.rightsmanager.reference.localization.CityRightsManager;
import org.sklsft.demo.bc.statemanager.reference.localization.CityStateManager;
import org.sklsft.demo.model.reference.localization.City;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class CityFullViewBaseMapper extends FullViewMapper<CityFullView, Long, CityForm, City> {

@Inject
protected CityRightsManager cityRightsManager;
@Inject
protected CityStateManager cityStateManager;

public CityFullViewBaseMapper() {
super(CityFullView.class, City.class);
}

@Override
public CityFullView mapFrom(CityFullView cityFullView, City city) {
cityFullView = super.mapFrom(cityFullView, city);
cityFullView.setCanUpdate(cityRightsManager.canUpdate(city) && cityStateManager.canUpdate(city));
return cityFullView;
}

}
