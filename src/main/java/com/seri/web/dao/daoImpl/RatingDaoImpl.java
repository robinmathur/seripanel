package com.seri.web.dao.daoImpl;

import com.seri.web.dao.RatingDao;
import com.seri.web.model.Rating;
import com.seri.web.model.Teacher;
import com.seri.web.utils.DbCon;
import com.seri.web.utils.GlobalFunUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by puneet on 08/06/16.
 */
public class RatingDaoImpl implements RatingDao {
    private GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    @Override
    public boolean create(Rating rating) {
        EntityManager em = DbCon.getEntityManager();
        globalFunUtils.inActiveAllTransaction(em);
        em.getTransaction().begin();
        em.persist(rating);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Rating rating) {
        EntityManager em = DbCon.getEntityManager();
        globalFunUtils.inActiveAllTransaction(em);
        em.getTransaction().begin();
        Rating rating1 = em.find(Rating.class, rating.getRatingId());

        rating1.setStudentId(rating.getStudentId());
        rating1.setRating(rating.getRating());
        rating1.setMaxRating(rating.getMaxRating());
        rating1.setSchoolId(rating.getSchoolId());
        rating1.setEntityId(rating.getEntityId());
        rating1.setComments(rating.getComments());
        rating1.setLastUpdatedBy(rating.getLastUpdatedBy());
        rating1.setLastUpdatedDate(rating.getLastUpdatedDate());

        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Rating> getRatingRecUsingFilters(Map<String, Object> params, boolean count) {
        EntityManager em = DbCon.getEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Rating> criteriaQuery = criteriaBuilder.createQuery(Rating.class);
        Teacher teacher;

        Root<Rating> ratingRoot = criteriaQuery.from(Rating.class);
        List<Predicate> predList = new LinkedList<Predicate>();
        Predicate p = null;
        if(params.containsKey("studentId") && params.get("studentId") != null) {
            p = criteriaBuilder.equal(ratingRoot.get("studentId"), params.get("studentId"));
            predList.add(p);
        }

        if(params.containsKey("entityId") && params.get("entityId") != null) {
            p = criteriaBuilder.equal(ratingRoot.get("entityId"), params.get("entityId"));
            predList.add(p);
        }

        if(params.containsKey("entityName") && params.get("entityName") != null) {
            p = criteriaBuilder.equal(ratingRoot.get("entityName"), params.get("entityName"));
            predList.add(p);
        }

        if(params.containsKey("rating") && params.get("rating") != null) {
            p = criteriaBuilder.equal(ratingRoot.get("rating"), params.get("rating"));
            predList.add(p);
        }

        if(params.containsKey("schoolId") && params.get("schoolId") != null) {
            p = criteriaBuilder.equal(ratingRoot.get("schoolId"), params.get("schoolId"));
            predList.add(p);
        }

        Predicate[] predArray = new Predicate[predList.size()];
        predList.toArray(predArray);

        criteriaQuery.where(predArray);

        CriteriaQuery<Rating> select = criteriaQuery.select(ratingRoot);
        TypedQuery<Rating> typedQuery = em.createQuery(select);

        if(!count && params.containsKey("rpp") && params.get("rpp") != null)
            typedQuery.setFirstResult((Integer) params.get("offset")).setMaxResults((Integer) params.get("rpp"));

        List<Rating> resultlist = typedQuery.getResultList();
        return resultlist;
    }
}
