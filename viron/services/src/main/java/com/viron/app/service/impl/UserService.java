/**
 * 
 */
package com.viron.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.viron.app.dmt.UserDMT;
import com.viron.app.dto.UserDTO;
import com.viron.app.service.IUserService;
import com.viron.data.entity.IEntity;
import com.viron.data.entity.User;
import com.viron.data.service.IUserDataService;
import com.viron.data.service.impl.DataServiceFactory;

/**
 * Manipulate with user related data.
 * 
 * @author zoran.talevski
 * 
 */
public class UserService implements IUserService {

	private IUserDataService userDataService;

	public UserService() {
		userDataService = DataServiceFactory.getUserService();
	}

	public void create(UserDTO userDTO) {

		userDataService.create(UserDMT.populateUser(userDTO));
	}

	public void update(UserDTO userDTO) {

		userDataService.update(UserDMT.populateUser(userDTO));
	}

	public void deleteAllUsers() {
		userDataService.deleteAll();
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> findAllUsers() {

		List<UserDTO> userslist = new ArrayList<UserDTO>();
		List<User> users = userDataService.findAll();

		for (User user : users) {
			userslist.add(UserDMT.populateUserDTO(user));
		}
		return userslist;
	}

	public List<UserDTO> findAllUsersLike(UserDTO userDTO) {
		List<UserDTO> userslist = new ArrayList<UserDTO>();
		List<User> users = userDataService.findAllLike(UserDMT
				.populateUser(userDTO));

		for (User user : users) {
			userslist.add(UserDMT.populateUserDTO(user));
		}
		return userslist;
	}

	public UserDTO findByPrimaryKey(Object id) {

		return UserDMT.populateUserDTO((User) userDataService
				.findByPrimaryKey(id));
	}

	public void delete(String personalNumber) {
		IEntity user = userDataService.findByPrimaryKey(personalNumber);
		if (user != null) {
			userDataService.delete(user);
		}
	}

}
