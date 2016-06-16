package com.seri.web.dao;

import com.seri.web.model.Rating;
import com.seri.web.model.School;

import java.util.List;
import java.util.Map;

/**
 * Created by puneet on 08/06/16.
 */
public interface RatingDao {

    public boolean create(Rating rating);

    public boolean update(Rating rating);

    List<Rating> getRatingRecUsingFilters(Map<String, Object> params, boolean count);
}
