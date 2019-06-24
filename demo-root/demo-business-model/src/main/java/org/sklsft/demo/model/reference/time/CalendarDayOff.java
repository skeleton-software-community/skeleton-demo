package org.sklsft.demo.model.reference.time;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by skeleton-generator
 */

@Entity
@Table(name="CALENDAR_DAY_OFF"
, uniqueConstraints = {@UniqueConstraint(columnNames = {"CALENDAR_ID", "DAY_OFF_DATE"})})
public class CalendarDayOff implements org.sklsft.commons.model.interfaces.Entity<Integer> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public CalendarDayOff(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "generator", sequenceName = "CALENDAR_DAY_OFF_id_seq", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
private Integer id;

@ManyToOne(fetch = FetchType.LAZY)
@Fetch(FetchMode.JOIN)
@JoinColumn(name = "CALENDAR_ID", nullable = false)
private Calendar calendar;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "DAY_OFF_DATE", nullable = false)
private Date dayOffDate;

@Column(name = "DAY_OFF_LABEL")
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

public Calendar getCalendar() {
return this.calendar;
}

public void setCalendar(Calendar calendar) {
this.calendar = calendar;
}

public Date getDayOffDate() {
return this.dayOffDate;
}

public void setDayOffDate(Date dayOffDate) {
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