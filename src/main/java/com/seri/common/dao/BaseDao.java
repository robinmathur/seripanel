package com.seri.common.dao;

import java.util.List;

public interface BaseDao<T> {
	
	T getByID(Long ID);
	List<T> getAll(); 
    T save(T type);
    T update(T type);
    void delete(T type); 

}
