package org.sklsft.demo.repository.dao.interfaces.reference.localization.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.model.reference.localization.Region;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface RegionBaseDao extends BaseDao<Region, Long> {

/**
 * load object list from country
 */
List<Region> loadListFromCountry(Long countryId);

/**
 * load object list eagerly from country
 */
List<Region> loadListEagerlyFromCountry(Long countryId);

/**
 * count filtered object list
 */
Long count(RegionFilter filter);

/**
 * count object list from country
 */
Long countFromCountry(Long countryId);

/**
 * count filtered object list from country
 */
Long countFromCountry(Long countryId, RegionFilter filter);

/**
 * scroll filtered object list
 */
List<Region> scroll(RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults);

/**
 * scroll filtered object from country
 */
List<Region> scrollFromCountry(Long countryId, RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String countryCode, String code);

/**
 * find object or null
 */
Region findOrNull(String countryCode, String code);

/**
 * find object
 */
Region find(String countryCode, String code);

}
