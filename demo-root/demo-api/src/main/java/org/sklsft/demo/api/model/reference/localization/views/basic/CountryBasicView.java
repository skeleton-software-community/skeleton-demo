package org.sklsft.demo.api.model.reference.localization.views.basic;

import java.io.Serializable;

/**
 * auto generated view bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class CountryBasicView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private Short id;
private boolean selected;
private boolean canDelete;
private String code;
private String label;

/*
 * getters and setters
 */
public Short getId() {
return this.id;
}

public void setId(Short id) {
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

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public String getLabel() {
return this.label;
}

public void setLabel(String label) {
this.label = label;
}


/* Specific Code Start */
/* Specific Code End */
}
