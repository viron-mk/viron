/**
 * 
 */
package com.viron.app.dmt;

import org.json.JSONException;
import org.json.JSONObject;

import com.viron.app.dto.UserDTO;
import com.viron.app.json.UserJSONFields;
import com.viron.data.entity.User;

/**
 * Data Model Transformation for User related data
 * 
 * @author zoran.talevski
 * 
 */
public class UserDMT {

	public static UserDTO populateUserDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setAddress(user.getAddress());
		userDTO.setCity(user.getCity());
		userDTO.setCountry(user.getCountry());
		userDTO.setName(user.getName());
		userDTO.setMiddleName(user.getMiddleName());
		userDTO.setSurname(user.getSurname());
		userDTO.setType(user.getType());
		userDTO.setGender(user.getGender());

		return userDTO;
	}

	public static User populateUser(UserDTO userDTO) {
		
		User user = new User();
		user.setId(userDTO.getId());
		user.setAddress(userDTO.getAddress());
		user.setCity(userDTO.getCity());
		user.setCountry(userDTO.getCountry());
		user.setName(userDTO.getName());
		user.setMiddleName(userDTO.getMiddleName());
		user.setSurname(userDTO.getSurname());
		user.setType(userDTO.getType());
		user.setGender(userDTO.getGender());
		
		return user;
	}

	/**
	 * @return json representaion of UserDTO instance.
	 */
	public static JSONObject getJson(UserDTO userDTO) {
		
		JSONObject jsonUser = new JSONObject();
		
		try {
			jsonUser.put(UserJSONFields.USERDTO_ID.getName(),
					userDTO.getId());
			jsonUser.put(UserJSONFields.USERDTO_ADDRESS.getName(),
					userDTO.getAddress());
			jsonUser.put(UserJSONFields.USERDTO_CITY.getName(),
					userDTO.getCity());
			jsonUser.put(UserJSONFields.USERDTO_COUNTRY.getName(),
					userDTO.getCountry());
			jsonUser.put(UserJSONFields.USERDTO_NAME.getName(),
					userDTO.getName());
			jsonUser.put(UserJSONFields.USERDTO_MIDDLE_NAME.getName(),
					userDTO.getMiddleName());
			jsonUser.put(UserJSONFields.USERDTO_SURNAME.getName(),
					userDTO.getSurname());
			jsonUser.put(UserJSONFields.USERDTO_GENDER.getName(),
					userDTO.getGender());
			jsonUser.put(UserJSONFields.USERDTO_TYPE.getName(),
					userDTO.getType());
		} catch (JSONException jsone) {
			System.out.println(jsone.getMessage());
		}
		
		return jsonUser;
	}

}
