package org.sklsft.demo.model.dummy;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="FOOL"
, uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE"})})
public class Fool implements org.sklsft.commons.model.interfaces.Entity<Long> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Fool(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "generator", sequenceName = "FOOL_id_seq", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
private Long id;

@Column(name = "CODE", nullable = false)
private String code;

@Lob
@Type(type="org.hibernate.type.TextType")
@Column(name = "DESCRIPTION")
private String description;

@Column(name = "LONG_FIELD")
private Long longField;

@Column(name = "BOOLEAN_FIELD")
private Boolean booleanField;

@Column(name = "DOUBLE_FIELD")
private Double doubleField;

@Column(name = "DECIMAL_FIELD")
private BigDecimal decimalField;

@Temporal(TemporalType.DATE)
@Column(name = "DATE_FIELD")
private Date dateField;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "DATETIME_FIELD")
private Date datetimeField;


/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
this.id = id;
}

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

public Double getDoubleField() {
return this.doubleField;
}

public void setDoubleField(Double doubleField) {
this.doubleField = doubleField;
}

public BigDecimal getDecimalField() {
return this.decimalField;
}

public void setDecimalField(BigDecimal decimalField) {
this.decimalField = decimalField;
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