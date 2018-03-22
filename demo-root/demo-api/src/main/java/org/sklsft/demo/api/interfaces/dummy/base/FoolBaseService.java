package org.sklsft.demo.api.interfaces.dummy.base;

import java.util.List;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.forms.FoolForm;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public interface FoolBaseService {

/**
 * search options
 */
List<SelectItem> searchOptions(String arg);
public static final String SEARCH_OPTIONS_URL = "/fool/options/search";

/**
 * load object list
 */
List<FoolBasicView> loadList();
public static final String GET_LIST_URL = "/fool/list";

/**
 * scroll object list
 */
ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form);
public static final String SCROLL_URL = "/fool/scroll";

/**
 * load object
 */
FoolFullView load(Long id);
public static final String GET_URL = "/fool/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/fool/find";
FoolFullView find(String code);

/**
 * create object
 */
FoolFullView create();
public static final String GET_NEW_URL = "/fool/new";

/**
 * save object
 */
Long save(FoolForm foolForm);
public static final String SAVE_URL = "/fool";

/**
 * update object
 */
void update(Long id, FoolForm foolForm);
public static final String UPDATE_URL = "/fool/{id}";

/**
 * delete object
 */
void delete(Long id);
public static final String DELETE_URL = "/fool/{id}";

/**
 * delete object list
 */
void deleteList(List<Long> idList);
public static final String DELETE_LIST_URL = "/fool/delete";

}
