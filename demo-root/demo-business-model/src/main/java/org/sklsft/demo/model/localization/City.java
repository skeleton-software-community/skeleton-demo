package org.sklsft.demo.model.localization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="CITY"
, uniqueConstraints = {@UniqueConstraint(columnNames = {"REGION_ID", "CODE"})})
public class City implements org.sklsft.commons.model.interfaces.Entity<Long> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public City(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "generator", sequenceName = "CITY_id_seq", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
private Long id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "REGION_ID", nullable = false)
private Region region;

@Column(name = "CODE", nullable = false)
private String code;

@Column(name = "LABEL", nullable = false)
private String label;


/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
this.id = id;
}

public Region getRegion() {
return this.region;
}

public void setRegion(Region region) {
this.region = region;
}

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public String getLabel() {
return this.label;
}

public void setLabel(String label) {
this.label = label;
}


/* Specific Code Start */
/* Specific Code End */
}