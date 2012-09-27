package com.egoi.api.wrapper.impl.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egoi.api.wrapper.domain.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.AbstractEgoiApi;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

public abstract class AbstractRestEgoiApi extends AbstractEgoiApi {

	private static final Logger log = LoggerFactory.getLogger(AbstractRestEgoiApi.class);
	
	private String serviceUrl;
	
	private Gson gson = new Gson();
	
	public AbstractRestEgoiApi(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	protected String buildUrl(String method, Map<String, String> values) {
		StringBuilder url = new StringBuilder(serviceUrl);
		url.append("&method=").append(method);
		for (String key : values.keySet())
			url.append("&functionOptions[").append(key).append("]=").append(values.get(key));
		return url.toString();
	}

	protected String fetchResponse(String requestUrl) throws EgoiException {
		try {

			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200)
				throw new EgoiException("Failed to Connect, HTTP_STATUS: " + conn.getResponseCode());

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			StringBuilder response = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null)
				response.append(line);

			conn.disconnect();

			return response.toString();
		} catch (MalformedURLException e) {
			throw new EgoiException(e.getMessage(), e);
		} catch (IOException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected Map<String, String> processRequest(String method, Map<String, String> values) throws EgoiException {
		String url = buildUrl(method, values);
		if (log.isDebugEnabled())
			log.debug("Trying url=" + url);
		String json = fetchResponse(url);
		Map<String, Object> root = (Map<String, Object>) gson.fromJson(json, Map.class);
		
		// Response is empty
		if(root.isEmpty())
			return Maps.newHashMap();
		
		// Fetch first value
		Object apiNameEntry = root.values().iterator().next();
		if(!(apiNameEntry instanceof Map))
			throw new EgoiException("Unexpected values: result map=" + root);
		
		// Method Map
		Map<String, Object> methodNameEntry = ((Map<String, Object>) apiNameEntry);
		if(methodNameEntry.isEmpty())
			return Maps.newHashMap();
		
		// Result
		Object result = methodNameEntry.get(method);
		if(!(result instanceof Map))
			throw new EgoiException("Unexpected values: result map=" + root);

		Map<String, String> map = (Map<String, String>) result;
		if(map.containsKey("response"))
			throw decodeError(map.get("response"));
		
		return map;
	}
}
