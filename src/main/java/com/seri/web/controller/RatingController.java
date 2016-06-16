package com.seri.web.controller;

import com.seri.web.dao.RatingDao;
import com.seri.web.dao.SchoolDao;
import com.seri.web.dao.daoImpl.RatingDaoImpl;
import com.seri.web.dao.daoImpl.SchoolDaoImpl;
import com.seri.web.model.Rating;
import com.seri.web.model.School;
import com.seri.web.model.User;
import com.seri.web.utils.GlobalFunUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by puneet on 08/06/16.
 */
@Controller
@RequestMapping(value = "rating")
public class RatingController {
    private GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    private RatingDao ratingDao = new RatingDaoImpl();


    @RequestMapping(value = "/addrating/", method = RequestMethod.GET)
    public @ResponseBody
    String getTeacherListing(@ModelAttribute("rating") Rating rating, HttpServletRequest request) {
        User sessUser = globalFunUtils.getLoggedInUserDetail();
        Boolean errFlag = false;
        try {
            Map<String, Object> params = new HashMap<String, Object>();

            String dateTime = globalFunUtils.getDateTime();
            rating.setCreatedBy(sessUser.getLogin());
            rating.setCreatedDate(dateTime);
            rating.setLastUpdatedBy(sessUser.getLogin());
            rating.setLastUpdatedDate(dateTime);

            params.put("studentId", rating.getStudentId());
            params.put("entityId", rating.getEntityId());
            params.put("entityName", rating.getEntityName());

            List<Rating> ratingList = ratingDao.getRatingRecUsingFilters(params, false);
            if(ratingList.size()==0) {
                ratingDao.create(rating);
            } else {
                rating.setRatingId(ratingList.get(0).getRatingId());
                ratingDao.update(rating);
            }
        } catch (Exception e){
            errFlag = true;
        }

        return "true";
    }
}
