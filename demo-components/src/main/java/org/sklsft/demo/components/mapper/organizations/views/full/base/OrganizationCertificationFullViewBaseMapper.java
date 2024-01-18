package org.sklsft.demo.components.mapper.organizations.views.full.base;

import org.sklsft.commons.mapper.impl.FullViewMapper;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.sklsft.demo.components.statemanager.organizations.OrganizationStateManager;
import org.sklsft.demo.model.organizations.OrganizationCertification;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

public class OrganizationCertificationFullViewBaseMapper extends FullViewMapper<OrganizationCertificationFullView, String, OrganizationCertificationForm, OrganizationCertification> {

@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationStateManager organizationStateManager;

public OrganizationCertificationFullViewBaseMapper() {
super(OrganizationCertificationFullView.class, OrganizationCertification.class);
}

@Override
public OrganizationCertificationFullView mapFrom(OrganizationCertificationFullView organizationCertificationFullView, OrganizationCertification organizationCertification) {
organizationCertificationFullView = super.mapFrom(organizationCertificationFullView, organizationCertification);
organizationCertificationFullView.setCanUpdate(organizationRightsManager.canUpdateOrganizationCertification(organizationCertification) && organizationStateManager.canUpdateOrganizationCertification(organizationCertification));
organizationCertificationFullView.setCanDelete(organizationRightsManager.canDeleteOrganizationCertification(organizationCertification) && organizationStateManager.canDeleteOrganizationCertification(organizationCertification));
return organizationCertificationFullView;
}

}
