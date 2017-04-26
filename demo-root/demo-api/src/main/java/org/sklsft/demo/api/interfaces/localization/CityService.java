package org.sklsft.demo.api.interfaces.localization;

import java.util.List;

import org.sklsft.demo.api.interfaces.localization.base.CityBaseService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;

/**
 * auto generated service interface file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public interface CityService extends CityBaseService {	

/* Specific Code Start */
	
	List<CityBasicView> loadList(CityFilter filter);
	
/* Specific Code End */
}
