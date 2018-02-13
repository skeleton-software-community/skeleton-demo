package org.sklsft.demo.mvc.model.organizations.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.organizations.filters.OrganizationFilter;
import org.sklsft.demo.api.model.organizations.sortings.OrganizationSorting;
import org.sklsft.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.sklsft.demo.api.model.organizations.views.full.OrganizationFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * auto generated list view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class OrganizationListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected ScrollForm<OrganizationFilter, OrganizationSorting> scrollForm = new ScrollForm<>();
protected ScrollView<OrganizationBasicView> scrollView = new ScrollView<>();
protected OrganizationFullView selectedOrganization;

/*
 * getters and setters
 */
public ScrollView<OrganizationBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<OrganizationBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<OrganizationFilter, OrganizationSorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<OrganizationFilter, OrganizationSorting> scrollForm) {
this.scrollForm = scrollForm;
}

public OrganizationFullView getSelectedOrganization() {
return selectedOrganization;
}
public void setSelectedOrganization(OrganizationFullView selectedOrganization) {
this.selectedOrganization = selectedOrganization;
}

/* Specific Code Start */
/* Specific Code End */
}
