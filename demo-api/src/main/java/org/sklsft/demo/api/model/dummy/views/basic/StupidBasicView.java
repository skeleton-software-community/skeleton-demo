package org.sklsft.demo.api.model.dummy.views.basic;

import java.io.Serializable;

/**
 * auto generated view bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class StupidBasicView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private Long id;
private boolean selected;
private boolean canDelete;
private String code;
private String foolCode;

/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
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

public String getFoolCode() {
return this.foolCode;
}

public void setFoolCode(String foolCode) {
this.foolCode = foolCode;
}


/* Specific Code Start */
/* Specific Code End */
}
