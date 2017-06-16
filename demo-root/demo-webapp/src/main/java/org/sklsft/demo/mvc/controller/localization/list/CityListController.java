package org.sklsft.demo.mvc.controller.localization.list;

import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.mvc.controller.localization.list.base.CityBaseListController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * auto generated list controller class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CityListController extends  CityBaseListController {

/* Specific Code Start */
	
	/**
	 * refresh object list
	 */
	public void refresh() {
		this.cityListView.setScrollView(cityService.scroll(this.cityListView.getScrollForm()));
		this.cityListView.getScrollForm().setPage(this.cityListView.getScrollView().getCurrentPage());
	}
	
	public void resetCityFilter() {
		this.cityListView.getScrollForm().setFilter(new CityFilter());
		refresh();
	}
	
/* Specific Code End */
}
