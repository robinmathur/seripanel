package com.seri.service.notification;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ENTITY_NOTIFICATIONS")
public class EntityNotifications {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="ENTITY_ID")
	private long entityId;
	@JoinColumn(name="NOTI_ID")
	@ManyToOne(cascade=CascadeType.ALL)
	private Notification notification;
	@Column(name="DUE_DATE")
	private Date dueDate;
	public long getId() {
		return id;
	}
	public long getEntityId() {
		return entityId;
	}
	public Notification getNotification() {
		return notification;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
}
