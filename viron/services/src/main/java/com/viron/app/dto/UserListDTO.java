/**
 * 
 */
package com.viron.app.dto;

import java.util.List;

/**
 * @author zoran.talevski
 * 
 */
public class UserListDTO {

	private List<UserDTO> userDTOs;

	/**
	 * @return the userDTOs
	 */
	public List<UserDTO> getUserDTOs() {
		return userDTOs;
	}

	/**
	 * @param userDTOs
	 *            the userDTOs to set
	 */
	public void setUserDTOs(List<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}

}
