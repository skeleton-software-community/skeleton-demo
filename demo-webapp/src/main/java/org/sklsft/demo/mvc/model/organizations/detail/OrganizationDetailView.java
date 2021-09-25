package org.sklsft.demo.mvc.model.organizations.detail;

import java.io.Serializable;

import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class OrganizationDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrganizationFullView selectedOrganization = new OrganizationFullView();

private OrganizationCertificationFullView selectedOrganizationCertification;

/*
 * getters and setters
 */
public OrganizationFullView getSelectedOrganization() {
return selectedOrganization;
}
public void setSelectedOrganization(OrganizationFullView selectedOrganization) {
this.selectedOrganization = selectedOrganization;
}

public OrganizationCertificationFullView getSelectedOrganizationCertification() {
return selectedOrganizationCertification;
}
public void setSelectedOrganizationCertification(OrganizationCertificationFullView selectedOrganizationCertification) {
this.selectedOrganizationCertification = selectedOrganizationCertification;
}

/* Specific Code Start */
/* Specific Code End */
}
