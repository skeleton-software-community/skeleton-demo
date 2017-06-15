package org.sklsft.demo.api.interfaces.localization.base;

import java.util.List;

import org.sklsft.demo.api.model.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.localization.forms.CountryForm;
import org.sklsft.demo.api.model.localization.views.basic.CountryBasicView;
import org.sklsft.demo.api.model.localization.views.full.CountryFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface CountryBaseService {

/**
 * get options
 */
List<String> getOptions();

/**
 * load object list
 */
List<CountryBasicView> loadList();

/**
 * load filtered object list
 */
List<CountryBasicView> loadList(CountryFilter filter);

/**
 * load object
 */
CountryFullView load(Long id);

/**
 * find object
 */
CountryFullView find(String code);

/**
 * create object
 */
CountryFullView create();

/**
 * save object
 */
Long save(CountryForm countryForm);

/**
 * update object
 */
void update(Long id, CountryForm countryForm);

/**
 * delete object
 */
void delete(Long id);

/**
 * delete object list
 */
void deleteList(List<Long> idList);

}
