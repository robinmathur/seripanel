package com.seri.web.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.seri.web.dao.ParentsDao;
import com.seri.web.dao.daoImpl.ParentsDaoImpl;
import com.seri.web.model.Parents;

/**
 * Created by puneet on 28/05/16.
 */
public class ParentsAttributesUsingLoginId extends SimpleTagSupport {

    private ParentsDao parentsDao = new ParentsDaoImpl();
    private String propName;
    private long loginId;

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public void doTag() throws IOException {
        Parents parents = parentsDao.getProfileUsingParentsId(loginId);
        JspWriter out = getJspContext().getOut();
        if(propName.equals("name"))
            out.println(parents.getfName()+" "+parents.getmName()+" "+parents.getlName());
        if(propName.equals("email"))
            out.println(parents.getEmail());
    }

}
