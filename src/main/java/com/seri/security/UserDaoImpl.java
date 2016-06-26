package com.seri.security;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.seri.common.dao.AbstractDao;
import com.seri.web.model.User;
import com.seri.web.utils.DbCon;
 
 
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao{
	
	public UserDaoImpl(){
		this.entityManager = DbCon.getEntityManager();
	}
 
    @Override
	public User loadUserByUsername(final String username) {
		//		List<User> us = query.getResultList();
		User user = null;
		try {
			Query query = entityManager.createQuery("select us from User us where us.username=:username");
			query.setParameter("username", username);
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return user;
    }
}