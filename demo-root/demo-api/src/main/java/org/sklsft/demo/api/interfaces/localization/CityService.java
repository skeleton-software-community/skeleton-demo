package org.sklsft.demo.api.interfaces.localization;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.localization.base.CityBaseService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.ordering.CityOrdering;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;

/**
 * auto generated service interface file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public interface CityService extends CityBaseService {

/* Specific Code Start */
	
	ScrollView<CityBasicView> scroll(ScrollForm<CityFilter, CityOrdering> form);
	
/* Specific Code End */
}
