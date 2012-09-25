package com.egoi.api.wrapper.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.domain.EgoiDataHelper;
import com.egoi.api.wrapper.domain.EgoiUserData;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;
import com.google.common.collect.Maps;

@SuppressWarnings("unchecked")
public class EgoiApiXmlRpc implements EgoiApi {

	private static final String Endpoint = "http://api.e-goi.com/v2/xmlrpc.php";
	private XmlRpcClient xmlrpc = new XmlRpcClient();
	
	public EgoiApiXmlRpc() throws EgoiException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL(Endpoint));
		} catch (MalformedURLException e) {
			throw new EgoiException(e.getMessage(), e);
		}
		xmlrpc.setConfig(config);
		// "Failed to parse server's response: Unknown type: nil" workaround
		xmlrpc.setTypeFactory(new NullWorkaroundTypeFactory(xmlrpc));
	}
	
	@Override
	public EgoiUserData getUserData(String apikey) throws EgoiException {
		EgoiUserData userData = null;

		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		try {
			Object o = xmlrpc.execute("getUserData", new Object[] {map});
			if (o instanceof String) {
				String error = (String) o;
				EgoiErrorEncoder.throwError(error);
			} else if(o instanceof HashMap) {
				Map<String, String> values = (Map<String, String>) o;
				userData = EgoiDataHelper.mapToUserData(values);
			}
		} catch (XmlRpcException e) {
			throw new EgoiException(e.getMessage(), e);
		}
		
		return userData;
	}

	@Override
	public EgoiUserData getUserData(String username, String password) throws EgoiException {
		EgoiUserData userData = null;

		Map<String, String> map = Maps.newHashMap();
		map.put("username", username);
		map.put("password", password);
		try {
			Object o = xmlrpc.execute("getUserData", new Object[] {map});
			if (o instanceof String) {
				String error = (String) o;
				EgoiErrorEncoder.throwError(error);
			} else if(o instanceof HashMap) {
				Map<String, String> values = (Map<String, String>) o;
				userData = EgoiDataHelper.mapToUserData(values);
			}
		} catch (XmlRpcException e) {
			throw new EgoiException(e.getMessage(), e);
		}
		
		return userData;
	}

}
