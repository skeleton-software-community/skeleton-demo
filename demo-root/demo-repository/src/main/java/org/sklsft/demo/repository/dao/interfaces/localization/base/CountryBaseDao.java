package org.sklsft.demo.repository.dao.interfaces.localization.base;
import org.sklsft.commons.model.patterns.BaseDao;
import org.sklsft.demo.model.localization.Country;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CountryBaseDao extends BaseDao<Country, Long> {

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object
 */
Country find(String code);

}
