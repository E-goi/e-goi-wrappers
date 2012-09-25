package com.egoi.api.wrapper.impl;

import com.egoi.api.wrapper.domain.exceptions.EgoiException;

public class EgoiErrorEncoder {

	public static void throwError(String error) throws EgoiException {
		if("NO_ACCESS".equals(error))
			throw new EgoiException("Falta a chave da API ou faltam permissões de acesso à lista");
		
		if("NO_USERNAME_AND_PASSWORD".equals(error) || "NO_USERNAME_AND_PASSWORD_AND_APIKEY".equals(error))
			throw new EgoiException("Falta o nome de utilizador e a palavra-passe");
		
		if("NO_USERNAME".equals(error))
			throw new EgoiException("Falta o nome de utilizador");
		
		if("NO_PASSWORD".equals(error))
			throw new EgoiException("Falta a palavra-passe");

		if("INVALID".equals(error))
			throw new EgoiException("O nome de utilizador não é válido");

		if("INTERNAL_ERROR".equals(error))
			throw new EgoiException("Ocorreu um problema no servidor");
	}
	
}
