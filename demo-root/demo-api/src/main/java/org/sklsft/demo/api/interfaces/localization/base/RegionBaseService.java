package org.sklsft.demo.api.interfaces.localization.base;

import java.util.List;

import org.sklsft.demo.api.model.localization.forms.RegionForm;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface RegionBaseService {

/**
 * load object list
 */
List<RegionBasicView> loadList();

/**
 * load object list from country
 */
List<RegionBasicView> loadListFromCountry (Long countryId);

/**
 * load object
 */
RegionFullView load(Long id);

/**
 * find object
 */
RegionFullView find(String countryCode,String code);

/**
 * create object
 */
RegionFullView create();

/**
 * save object
 */
Long save(RegionForm regionForm);

/**
 * save object from parent Country
 */
Long saveFromCountry(Long countryId, RegionForm regionForm);

/**
 * update object
 */
void update(Long id, RegionForm regionForm);

/**
 * delete object
 */
void delete(Long id);

/**
 * delete object list
 */
void deleteList(List<Long> idList);

}
