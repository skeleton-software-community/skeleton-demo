package org.sklsft.demo.components.mapper.organizations.forms.base;

import org.sklsft.commons.mapper.impl.BasicMapperImpl;
import org.sklsft.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.sklsft.demo.model.organizations.OrganizationCertification;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
public class OrganizationCertificationFormBaseMapper extends BasicMapperImpl<OrganizationCertificationForm, OrganizationCertification> {

public OrganizationCertificationFormBaseMapper() {
super(OrganizationCertificationForm.class, OrganizationCertification.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public OrganizationCertificationForm mapFrom(OrganizationCertificationForm organizationCertificationForm, OrganizationCertification organizationCertification) {
organizationCertificationForm = super.mapFrom(organizationCertificationForm, organizationCertification);
return organizationCertificationForm;
}

/**
 * mapping view to object
 */
@Override
public OrganizationCertification mapTo(OrganizationCertificationForm organizationCertificationForm, OrganizationCertification organizationCertification) {
organizationCertification = super.mapTo(organizationCertificationForm, organizationCertification);
return organizationCertification;
}

}
