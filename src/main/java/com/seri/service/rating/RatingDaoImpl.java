package com.seri.service.rating;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.seri.common.dao.AbstractDao;
import com.seri.web.utils.CalendarUtil;
import com.seri.web.utils.DbCon;

@Repository("ratingDao")
public class RatingDaoImpl extends AbstractDao<Rating> implements RatingDao {

	private Logger logger = LoggerFactory.getLogger(RatingDaoImpl.class.getName());

	public RatingDaoImpl() {
		this.entityManager = DbCon.getEntityManager();
	}
	
	@Override
	public int update(long id, int rate, long updateBy) {
		entityManager.getTransaction().begin();
		Rating rating = entityManager.find(Rating.class, id);
		if(null != rating){
			rating.setRate(rate);
			rating.setLastUpdatedBy(updateBy);
			rating.setLastUpdatedDate(CalendarUtil.getDate());
		}
		entityManager.getTransaction().commit();
		return 1;
	}

	/*@Override
	public int update(long id, int rate, long updateBy) {
		entityManager.getTransaction().begin();
		Query updateQuery = entityManager.createQuery("update Rating set rate=:rate,lastUpdatedBy=:updateBy,lastUpdatedDate=:updatedDate where createdBy=:updateBy");
		updateQuery.setParameter("rate", rate);
		updateQuery.setParameter("updateBy", updateBy);
		updateQuery.setParameter("updatedDate", CalendarUtil.getDate());
		int records = updateQuery.executeUpdate();
		entityManager.getTransaction().commit();
		return records;
	}*/

	@Override
	public List<Rating> getRatingForEntity(long id) {
		Query query = entityManager.createQuery("select r from Rating r where r.entityId=:entityId");
		query.setParameter("entityId", id);
		List<Rating> ratingList = query.getResultList();
		return ratingList;
	}

	@Override
	public List<Rating> getRatingWithFilter(Map<String, Object> filter) {
		StringBuilder stringBuilder = new StringBuilder("select r from Rating r");
		stringBuilder.append("where r.entityId=").append(filter.get("entityId"));
		filter.remove("entityId");
		for(Map.Entry<String, Object> entry : filter.entrySet()){
			stringBuilder.append(" and r.").append(entry.getKey()+"="+entry.getValue());
		}
		Query query = entityManager.createQuery(stringBuilder.toString());
		List<Rating> ratingList = query.getResultList();
		return ratingList;
	}

	@Override
	public int deleteRatingForEntity(long id) {
		entityManager.getTransaction().begin();
		/*Rating rating = entityManager.find(Rating.class, id);
		entityManager.remove(rating);*/
		Query updateQuery = entityManager.createQuery("delete from Rating r where r.entityId=:entityId");
		updateQuery.setParameter("entityId", id);
		int records = updateQuery.executeUpdate();
		entityManager.getTransaction().commit();
		return records;
	}

	@Override
	public int deleteRatingWithFilter(Map<String, Object> filter) {
		StringBuilder stringBuilder = new StringBuilder("delete from Rating r");
		stringBuilder.append("where r.entityId=").append(filter.get("entityId"));
		filter.remove("entityId");
		for(Map.Entry<String, Object> entry : filter.entrySet()){
			stringBuilder.append(" and r.").append(entry.getKey()+"="+entry.getValue());
		}
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery(stringBuilder.toString());
		int records = query.executeUpdate();
		entityManager.getTransaction().commit();
		return records;
	}


}
