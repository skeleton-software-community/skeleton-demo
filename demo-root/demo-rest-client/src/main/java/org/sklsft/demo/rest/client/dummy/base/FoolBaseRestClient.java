package org.sklsft.demo.rest.client.dummy.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.dummy.base.FoolBaseService;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.forms.FoolForm;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
import org.springframework.core.ParameterizedTypeReference;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseRestClient implements FoolBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
/**
 * search options
 */
@Override
public List<SelectItem> searchOptions(String arg) {
return Arrays.asList(restClient.postForObject(SEARCH_OPTIONS_URL, arg, SelectItem[].class));
}

/**
 * load object list
 */
@Override
public List<FoolBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, FoolBasicView[].class));
}

/**
 * scroll object list
 */
@Override
public ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form) {
return restClient.postForObject(SCROLL_URL, form, new ParameterizedTypeReference<ScrollView<FoolBasicView>>(){});
}

/**
 * load object
 */
@Override
public FoolFullView load(String id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.getForObject(GET_URL, FoolFullView.class, vars);
}

/**
 * find object
 */
@Override
public FoolFullView find(String code) {
return null;
}

/**
 * create object
 */
@Override
public FoolFullView create() {
return restClient.getForObject(GET_NEW_URL, FoolFullView.class);
}

/**
 * save object
 */
@Override
public String save(FoolForm foolForm) {
return restClient.postForObject(SAVE_URL, foolForm, String.class);
}

/**
 * update object
 */
@Override
public void update(String id, FoolForm foolForm) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.put(UPDATE_URL, foolForm, vars);
}

/**
 * delete object
 */
@Override
public void delete(String id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.delete(DELETE_URL, vars);
}

/**
 * delete object list
 */
@Override
public void deleteList(List<String> idList) {
}

}
