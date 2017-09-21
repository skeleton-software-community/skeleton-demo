package org.sklsft.demo.api.model.time.filters;

import java.io.Serializable;
import java.util.Date;

/**
 * auto generated filter class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class CalendarDayOffFilter implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private Date dayOffDateMinValue;
private Date dayOffDateMaxValue;
private String dayOffLabel;

/*
 * getters and setters
 */
public Date getDayOffDateMinValue() {
return this.dayOffDateMinValue;
}
public void setDayOffDateMinValue(Date dayOffDateMinValue) {
this.dayOffDateMinValue = dayOffDateMinValue;
}
public Date getDayOffDateMaxValue() {
return this.dayOffDateMaxValue;
}
public void setDayOffDateMaxValue(Date dayOffDateMaxValue) {
this.dayOffDateMaxValue = dayOffDateMaxValue;
}
public String getDayOffLabel() {
return this.dayOffLabel;
}
public void setDayOffLabel(String dayOffLabel) {
this.dayOffLabel = dayOffLabel;
}

/* Specific Code Start */
/* Specific Code End */
}
