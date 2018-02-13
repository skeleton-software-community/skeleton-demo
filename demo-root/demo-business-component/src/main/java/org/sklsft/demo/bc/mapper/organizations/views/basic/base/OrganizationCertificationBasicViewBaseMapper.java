package org.sklsft.demo.bc.mapper.organizations.views.basic.base;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationCertificationBasicView;
import org.sklsft.demo.bc.rightsmanager.organizations.OrganizationRightsManager;
import org.sklsft.demo.bc.statemanager.organizations.OrganizationStateManager;
import org.sklsft.demo.model.organizations.OrganizationCertification;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationCertificationBasicViewBaseMapper extends BasicMapperImpl<OrganizationCertificationBasicView, OrganizationCertification> {

public OrganizationCertificationBasicViewBaseMapper() {
super(OrganizationCertificationBasicView.class, OrganizationCertification.class);
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
public OrganizationCertificationBasicView mapFrom(OrganizationCertificationBasicView organizationCertificationBasicView, OrganizationCertification organizationCertification) {
organizationCertificationBasicView = super.mapFrom(organizationCertificationBasicView, organizationCertification);
organizationCertificationBasicView.setSelected(false);
organizationCertificationBasicView.setCanDelete(organizationRightsManager.canDeleteOrganizationCertification(organizationCertification) && organizationStateManager.canDeleteOrganizationCertification(organizationCertification));
return organizationCertificationBasicView;
}

/**
 * mapping view to object
 */
@Override
public OrganizationCertification mapTo(OrganizationCertificationBasicView organizationCertificationBasicView, OrganizationCertification organizationCertification) {
organizationCertification = super.mapTo(organizationCertificationBasicView, organizationCertification);
return organizationCertification;
}

}
