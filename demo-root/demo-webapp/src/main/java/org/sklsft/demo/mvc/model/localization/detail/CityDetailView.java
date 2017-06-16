package org.sklsft.demo.mvc.model.localization.detail;

import java.io.Serializable;
import java.util.List;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.localization.views.full.CityFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

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
