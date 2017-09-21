package org.sklsft.demo.mvc.model.dummy.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.dummy.filters.FoolFilter;
import org.sklsft.demo.api.model.dummy.sortings.FoolSorting;
import org.sklsft.demo.api.model.dummy.views.basic.FoolBasicView;
import org.sklsft.demo.api.model.dummy.views.full.FoolFullView;
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
public class FoolListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected ScrollForm<FoolFilter, FoolSorting> scrollForm = new ScrollForm<>();
protected ScrollView<FoolBasicView> scrollView = new ScrollView<>();
protected FoolFullView selectedFool;

/*
 * getters and setters
 */
public ScrollView<FoolBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<FoolBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<FoolFilter, FoolSorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<FoolFilter, FoolSorting> scrollForm) {
this.scrollForm = scrollForm;
}

public FoolFullView getSelectedFool() {
return selectedFool;
}
public void setSelectedFool(FoolFullView selectedFool) {
this.selectedFool = selectedFool;
}

/* Specific Code Start */
/* Specific Code End */
}
