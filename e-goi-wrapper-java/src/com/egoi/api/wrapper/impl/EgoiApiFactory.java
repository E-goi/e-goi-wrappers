package com.egoi.api.wrapper.impl;

import javax.xml.rpc.ServiceException;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.rest.EgoiApiRestImpl;
import com.egoi.api.wrapper.impl.soap.EgoiApiSoap;
import com.egoi.api.wrapper.impl.xmlrpc.EgoiApiXmlRpcImpl;

public abstract class EgoiApiFactory {

	public static enum EgoiProtocol {
		Soap, Rest, XmlRpc
	}

	private static EgoiApi soapImpl;
	
	private static EgoiApi xmlRpcImpl;
	
	private static EgoiApi restImpl;
	
	public static EgoiApi getApi(EgoiProtocol protocol) throws EgoiException {
		switch (protocol) {
			default: case Soap: return getSoapApi();
			case XmlRpc: return getXmlRpcApi();
			case Rest: return getRestApi();
		}
	}

	private static EgoiApi getRestApi() {
		if(restImpl == null)
			restImpl= new EgoiApiRestImpl();
		return restImpl;
	}

	private static EgoiApi getXmlRpcApi() throws EgoiException {
		if(xmlRpcImpl == null)
			try {
				xmlRpcImpl = new EgoiApiXmlRpcImpl();
			} catch (EgoiException e) {
				throw new EgoiException(e.getMessage(), e);
			}
		return xmlRpcImpl;
	}

	private static EgoiApi getSoapApi() throws EgoiException {
		if(soapImpl == null) {
			try {
				soapImpl = new EgoiApiSoap();
			} catch (ServiceException e) {
				throw new EgoiException(e.getMessage(), e);
			}
		}
		return soapImpl;
	}
	
	
}
