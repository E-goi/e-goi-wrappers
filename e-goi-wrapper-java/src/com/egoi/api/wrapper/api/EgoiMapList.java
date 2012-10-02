package com.egoi.api.wrapper.api;

import java.util.ArrayList;

import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.google.common.collect.Lists;

@SuppressWarnings("serial")
public class EgoiMapList extends ArrayList<EgoiMap> implements EgoiType {

	public EgoiMapList() {
	}

	public EgoiMapList(EgoiMap... subscribers) {
		addAll(Lists.newArrayList(subscribers));
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends EgoiType> T as(Class<T> proto) throws EgoiException {
		if(proto.equals(getClass()))
			return (T) this;
		throw new EgoiException("Cannot convert myself (" + getClass() +") into a '" + proto + "'");
	}

}
