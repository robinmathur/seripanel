package com.seri.web.utils.tags;

import com.seri.web.dao.RatingDao;
import com.seri.web.dao.SubjectDao;
import com.seri.web.dao.daoImpl.RatingDaoImpl;
import com.seri.web.dao.daoImpl.SubjectDaoImpl;
import com.seri.web.model.Rating;
import com.seri.web.model.Subject;
import com.seri.web.utils.GlobalFunUtils;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by puneet on 11/06/16.
 */
public class StudentRatingInformationTag extends SimpleTagSupport {
    private RatingDao ratingDao = new RatingDaoImpl();
    private String studentId;
    private String entityName;
    private String moduleId;
    private String entityId;

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void doTag() throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("studentId", studentId);
        params.put("entityId", entityId);
        params.put("entityName", entityName);
//        List<Rating> ratingList = ratingDao.getRatingRecUsingFilters(params, false);
        Rating rateing = new Rating();
        rateing.setRating(4);
        List<Rating> ratingList =Arrays.asList(rateing);
        String retHtml = "";
        if(ratingList.size()>0){
            Rating rating = ratingList.get(0);
            String comments = "";
            String msgClass = "alert-error";
            if(rating.getRating()==3)
                msgClass="alert-block";
            if(rating.getRating()==4)
                msgClass="alert-info";
            if(rating.getRating()==5)
                msgClass="alert-success";
            if(rating.getComments()!=null && !rating.getComments().equals("")){
                comments = "<p>Comments: "+rating.getComments()+"</p>";
            }
            retHtml+="<div class=\"alert "+msgClass+"\">\n" +
                    "<button class=\"close\" type=\"button\" data-dismiss=\"alert\">×</button>\n" +
                    "<h4>Teacher Rating: "+rating.getRating()+" out of "+rating.getMaxRating()+"</h4>\n" +comments+
                    "</div>";
        }
        JspWriter out = getJspContext().getOut();
        out.println(retHtml);
    }
}
