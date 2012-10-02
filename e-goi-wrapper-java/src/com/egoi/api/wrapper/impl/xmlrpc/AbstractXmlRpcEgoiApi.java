package com.egoi.api.wrapper.impl.xmlrpc;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiType;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.AbstractEgoiApi;

public abstract class AbstractXmlRpcEgoiApi extends AbstractEgoiApi {

	private XmlRpcClient xmlrpc = new XmlRpcClient();
	
	public AbstractXmlRpcEgoiApi(String serviceUrl) throws EgoiException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL(serviceUrl));
		} catch (MalformedURLException e) {
			throw new EgoiException(e.getMessage(), e);
		}
		xmlrpc.setConfig(config);
		// "Failed to parse server's response: Unknown type: nil" workaround
		xmlrpc.setTypeFactory(new NullWorkaroundTypeFactory(xmlrpc));
	}
	
	protected <T extends EgoiType> T processRequest(String method, EgoiMap arguments, Class<T> proto) throws EgoiException {
		try {
			Object o = xmlrpc.execute(method, new Object[] {arguments});
			return decodeResult(o, proto);
		} catch (XmlRpcException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}
	
}
