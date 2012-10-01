package com.egoi.api.wrapper.api;


import com.egoi.api.wrapper.api.exceptions.EgoiException;

public interface EgoiApi {
	
	IResult addExtraField(String apikey, int listID, String name, String type) throws EgoiException;
	
	IResult getUserData(String apikey) throws EgoiException;
	
	IResult getUserData(String username, String password) throws EgoiException;

	IResult getLists(String apikey) throws EgoiException;
}