package org.sklsft.demo.model.reference.localization;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@StaticMetamodel(Region.class)
public abstract class Region_ {

public static volatile SingularAttribute<Region, Integer> id;
public static volatile SingularAttribute<Region, Country> country;
public static volatile SingularAttribute<Region, String> code;
public static volatile SingularAttribute<Region, String> label;
public static volatile SetAttribute<Region, City> cityCollection;

public static final String ID = "id";
public static final String COUNTRY = "country";
public static final String CODE = "code";
public static final String LABEL = "label";
public static final String CITY_COLLECTION = "cityCollection";

/* Specific Code Start */
/* Specific Code End */
}