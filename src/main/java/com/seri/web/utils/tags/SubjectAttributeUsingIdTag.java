package com.seri.web.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.seri.web.dao.SubjectDao;
import com.seri.web.dao.daoImpl.SubjectDaoImpl;
import com.seri.web.model.Subject;

/**
 * Created by puneet on 05/06/16.
 */
public class SubjectAttributeUsingIdTag extends SimpleTagSupport {

    private SubjectDao subjectDao = new SubjectDaoImpl();
    private String propName;
    private String id;

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void doTag() throws IOException {
        Subject subject = subjectDao.getSubjectBySubjectId(Integer.parseInt(id));
        JspWriter out = getJspContext().getOut();
        if(propName.equals("name"))
            out.println(subject.getSubjectName());
    }
}
