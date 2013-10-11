package com.viron.data.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.viron.data.dao.IBaseReadOnlyDAO;
import com.viron.data.dao.util.BusinessObjectManager;

/**
 * Provides basic read methods. TODO implement count and findAll.
 * 
 * @author zoran.talevski
 * 
 * @param <T>
 *            object type
 * @param <PK>
 *            object id type
 */
public abstract class BaseReadOnlyDAO<T, PK> implements IBaseReadOnlyDAO<T, PK> {

	protected Class<T> entityClass;

	public BaseReadOnlyDAO() {
		initEntityClass();
	}

	@SuppressWarnings("unchecked")
	private void initEntityClass() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	public boolean contains(T element) {
		return getEntityManager().contains(element);
	}

	public int count() {
		return 0;
	}

	public T findByPrimaryKey(PK primaryKey) {
		return (T) getEntityManager().find(entityClass, primaryKey);
	}

	public abstract List<T> findAll();

	@SuppressWarnings("unchecked")
	protected List<T> getResultList(Query query, boolean detach) {
		try {
			List<T> list = query.getResultList();

			if (detach) {
				for (T o : list) {
					detach(o);
				}
			}
			return list;
		} catch (NoResultException nre) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	protected T getSingleResult(Query query, boolean detach) {
		try {
			T object = (T) query.getSingleResult();
			if (object != null && detach) {
				detach(object);
			}
			return object;
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Clear session cached beans
	 * 
	 * @param object
	 * @return
	 */
	private T detach(T object) {
		getEntityManager().getEntityManagerFactory().getCache()
				.evict(object.getClass());
		return object;
	}

	/**
	 * Get the entity manager.
	 * 
	 * @return The entity manager in use.
	 */
	public EntityManager getEntityManager() {
		return BusinessObjectManager.getInstance().getEntityManager();
	}
}
