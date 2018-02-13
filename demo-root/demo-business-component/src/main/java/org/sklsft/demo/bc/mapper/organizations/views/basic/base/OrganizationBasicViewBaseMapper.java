package org.sklsft.demo.bc.mapper.organizations.views.basic.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.bc.rightsmanager.organizations.OrganizationRightsManager;
import org.sklsft.demo.bc.statemanager.organizations.OrganizationStateManager;
import org.sklsft.demo.model.organizations.Organization;
import org.sklsft.demo.model.organizations.OrganizationDescription;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationBasicViewBaseMapper extends BasicMapperImpl<OrganizationBasicView, Organization> {

public OrganizationBasicViewBaseMapper() {
super(OrganizationBasicView.class, Organization.class);
}

/*
 * properties
 */

@Inject
protected OrganizationRightsManager organizationRightsManager;
@Inject
protected OrganizationStateManager organizationStateManager;

/**
 * mapping view from object
 */
@Override
public OrganizationBasicView mapFrom(OrganizationBasicView organizationBasicView, Organization organization) {
organizationBasicView = super.mapFrom(organizationBasicView, organization);
organizationBasicView.setSelected(false);
organizationBasicView.setCanDelete(organizationRightsManager.canDelete(organization) && organizationStateManager.canDelete(organization));
organizationBasicView.setDescription(organization.getOrganizationDescription().getDescription());
return organizationBasicView;
}

/**
 * mapping view to object
 */
@Override
public Organization mapTo(OrganizationBasicView organizationBasicView, Organization organization) {
organization = super.mapTo(organizationBasicView, organization);
OrganizationDescription organizationDescription = organization.getOrganizationDescription();
if (organizationDescription == null) {
organizationDescription = new OrganizationDescription();
organization.setOrganizationDescription(organizationDescription);
}
organizationDescription.setDescription(organizationBasicView.getDescription());
return organization;
}

}
