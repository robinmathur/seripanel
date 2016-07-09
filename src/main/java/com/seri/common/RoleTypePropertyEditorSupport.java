package com.seri.common;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringUtils;

import com.seri.service.notification.RoleType;

public class RoleTypePropertyEditorSupport extends PropertyEditorSupport {
	
	@Override public void setAsText(final String text) throws IllegalArgumentException
    {
		if(StringUtils.isBlank(text))
			setValue(null);
		else
			setValue(RoleType.valueOf(text.trim()));
    }

}
