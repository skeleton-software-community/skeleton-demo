package org.sklsft.demo.api.model.reference.time.views.basic;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * auto generated view bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
public class CalendarDayOffBasicView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private Integer id;
private boolean selected;
private boolean canDelete;
private LocalDate dayOffDate;
private String dayOffLabel;

/*
 * getters and setters
 */
public Integer getId() {
return this.id;
}

public void setId(Integer id) {
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

public LocalDate getDayOffDate() {
return this.dayOffDate;
}

public void setDayOffDate(LocalDate dayOffDate) {
this.dayOffDate = dayOffDate;
}

public String getDayOffLabel() {
return this.dayOffLabel;
}

public void setDayOffLabel(String dayOffLabel) {
this.dayOffLabel = dayOffLabel;
}


/* Specific Code Start */
/* Specific Code End */
}
