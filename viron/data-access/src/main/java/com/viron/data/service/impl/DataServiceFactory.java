package com.viron.data.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.viron.data.service.IUserDataService;

public class DataServiceFactory {

	public static final String USER_SERVICE = "userservice";

	private static Map<String, Object> services = new HashMap<String, Object>();

	public static IUserDataService getUserService() {

		if (!services.containsKey(USER_SERVICE)) {
			services.put(USER_SERVICE, new UserDataService());
		}
		return (IUserDataService) services.get(USER_SERVICE);
	}
}
