package org.sklsft.demo.repository.dao.impl.localization;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;
import org.sklsft.demo.api.model.localization.filters.CityFilter;
import org.sklsft.demo.api.model.localization.ordering.CityOrdering;
import org.sklsft.demo.model.localization.City;
import org.sklsft.demo.repository.dao.impl.localization.base.CityBaseDaoImpl;
import org.sklsft.demo.repository.dao.interfaces.localization.CityDao;
import org.springframework.stereotype.Repository;
import static org.sklsft.commons.model.patterns.HibernateCriteriaUtils.addStringContainsRestriction;

/**
 * auto generated dao class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Repository
public class CityDaoImpl extends CityBaseDaoImpl implements CityDao {

/* Specific Code Start */
	
	/**
	 * load filtered object list eagerly
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<City> scroll(CityFilter filter, CityOrdering ordering, Long firstResult, Long maxResults) {
	Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class);
	Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
	Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
	addStringContainsRestriction(regionCountryCriteria, "{alias}.code", filter.getRegionCountryCode());
	addStringContainsRestriction(regionCriteria, "{alias}.code", filter.getRegionCode());
	addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
	addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());
	criteria.setFirstResult(firstResult.intValue());
	criteria.setMaxResults(maxResults.intValue());
	
	return criteria.list();
	}
	
	@Override
	public Long count(CityFilter filter) {
	Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(City.class)
			.setProjection(Projections.rowCount());
	Criteria regionCriteria = criteria.createCriteria("region", JoinType.LEFT_OUTER_JOIN);
	Criteria regionCountryCriteria = regionCriteria.createCriteria("country", JoinType.LEFT_OUTER_JOIN);
	addStringContainsRestriction(regionCountryCriteria, "{alias}.code", filter.getRegionCountryCode());
	addStringContainsRestriction(regionCriteria, "{alias}.code", filter.getRegionCode());
	addStringContainsRestriction(criteria, "{alias}.code", filter.getCode());
	addStringContainsRestriction(criteria, "{alias}.label", filter.getLabel());

	return (Long) criteria.uniqueResult();
	}
	
/* Specific Code End */
}
