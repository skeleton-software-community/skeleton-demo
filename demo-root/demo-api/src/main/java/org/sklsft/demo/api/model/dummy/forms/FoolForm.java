package org.sklsft.demo.api.model.dummy.forms;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * auto generated form bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class FoolForm implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
@NotNull
private String code;
private String description;
private Long longField;
private Boolean booleanField;
private Double doubleField2;
private Double doubleField4;
private Date dateField;
private Date datetimeField;

/*
 * getters and setters
 */
public String getCode() {
return this.code;
}
public void setCode(String code) {
this.code = code;
}
public String getDescription() {
return this.description;
}
public void setDescription(String description) {
this.description = description;
}
public Long getLongField() {
return this.longField;
}
public void setLongField(Long longField) {
this.longField = longField;
}
public Boolean getBooleanField() {
return this.booleanField;
}
public void setBooleanField(Boolean booleanField) {
this.booleanField = booleanField;
}
public Double getDoubleField2() {
return this.doubleField2;
}
public void setDoubleField2(Double doubleField2) {
this.doubleField2 = doubleField2;
}
public Double getDoubleField4() {
return this.doubleField4;
}
public void setDoubleField4(Double doubleField4) {
this.doubleField4 = doubleField4;
}
public Date getDateField() {
return this.dateField;
}
public void setDateField(Date dateField) {
this.dateField = dateField;
}
public Date getDatetimeField() {
return this.datetimeField;
}
public void setDatetimeField(Date datetimeField) {
this.datetimeField = datetimeField;
}

/* Specific Code Start */
/* Specific Code End */
}
