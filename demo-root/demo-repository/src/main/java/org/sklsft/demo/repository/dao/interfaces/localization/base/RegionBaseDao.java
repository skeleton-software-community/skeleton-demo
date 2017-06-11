package org.sklsft.demo.repository.dao.interfaces.localization.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.model.localization.Region;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface RegionBaseDao extends BaseDao<Region, Long> {

/**
 * load object list from country
 */
List<Region> loadListFromCountry (Long countryId);

/**
 * load object list eagerly from list of country
 */
List<Region> loadListEagerlyFromCountry (Long countryId);

/**
 * exists object
 */
boolean exists(String countryCode, String code);

/**
 * find object
 */
Region find(String countryCode, String code);

}
