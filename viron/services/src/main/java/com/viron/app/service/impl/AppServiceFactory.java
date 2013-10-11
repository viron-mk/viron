package com.viron.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.viron.app.service.IUserService;

public class AppServiceFactory {

	public static final String OWNER_SERVICE = "ownerservice";

	private static Map<String, Object> services = new HashMap<String, Object>();

	public static IUserService getUserService() {

		if (!services.containsKey(OWNER_SERVICE)) {
			services.put(OWNER_SERVICE, new UserService());
		}
		return (IUserService) services.get(OWNER_SERVICE);
	}
}
