package com.egoi.api.wrapper.api;

import java.util.HashMap;
import java.util.Map;

import com.egoi.api.wrapper.api.exceptions.EgoiException;

@SuppressWarnings("serial")
public class EgoiMap extends HashMap<String,Object > implements EgoiType {
	
	public EgoiMap() {
	}
	
	public EgoiMap(Map<String, ? extends Object> map) {
		putAll(map);
	}

	@SuppressWarnings("unchecked")
	public EgoiMap(Object o) {
		if(o instanceof Map)
			putAll((Map<String, ?>)o);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EgoiType> T as(Class<T> proto) throws EgoiException {
		if(proto.equals(getClass()))
			return (T) this;
		throw new EgoiException("Cannot convert myself (" + getClass() +") into a '" + proto + "'");
	}
	
}
