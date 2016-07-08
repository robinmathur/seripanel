package com.seri.service.rating;

import java.util.List;
import java.util.Map;

import com.seri.common.dao.BaseDao;

public interface RatingDao extends BaseDao<Rating>{
	
	public int update(long id, int rate, long updateBy);
	public List<Rating> getRatingForEntity(long id);
	public List<Rating> getRatingWithFilter(Map<String, Object> filter);
	public int deleteRatingForEntity(long id);
	public int deleteRatingWithFilter(Map<String, Object> filter);
	
}
