package com.viron.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.viron.data.dao.IUserDAO;
import com.viron.data.entity.User;

/**
 * Entity specific operations.
 * 
 * @author zoran.talevski
 * 
 */
public class UserDAO extends BaseDAO<User, Integer> implements IUserDAO {

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Query query = getEntityManager().createNamedQuery("FIND_ALL_USERS");
		return (List<User>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllLike(User user) {
		Query query = getEntityManager().createNamedQuery("FIND_USERS_LIKE");
		query.setParameter("address", user.getAddress());
		query.setParameter("city", user.getCity());
		query.setParameter("country", user.getCountry());
		query.setParameter("gender", user.getGender());
		query.setParameter("id", user.getId());
		query.setParameter("middleName", user.getMiddleName());
		query.setParameter("name", user.getName());
		query.setParameter("type", user.getType());
		query.setParameter("surname", user.getSurname());
		query.setFirstResult(0);
		return (List<User>) query.getResultList();
	}

}
