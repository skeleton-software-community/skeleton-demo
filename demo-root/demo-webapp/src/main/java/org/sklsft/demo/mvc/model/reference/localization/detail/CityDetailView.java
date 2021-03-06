package org.sklsft.demo.mvc.model.reference.localization.detail;

import java.io.Serializable;

import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.reference.localization.views.full.CityFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class CityDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private CityFullView selectedCity = new CityFullView();

/*
 * getters and setters
 */
public CityFullView getSelectedCity() {
return selectedCity;
}
public void setSelectedCity(CityFullView selectedCity) {
this.selectedCity = selectedCity;
}

/* Specific Code Start */
/* Specific Code End */
}
