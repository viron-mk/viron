package com.viron.data.dao.impl;

import com.viron.data.dao.IBaseDAO;

/**
 * Provides basic CRUD operations. TODO implement deleteAll.
 * 
 * @author zoran.talevski
 * 
 * @param <T>
 * @param <PK>
 */
public abstract class BaseDAO<T, PK> extends BaseReadOnlyDAO<T, PK> implements
		IBaseDAO<T, PK> {

	public BaseDAO() {
		super();
	}

	public void create(T element) {
		getEntityManager().persist(element);
	}

	public boolean update(T element) {
		getEntityManager().merge(element);
		return true;
	}

	public boolean delete(T element) {
		getEntityManager().remove(element);
		return true;
	}

	public void deleteAll() {
		// TODO implement generic delete all method
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}

}
