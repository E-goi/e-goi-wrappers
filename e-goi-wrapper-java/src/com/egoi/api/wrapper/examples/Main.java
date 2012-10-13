package com.egoi.api.wrapper.examples;

import java.lang.reflect.Method;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.EgoiProtocol;

public class Main {

	static final String ApiAccessKey = "<api key>";

	public static void main(String[] args) throws Exception {
		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
		
		EgoiMap arg = new EgoiMap();
		arg.put("apikey", ApiAccessKey);
		
		EgoiMapList lists = api.getLists(arg);
		for(EgoiMap list : lists) {
			// Fazer alguma coisa com a lista
			System.out.println(list);
		}
		
		
		Method[] methods = EgoiApi.class.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println("    def " + m.getName() + "(self, functionOptions):");
			System.out.println("        return self.client." + m.getName() + "(functionOptions)");
			System.out.println();
		}
	}

}
