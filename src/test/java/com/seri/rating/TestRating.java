package com.seri.rating;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seri.common.CommonTypes;
import com.seri.service.rating.Rating;
import com.seri.service.rating.RatingService;
import com.seri.web.utils.CalendarUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRating {
	
	static Rating tempRate = null;
	
	Logger logger = LoggerFactory.getLogger(TestRating.class.getName());
	@Autowired
	RatingService ratingService;

	@Test
	public void testACreateRating(){
		Rating rate = new Rating();
		rate.setRatingType(CommonTypes.HOME_WORK);
		rate.setCreatedBy(7);
		rate.setLastUpdatedBy(7);
		rate.setRate(3);
		rate.setOutof(5);
		rate.setEntityId(7);
		rate.setCreatedDate(CalendarUtil.getDate());
		rate.setLastUpdatedDate(CalendarUtil.getDate());
		rate.setSchoolId(9);
		rate.setStandardId(4);
		rate.setComment("test Comment");
		Rating dbrateing = ratingService.create(rate);
		assertNotNull(dbrateing);
		logger.info("Rating id {}",dbrateing.getId());
		tempRate = dbrateing;
//		int recordDeleted  = ratingService.deleteRatingForEntity(dbrateing.getId());
//		assertEquals(1, recordDeleted);
	}
	
	
	@Test
	public void testBUpdateRating(){
		int record = ratingService.update(tempRate.getId(), 4, 7);
		assertEquals(1, record);
		tempRate = ratingService.getRatingForEntity(tempRate.getEntityId()).get(0);
		assertEquals(4, tempRate.getRate());
		
	}
	
	@Test
	public void testCDeleteRating(){
		int record = ratingService.deleteRatingForEntity(tempRate.getEntityId());
		assertEquals(1, record);
		logger.info("Delete Rating id {}", tempRate.getId());
	}
	
	
}
