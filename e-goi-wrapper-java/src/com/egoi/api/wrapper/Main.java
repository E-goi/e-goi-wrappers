package com.egoi.api.wrapper;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.IResult;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.EgoiProtocol;
public class Main {

	static final String ApiAccessKey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";
	
	public static void main(String[] args) throws Exception {
		new Main();
	}
	
	public Main() throws EgoiException {
		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
		IResult lists = api.getLists(ApiAccessKey);
		System.out.println(lists);

		EgoiApi api1 = EgoiApiFactory.getApi(EgoiProtocol.Rest);
		IResult lists1 = api1.getLists(ApiAccessKey);
		System.out.println(lists1);

		EgoiApi api11 = EgoiApiFactory.getApi(EgoiProtocol.XmlRpc);
		IResult lists11 = api11.getUserData(ApiAccessKey);
		System.out.println(lists11);
	}

	

}
