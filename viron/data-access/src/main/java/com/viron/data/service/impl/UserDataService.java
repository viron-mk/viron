package com.viron.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.viron.data.dao.impl.UserDAO;
import com.viron.data.entity.IEntity;
import com.viron.data.entity.User;
import com.viron.data.service.IUserDataService;

/**
 * Owner data access service
 * 
 * @author zoran.talevski
 * 
 */
public class UserDataService implements IUserDataService {

	/**
	 * Owner data access object
	 */
	public static UserDAO userDAO;

	public UserDataService() {
		userDAO = new UserDAO();
	}

	public void create(IEntity element) {

		userDAO.beginTransaction();
		userDAO.create((User) element);
		userDAO.commitTransaction();
	}

	public boolean update(IEntity element) {

		boolean updated = false;
		userDAO.beginTransaction();
		updated = userDAO.update((User) element);
		userDAO.commitTransaction();
		return updated;
	}

	public boolean delete(IEntity element) {

		boolean deleted = false;
		userDAO.beginTransaction();
		deleted = userDAO.delete((User) element);
		userDAO.commitTransaction();
		return deleted;
	}

	public void deleteAll() {

		userDAO.beginTransaction();
		userDAO.deleteAll();
		userDAO.commitTransaction();
	}

	public boolean contains(IEntity element) {
		return userDAO.contains((User) element);
	}


	public int count() {
		return userDAO.count();
	}

	public User findByPrimaryKey(Object primaryKey) {
		return userDAO.findByPrimaryKey((Integer) primaryKey);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {

		List<User> allUsers = userDAO.findAll();
		if (allUsers == null) {
			allUsers = new ArrayList<User>();
		}
		return allUsers;
	}

	public List<User> findAllLike(User user) {
		return userDAO.findAllLike(user);
	}

}
