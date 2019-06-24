package org.sklsft.demo.rest.client.dummy.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import org.sklsft.demo.model.dummy.Fool;

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
return null;
}

/**
 * load object list
 */
@Override
public List<FoolBasicView> loadList() {
return null;
}

/**
 * scroll object list
 */
@Override
public ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form) {
return null;
}

/**
 * load object
 */
@Override
public FoolFullView load(String id) {
return null;
}

/**
 * find object
 */
@Override
public FoolFullView find(return null;
}

/**
 * create object
 */
@Override
public FoolFullView create() {
return null;
}

/**
 * save object
 */
@Override
public String save(FoolForm foolForm) {
return null;
}

/**
 * update object
 */
@Override
public void update(String id, FoolForm foolForm) {
}

/**
 * delete object
 */
@Override
public void delete(String id) {
}

/**
 * delete object list
 */
@Override
public void deleteList(List<String> idList) {
Fool fool;
}

}
