package com.seri.service.notification;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.seri.web.utils.DbCon;

@Repository("notificationDao")
public class NotificationDaoImpl implements NotificationDao{
	
	@PersistenceContext
    private EntityManager manager;

	@Override
	public void createEntityNotification(EntityNotifications entityNotification) {
		manager.getTransaction().begin();
		manager.persist(entityNotification);
		manager.getTransaction().commit();
	}

	@Override
	public void createGroupNotification(GroupNotifications groupNotification) {
		manager = DbCon.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(groupNotification);
		manager.getTransaction().commit();
		
	}

	@Override
	public List<Notification> getNotificationForUser(long userID) {
		manager = DbCon.getEntityManager();
		Query query = manager.createQuery("select en.notification from EntityNotifications en where en.entityId=:userId",Notification.class);
		query.setParameter("userId", userID);
		List<Notification> notificationList = query.getResultList();
		return null;
	}

}
