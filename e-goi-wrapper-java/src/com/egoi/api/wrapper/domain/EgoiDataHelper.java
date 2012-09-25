package com.egoi.api.wrapper.domain;

import java.util.Map;

public class EgoiDataHelper {

	public static EgoiUserData mapToUserData(Map<String, String> values) {
		EgoiUserData userData = new EgoiUserData();
		userData.setApikey(values.get("APIKEY"));
		userData.setCellphone(values.get("CELLPHONE"));
		userData.setClienteId(values.get("CLIENTE_ID"));
		userData.setEmail(values.get("EMAIL"));
		userData.setFax(values.get("FAX"));
		userData.setFirstName(values.get("FIRST_NAME"));
		userData.setGender(values.get("GENDER"));
		userData.setId(values.get("USER_ID"));
		userData.setLanguage(values.get("LANGUAGE"));
		userData.setLastName(values.get("LAST_NAME"));
		userData.setTelephone(values.get("TELEPHONE"));
		userData.setUserLevel(values.get("USER_LEVEL"));
		userData.setUsername(values.get("USERNNAME"));
		return userData;
	}
	
}
