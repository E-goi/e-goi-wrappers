package com.egoi.api.wrapper.impl;

import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.egoi.api.soap.Egoi_ApiPort;
import com.egoi.api.soap.Egoi_ApiServiceLocator;
import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.domain.EgoiUserData;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;
import com.google.common.collect.Maps;

public class EgoiApiSoap implements EgoiApi {

	private Egoi_ApiPort api;
	
	public EgoiApiSoap() throws ServiceException {
		Egoi_ApiServiceLocator loc = new Egoi_ApiServiceLocator();
		api = loc.getEgoi_ApiPort();
	}
	
	@Override
	public EgoiUserData getUserData(String apikey) throws EgoiException {
		Map<String, String> map = Maps.newHashMap();
		map.put("apikey", apikey);
		try {
			Object o = api.getUserData(new Object[] {map});
			System.out.println(o);
		} catch (RemoteException e) {
			throw new EgoiException(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public EgoiUserData getUserData(String username, String password) throws EgoiException {
		return null;
	}

}
