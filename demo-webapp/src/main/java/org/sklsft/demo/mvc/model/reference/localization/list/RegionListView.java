package org.sklsft.demo.mvc.model.reference.localization.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.reference.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.reference.localization.sortings.RegionSorting;
import org.sklsft.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.reference.localization.views.full.RegionFullView;
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
public class RegionListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected ScrollForm<RegionFilter, RegionSorting> scrollForm = new ScrollForm<>();
protected ScrollView<RegionBasicView> scrollView = new ScrollView<>();
protected RegionFullView selectedRegion = new RegionFullView();

/*
 * getters and setters
 */
public ScrollView<RegionBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<RegionBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<RegionFilter, RegionSorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<RegionFilter, RegionSorting> scrollForm) {
this.scrollForm = scrollForm;
}

public RegionFullView getSelectedRegion() {
return selectedRegion;
}
public void setSelectedRegion(RegionFullView selectedRegion) {
this.selectedRegion = selectedRegion;
}

/* Specific Code Start */
/* Specific Code End */
}
