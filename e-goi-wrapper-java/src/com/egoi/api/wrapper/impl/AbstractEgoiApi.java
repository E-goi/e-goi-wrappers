package com.egoi.api.wrapper.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.IResult;
import com.egoi.api.wrapper.api.MapResult;
import com.egoi.api.wrapper.api.MapResultList;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.google.common.collect.Lists;

public abstract class AbstractEgoiApi implements EgoiApi {

	private static final Logger log = LoggerFactory.getLogger(AbstractEgoiApi.class);

	@SuppressWarnings("unchecked")
	protected IResult walkMap(Map<String, ?> map) {
		IResult r = null;
		if(map.containsKey("key_0")) {
			MapResultList mrl = new MapResultList();
			List<String> keys = Lists.newArrayList(map.keySet());
			Collections.sort(keys);
			for(String k : keys) {
				if(!k.startsWith("key_"))
					continue;
				
				Map<String, ?> v = (Map<String, ?>) map.get(k);
				mrl.add(walkValues(new MapResult(v)));
			}
			r = mrl;
		} else {
			r = walkValues(new MapResult(map));
		}
			
		return r;
	}

	private IResult walkArray(List<Map<String, ?>> list) {
		MapResultList mrl = new MapResultList();
		for(Map<String, ?> map : list)
			mrl.add(walkValues(new MapResult(map)));
		return mrl;
	}

	@SuppressWarnings("unchecked")
	protected IResult walkValues(MapResult map) {
		for(String key : map.keySet()) {
			Object obj = map.get(key);
			if (obj instanceof Map) {
				Map<String, ?> sm = (Map<String, ?>) obj;
				map.put(key, walkMap(sm));
			}
			
			if(obj instanceof Object[]) {
				List<Map<String, ?>> mapList = extractMapList((Object[]) obj);
				map.put(key, walkArray(mapList));
			}
		}
		return map;
	}
	
	public IResult decodeResult(Object obj) throws EgoiException {
		if(obj==null)
			return null;

		if (obj instanceof String) {
			String error = (String) obj;
			throw decodeError(error);
		} else if (obj instanceof Map) {
			return walkValues(new MapResult(obj));
		} else if(obj instanceof Object[]) {
			List<Map<String, ?>> mapList = extractMapList((Object[]) obj);
			return walkArray(mapList);
		} else {
			throw new EgoiException("The request result is neither a Map nor a String: " + obj.getClass().getSimpleName() + "(" + obj.toString() + ")");
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<Map<String, ?>> extractMapList(Object[] arr) {
		List<Map<String, ?>> mapList = Lists.newArrayList();
		for(Object o : arr) {
			if (o instanceof Map) {
				Map<String, ?> m = (Map<String, ?>) o;
				mapList.add(m);
			}
		}
		return mapList;
	}

	protected EgoiException decodeError(String error) {
		if("NO_ACCESS".equals(error))
			return new EgoiException("Falta a chave da API ou faltam permissões de acesso à lista");
		
		if("NO_USERNAME_AND_PASSWORD".equals(error) || "NO_USERNAME_AND_PASSWORD_AND_APIKEY".equals(error))
			return new EgoiException("Falta o nome de utilizador e a palavra-passe");
		
		if("NO_USERNAME".equals(error))
			return new EgoiException("Falta o nome de utilizador");
		
		if("NO_PASSWORD".equals(error))
			return new EgoiException("Falta a palavra-passe");

		if("INVALID".equals(error))
			return new EgoiException("O nome de utilizador não é válido");

		if("INTERNAL_ERROR".equals(error))
			return new EgoiException("Ocorreu um problema no servidor");
		
		return new EgoiException("Erro Desconhecido");
	}
}
