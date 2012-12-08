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
//		EgoiApi api = EgoiApiFactory.getApi(EgoiProtocol.Soap);
//		
//		EgoiMap arg = new EgoiMap();
//		arg.put("apikey", ApiAccessKey);
//		
//		EgoiMapList lists = api.getLists(arg);
//		for(EgoiMap list : lists) {
//			// Fazer alguma coisa com a lista
//			System.out.println(list);
//		}
		
		
		// virtual EgoiMapList getLists(EgoiMap & functionOptions) const = 0;
		// EgoiMap EgoiApiXmlRpcImpl::invokeMap(const std::string & fname, EgoiMap &funcionOptions) const {
		Method[] methods = EgoiApi.class.getDeclaredMethods();
		for(Method m : methods) {
			
			String ret = m.getReturnType().equals(EgoiMap.class) ? "Map" : "MapList";
			String fname = m.getName();
			
			StringBuilder s = new StringBuilder();
			s.append("[XmlRpcMethod(\"").append(fname).append("\")]\n");
			s.append("object ").append(fname).append("(XmlRpcStruct o);\n");

			System.out.println(s);
		}
	}

}
