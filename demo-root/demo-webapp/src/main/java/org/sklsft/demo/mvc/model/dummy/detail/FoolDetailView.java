package org.sklsft.demo.mvc.model.dummy.detail;

import java.io.Serializable;

import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * auto generated detail view class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */
@Component
@Scope(ViewScope.NAME)
public class FoolDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private FoolFullView selectedFool = new FoolFullView();

/*
 * getters and setters
 */
public FoolFullView getSelectedFool() {
return selectedFool;
}
public void setSelectedFool(FoolFullView selectedFool) {
this.selectedFool = selectedFool;
}

/* Specific Code Start */
/* Specific Code End */
}
