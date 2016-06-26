package com.seri.common.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T> implements BaseDao<T>{
	
	protected EntityManager entityManager;
	
	private final Class<T> entityType;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.entityType = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	public T getByID(Long ID) {
		return entityManager.find(entityType, ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return entityManager.createQuery("Select entities from "+entityType.getName()+" entities").getResultList();
	}

	@Override
	public T save(T type) {
		entityManager.getTransaction().begin();
		entityManager.persist(type);
		entityManager.getTransaction().commit();
		return type;
	}

	@Override
	public T update(T type) {
		entityManager.getTransaction().begin();
		T newType = entityManager.merge(type);
		entityManager.getTransaction().commit();
		return newType;
	}

	@Override
	public void delete(T type) {
		entityManager.getTransaction().begin();
		T newType = entityManager.merge(type);
		entityManager.remove(newType);
		entityManager.getTransaction().commit();
	}

}
