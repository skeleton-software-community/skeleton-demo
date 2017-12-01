package org.sklsft.demo.api.interfaces.dummy.base;

import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface StupidBaseService {

/**
 * load object list
 */
List<StupidBasicView> loadList();

/**
 * scroll object list
 */
ScrollView<StupidBasicView> scroll(ScrollForm<StupidFilter, StupidSorting> form);

/**
 * load object
 */
StupidFullView load(Long id);

/**
 * find object
 */
StupidFullView find(String code);

/**
 * create object
 */
StupidFullView create();

/**
 * save object
 */
Long save(StupidForm stupidForm);

/**
 * update object
 */
void update(Long id, StupidForm stupidForm);

/**
 * delete object
 */
void delete(Long id);

/**
 * delete object list
 */
void deleteList(List<Long> idList);

}
