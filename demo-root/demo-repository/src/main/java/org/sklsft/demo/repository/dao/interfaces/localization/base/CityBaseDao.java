package org.sklsft.demo.repository.dao.interfaces.localization.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.model.localization.City;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CityBaseDao extends BaseDao<City, Long> {

/**
 * load filtered object list eagerly
 */
List<City> loadListEagerly(CityFilter filter);

/**
 * load object list from region
 */
List<City> loadListFromRegion (Long regionId);

/**
 * load object list eagerly from list of region
 */
List<City> loadListEagerlyFromRegion (Long regionId);

/**
 * exists object
 */
boolean exists(String regionCountryCode, String regionCode, String code);

/**
 * find object or null
 */
City findOrNull(String regionCountryCode, String regionCode, String code);

/**
 * find object
 */
City find(String regionCountryCode, String regionCode, String code);

}
