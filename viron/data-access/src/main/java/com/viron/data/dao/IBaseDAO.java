package com.viron.data.dao;


/**
 * Provides basic read methods.
 * 
 * @author zoran.talevski
 */
public interface IBaseDAO<T, ID> extends IBaseReadOnlyDAO<T, ID> {

	public void create(T element);

	public boolean update(T element);

	public boolean delete(T element);

	public void deleteAll();

}
