package org.sklsft.demo.mvc.model.time.list;

import java.io.Serializable;

import org.sklsft.commons.api.model.ScrollForm;
import org.sklsft.commons.api.model.ScrollView;
import org.sklsft.demo.api.model.time.filters.CalendarFilter;
import org.sklsft.demo.api.model.time.sortings.CalendarSorting;
import org.sklsft.demo.api.model.time.views.basic.CalendarBasicView;
import org.sklsft.demo.api.model.time.views.full.CalendarFullView;
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
public class CalendarListView implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
protected ScrollForm<CalendarFilter, CalendarSorting> scrollForm = new ScrollForm<>();
protected ScrollView<CalendarBasicView> scrollView = new ScrollView<>();
protected CalendarFullView selectedCalendar;

/*
 * getters and setters
 */
public ScrollView<CalendarBasicView> getScrollView() {
return scrollView;
}
public void setScrollView(ScrollView<CalendarBasicView> scrollView) {
this.scrollView = scrollView;
}

public ScrollForm<CalendarFilter, CalendarSorting> getScrollForm() {
return scrollForm;
}
public void setScrollForm(ScrollForm<CalendarFilter, CalendarSorting> scrollForm) {
this.scrollForm = scrollForm;
}

public CalendarFullView getSelectedCalendar() {
return selectedCalendar;
}
public void setSelectedCalendar(CalendarFullView selectedCalendar) {
this.selectedCalendar = selectedCalendar;
}

/* Specific Code Start */
/* Specific Code End */
}
