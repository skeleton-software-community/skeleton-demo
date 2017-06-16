package org.sklsft.demo.repository.dao.interfaces.localization.base;
import java.util.Date;
import java.util.List;
import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.orderings.CityOrdering;
import org.sklsft.demo.model.localization.City;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CityBaseDao extends BaseDao<City, Long> {

/**
 * count filtered object list
 */
Long count(CityFilter filter);

/**
 * scroll filtered object list
 */
List<City> scroll(CityFilter filter, CityOrdering ordering, Long firstResult, Long maxResults);

/**
 * load object list from region
 */
List<City> loadListFromRegion (Long regionId);

/**
 * load object list eagerly from region
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
