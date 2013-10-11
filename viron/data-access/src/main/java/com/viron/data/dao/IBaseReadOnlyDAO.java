package com.viron.data.dao;

import java.util.List;

/**
 * Provides basic read methods.
 * 
 * @author zoran.talevski
 */
public interface IBaseReadOnlyDAO<T, ID> {

	public boolean contains(T element);

	public int count();

	public T findByPrimaryKey(ID id);

	public List<T> findAll();
}
