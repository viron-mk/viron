package com.viron.data.service;

import java.util.List;

import com.viron.data.entity.IEntity;

/**
 * @author zoran.talevski
 * 
 */
public interface IReadOnlyDataService {

	public boolean contains(IEntity element);

	public int count();

	public IEntity findByPrimaryKey(Object id);

	@SuppressWarnings("rawtypes")
	public List findAll();

}
