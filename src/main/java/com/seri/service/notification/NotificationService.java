package com.seri.service.notification;

import java.util.Date;
import java.util.List;

public interface NotificationService {

	void createNotification(NotificationType notificationType, long entityId, Date dueDate);

	void createNotification(NotificationType notificationType, long entityId, Date dueDate, long linkedEntity,
			Roles linkedEntityRole);

	void createNotification(NotificationType notificationType, long entityId, Date dueDate, long linkedEntity,
			Roles linkedEntityRole, long createdBy, Date createdDate);

	void cretateGroupNotification(NotificationType notificationType, Roles groupType, long standardId, long schoolId,
			Date dueDate, long linkedEntity, Roles linkedEntityRole);

	void cretateGroupNotification(NotificationType notificationType, Roles groupType, long standardId, long schoolId,
			Date dueDate, long linkedEntity, Roles linkedEntityRole, Date createdDate, long createdBy);
	
	public List<Notification> getNotificationForCurrentUser();
	public List<Notification> getNotificationForUser(long userID);

}