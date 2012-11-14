package com.egoi.api.wrapper.examples;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.impl.EgoiApiFactory;
import com.egoi.api.wrapper.impl.EgoiApiFactory.EgoiProtocol;

public class Main {

	static final String ApiAccessKey = "<api key>";

	public static void main(String[] args) throws Exception {
		// Obter a implementação desejada (@see EgoiProtocol)
		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
		
		// Criar a lista de argumentos
		EgoiMap params = new EgoiMap();
		params.put("apikey", ApiAccessKey);
		
		EgoiMapList lists = api.getLists(params);
		for(EgoiMap list : lists) {
			// Fazer alguma coisa com a lista
			System.out.println(list);
		}
	}

}
