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

/**
 * load object list
 */
List<FoolBasicView> loadList();

/**
 * scroll object list
 */
ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form);

/**
 * load object
 */
FoolFullView load(Long id);

/**
 * find object
 */
FoolFullView find(String code);

/**
 * create object
 */
FoolFullView create();

/**
 * save object
 */
Long save(FoolForm foolForm);

/**
 * update object
 */
void update(Long id, FoolForm foolForm);

/**
 * delete object
 */
void delete(Long id);

/**
 * delete object list
 */
void deleteList(List<Long> idList);

}
