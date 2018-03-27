package org.sklsft.demo.api.interfaces.localization.base;

import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.forms.RegionForm;
import org.sklsft.demo.api.model.localization.sortings.RegionSorting;
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
public static final String GET_LIST_URL = "/region/list";

/**
 * load object list from country
 */
List<RegionBasicView> loadListFromCountry (Long countryId);
public static final String GET_REGION_LIST_fROM_COUNTRY_URL = "/country/{countryId}/region/list";

/**
 * scroll object list
 */
ScrollView<RegionBasicView> scroll(ScrollForm<RegionFilter, RegionSorting> form);
public static final String SCROLL_URL = "/region/scroll";

/**
 * scroll object list from country
 */
ScrollView<RegionBasicView> scrollFromCountry (Long countryId, ScrollForm<RegionFilter, RegionSorting> form);
public static final String SCROLL_REGION_fROM_COUNTRY_URL = "/country/{countryId}/region/scroll";

/**
 * load object
 */
RegionFullView load(Long id);
public static final String GET_URL = "/region/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/region/find";
RegionFullView find(String countryCode, String code);

/**
 * create object
 */
RegionFullView create();
public static final String GET_NEW_URL = "/region/new";

/**
 * save object
 */
Long save(RegionForm regionForm);
public static final String SAVE_URL = "/region";

/**
 * save object from parent Country
 */
Long saveFromCountry(Long countryId, RegionForm regionForm);
public static final String SAVE_FROM_COUNTRY_URL = "/country/{countryId}/region";

/**
 * update object
 */
void update(Long id, RegionForm regionForm);
public static final String UPDATE_URL = "/region/{id}";

/**
 * delete object
 */
void delete(Long id);
public static final String DELETE_URL = "/region/{id}";

/**
 * delete object list
 */
void deleteList(List<Long> idList);
public static final String DELETE_LIST_URL = "/region/delete";

}
