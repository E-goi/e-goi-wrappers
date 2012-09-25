package com.egoi.api.wrapper.impl;

import javax.xml.rpc.ServiceException;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;

public abstract class EgoiApiFactory {

	public static enum Protocol {
		Soap, Rest, XmlRpc
	}

	private static EgoiApi soapImpl;
	
	private static EgoiApi xmlRpcImpl;
	
	public static EgoiApi getApi(Protocol protocol) throws EgoiException {
		switch (protocol) {
			default: case Soap: return getSoapApi();
			case XmlRpc: return getXmlRpcApi();
		}
	}

	private static EgoiApi getXmlRpcApi() throws EgoiException {
		if(xmlRpcImpl == null)
			try {
				xmlRpcImpl = new EgoiApiXmlRpc();
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
