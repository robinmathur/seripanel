package com.seri.service.rating;

import org.springframework.beans.factory.annotation.Autowired;

import com.seri.common.CommonTypes;
import com.seri.web.utils.CalendarUtil;
import com.seri.web.utils.LoggedUserUtil;

public class RatingServiceAdaptor{
	
	@Autowired
	private static RatingService ratingService;

	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf) {
		giveRating(rateType, entityId, rate, outOf,null);
	}

	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf, String comments) {
		giveRating(rateType, entityId, rate, outOf, 0, comments);
	}

	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf, long school) {
		giveRating(rateType, entityId, rate, outOf, school, 0);
	}
	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf, long school, String comments) {
		giveRating(rateType, entityId, rate, outOf, school, 0, comments);
	}
	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf, long school, long standard) {
		giveRating(rateType, entityId, rate, outOf, school, standard, null);
	}

	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf, long school, long standard, String comments) {
		giveRating(rateType, entityId, rate, outOf, school, standard, 0, comments);
	}

	public static void giveRating(CommonTypes rateType, long entityId,int rate, int outOf, long school, long standard, long module) {
		giveRating(rateType, entityId, rate, outOf, school, standard,module, null);
	}
	public static void giveRating(CommonTypes rateType, long entityId, int rate, int outOf, long school, long standard, long module,String comments) {
		Rating rating = new Rating();
		rating.setRatingType(rateType);
		rating.setRate(rate);
		rating.setOutof(outOf);
		rating.setSchoolId(school);
		rating.setStandardId(standard);
		rating.setModuleId(module);
		rating.setComment(comments);
		rating.setCreatedBy(LoggedUserUtil.getUserId());
		rating.setCreatedDate(CalendarUtil.getDate());
		rating.setEntityId(entityId);
		ratingService.create(rating);
	}

}
