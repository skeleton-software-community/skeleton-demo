package org.sklsft.demo.bc.mapper.organizations.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.organizations.forms.OrganizationForm;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;
import org.sklsft.demo.bc.rightsmanager.organizations.OrganizationRightsManager;
import org.sklsft.demo.bc.statemanager.organizations.OrganizationStateManager;
import org.sklsft.demo.model.organizations.Organization;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class OrganizationFullViewBaseMapper extends FullViewMapper<OrganizationFullView, Long, OrganizationForm, Organization> {

@Inject
protected OrganizationRightsManager organizationRightsManager;
@Inject
protected OrganizationStateManager organizationStateManager;

public OrganizationFullViewBaseMapper() {
super(OrganizationFullView.class, Organization.class);
}

@Override
public OrganizationFullView mapFrom(OrganizationFullView organizationFullView, Organization organization) {
organizationFullView = super.mapFrom(organizationFullView, organization);
organizationFullView.setCanUpdate(organizationRightsManager.canUpdate(organization) && organizationStateManager.canUpdate(organization));
return organizationFullView;
}

}
