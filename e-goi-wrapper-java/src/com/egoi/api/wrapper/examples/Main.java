package com.egoi.api.wrapper.examples;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.IResult;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.EgoiProtocol;

public class Main {

	static final String ApiAccessKey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";

	public static void main(String[] args) throws Exception {
		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
		IResult lists = api.getLists(ApiAccessKey);
		System.out.println(lists);
	}

}
