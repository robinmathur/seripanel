package com.seri.service.notification;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seri.web.utils.GlobalFunUtils;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDao notificationDao;
	
	private  Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class.getName());
	

	/* (non-Javadoc)
	 * @see com.seri.service.notification.NotificationService#createNotification(com.seri.service.notification.NotificationType, long, java.util.Date)
	 */
	@Override
	public  void createNotification(NotificationType notificationType, long entityId, Date dueDate) {
		createNotification(notificationType, entityId,dueDate, 0, null);
	}
	
	/* (non-Javadoc)
	 * @see com.seri.service.notification.NotificationService#createNotification(com.seri.service.notification.NotificationType, long, java.util.Date, long, com.seri.service.notification.Roles)
	 */
	@Override
	public  void createNotification(NotificationType notificationType, long entityId, Date dueDate, long linkedEntity, Roles linkedEntityRole) {
		long createdBy = GlobalFunUtils.getLoggedInUserId();
		Date createdDate = new Date();
		createNotification(notificationType, entityId,dueDate,linkedEntity, linkedEntityRole, createdBy, createdDate);
	}
	
	/* (non-Javadoc)
	 * @see com.seri.service.notification.NotificationService#createNotification(com.seri.service.notification.NotificationType, long, java.util.Date, long, com.seri.service.notification.Roles, long, java.util.Date)
	 */
	@Override
	public  void createNotification(NotificationType notificationType, long entityId, Date dueDate, long linkedEntity, Roles linkedEntityRole, long createdBy, Date createdDate) {
		logger.info("New notification of type {} is created for entity {} ",notificationType.getTitle(),entityId);
		Notification notification = new Notification();
		notification.setNotificationType(notificationType);
		notification.setLinkedEntity(linkedEntity);
		notification.setLinkedEntityRole(linkedEntityRole);
		notification.setCreatedDate(createdDate);
		notification.setCreatedBy(createdBy);
		notification.setDueDate(dueDate);
		EntityNotifications entityNotification = new EntityNotifications();
		entityNotification.setEntityId(entityId);
		entityNotification.setDueDate(dueDate);
		entityNotification.setNotification(notification);
		notification.setEntityNotifications(Arrays.asList(entityNotification));
		try{
		notificationDao.createEntityNotification(entityNotification);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.seri.service.notification.NotificationService#cretateGroupNotification(com.seri.service.notification.NotificationType, com.seri.service.notification.Roles, long, long, java.util.Date, long, com.seri.service.notification.Roles)
	 */
	@Override
	public  void cretateGroupNotification(NotificationType notificationType, Roles groupType,long standardId, long schoolId,Date dueDate, long linkedEntity,Roles linkedEntityRole){ 
		long createdBy = GlobalFunUtils.getLoggedInUserId();
		Date createdDate = new Date();
		cretateGroupNotification(notificationType, groupType, standardId, schoolId, dueDate, linkedEntity, linkedEntityRole, createdDate, createdBy);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.seri.service.notification.NotificationService#cretateGroupNotification(com.seri.service.notification.NotificationType, com.seri.service.notification.Roles, long, long, java.util.Date, long, com.seri.service.notification.Roles, java.util.Date, long)
	 */
	@Override
	public  void cretateGroupNotification(NotificationType notificationType, Roles groupType,long standardId, long schoolId,Date dueDate, long linkedEntity,Roles linkedEntityRole, Date createdDate, long createdBy){ 
		Notification notification = new Notification();
		notification.setNotificationType(notificationType);
		notification.setLinkedEntity(linkedEntity);
		notification.setLinkedEntityRole(linkedEntityRole);
		notification.setCreatedDate(createdDate);
		notification.setCreatedBy(createdBy);
		notification.setDueDate(dueDate);
		GroupNotifications groupNotification = new GroupNotifications();
		groupNotification.setNotification(notification);
		groupNotification.setGroupType(groupType);
		groupNotification.setSchoolId(schoolId);
		groupNotification.setStandardId(standardId);
		groupNotification.setDueDate(dueDate);
		notification.setGroupNotifications(Arrays.asList(groupNotification));
		
		try{
			notificationDao.createGroupNotification(groupNotification);
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}

	@Override
	public List<Notification> getNotificationForCurrentUser() {
		long currentUser = GlobalFunUtils.getLoggedInUserId();
		return getNotificationForUser(currentUser);
	}

	@Override
	public List<Notification> getNotificationForUser(long userID) {
		return notificationDao.getNotificationForUser(userID);
	}
		
	

}
