package com.egoi.api.wrapper.api;

import com.egoi.api.wrapper.domain.EgoiUserData;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;

public interface EgoiApi {
	
	EgoiUserData getUserData(String apikey) throws EgoiException;
	
	EgoiUserData getUserData(String username, String password) throws EgoiException;

}