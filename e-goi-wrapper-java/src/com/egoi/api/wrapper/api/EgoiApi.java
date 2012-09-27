package com.egoi.api.wrapper.api;

import java.util.Map;

import com.egoi.api.wrapper.domain.exceptions.EgoiException;

public interface EgoiApi {
	
	Map<String, String> getUserData(String apikey) throws EgoiException;
	
	Map<String, String> getUserData(String username, String password) throws EgoiException;

}