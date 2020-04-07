package org.sklsft.demo.model.reference.localization;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="COUNTRY"
, uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE"})})
public class Country implements org.sklsft.commons.model.interfaces.Entity<Short> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Country(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "generator", sequenceName = "COUNTRY_id_seq", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
private Short id;

@Column(name = "CODE", nullable = false)
private String code;

@Column(name = "LABEL", nullable = false)
private String label;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
private Set <Region> regionCollection;


/*
 * getters and setters
 */
public Short getId() {
return this.id;
}

public void setId(Short id) {
this.id = id;
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

public Set <Region> getRegionCollection () {
return this.regionCollection;
}

public void setRegionCollection(Set <Region> regionCollection) {
this.regionCollection = regionCollection;
}


/* Specific Code Start */
/* Specific Code End */
}