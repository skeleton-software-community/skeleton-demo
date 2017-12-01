package org.sklsft.demo.repository.dao.interfaces.dummy.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.model.dummy.Stupid;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface StupidBaseDao extends BaseDao<Stupid, Long> {

/**
 * count filtered object list
 */
Long count(StupidFilter filter);

/**
 * scroll filtered object list
 */
List<Stupid> scroll(StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Stupid findOrNull(String code);

/**
 * find object
 */
Stupid find(String code);

}
