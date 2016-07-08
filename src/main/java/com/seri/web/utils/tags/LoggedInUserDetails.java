package com.seri.web.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.seri.web.utils.LoggedUserUtil;

/**
 * Created by puneet on 22/05/16.
 */
public class LoggedInUserDetails extends SimpleTagSupport {

    private String propName;

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if(propName.equals("name"))
            out.println(LoggedUserUtil.getUser().getfName()+" "+LoggedUserUtil.getUser().getmName()+" "+LoggedUserUtil.getUser().getlName());
        if(propName.equals("email"))
            out.println(LoggedUserUtil.getEmailId());
    }
}
