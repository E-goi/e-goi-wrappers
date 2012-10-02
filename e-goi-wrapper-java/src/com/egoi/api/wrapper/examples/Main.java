package com.egoi.api.wrapper.examples;

import java.lang.reflect.Method;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.EgoiProtocol;

public class Main {

	static final String ApiAccessKey = "d7cdcc90c0547da5da90c3e14eeff180455c38a2";

	public static void main(String[] args) throws Exception {
//		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
//		
//		EgoiMap arg = new EgoiMap();
//		arg.put("apikey", ApiAccessKey);
//		
//		EgoiMapList lists = api.getLists(arg);
//		for(EgoiMap list : lists) {
//			// Fazer alguma coisa com a lista
//		}
//		
//		
		Method[] methods = EgoiApi.class.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println("\tpublic abstract function " + m.getName() + "($map) {\n\n}\n\n");
		}
	}

}
