package com.egoi.api.wrapper.api;

import java.util.Map;

import com.google.gson.internal.StringMap;

public interface IResult {
	
	public static final class Util {

		public static IResult parseResult(Map<String, ?> map) {
			IResult result = null;
			
			if(map.containsKey("key_0")) { // é um array de mapas
				MapResultList r = new MapResultList();
				for(String key : map.keySet()) {
					Object value = map.get(key);
					if (value instanceof StringMap) {
						Map<String, ?> smap = (Map<String, ?>) value;
						r.add(parseResult(smap));
					} // else ignore
				}
				result = r;
			} else { // é um mapa
				result = new MapResult(map);
				
				// Fix fields
				
			}
			
			return result;
		}
		

	}

}
