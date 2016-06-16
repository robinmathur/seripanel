package com.seri.web.utils.tags;

import com.seri.web.dao.ParentsDao;
import com.seri.web.dao.StandardDao;
import com.seri.web.dao.daoImpl.ParentsDaoImpl;
import com.seri.web.dao.daoImpl.STandardDaoImpl;
import com.seri.web.model.Parents;
import com.seri.web.model.Standard;
import com.seri.web.model.Syllabus;
import com.seri.web.utils.GlobalFunUtils;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by puneet on 05/06/16.
 */
public class StandardAttributeUsingIdTag extends SimpleTagSupport {

    private GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    private StandardDao standardDao = new STandardDaoImpl();
    private String propName;
    private String id;

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void doTag() throws IOException {
        Standard standard = standardDao.getStandardById(Integer.parseInt(id));
        JspWriter out = getJspContext().getOut();
        if(propName.equals("name"))
            out.println(standard.getStandardName());
    }
}
