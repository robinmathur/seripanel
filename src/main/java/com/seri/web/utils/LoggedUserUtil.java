package com.seri.web.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.seri.service.notification.RoleType;
import com.seri.web.model.User;

public class LoggedUserUtil {
	
	public static long getUserId(){
        return getUser().getId();
    }
	public static long getSchoolId(){
		return getUser().getSchool();
	}
	public static long getStandardId(){
		return getUser().getStandard();
	}
	public static String getEmailId(){
		return getUser().getEmail();
	}
	
	public static boolean hasRole(RoleType role){
		if(getUser().getRoleTypeList().contains(role))
			return true;
		return false;
	}
	public static boolean hasAnyRole(RoleType... roles){
		
		for(RoleType role : roles){
			if(hasRole(role))
				return true;
		}
		return false;
	}
	
	public static User getUser(){
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails;
	}

}
