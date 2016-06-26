package com.seri.service.notification;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.seri.common.dao.AbstractDao;
import com.seri.web.model.User;
import com.seri.web.utils.DbCon;

@Repository("notificationDao")
public class NotificationDaoImpl extends AbstractDao<Notification> implements NotificationDao{
	
	private Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class.getName());
	
	public NotificationDaoImpl() {
		this.entityManager=DbCon.getEntityManager();
	}


	@Override
	public List<Notification> getNotificationsForUser(User user) {
		
		//TODO
		return null;
	}

}
