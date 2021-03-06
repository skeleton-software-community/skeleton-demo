package org.sklsft.demo.mvc.model.dummy.detail;

import java.io.Serializable;

import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class StupidDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private StupidFullView selectedStupid = new StupidFullView();

/*
 * getters and setters
 */
public StupidFullView getSelectedStupid() {
return selectedStupid;
}
public void setSelectedStupid(StupidFullView selectedStupid) {
this.selectedStupid = selectedStupid;
}

/* Specific Code Start */
/* Specific Code End */
}
