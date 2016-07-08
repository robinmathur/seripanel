package com.seri.web.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.seri.web.dao.ParentsDao;
import com.seri.web.dao.daoImpl.ParentsDaoImpl;
import com.seri.web.model.Parents;

/**
 * Created by puneet on 13/04/16.
 */
public class UserNameUsingIdTag extends SimpleTagSupport {

    private String loginId;
    private ParentsDao parentsDao = new ParentsDaoImpl();

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        String name = "No User Found";
        if(loginId==null || loginId == "") {
        	Parents parents = parentsDao.getProfileUsingParentsId(Long.valueOf(loginId));
        	if(parents != null)
        		name = parents.getfName() +" "+ parents.getlName();
        } else {
        	out.println(name);
        }

    }
}
