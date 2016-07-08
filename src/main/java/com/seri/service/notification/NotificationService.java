package com.seri.service.notification;

import java.util.List;

import com.seri.web.model.User;

public interface NotificationService {

	void createNotification(Notification notification);

	List<Notification> getNotificationForUser(User user);
	
	void deleteNotification(Notification notification);

}