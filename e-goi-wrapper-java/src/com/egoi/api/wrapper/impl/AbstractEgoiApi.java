package com.egoi.api.wrapper.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.domain.exceptions.EgoiException;

public abstract class AbstractEgoiApi implements EgoiApi {

	private static final Logger log = LoggerFactory.getLogger(AbstractEgoiApi.class);
	
	@SuppressWarnings("unchecked")
	public Map<String, String> extractValueMapOrError(Object o) throws EgoiException {
		if(o==null)
			return null;
		
		if (o instanceof String) {
			String error = (String) o;
			throw decodeError(error);
		} else if(o instanceof HashMap) {
			return (Map<String, String>) o;
		} else {
			throw new EgoiException("The request result is neither a Map nor a String: " + o.getClass().getSimpleName() + "(" + o.toString() + ")");
		}
	}
	
	protected EgoiException decodeError(String error) {
		if("NO_ACCESS".equals(error))
			return new EgoiException("Falta a chave da API ou faltam permissões de acesso à lista");
		
		if("NO_USERNAME_AND_PASSWORD".equals(error) || "NO_USERNAME_AND_PASSWORD_AND_APIKEY".equals(error))
			return new EgoiException("Falta o nome de utilizador e a palavra-passe");
		
		if("NO_USERNAME".equals(error))
			return new EgoiException("Falta o nome de utilizador");
		
		if("NO_PASSWORD".equals(error))
			return new EgoiException("Falta a palavra-passe");

		if("INVALID".equals(error))
			return new EgoiException("O nome de utilizador não é válido");

		if("INTERNAL_ERROR".equals(error))
			return new EgoiException("Ocorreu um problema no servidor");
		
		return new EgoiException("Erro Desconhecido");
	}
}
