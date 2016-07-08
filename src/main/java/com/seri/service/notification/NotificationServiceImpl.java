package com.seri.service.notification;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seri.web.model.User;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDao notificationDao;
	
	private  Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class.getName());

	@Override
	public void createNotification(Notification notification) {
		notificationDao.save(notification);
	}

	@Override
	public List<Notification> getNotificationForUser(User user) {
		List<Notification> notificationList= notificationDao.getNotificationsForUser(user);
		return notificationList;
	}

	@Override
	public void deleteNotification(Notification notification) {
		notificationDao.delete(notification);
	}
	
	
	

}
