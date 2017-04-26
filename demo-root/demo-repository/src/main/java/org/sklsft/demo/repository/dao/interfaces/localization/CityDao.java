package org.sklsft.demo.repository.dao.interfaces.localization;

import java.util.List;

import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.interfaces.localization.base.CityBaseDao;

/**
 * auto generated dao interface file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public interface CityDao extends CityBaseDao {	

/* Specific Code Start */
	List<City> loadListEagerly(CityFilter filter);
/* Specific Code End */
}
