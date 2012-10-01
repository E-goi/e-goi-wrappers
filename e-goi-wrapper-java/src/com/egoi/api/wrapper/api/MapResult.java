package com.egoi.api.wrapper.api;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class MapResult extends HashMap<String,Object > implements IResult {
	
	public MapResult() {
	}
	
	public MapResult(Map<String, ? extends Object> map) {
		putAll(map);
	}

	@SuppressWarnings("unchecked")
	public MapResult(Object o) {
		if(o instanceof Map)
			putAll((Map<String, ?>)o);
	}
	
}
