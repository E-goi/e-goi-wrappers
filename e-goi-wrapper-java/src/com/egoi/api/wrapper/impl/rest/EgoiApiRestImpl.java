package com.egoi.api.wrapper.impl.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egoi.api.wrapper.domain.exceptions.EgoiException;
import com.google.common.collect.Maps;

public class EgoiApiRestImpl extends AbstractRestEgoiApi {

	private static final String ServiceUrl = "http://api.e-goi.com/v2/rest.php?type=json";

	public EgoiApiRestImpl() {
		super(ServiceUrl);
	}

	private static final Logger log = LoggerFactory.getLogger(EgoiApiRestImpl.class);

	@Override
	public Map<String, String> getUserData(String apikey) throws EgoiException {
		Map<String, String> values = Maps.newHashMap();
		values.put("apikey", apikey);
		return processRequest("getUserData", values);
	}

	@Override
	public Map<String, String> getUserData(String username, String password) throws EgoiException {
		Map<String, String> values = Maps.newHashMap();
		values.put("username", username);
		values.put("password", password);
		return processRequest("getUserData", values);
	}

}
