package org.sklsft.demo.rest.client.reference.localization.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.reference.localization.base.RegionBaseService;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.forms.RegionForm;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.RegionFullView;
import org.sklsft.demo.model.reference.localization.Region;

/**
 * auto generated base rest client class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class RegionBaseRestClient implements RegionBaseService {

/*
 * properties injected by spring
 */
@Inject
private RestClient restClient;
/**
 * load object list
 */
@Override
public List<RegionBasicView> loadList() {
return null;
}

/**
 * load object list from country
 */
@Override
public List<RegionBasicView> loadListFromCountry (Short countryId) {
return null;
}

/**
 * scroll object list
 */
@Override
public ScrollView<RegionBasicView> scroll(ScrollForm<RegionFilter, RegionSorting> form) {
return null;
}

/**
 * scroll object list from country
 */
@Override
public ScrollView<RegionBasicView> scrollFromCountry (Short countryId, ScrollForm<RegionFilter, RegionSorting> form) {
return null;
}

/**
 * load object
 */
@Override
public RegionFullView load(Integer id) {
return null;
}

/**
 * find object
 */
@Override
public RegionFullView find(return null;
}

/**
 * create object
 */
@Override
public RegionFullView create() {
return null;
}

/**
 * save object
 */
@Override
public Integer save(RegionForm regionForm) {
return null;
}

/**
 * save object from parent Country
 */
@Override
public Integer saveFromCountry(Short countryId, RegionForm regionForm) {
return null;
}

/**
 * update object
 */
@Override
public void update(Integer id, RegionForm regionForm) {
}

/**
 * delete object
 */
@Override
public void delete(Integer id) {
}

/**
 * delete object list
 */
@Override
public void deleteList(List<Integer> idList) {
Region region;
}

}
