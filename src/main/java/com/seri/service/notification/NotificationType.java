package com.seri.service.notification;

public enum NotificationType {
	
	SYLLABUS("Syllabus"),
	HOME_WORK("Home Work"),
	CLASS_WORK("Class Work");
	
	private final String title;
	
	private NotificationType(final String title){
		this.title=title;
	}

	public String getTitle(){
		return this.title;
	}
}
