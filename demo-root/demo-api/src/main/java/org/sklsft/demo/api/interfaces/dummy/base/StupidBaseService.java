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
public static final String GET_LIST_URL = "/stupid/list";

/**
 * load object list from fool
 */
List<StupidBasicView> loadListFromFool (String foolId);
public static final String GET_STUPID_LIST_fROM_FOOL_URL = "/fool/{foolId}/stupid/list";

/**
 * scroll object list
 */
ScrollView<StupidBasicView> scroll(ScrollForm<StupidFilter, StupidSorting> form);
public static final String SCROLL_URL = "/stupid/scroll";

/**
 * scroll object list from fool
 */
ScrollView<StupidBasicView> scrollFromFool (String foolId, ScrollForm<StupidFilter, StupidSorting> form);
public static final String SCROLL_STUPID_fROM_FOOL_URL = "/fool/{foolId}/stupid/scroll";

/**
 * load object
 */
StupidFullView load(Long id);
public static final String GET_URL = "/stupid/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/stupid/find";
StupidFullView find(String code);

/**
 * create object
 */
StupidFullView create();
public static final String GET_NEW_URL = "/stupid/new";

/**
 * save object
 */
Long save(StupidForm stupidForm);
public static final String SAVE_URL = "/stupid";

/**
 * save object from parent Fool
 */
Long saveFromFool(String foolId, StupidForm stupidForm);
public static final String SAVE_FROM_FOOL_URL = "/fool/{foolId}/stupid";

/**
 * update object
 */
void update(Long id, StupidForm stupidForm);
public static final String UPDATE_URL = "/stupid/{id}";

/**
 * delete object
 */
void delete(Long id);
public static final String DELETE_URL = "/stupid/{id}";

/**
 * delete object list
 */
void deleteList(List<Long> idList);
public static final String DELETE_LIST_URL = "/stupid/delete";

}
