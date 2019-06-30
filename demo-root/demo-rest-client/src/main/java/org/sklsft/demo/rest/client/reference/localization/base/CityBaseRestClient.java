package org.sklsft.demo.rest.client.reference.localization.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.reference.localization.base.CityBaseService;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.forms.CityForm;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CityFullView;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CityBaseRestClient implements CityBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
/**
 * load object list
 */
@Override
public List<CityBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, CityBasicView[].class));
}

/**
 * load object list from region
 */
@Override
public List<CityBasicView> loadListFromRegion (Integer regionId) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("regionId", regionId);
return Arrays.asList(restClient.getForObject(GET_CITY_LIST_fROM_REGION_URL, CityBasicView[].class, vars));
}

/**
 * scroll object list
 */
@Override
public ScrollView<CityBasicView> scroll(ScrollForm<CityFilter, CitySorting> form) {
return null;
}

/**
 * scroll object list from region
 */
@Override
public ScrollView<CityBasicView> scrollFromRegion (Integer regionId, ScrollForm<CityFilter, CitySorting> form) {
return null;
}

/**
 * load object
 */
@Override
public CityFullView load(Long id) {
return null;
}

/**
 * find object
 */
@Override
public CityFullView find(String regionCountryCode, String regionCode, String code) {
return null;
}

/**
 * create object
 */
@Override
public CityFullView create() {
return null;
}

/**
 * save object
 */
@Override
public Long save(CityForm cityForm) {
return null;
}

/**
 * save object from parent Region
 */
@Override
public Long saveFromRegion(Integer regionId, CityForm cityForm) {
return null;
}

/**
 * update object
 */
@Override
public void update(Long id, CityForm cityForm) {
}

/**
 * delete object
 */
@Override
public void delete(Long id) {
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Long> idList) {
}

}
