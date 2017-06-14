package org.sklsft.demo.repository.dao.impl.localization;

import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.*;

import java.util.List;

import org.hibernate.Criteria;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.impl.localization.base.CityBaseDaoImpl;
import org.sklsft.demo.repository.dao.interfaces.localization.CityDao;
import org.springframework.stereotype.Repository;

/**
 * auto generated dao class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Repository
public class CityDaoImpl extends CityBaseDaoImpl implements CityDao {

/* Specific Code Start */
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<City> loadListEagerly(CityFilter filter) {

	Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class)
	.createAlias("region","Region")
	.createAlias("region.country","RegionCountry");
	addStringContainsRestriction(criteria, "RegionCountry.code", filter.getRegionCountryCode());
	addStringContainsRestriction(criteria, "Region.code",filter.getRegionCode());
	addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
	addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());

	List<City> result = criteria.list();
	return result;
	}

	
/* Specific Code End */
}
