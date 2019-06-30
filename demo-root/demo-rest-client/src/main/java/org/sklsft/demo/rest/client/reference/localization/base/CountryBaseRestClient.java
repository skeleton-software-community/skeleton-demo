package org.sklsft.demo.rest.client.reference.localization.base;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

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

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseRestClient implements CountryBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
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
return null;
}

/**
 * load object
 */
@Override
public CountryFullView load(Short id) {
return null;
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
return null;
}

/**
 * save object
 */
@Override
public Short save(CountryForm countryForm) {
return null;
}

/**
 * update object
 */
@Override
public void update(Short id, CountryForm countryForm) {
}

/**
 * delete object
 */
@Override
public void delete(Short id) {
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Short> idList) {
}

}
