package org.sklsft.demo.repository.dao.interfaces.dummy.base;
import java.util.List;

import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.model.dummy.Fool;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface FoolBaseDao extends BaseDao<Fool, Long> {

/**
 * count filtered object list
 */
Long count(FoolFilter filter);

/**
 * scroll filtered object list
 */
List<Fool> scroll(FoolFilter filter, FoolSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Fool findOrNull(String code);

/**
 * find object
 */
Fool find(String code);

/**
 * search
 */
List<Fool> search(String arg);

}
