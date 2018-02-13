package org.sklsft.demo.bc.mapper.organizations.forms.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationDescription;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationFormBaseMapper extends BasicMapperImpl<OrganizationForm, Organization> {

public OrganizationFormBaseMapper() {
super(OrganizationForm.class, Organization.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public OrganizationForm mapFrom(OrganizationForm organizationForm, Organization organization) {
organizationForm = super.mapFrom(organizationForm, organization);
organizationForm.setDescription(organization.getOrganizationDescription().getDescription());
return organizationForm;
}

/**
 * mapping view to object
 */
@Override
public Organization mapTo(OrganizationForm organizationForm, Organization organization) {
organization = super.mapTo(organizationForm, organization);
OrganizationDescription organizationDescription = organization.getOrganizationDescription();
if (organizationDescription == null) {
organizationDescription = new OrganizationDescription();
organization.setOrganizationDescription(organizationDescription);
}
organizationDescription.setDescription(organizationForm.getDescription());
return organization;
}

}
