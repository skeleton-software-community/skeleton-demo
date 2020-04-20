package org.sklsft.demo.model.organizations;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="ORGANIZATION"
, uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE"})})
public class Organization implements org.sklsft.commons.model.interfaces.Entity<Integer> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Organization(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "organizationIdGenerator", sequenceName = "ORGANIZATION_id_seq", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationIdGenerator")
private Integer id;

@Column(name = "CODE", nullable = false)
private String code;

@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "ORGANIZATION_DESCRIPTION_ID", unique = true, nullable = false)
private OrganizationDescription organizationDescription;

@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "organization")
@Fetch(FetchMode.JOIN)
private OrganizationCertification organizationCertification;


/*
 * getters and setters
 */
public Integer getId() {
return this.id;
}

public void setId(Integer id) {
this.id = id;
}

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public OrganizationDescription getOrganizationDescription() {
return this.organizationDescription;
}

public void setOrganizationDescription(OrganizationDescription organizationDescription) {
this.organizationDescription = organizationDescription;
}

public OrganizationCertification getOrganizationCertification () {
return this.organizationCertification;
}

public void setOrganizationCertification (OrganizationCertification organizationCertification) {
this.organizationCertification = organizationCertification;
}


/* Specific Code Start */
/* Specific Code End */
}