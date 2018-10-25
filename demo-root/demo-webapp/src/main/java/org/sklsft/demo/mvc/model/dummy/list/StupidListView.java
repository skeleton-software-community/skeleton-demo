package org.sklsft.demo.mvc.model.dummy.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.dummy.filters.StupidFilter;
import org.sklsft.demo.api.model.dummy.sortings.StupidSorting;
import org.sklsft.demo.api.model.dummy.views.basic.StupidBasicView;
import org.sklsft.demo.api.model.dummy.views.full.StupidFullView;
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
public class StupidListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected ScrollForm<StupidFilter, StupidSorting> scrollForm = new ScrollForm<>();
protected ScrollView<StupidBasicView> scrollView = new ScrollView<>();
protected StupidFullView selectedStupid = new StupidFullView();

/*
 * getters and setters
 */
public ScrollView<StupidBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<StupidBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<StupidFilter, StupidSorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<StupidFilter, StupidSorting> scrollForm) {
this.scrollForm = scrollForm;
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
