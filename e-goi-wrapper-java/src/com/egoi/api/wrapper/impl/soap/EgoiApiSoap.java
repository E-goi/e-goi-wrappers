package com.egoi.api.wrapper.impl.soap;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.egoi.api.soap.Egoi_Api_SoapPort;
import com.egoi.api.soap.Egoi_Api_SoapServiceLocator;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.AbstractEgoiApi;
import com.google.common.collect.Maps;

public class EgoiApiSoap extends AbstractEgoiApi {

	private Egoi_Api_SoapPort api;
	
	public EgoiApiSoap() throws ServiceException {
		Egoi_Api_SoapServiceLocator loc = new Egoi_Api_SoapServiceLocator();
		api = loc.getEgoi_Api_SoapPort();
	}
	
	@Override
	public Map<String, String> getUserData(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		try {
			return decodeMap(api.getUserData(map));
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public Map<String, String> getUserData(String username, String password) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("username", username);
		map.put("password", password);
		try {
			return decodeMap(api.getUserData(map));
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public Map<String, ?> getLists(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		try {
			return decodeMap(api.getLists(map));
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

}
