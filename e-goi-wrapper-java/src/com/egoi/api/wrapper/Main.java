package com.egoi.api.wrapper;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.domain.EgoiUserData;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.Protocol;



public class Main {
	
	private static final String ApiAccessKey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";
	
	public static void main(String[] args) throws EgoiException {
		EgoiApi api = EgoiApiFactory.getApi(Protocol.XmlRpc);
		EgoiUserData u = api.getUserData("lflobo@gmail.com", "a2d84f507d");
		System.out.println(u);
	}

}
