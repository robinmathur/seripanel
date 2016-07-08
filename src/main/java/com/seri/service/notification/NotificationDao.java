package com.seri.service.notification;

import java.util.List;

import com.seri.common.dao.BaseDao;
import com.seri.web.model.User;

public interface NotificationDao extends BaseDao<Notification>{
	public List<Notification> getNotificationsForUser(User user);
}
