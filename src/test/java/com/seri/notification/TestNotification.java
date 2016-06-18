package com.seri.notification;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seri.service.notification.NotificationService;
import com.seri.service.notification.NotificationType;
import com.seri.web.utils.CalendarUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:spring-security.xml"})
public class TestNotification {
	
	@Autowired
	NotificationService notificationService;

	@Test
	@Ignore
	public void testGetUserNotification() {
		notificationService.getNotificationForUser(2232);
		fail("Not yet implemented");
	}
	@Test
	public void createEntityNotification(){
		notificationService.createNotification(NotificationType.CLASS_WORK, 7, CalendarUtil.addDays(32));
	}

}
