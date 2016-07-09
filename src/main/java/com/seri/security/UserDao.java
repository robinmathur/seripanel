package com.seri.security;

import com.seri.common.dao.BaseDao;
import com.seri.web.model.User;

public interface UserDao extends BaseDao<User>{

	User loadUserByUsername(String username);

}