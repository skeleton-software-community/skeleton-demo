package org.sklsft.demo.model.organizations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="ORGANIZATION_DESCRIPTION")
public class OrganizationDescription implements org.sklsft.commons.model.interfaces.Entity<Long> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public OrganizationDescription(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "organizationDescriptionIdGenerator", sequenceName = "ORGANIZATION_DESCRIPTION_id_seq", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationDescriptionIdGenerator")
private Long id;

@Lob
@Type(type="org.hibernate.type.TextType")
@Column(name = "DESCRIPTION")
private String description;


/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
this.id = id;
}

public String getDescription() {
return this.description;
}

public void setDescription(String description) {
this.description = description;
}


/* Specific Code Start */
/* Specific Code End */
}