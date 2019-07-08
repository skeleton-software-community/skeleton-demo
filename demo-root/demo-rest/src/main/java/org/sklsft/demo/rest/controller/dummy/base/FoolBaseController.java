package org.sklsft.demo.rest.controller.dummy.base;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.forms.FoolForm;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * auto generated base rest controller file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class FoolBaseController {

/*
 * services injected by spring
 */
@Inject
protected FoolService foolService;

/**
 * search options
 */
@RequestMapping(value = {FoolService.SEARCH_OPTIONS_URL }, method = RequestMethod.POST)
public @ResponseBody List<SelectItem> searchOptions(@RequestBody String arg) {
return foolService.searchOptions(arg);
}

/**
 * load object list
 */
@RequestMapping(value = {FoolService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<FoolBasicView> loadList() {
return foolService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {FoolService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<FoolBasicView> scroll(@RequestBody ScrollForm<FoolFilter, FoolSorting> form) {
return foolService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {FoolService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody FoolFullView load(@PathVariable("id") String id) {
return foolService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {FoolService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody FoolFullView find(@RequestParam("code") String code) {
return foolService.find(code);
}

/**
 * create object
 */
@RequestMapping(value = {FoolService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody FoolFullView create() {
return foolService.create();
}

/**
 * save object
 */
@RequestMapping(value = {FoolService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody String save(@Valid @RequestBody FoolForm form) {
return foolService.save(form);
}

/**
 * update object
 */
@RequestMapping(value = {FoolService.UPDATE_URL}, method = RequestMethod.PUT)
public @ResponseBody void update(@PathVariable("id") String id, @Valid @RequestBody FoolForm form) {
foolService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {FoolService.DELETE_URL}, method = RequestMethod.DELETE)
public @ResponseBody void delete(@PathVariable("id") String id) {
foolService.delete(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {FoolService.DELETE_LIST_URL}, method = RequestMethod.POST)
public @ResponseBody void deleteList(@RequestBody List<String> idList) {
foolService.deleteList(idList);
}

}
