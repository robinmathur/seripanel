package com.seri.service.notification;

import java.util.List;

public interface NotificationDao {
	
	public void createEntityNotification(EntityNotifications entityNotification); 
	public void createGroupNotification(GroupNotifications groupNotification); 
	public List<Notification> getNotificationForUser(long userID);
}
