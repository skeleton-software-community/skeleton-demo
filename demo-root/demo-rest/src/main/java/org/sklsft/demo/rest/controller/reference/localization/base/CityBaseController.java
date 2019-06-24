package org.sklsft.demo.rest.controller.reference.localization.base;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.reference.localization.CityService;
import org.sklsft.demo.api.model.reference.localization.filters.CityFilter;
import org.sklsft.demo.api.model.reference.localization.forms.CityForm;
import org.sklsft.demo.api.model.reference.localization.sortings.CitySorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.CityFullView;
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
public class CityBaseController {

/*
 * services injected by spring
 */
@Inject
protected CityService cityService;

/**
 * load object list
 */
@RequestMapping(value = {CityService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<CityBasicView> loadList() {
return cityService.loadList();
}

/**
 * load object list from region
 */
@RequestMapping(value = {CityService.GET_CITY_LIST_fROM_REGION_URL}, method = RequestMethod.GET)
public @ResponseBody List<CityBasicView> loadListFromRegion (@PathVariable("regionId") Integer regionId) {
return cityService.loadListFromRegion(regionId);
}
/**
 * scroll object list
 */
@RequestMapping(value = {CityService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<CityBasicView> scroll(@RequestBody ScrollForm<CityFilter, CitySorting> form) {
return cityService.scroll(form);
}

/**
 * scroll object list from region
 */
@RequestMapping(value = {CityService.SCROLL_CITY_fROM_REGION_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<CityBasicView> scrollFromRegion (@PathVariable("regionId") Integer regionId, @RequestBody ScrollForm<CityFilter, CitySorting> form) {
return cityService.scrollFromRegion(regionId, form);
}
/**
 * load object
 */
@RequestMapping(value = {CityService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody CityFullView load(@PathVariable("id") Long id) {
return cityService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {CityService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody CityFullView find(@RequestParam("regionCountryCode") String regionCountryCode, @RequestParam("regionCode") String regionCode, @RequestParam("code") String code) {
return cityService.find(regionCountryCode, regionCode, code);
}

/**
 * create object
 */
@RequestMapping(value = {CityService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody CityFullView create() {
return cityService.create();
}

/**
 * save object
 */
@RequestMapping(value = {CityService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@Valid @RequestBody CityForm form) {
return cityService.save(form);
}

/**
 * save object from parent Region
 */
@RequestMapping(value = {CityService.SAVE_FROM_REGION_URL}, method = RequestMethod.POST)
public @ResponseBody Long saveFromRegion(@PathVariable("regionId") Integer regionId, @Valid @RequestBody CityForm form) {
return cityService.saveFromRegion(regionId, form);
}

/**
 * update object
 */
@RequestMapping(value = {CityService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @Valid @RequestBody CityForm form) {
cityService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {CityService.DELETE_URL}, method = RequestMethod.DELETE)
public void delete(@PathVariable("id") Long id) {
cityService.delete(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {CityService.DELETE_LIST_URL}, method = RequestMethod.POST)
public @ResponseBody void deleteList(@RequestBody List<Long> idList) {
cityService.deleteList(idList);
}

}
