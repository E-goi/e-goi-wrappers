package com.egoi.api.wrapper.impl.soap;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.egoi.api.soap.any.Egoi_Api_SoapPort;
import com.egoi.api.soap.any.Egoi_Api_SoapServiceLocator;
import com.egoi.api.wrapper.api.IResult;
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
	public IResult addExtraField(String apikey, int listID, String name, String type) throws EgoiException {
		return null;
	}
	
	@Override
	public IResult getUserData(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		try {
			return decodeResult(api.getUserData(map));
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public IResult getUserData(String username, String password) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("username", username);
		map.put("password", password);
		try {
			return decodeResult(api.getUserData(map));
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

	@Override
	public IResult getLists(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		try {
			return decodeResult(api.getLists(map));
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}

}
