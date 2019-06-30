package org.sklsft.demo.rest.client.dummy.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.dummy.base.StupidBaseService;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class StupidBaseRestClient implements StupidBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
/**
 * load object list
 */
@Override
public List<StupidBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, StupidBasicView[].class));
}

/**
 * load object list from fool
 */
@Override
public List<StupidBasicView> loadListFromFool (String foolId) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("foolId", foolId);
return Arrays.asList(restClient.getForObject(GET_STUPID_LIST_fROM_FOOL_URL, StupidBasicView[].class, vars));
}

/**
 * scroll object list
 */
@Override
public ScrollView<StupidBasicView> scroll(ScrollForm<StupidFilter, StupidSorting> form) {
return null;
}

/**
 * scroll object list from fool
 */
@Override
public ScrollView<StupidBasicView> scrollFromFool (String foolId, ScrollForm<StupidFilter, StupidSorting> form) {
return null;
}

/**
 * load object
 */
@Override
public StupidFullView load(Long id) {
return null;
}

/**
 * find object
 */
@Override
public StupidFullView find(String code) {
return null;
}

/**
 * create object
 */
@Override
public StupidFullView create() {
return null;
}

/**
 * save object
 */
@Override
public Long save(StupidForm stupidForm) {
return null;
}

/**
 * save object from parent Fool
 */
@Override
public Long saveFromFool(String foolId, StupidForm stupidForm) {
return null;
}

/**
 * update object
 */
@Override
public void update(Long id, StupidForm stupidForm) {
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
