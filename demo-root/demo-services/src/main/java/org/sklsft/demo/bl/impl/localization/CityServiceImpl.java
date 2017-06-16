package org.sklsft.demo.bl.impl.localization;

import java.util.ArrayList;
import java.util.List;
import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.interfaces.localization.CityService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.ordering.CityOrdering;
import org.sklsft.demo.api.model.localization.views.basic.CityBasicView;
import org.sklsft.demo.bl.impl.localization.base.CityBaseServiceImpl;
import org.sklsft.demo.model.localization.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated service class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Service("demoCityServiceImpl")
public class CityServiceImpl extends CityBaseServiceImpl implements CityService{

/* Specific Code Start */

	/**
	 * load filtered object list
	 */
	@Override
	@Transactional(readOnly = true)
	public ScrollView<CityBasicView> scroll(ScrollForm<CityFilter, CityOrdering> form) {
		cityRightsManager.checkCanAccess();
		ScrollView<CityBasicView> result = new ScrollView<>();
		result.setSize(cityDao.count());
		Long size = cityDao.count(form.getFilter());		
		result.setNumberOfPages(size/form.getElementsPerPage() + ((size%form.getElementsPerPage()) > 0L?1L:0L));
		result.setCurrentPage(Math.min(form.getPage()!=null?form.getPage():1L, result.getNumberOfPages()));		
		List<City> cityList = cityDao.scroll(form.getFilter(), form.getSorting(),(result.getCurrentPage()-1)*form.getElementsPerPage(), form.getElementsPerPage());
		List<CityBasicView> list = new ArrayList<>(cityList.size());
		for (City city : cityList) {
			list.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(), city));
		}
		result.setElements(list);
		return result;
	}

/* Specific Code End */
}
