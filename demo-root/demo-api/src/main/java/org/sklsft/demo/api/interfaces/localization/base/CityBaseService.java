package org.sklsft.demo.api.interfaces.localization.base;

import java.util.List;

import org.sklsft.demo.api.model.localization.forms.CityForm;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.localization.views.full.CityFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CityBaseService {

/**
 * load object list
 */
List<CityBasicView> loadList();

/**
 * load object list from region
 */
List<CityBasicView> loadListFromRegion (Long regionId);

/**
 * load object
 */
CityFullView load(Long id);

/**
 * find object
 */
CityFullView find(String regionCountryCode,String regionCode,String code);

/**
 * create object
 */
CityFullView create();

/**
 * save object
 */
Long save(CityForm cityForm);

/**
 * save object from parent Region
 */
Long saveFromRegion(Long regionId, CityForm cityForm);

/**
 * update object
 */
void update(Long id, CityForm cityForm);

/**
 * delete object
 */
void delete(Long id);

/**
 * delete object list
 */
void deleteList(List<Long> idList);

}
