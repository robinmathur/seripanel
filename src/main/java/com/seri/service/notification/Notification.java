package com.seri.service.notification;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION")
public class Notification implements Serializable,Comparable<Notification> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="NOTI_TYPE")
	@Enumerated(EnumType.ORDINAL)
	private NotificationType notificationType;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	@Column(name="CREATED_BY")
	private long createdBy;
	@Column(name="LINKED_ENTITY")
	private long linkedEntity;
	@Column(name="LINKED_ENTITY_ROLE")
	@Enumerated(EnumType.STRING)
	private Roles linkedEntityRole;
	@Column(name="DUE_DATE")
	private Date dueDate;
	
	@OneToMany(mappedBy="notification")
	private List<GroupNotifications> groupNotifications;
	
	@OneToMany(mappedBy="notification")
	private List<EntityNotifications> entityNotifications;

	public long getId() {
		return id;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public long getLinkedEntity() {
		return linkedEntity;
	}

	public List<GroupNotifications> getGroupNotifications() {
		return groupNotifications;
	}

	public List<EntityNotifications> getEntityNotifications() {
		return entityNotifications;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public void setLinkedEntity(long linkedEntity) {
		this.linkedEntity = linkedEntity;
	}

	public void setGroupNotifications(List<GroupNotifications> groupNotifications) {
		this.groupNotifications = groupNotifications;
	}

	public void setEntityNotifications(List<EntityNotifications> entityNotifications) {
		this.entityNotifications = entityNotifications;
	}

	public Roles getLinkedEntityRole() {
		return linkedEntityRole;
	}

	public void setLinkedEntityRole(Roles linkedEntityRole) {
		this.linkedEntityRole = linkedEntityRole;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int compareTo(Notification o) {
		return this.createdDate.compareTo(o.createdDate);
	}
	
	
	

}
