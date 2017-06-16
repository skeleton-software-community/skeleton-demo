package org.sklsft.demo.api.model.localization.orderings;

import java.io.Serializable;
import java.util.Date;
import org.sklsft.commons.api.model.OrderType;

/**
 * auto generated ordering class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class RegionOrdering implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrderType countryCodeOrderType;
private OrderType codeOrderType;
private OrderType labelOrderType;

/*
 * getters and setters
 */
public OrderType getCountryCodeOrderType() {
return this.countryCodeOrderType;
}

public void setCountryCodeOrderType(OrderType countryCodeOrderType) {
this.countryCodeOrderType = countryCodeOrderType;
}

public OrderType getCodeOrderType() {
return this.codeOrderType;
}

public void setCodeOrderType(OrderType codeOrderType) {
this.codeOrderType = codeOrderType;
}

public OrderType getLabelOrderType() {
return this.labelOrderType;
}

public void setLabelOrderType(OrderType labelOrderType) {
this.labelOrderType = labelOrderType;
}


/* Specific Code Start */
/* Specific Code End */
}
