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

import com.egoi.api.wrapper.api.IResult;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.AbstractEgoiApi;
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
				response.append(line).append("\n");

			conn.disconnect();

			return response.toString();
		} catch (MalformedURLException e) {
			throw new EgoiException(e.getMessage(), e);
		} catch (IOException e) {
			throw new EgoiException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected Map<String, ?> processResult(String method, Map<String, String> arguments) throws EgoiException {
		String url = buildUrl(method, arguments);
		String json = fetchResponse(url);

		/**
		 * Argh... Black Magic :D
		 * TODO: This method relies too much on the server's response being:
		 * {
		 * 	"Egoi_Api" : {
		 * 		"<method_name>" : {
		 * 			"key0" : "value0",
		 * 			"key1" : "value1",
		 * 			...
		 * 		}
		 * 	}
		 * }
		 * Will have trouble if the response changes
		 */
		Map<String, Map<String, Map<String, ?>>> m = gson.fromJson(json, Map.class);
		Map<String, ?> map = m.get("Egoi_Api").get(method);
		
		// Se o response existe e é uma String -> ERRO!
		if(map.containsKey("response")) {
			Object _response = map.get("response");
			if (_response instanceof String) {
				String response = (String) _response;
				throw decodeError(response);
			}
		}

		// Remover o response e o status
//		if(map.containsKey("status")) map.remove("status");
		
		return map;
	}
	
	protected IResult decodeResult(String method, Map<String, String> arguments) throws EgoiException {
		Map<String, ?> map = processResult(method, arguments);
		return walkMap(map);
	}
	
}
