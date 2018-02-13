package org.sklsft.demo.bc.mapper.organizations.views.full.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.bc.rightsmanager.organizations.OrganizationRightsManager;
import org.sklsft.demo.bc.statemanager.organizations.OrganizationStateManager;
import org.sklsft.demo.model.organizations.OrganizationCertification;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class OrganizationCertificationFullViewBaseMapper extends FullViewMapper<OrganizationCertificationFullView, Long, OrganizationCertificationForm, OrganizationCertification> {

@Inject
protected OrganizationRightsManager organizationRightsManager;
@Inject
protected OrganizationStateManager organizationStateManager;

public OrganizationCertificationFullViewBaseMapper() {
super(OrganizationCertificationFullView.class, OrganizationCertification.class);
}

@Override
public OrganizationCertificationFullView mapFrom(OrganizationCertificationFullView organizationCertificationFullView, OrganizationCertification organizationCertification) {
organizationCertificationFullView = super.mapFrom(organizationCertificationFullView, organizationCertification);
organizationCertificationFullView.setCanUpdate(organizationRightsManager.canUpdateOrganizationCertification(organizationCertification) && organizationStateManager.canUpdateOrganizationCertification(organizationCertification));
return organizationCertificationFullView;
}

}
