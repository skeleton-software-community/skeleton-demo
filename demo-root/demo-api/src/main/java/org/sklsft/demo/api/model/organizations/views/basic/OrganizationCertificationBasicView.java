package org.sklsft.demo.api.model.organizations.views.basic;

import java.io.Serializable;

/**
 * auto generated view bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class OrganizationCertificationBasicView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private String id;
private boolean selected;
private boolean canDelete;
private Boolean certified;

/*
 * getters and setters
 */
public String getId() {
return this.id;
}

public void setId(String id) {
this.id = id;
}

public boolean getSelected() {
return this.selected;
}

public void setSelected(boolean selected) {
this.selected = selected;
}

public boolean getCanDelete() {
return this.canDelete;
}

public void setCanDelete(boolean canDelete) {
this.canDelete = canDelete;
}

public Boolean getCertified() {
return this.certified;
}

public void setCertified(Boolean certified) {
this.certified = certified;
}


/* Specific Code Start */
/* Specific Code End */
}
