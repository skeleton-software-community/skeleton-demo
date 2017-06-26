package org.sklsft.demo.mvc.controller.localization.list.base;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.sklsft.commons.api.exception.rights.OperationDeniedException;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.annotations.AjaxMethod;
import org.sklsft.demo.api.interfaces.localization.CountryService;
import org.sklsft.demo.api.model.localization.filters.CountryFilter;
import org.sklsft.demo.api.model.localization.sortings.CountrySorting;
import org.sklsft.demo.api.model.localization.views.basic.CountryBasicView;
import org.sklsft.demo.mvc.controller.BaseController;
import org.sklsft.demo.mvc.controller.CommonController;
import org.sklsft.demo.mvc.model.localization.list.CountryListView;

/**
 * auto generated base list controller class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class CountryBaseListController extends BaseController {

/*
 * services injected by spring
 */
@Inject
protected CountryService countryService;
@Inject
protected CommonController commonController;

/*
 * view
 */
@Inject
protected CountryListView countryListView;

/*
 * getters and setters
 */
public CountryListView getCountryListView() {
return countryListView;
}
public void setCountryListView(CountryListView countryListView) {
this.countryListView = countryListView;
}

/**
 * load object list
 */
public void load() {
this.reset();
}

/**
 * refresh object list
 */
public void refresh() {
countryListView.setScrollView(countryService.scroll(countryListView.getScrollForm()));
countryListView.getScrollForm().setPage(countryListView.getScrollView().getCurrentPage());
}

/**
 * create object
 */
public void createCountry() {
try {
this.countryListView.setSelectedCountry(this.countryService.create());
} catch (OperationDeniedException e) {
displayError(e.getMessage());
}
}

/**
 * save object
 */
public void save() {
executeAjaxMethod("Country.save", new AjaxMethodTemplate() {
@Override
public Object execute() {
return countryService.save(countryListView.getSelectedCountry().getForm());
}
@Override
public void redirectOnComplete(Object result) {
redirect("/sections/localization/country/CountryDetails.jsf?id=" + result);
}
});
}
/**
 * edit object
 */
public void editCountry(Long id) {
countryListView.setSelectedCountry(countryService.load(id));
}

/**
 * update object
 */
@AjaxMethod("Country.update")
public void update() {
countryService.update(this.countryListView.getSelectedCountry().getId(), this.countryListView.getSelectedCountry().getForm());
this.refresh();
}

/**
 * delete object
 */
@AjaxMethod("Country.delete")
public void delete(Long id) {
countryService.delete(id);
this.refresh();
}

/**
 * delete object list
 */
@AjaxMethod("Country.deleteList")
public void deleteList() {
List<Long> ids = new ArrayList<>();
for (CountryBasicView country:countryListView.getScrollView().getElements()) {
if (country.getSelected()) {
ids.add(country.getId());
}
}
countryService.deleteList(ids);
this.refresh();
}

/**
 * reset filters and sortings
 */
public void reset() {
this.countryListView.setScrollForm(new ScrollForm<>());
this.countryListView.getScrollForm().setFilter(new CountryFilter());
this.countryListView.getScrollForm().setSorting(new CountrySorting());
refresh();
}

}
