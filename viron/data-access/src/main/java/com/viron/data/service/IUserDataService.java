package com.viron.data.service;

import java.util.List;

import com.viron.data.entity.User;

public interface IUserDataService extends IDataService {

	public List<User> findAllLike(User user);

}
