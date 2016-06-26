package com.seri.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seri.web.dao.RatingDao;
import com.seri.web.dao.daoImpl.RatingDaoImpl;
import com.seri.web.model.Rating;
import com.seri.web.utils.CalendarUtil;
import com.seri.web.utils.LoggedUserUtil;

/**
 * Created by puneet on 08/06/16.
 */
@Controller
@RequestMapping(value = "rating")
public class RatingController {
    private RatingDao ratingDao = new RatingDaoImpl();


    @RequestMapping(value = "/addrating/", method = RequestMethod.GET)
    public @ResponseBody
    String getTeacherListing(@ModelAttribute("rating") Rating rating, HttpServletRequest request) {
        Boolean errFlag = false;
        try {
            Map<String, Object> params = new HashMap<String, Object>();

            rating.setCreatedBy(LoggedUserUtil.getUserId());
            rating.setCreatedDate(CalendarUtil.getDate());
            rating.setLastUpdatedBy(LoggedUserUtil.getUserId());
            rating.setLastUpdatedDate(CalendarUtil.getDate());

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
