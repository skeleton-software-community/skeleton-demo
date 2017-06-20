package org.sklsft.demo.repository.dao.interfaces.localization.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.localization.sortings.CountrySorting;
import org.sklsft.demo.model.localization.Country;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CountryBaseDao extends BaseDao<Country, Long> {

/**
 * count filtered object list
 */
Long count(CountryFilter filter);

/**
 * scroll filtered object list
 */
List<Country> scroll(CountryFilter filter, CountrySorting ordering, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Country findOrNull(String code);

/**
 * find object
 */
Country find(String code);

}
