package org.sklsft.demo.rest.client.reference.localization.base;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.commons.rest.client.RestClient;
import org.sklsft.demo.api.interfaces.reference.localization.base.RegionBaseService;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.forms.RegionForm;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.RegionFullView;
import org.springframework.core.ParameterizedTypeReference;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseRestClient implements RegionBaseService {

/*
 * properties injected by spring
 */
@Resource(name="demoRestClient")
protected RestClient restClient;
/**
 * load object list
 */
@Override
public List<RegionBasicView> loadList() {
return Arrays.asList(restClient.getForObject(GET_LIST_URL, RegionBasicView[].class));
}

/**
 * load object list from country
 */
@Override
public List<RegionBasicView> loadListFromCountry (Short countryId) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("countryId", countryId);
return Arrays.asList(restClient.getForObject(GET_REGION_LIST_FROM_COUNTRY_URL, RegionBasicView[].class, vars));
}

/**
 * scroll object list
 */
@Override
public ScrollView<RegionBasicView> scroll(ScrollForm<RegionFilter, RegionSorting> form) {
return restClient.postForObject(SCROLL_URL, form, new ParameterizedTypeReference<ScrollView<RegionBasicView>>(){});
}

/**
 * scroll object list from country
 */
@Override
public ScrollView<RegionBasicView> scrollFromCountry (Short countryId, ScrollForm<RegionFilter, RegionSorting> form) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("countryId", countryId);
return restClient.postForObject(SCROLL_REGION_FROM_COUNTRY_URL, form, new ParameterizedTypeReference<ScrollView<RegionBasicView>>(){}, vars);
}

/**
 * load object
 */
@Override
public RegionFullView load(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
return restClient.getForObject(GET_URL, RegionFullView.class, vars);
}

/**
 * find object
 */
@Override
public RegionFullView find(String countryCode, String code) {
return null;
}

/**
 * create object
 */
@Override
public RegionFullView create() {
return restClient.getForObject(GET_NEW_URL, RegionFullView.class);
}

/**
 * save object
 */
@Override
public Integer save(RegionForm regionForm) {
return restClient.postForObject(SAVE_URL, regionForm, Integer.class);
}

/**
 * update object
 */
@Override
public void update(Integer id, RegionForm regionForm) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.put(UPDATE_URL, regionForm, vars);
}

/**
 * delete object
 */
@Override
public void delete(Integer id) {
Map<String, Object> vars = new HashMap<String, Object>();
vars.put("id", id);
restClient.delete(DELETE_URL, vars);
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Integer> idList) {
restClient.postForObject(DELETE_LIST_URL, idList, Void.class);
}

}
