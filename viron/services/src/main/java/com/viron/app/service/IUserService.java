package com.viron.app.service;

import java.util.List;

import com.viron.app.dto.UserDTO;

public interface IUserService {

	public void create(UserDTO userDTO);

	public void update(UserDTO userDTO);

	public UserDTO findByPrimaryKey(Object id);

	public List<UserDTO> findAllUsers();

	public List<UserDTO> findAllUsersLike(UserDTO user);
}
