package com.egoi.api.wrapper.api;

import com.egoi.api.wrapper.api.exceptions.EgoiException;

public interface EgoiType {

	<T extends EgoiType> T as(Class<T> proto) throws EgoiException;

}
