/**
 * 
 */
package com.viron.app.json;

/**
 * @author zoran.talevski
 * 
 */
public enum UserJSONFields {

	USERDTO_SURNAME("userSurname"), USERDTO_MIDDLE_NAME(
			"userMiddleName"), USERDTO_NAME("userName"), USERDTO_ID(
			"userId"), USERDTO_COUNTRY("userCountry"), USERDTO_CITY(
			"userCity"), USERDTO_ADDRESS("userAddress"), USERDTO_TYPE("userType"), USERDTO_GENDER(
			"gender");

	private final String name;

	private UserJSONFields(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
