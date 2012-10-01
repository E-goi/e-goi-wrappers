package com.egoi.api.wrapper.impl.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egoi.api.wrapper.api.IResult;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.google.common.collect.Maps;

public class EgoiApiRestImpl extends AbstractRestEgoiApi {

	private static final String ServiceUrl = "http://api.e-goi.com/v2/rest.php?type=json";

	public EgoiApiRestImpl() {
		super(ServiceUrl);
	}

	private static final Logger log = LoggerFactory.getLogger(EgoiApiRestImpl.class);

	@Override
	public IResult addExtraField(String apikey, int listID, String name, String type) throws EgoiException {
		return null;
	}
	
	@Override
	public IResult getUserData(String apikey) throws EgoiException {
		Map<String, String> values = Maps.newHashMap();
		values.put("apikey", apikey);
		return decodeResult("getUserData", values);
	}

	@Override
	public IResult getUserData(String username, String password) throws EgoiException {
		Map<String, String> values = Maps.newHashMap();
		values.put("username", username);
		values.put("password", password);
		return decodeResult("getUserData", values);
	}

	@Override
	public IResult getLists(String apikey) throws EgoiException {
		Map<String, String> values = Maps.newHashMap();
		values.put("apikey", apikey);
		return decodeResult("getLists", values);
	}

}
