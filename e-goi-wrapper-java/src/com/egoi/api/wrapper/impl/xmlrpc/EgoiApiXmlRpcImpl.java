package com.egoi.api.wrapper.impl.xmlrpc;

import java.util.Map;

import com.egoi.api.wrapper.api.IResult;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.google.common.collect.Maps;

public class EgoiApiXmlRpcImpl extends AbstractXmlRpcEgoiApi {

	private static final String ServiceUrl = "http://api.e-goi.com/v2/xmlrpc.php";
	
	public EgoiApiXmlRpcImpl() throws EgoiException {
		super(ServiceUrl);
	}
	
	@Override
	public IResult addExtraField(String apikey, int listID, String name, String type) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		map.put("listID", Integer.toString(listID));
		map.put("name", name);
		map.put("type", type);
		return processRequest("addExtraField", map);
	}
	
	@Override
	public IResult getUserData(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		return processRequest("getUserData", map);
	}

	@Override
	public IResult getUserData(String username, String password) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("username", username);
		map.put("password", password);
		return processRequest("getUserData", map);
	}

	@Override
	public IResult getLists(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		return processRequest("getLists", map);
	}

}
