package org.sklsft.demo.rest.controller.reference.localization.base;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.api.model.SelectItem;
import org.sklsft.demo.api.interfaces.reference.localization.CountryService;
import org.sklsft.demo.api.model.reference.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.reference.localization.forms.CountryForm;
import org.sklsft.demo.api.model.reference.localization.sortings.CountrySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CountryBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CountryFullView;
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
public class CountryBaseController {

/*
 * services injected by spring
 */
@Inject
protected CountryService countryService;

/**
 * get options
 */
@RequestMapping(value = {CountryService.GET_OPTIONS_URL}, method = RequestMethod.GET)
public @ResponseBody List<SelectItem> getOptions() {
return countryService.getOptions();
}

/**
 * load object list
 */
@RequestMapping(value = {CountryService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<CountryBasicView> loadList() {
return countryService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {CountryService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<CountryBasicView> scroll(@RequestBody ScrollForm<CountryFilter, CountrySorting> form) {
return countryService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {CountryService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody CountryFullView load(@PathVariable("id") Long id) {
return countryService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {CountryService.FIND_URL}, method = RequestMethod.GET)
@ResponseBody CountryFullView find(@RequestParam("code") String code) {
return countryService.find(code);
}

/**
 * create object
 */
@RequestMapping(value = {CountryService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody CountryFullView create() {
return countryService.create();
}

/**
 * save object
 */
@RequestMapping(value = {CountryService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@RequestBody CountryForm form) {
return countryService.save(form);
}

/**
 * update object
 */
@RequestMapping(value = {CountryService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @RequestBody CountryForm form) {
countryService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {CountryService.DELETE_URL}, method = RequestMethod.DELETE)
void delete(@PathVariable("id") Long id) {
countryService.delete(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {CountryService.DELETE_LIST_URL}, method = RequestMethod.POST)
@ResponseBody void deleteList(@RequestBody List<Long> idList) {
countryService.deleteList(idList);
}

}
