package com.seri.web.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.seri.web.dao.StandardDao;
import com.seri.web.dao.daoImpl.StandardDaoImpl;
import com.seri.web.model.Standard;
import com.seri.web.utils.GlobalFunUtils;

/**
 * Created by puneet on 05/06/16.
 */
public class StandardAttributeUsingIdTag extends SimpleTagSupport {

    private GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    private StandardDao standardDao = new StandardDaoImpl();
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
