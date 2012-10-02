package com.egoi.api.wrapper.examples;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.EgoiProtocol;

public class Main {

	static final String ApiAccessKey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";

	public static void main(String[] args) throws Exception {
		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
		
		EgoiMap subscriber1 = new EgoiMap();
		subscriber1.put("apikey", ApiAccessKey);
		subscriber1.put("listID", 1);
		subscriber1.put("email", "ppinto@e-goi.com");
		subscriber1.put("first_name", "Inspetor");
		subscriber1.put("last_name", "Milimétrico");
		
		EgoiMap subscriber2 = new EgoiMap();
		subscriber2.put("apikey", ApiAccessKey);
		subscriber2.put("listID", 1);
		subscriber2.put("email", "seg7@ipb.pt");
		subscriber2.put("first_name", "Seg");
		subscriber2.put("last_name", "7");
		
		EgoiMap arguments = new EgoiMap();
		arguments.put("apikey", ApiAccessKey);
		arguments.put("listID", 2);
		arguments.put("compareField", "email");
		arguments.put("defaultCountryCode", "pt");
		arguments.put("subscribers", new EgoiMapList(subscriber1, subscriber2));

//		EgoiMap out = api.addSubscriberBulk(arguments);
		
		EgoiMap arg = new EgoiMap();
		arg.put("apikey", ApiAccessKey);
		arg.put("listID", 2);
		arg.put("subscriber", "all_subscribers");
		
		EgoiMap out = api.subscriberData(arg);
		System.out.println(out);
	}

}
