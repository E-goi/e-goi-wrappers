package com.egoi.api.wrapper.impl.xmlrpc;

import java.util.Map;

import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.google.common.collect.Maps;

public class EgoiApiXmlRpcImpl extends AbstractXmlRpcEgoiApi {

	private static final String ServiceUrl = "http://api.e-goi.com/v2/xmlrpc.php";
	
	public EgoiApiXmlRpcImpl() throws EgoiException {
		super(ServiceUrl);
	}
	
	@Override
	public Map<String, String> getUserData(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		return processMapRequest("getUserData", map);
	}

	@Override
	public Map<String, String> getUserData(String username, String password) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("username", username);
		map.put("password", password);
		return processMapRequest("getUserData", map);
	}

	@Override
	public Map<String, String> getLists(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		return Maps.newHashMap();
		/*
		return processMapArrayRequest("getLists", map);
		*/
	}

}
