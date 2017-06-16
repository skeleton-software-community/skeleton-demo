package org.sklsft.demo.mvc.model.localization.list;

import java.io.Serializable;
import java.util.List;
import org.sklsft.demo.api.model.localization.filters.RegionFilter;
import org.sklsft.demo.api.model.localization.views.basic.RegionBasicView;
import org.sklsft.demo.api.model.localization.views.full.RegionFullView;
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
protected List<RegionBasicView> regionList;
protected RegionFilter regionFilter = new RegionFilter();
protected RegionFullView selectedRegion;

/*
 * getters and setters
 */
public List<RegionBasicView> getRegionList() {
return regionList;
}
public void setRegionList(List<RegionBasicView> regionList) {
this.regionList = regionList;
}

public RegionFilter getRegionFilter() {
return regionFilter;
}
public void setRegionFilter(RegionFilter regionFilter) {
this.regionFilter = regionFilter;
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
