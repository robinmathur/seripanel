package com.seri.service.notification;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GROUP_NOTIFICATIONS")
public class GroupNotifications {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="GROUP_TYPE")
	@Enumerated(EnumType.STRING)
	private Roles groupType;
	@Column(name="STANDARD_ID")
	private long standardId;
	@Column(name="SCHOOL_ID")
	private long schoolId;
	@JoinColumn(name="NOTI_ID")
	@ManyToOne(cascade=CascadeType.ALL)
	private Notification notification;
	@Column(name="DUE_DATE")
	private Date dueDate;
	
	public long getId() {
		return id;
	}
	public long getStandardId() {
		return standardId;
	}
	public long getSchoolId() {
		return schoolId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setStandardId(long standardId) {
		this.standardId = standardId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public Roles getGroupType() {
		return groupType;
	}
	public void setGroupType(Roles groupType) {
		this.groupType = groupType;
	}
	
	
}
