package com.seri.service.rating;

import org.springframework.stereotype.Repository;

import com.seri.common.dao.AbstractDao;

@Repository("ratingDao")
public class RatingDaoImpl extends AbstractDao<Rating> implements RatingDao{

}
