package org.sklsft.demo.model.dummy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Entity
@Table(name="FOOL"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_FOOL", columnNames = {"CODE"})
}
, indexes = {
@Index(name = "IDX_FOOL_UC", columnList = "CODE")
})
public class Fool implements org.sklsft.commons.model.interfaces.Entity<String> {

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
@GeneratedValue(generator="uuid")
@GenericGenerator(name="uuid", strategy = "uuid2")
private String id;

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

@Column(name = "DATE_FIELD")
private LocalDate dateField;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "DATETIME_FIELD")
private Date datetimeField;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "fool")
private Set <Stupid> stupidCollection;


/*
 * getters and setters
 */
public String getId() {
return this.id;
}

public void setId(String id) {
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

public LocalDate getDateField() {
return this.dateField;
}

public void setDateField(LocalDate dateField) {
this.dateField = dateField;
}

public Date getDatetimeField() {
return this.datetimeField;
}

public void setDatetimeField(Date datetimeField) {
this.datetimeField = datetimeField;
}

public Set <Stupid> getStupidCollection () {
return this.stupidCollection;
}

public void setStupidCollection(Set <Stupid> stupidCollection) {
this.stupidCollection = stupidCollection;
}


/* Specific Code Start */
/* Specific Code End */
}