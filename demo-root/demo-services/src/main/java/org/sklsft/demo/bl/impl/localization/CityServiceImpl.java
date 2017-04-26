package org.sklsft.demo.bl.impl.localization;

import java.util.ArrayList;
import java.util.List;

import org.sklsft.demo.api.interfaces.localization.CityService;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
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
	 * load object list
	 */
	@Override
	@Transactional(readOnly=true)
	public List<CityBasicView> loadList(CityFilter filter) {
	cityRightsManager.checkCanAccess();
	List<City> cityList = cityDao.loadListEagerly(filter);
	List<CityBasicView> result = new ArrayList<>(cityList.size());
	for (City city : cityList) {
	result.add(this.cityBasicViewMapper.mapFrom(new CityBasicView(),city));
	}
	return result;
	}
	
/* Specific Code End */
}
