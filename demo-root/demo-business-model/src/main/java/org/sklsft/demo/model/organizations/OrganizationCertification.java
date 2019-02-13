package org.sklsft.demo.model.organizations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="ORGANIZATION_CERTIFICATION"
, uniqueConstraints = {@UniqueConstraint(columnNames = {"ORGANIZATION_ID"})})
public class OrganizationCertification implements org.sklsft.commons.model.interfaces.Entity<String> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public OrganizationCertification(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@GeneratedValue(generator="uuid")
@GenericGenerator(name="uuid", strategy = "uuid2")
private String id;

@ManyToOne(fetch = FetchType.LAZY)
@Fetch(FetchMode.JOIN)
@JoinColumn(name = "ORGANIZATION_ID", unique = true)
private Organization organization;

@Column(name = "CERTIFIED", nullable = false)
private Boolean certified;


/*
 * getters and setters
 */
public String getId() {
return this.id;
}

public void setId(String id) {
this.id = id;
}

public Organization getOrganization() {
return this.organization;
}

public void setOrganization(Organization organization) {
this.organization = organization;
}

public Boolean getCertified() {
return this.certified;
}

public void setCertified(Boolean certified) {
this.certified = certified;
}


/* Specific Code Start */
/* Specific Code End */
}