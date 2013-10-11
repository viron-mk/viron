package com.viron.data.service;

import com.viron.data.entity.IEntity;

/**
 * @author zoran.talevski
 * 
 */
public interface IDataService extends IReadOnlyDataService {

	public void create(IEntity element);

	public boolean update(IEntity element);

	public boolean delete(IEntity element);

	public void deleteAll();

}
