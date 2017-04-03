package com.egoi.api.wrapper.impl.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.api.EgoiType;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.AbstractEgoiApi;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class AbstractRestEgoiApi extends AbstractEgoiApi {

//	private static final Logger log = LoggerFactory.getLogger(AbstractRestEgoiApi.class);
	
	private String serviceUrl;
	
	private Gson gson = new Gson();
	
	public AbstractRestEgoiApi(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	protected String buildUrl(String method, EgoiMap values) throws EgoiException {
		StringBuilder url = new StringBuilder(serviceUrl);
		url.append("&method=").append(method);
		url.append("&").append(prepareMapUrl("functionOptions", values));
		return url.toString();
	}

	public static String prepareMapUrl(String prepend, EgoiMap values) throws EgoiException {
		StringBuilder q = new StringBuilder();
		for(String key : values.keySet()) {
			Object value = values.get(key);
			String result = null;
			
			String prefix = String.format("%s[%s]", prepend, key);
			
			if (value instanceof EgoiMap) {
				EgoiMap map = (EgoiMap) value;
				result = prepareMapUrl(prefix, map);
			} else if (value instanceof EgoiMapList) {
				EgoiMapList list = (EgoiMapList) value;
				result = prepareListUrl(prefix, list);
			} else {
                            try {
				result = String.format("%s=%s&", prefix, URLEncoder.encode(value.toString(), "UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                throw new EgoiException(e.getMessage(), e);
                            }
			}
			
			q.append(result);
		}
		return q.toString();
	}

	private static String prepareListUrl(String prepend, EgoiMapList list) throws EgoiException {
		StringBuilder q = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			String prefix = String.format("%s[%s]", prepend, i);
			EgoiMap value = list.get(i);
			q.append(prepareMapUrl(prefix, value));
		}
		return q.toString();
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
	protected Map<String, Object> processResult(String method, EgoiMap arguments) throws EgoiException {
		String url = buildUrl(method, arguments);
		String json = fetchResponse(url);

		/**
		 * Argh... Black Magic :D
		 * TODO: This method relies too much on the server's response being:
		 * {
		 * 	"Egoi_Api" : {
		 * 		"<method_name>" : {
		 * 			"key_0" : "value0",
		 * 			"key_1" : "value1",
		 * 			...
		 * 		}
		 * 	}
		 * }
		 * Will have trouble if the response changes
		 */
		Map<String, Map<String, Map<String, Object>>> m = gson.fromJson(json, Map.class);
		Map<String, Object> map = m.get("Egoi_Api").get(method);
		
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
	
	protected <T extends EgoiType> T decodeResult(String method, EgoiMap arguments, Class<T> proto) throws EgoiException {
		Map<String, Object> map = processResult(method, arguments);
		EgoiType r = walkMap(map);
               
		//return r != null ? r.as(proto) : null;
                
                try{
                    return r != null ? r.as(proto) : null;
                }catch(Exception ex){
                    throw new EgoiException(EgoiException.idToMessage(((EgoiMap)r).get("ERROR").toString())); 
                }
	}
	
}
