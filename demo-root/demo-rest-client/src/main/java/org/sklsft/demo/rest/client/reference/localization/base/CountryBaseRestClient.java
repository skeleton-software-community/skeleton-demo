package org.sklsft.demo.rest.client.reference.localization.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.reference.localization.base.CountryBaseService;
import org.sklsft.demo.api.model.reference.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.reference.localization.forms.CountryForm;
import org.sklsft.demo.api.model.reference.localization.sortings.CountrySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CountryBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CountryFullView;
import org.springframework.core.ParameterizedTypeReference;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseRestClient implements CountryBaseService {

/*
 * properties injected by spring
 */
@Resource(name="demoRestClient")
protected RestClient restClient;
/**
 * get options
 */
@Override
public List<SelectItem> getOptions() {
return Arrays.asList(restClient.getForObject(GET_OPTIONS_URL, SelectItem[].class));
}

/**
 * load object list
 */
@Override
public List<CountryBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, CountryBasicView[].class));
}

/**
 * scroll object list
 */
@Override
public ScrollView<CountryBasicView> scroll(ScrollForm<CountryFilter, CountrySorting> form) {
return restClient.postForObject(SCROLL_URL, form, new ParameterizedTypeReference<ScrollView<CountryBasicView>>(){});
}

/**
 * load object
 */
@Override
public CountryFullView load(Short id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.getForObject(GET_URL, CountryFullView.class, vars);
}

/**
 * find object
 */
@Override
public CountryFullView find(String code) {
return null;
}

/**
 * create object
 */
@Override
public CountryFullView create() {
return restClient.getForObject(GET_NEW_URL, CountryFullView.class);
}

/**
 * save object
 */
@Override
public Short save(CountryForm countryForm) {
return restClient.postForObject(SAVE_URL, countryForm, Short.class);
}

/**
 * update object
 */
@Override
public void update(Short id, CountryForm countryForm) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.put(UPDATE_URL, countryForm, vars);
}

/**
 * delete object
 */
@Override
public void delete(Short id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.delete(DELETE_URL, vars);
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Short> idList) {
restClient.postForObject(DELETE_LIST_URL, idList, Void.class);
}

}
