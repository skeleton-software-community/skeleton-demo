package org.sklsft.demo.rest.controller.dummy.base;

import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.dummy.StupidService;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * auto generated base rest controller file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Controller
public class StupidBaseController {

/*
 * services injected by spring
 */
@Inject
protected StupidService stupidService;

/**
 * load object list
 */
@RequestMapping(value = {StupidService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<StupidBasicView> loadList() {
return stupidService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {StupidService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<StupidBasicView> scroll(@RequestBody ScrollForm<StupidFilter, StupidSorting> form) {
return stupidService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {StupidService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody StupidFullView load(@PathVariable("id") Long id) {
return stupidService.load(id);
}
/**
 * create object
 */
@RequestMapping(value = {StupidService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody StupidFullView create() {
return stupidService.create();
}

/**
 * save object
 */
@RequestMapping(value = {StupidService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@RequestBody StupidForm stupidForm) {
return stupidService.save(stupidForm);
}

/**
 * update object
 */
@RequestMapping(value = {StupidService.UPDATE_URL}, method = RequestMethod.PUT)
public void update(@PathVariable("id") Long id, @RequestBody StupidForm stupidForm) {
stupidService.update(id, stupidForm);
}

/**
 * delete object
 */
@RequestMapping(value = {StupidService.DELETE_URL}, method = RequestMethod.DELETE)
void delete(@PathVariable("id") Long id) {
stupidService.delete(id);
}

}
