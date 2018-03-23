package org.sklsft.demo.rest.controller.localization.base;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.localization.RegionService;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.forms.RegionForm;
import org.sklsft.demo.api.model.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;
import org.springframework.stereotype.Controller;
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
@Controller
public class RegionBaseController {

/*
 * services injected by spring
 */
@Inject
protected RegionService regionService;

/**
 * load object list
 */
@RequestMapping(value = {RegionService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<RegionBasicView> loadList() {
return regionService.loadList();
}

/**
 * load object list from country
 */
@RequestMapping(value = {RegionService.GET_REGION_LIST_fROM_COUNTRY_URL}, method = RequestMethod.GET)
public @ResponseBody List<RegionBasicView> loadListFromCountry (@PathVariable("countryId") Long countryId) {
return regionService.loadListFromCountry(countryId);
}
/**
 * scroll object list
 */
@RequestMapping(value = {RegionService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<RegionBasicView> scroll(@RequestBody ScrollForm<RegionFilter, RegionSorting> form) {
return regionService.scroll(form);
}

/**
 * scroll object list from country
 */
@RequestMapping(value = {RegionService.SCROLL_REGION_fROM_COUNTRY_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<RegionBasicView> scrollFromCountry (@PathVariable("countryId") Long countryId, @RequestBody ScrollForm<RegionFilter, RegionSorting> form) {
return regionService.scrollFromCountry(countryId, form);
}
/**
 * load object
 */
@RequestMapping(value = {RegionService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody RegionFullView load(@PathVariable("id") Long id) {
return regionService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {RegionService.FIND_URL}, method = RequestMethod.GET)
@ResponseBody RegionFullView find(@RequestParam("countryCode") String countryCode, @RequestParam("code") String code) {
return regionService.find(countryCode, code);
}

/**
 * create object
 */
@RequestMapping(value = {RegionService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody RegionFullView create() {
return regionService.create();
}

/**
 * save object
 */
@RequestMapping(value = {RegionService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@RequestBody RegionForm form) {
return regionService.save(form);
}

/**
 * save object from parent Country
 */
@RequestMapping(value = {RegionService.SAVE_FROM_COUNTRY_URL}, method = RequestMethod.POST)
public @ResponseBody Long saveFromCountry(@PathVariable("countryId") Long countryId, @RequestBody RegionForm form) {
return regionService.saveFromCountry(countryId, form);
}

/**
 * update object
 */
@RequestMapping(value = {RegionService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @RequestBody RegionForm form) {
regionService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {RegionService.DELETE_URL}, method = RequestMethod.DELETE)
void delete(@PathVariable("id") Long id) {
regionService.delete(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {RegionService.DELETE_LIST_URL}, method = RequestMethod.POST)
@ResponseBody void deleteList(@RequestBody List<Long> idList) {
regionService.deleteList(idList);
}

}
