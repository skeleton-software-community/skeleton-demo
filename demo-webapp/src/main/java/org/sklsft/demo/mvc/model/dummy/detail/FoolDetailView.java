package org.sklsft.demo.mvc.model.dummy.detail;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.commons.mvc.scopes.ViewScope;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
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
public class FoolDetailView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private FoolFullView selectedFool = new FoolFullView();

protected ScrollForm<StupidFilter, StupidSorting> stupidScrollForm = new ScrollForm<>();
protected ScrollView<StupidBasicView> stupidScrollView = new ScrollView<>();
private StupidFullView selectedStupid = new StupidFullView();

/*
 * getters and setters
 */
public FoolFullView getSelectedFool() {
return selectedFool;
}
public void setSelectedFool(FoolFullView selectedFool) {
this.selectedFool = selectedFool;
}

public ScrollView<StupidBasicView> getStupidScrollView() {
return stupidScrollView;
}
public void setStupidScrollView(ScrollView<StupidBasicView> stupidScrollView) {
this.stupidScrollView = stupidScrollView;
}

public ScrollForm<StupidFilter, StupidSorting> getStupidScrollForm() {
return stupidScrollForm;
}
public void setStupidScrollForm(ScrollForm<StupidFilter, StupidSorting> stupidScrollForm) {
this.stupidScrollForm = stupidScrollForm;
}

public StupidFullView getSelectedStupid() {
return selectedStupid;
}
public void setSelectedStupid(StupidFullView selectedStupid) {
this.selectedStupid = selectedStupid;
}

/* Specific Code Start */
/* Specific Code End */
}
