package com.egoi.api.wrapper.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.egoi.api.wrapper.api.EgoiApi;
import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.api.EgoiType;
import com.egoi.api.wrapper.api.exceptions.EgoiException;
import com.google.common.collect.Lists;

public abstract class AbstractEgoiApi implements EgoiApi {

//	private static final Logger log = LoggerFactory.getLogger(AbstractEgoiApi.class);

	@SuppressWarnings("unchecked")
	protected EgoiType walkMap(Map<String, ?> map) {
		EgoiType r = null;
		if(map.containsKey("key_0")) {
			EgoiMapList mrl = new EgoiMapList();
			List<String> keys = Lists.newArrayList(map.keySet());
			Collections.sort(keys);
			for(String k : keys) {
				if(!k.startsWith("key_"))
					continue;
				
				Map<String, ?> v = (Map<String, ?>) map.get(k);
				mrl.add(walkValues(new EgoiMap(v)));
			}
			r = mrl;
		} else {
			r = walkValues(new EgoiMap(map));
		}
			
		return r;
	}

	private EgoiType walkArray(List<Map<String, ?>> list) {
		EgoiMapList mrl = new EgoiMapList();
		for(Map<String, ?> map : list)
			mrl.add(walkValues(new EgoiMap(map)));
		return mrl;
	}

	@SuppressWarnings("unchecked")
	protected EgoiMap walkValues(EgoiMap map) {
		for(String key : map.keySet()) {
			Object obj = map.get(key);
			if (obj instanceof Map) {
				Map<String, ?> sm = (Map<String, ?>) obj;
				map.put(key, walkMap(sm));
			}
			
			if(obj instanceof Object[]) {
				List<Map<String, ?>> mapList = extractMapList((Object[]) obj);
				map.put(key, walkArray(mapList));
			}
		}
		return map;
	}
	
	public <T extends EgoiType> T decodeResult(Object obj, Class<T> expected) throws EgoiException {
		if(obj==null)
			return null;

		EgoiType r = null;
		
		if (obj instanceof String) {
			String error = (String) obj;
			throw decodeError(error);
		} else if (obj instanceof Map) {
			r = walkValues(new EgoiMap(obj));
		} else if(obj instanceof Object[]) {
			List<Map<String, ?>> mapList = extractMapList((Object[]) obj);
			r = walkArray(mapList);
		} else {
			throw new EgoiException("The request result is neither a Map nor a String: " + obj.getClass().getSimpleName() + "(" + obj.toString() + ")");
		}
		
		return r != null ? r.as(expected) : null;
	}
	
	@SuppressWarnings("unchecked")
	private List<Map<String, ?>> extractMapList(Object[] arr) {
		List<Map<String, ?>> mapList = Lists.newArrayList();
		for(Object o : arr) {
			if (o instanceof Map) {
				Map<String, ?> m = (Map<String, ?>) o;
				mapList.add(m);
			}
		}
		return mapList;
	}

	protected EgoiException decodeError(String error) {
		if("CANNOT_BE_DELETED".equals(error))
			return new EgoiException("A campanha é recorrente ou activada por evento e não pode ser eliminada por API");
		if("ALREADY_DELETED".equals(error))
			return new EgoiException("A campanha já foi eliminada");
		if("CAMPAIGN_NOT_FOUND".equals(error))
			return new EgoiException("A campanha não existe");
		if("CANNOT_EDIT_CAMPAIGN".equals(error))
			return new EgoiException("A campanha não pode ser editada neste momento (pode estar sendo enviada ou num estado que impossibilite a edição)");
		if("CAMPAIGN_NOT_VALID".equals(error))
			return new EgoiException("A campanha ou modelo de campanha não é válida");
		if("BIRTH_DATE_ALREADY_EXISTS".equals(error))
			return new EgoiException("A data de nascimento introduzida já existe na lista");
		if("LIST_NOT_FOUND".equals(error))
			return new EgoiException("A lista de distribuição não existe");
		if("MESSAGE_TO_LONG".equals(error))
			return new EgoiException("A mensagem tem mais que 160 caracteres");
		if("MESSAGE_TOO_LONG".equals(error))
			return new EgoiException("A mensagem tem mais que 160 caracteres");
		if("NO_ACCESS".equals(error))
			return new EgoiException("Falta a chave da API ou faltam permissões de acesso à lista");
		if("BIRTH_DATE_REQUIRED".equals(error))
			return new EgoiException("Falta a data de nascimento");
		if("LIST_MISSING".equals(error))
			return new EgoiException("Falta a lista de distribuição");
		if("NO_MESSAGE".equals(error))
			return new EgoiException("Falta a mensagem");
		if("NO_PASSWORD".equals(error))
			return new EgoiException("Falta a palavra-passe");
		if("SUBSCRIBER_MISSING".equals(error))
			return new EgoiException("Falta a referência do subscritor");
		if("NO_PASSWORD".equals(error))
			return new EgoiException("Falta a palavra-passe");
		if("FIELD_NAME_MISSING".equals(error))
			return new EgoiException("Falta dar um nome ao campo extra");
		if("SEGMENT_NAME_MISSING".equals(error))
			return new EgoiException("Falta dar um nome ao segmento");
		if("LIST_MISSING".equals(error))
			return new EgoiException("Falta definir a lista");
		if("NO_SUBSCRIBERS".equals(error))
			return new EgoiException("Falta definir os contactos a importar");
		if("NO_COMPARE_FIELD".equals(error))
			return new EgoiException("Falta definir um campo de comparação");
		if("NO_ZIP_FILE".equals(error))
			return new EgoiException("Falta o arquivo ZIP com o conteúdo do e-mail");
		if("NO_SUBJECT".equals(error))
			return new EgoiException("Falta o assunto");
		if("INVALID_FROM".equals(error))
			return new EgoiException("Falta o código do remetente (ou está incorrecto) ou o remetente ainda não foi validado no E-goi");
		if("NO_MESSAGE".equals(error))
			return new EgoiException("Falta o conteúdo do e-mail a enviar (não foi fornecido por arquivo ZIP ou por URL)");
		if("FAX_REQUIRED".equals(error))
			return new EgoiException("Falta o fax");
		if("NO_FAX_FILE".equals(error))
			return new EgoiException("Falta o ficheiro com o fax");
		if("NO_AUDIO_FILE".equals(error))
			return new EgoiException("Falta o ficheiro de áudio");
		if("NO_SUBJECT".equals(error))
			return new EgoiException("Falta o nome da campanha");
		if("NO_USERNAME".equals(error))
			return new EgoiException("Falta o nome de utilizador");
		if("NO_USERNAME_AND_PASSWORD".equals(error))
			return new EgoiException("Falta o nome de utilizador e a palavra-passe");
		if("NO_USERNAME".equals(error))
			return new EgoiException("Falta o nome de usuário");
		if("SEGMENT_NAME_MISSING".equals(error))
			return new EgoiException("Falta o nome do segmento");
		if("NO_CELLPHONE_OR_TELEPHONE".equals(error))
			return new EgoiException("Falta o número de celular ou telefone");
		if("FIRST_NAME_REQUIRED".equals(error))
			return new EgoiException("Falta o primeiro nome");
		if("SUBSCRIBER_MISSING".equals(error))
			return new EgoiException("Falta o subscritor");
		if("TELEPHONE_REQUIRED".equals(error))
			return new EgoiException("Falta o telefone");
		if("EMAIL_REQUIRED".equals(error))
			return new EgoiException("Falta o e-mail");
		if("NO_CAMPAIGN".equals(error))
			return new EgoiException("Falta o hash da campanha");
		if("LAST_NAME_REQUIRED".equals(error))
			return new EgoiException("Falta o sobrenome");
		if("NO_SEARCH_FIELDS".equals(error))
			return new EgoiException("Faltam os campos em que a pesquisa vai ser feita");
		if("CANNOT_ADD_MORE_SUBSCRIBERS".equals(error))
			return new EgoiException("Não é possível adicionar mais subscritores porque foi atingido o limite");
		if("SUBSCRIBER_DATA_CANNOT_BE_EDITED".equals(error))
			return new EgoiException("Não é possível editar os dados do subscritor porque o subscritor já foi removido");
		if("NO_SEGMENTS_FOUND".equals(error))
			return new EgoiException("Não foi encontrado nenhum segmento");
		if("INVALID_URL".equals(error))
			return new EgoiException("Não foi possível carregar o conteúdo do URL");
		if("NO_DATA_TO_INSERT".equals(error))
			return new EgoiException("Não foram introduzidos quaisquer dados");
		if("INVALID_FILE".equals(error))
			return new EgoiException("O arquivo ZIP importado não é válido");
		if("FILE_TOO_LARGE".equals(error))
			return new EgoiException("O arquivo ZIP tem mais de 8 MB");
		if("FIELD_NOT_FOUND".equals(error))
			return new EgoiException("O campo extra não foi encontrado");
		if("EXTRA_FIELD_XX_ALREADY_EXISTS".equals(error))
			return new EgoiException("O campo extra X já existe na lista");
		if("FAX_ALREADY_EXISTS".equals(error))
			return new EgoiException("O fax introduzido já existe na lista");
		if("INVALID_FILE".equals(error))
			return new EgoiException("O ficheiro de áudio não é válido ou não se encontra no formato correcto");
		if("FILE_TOO_LARGE".equals(error))
			return new EgoiException("O ficheiro de fax tem mais que 8 MB");
		if("INVALID".equals(error))
			return new EgoiException("O nome de utilizador não é válido");
		if("FIST_NAME_ALREADY_EXISTS".equals(error))
			return new EgoiException("O primeiro nome introduzido já existe na lista");
		if("SEGMENT_NOT_FOUND".equals(error))
			return new EgoiException("O segmento da lista de distribuição não existe");
		if("LAST_NAME_ALREADY_EXISTS".equals(error))
			return new EgoiException("O sobrenome introduzido já existe na lista");
		if("SUBSCRIBER_ALREADY_REMOVED".equals(error))
			return new EgoiException("O subscritor já foi removido");
		if("SUBSCRIBER_NOT_FOUND".equals(error))
			return new EgoiException("O subscritor não existe");
		if("TELEPHONE_ALREADY_EXISTS".equals(error))
			return new EgoiException("O telefone introduzido já existe na lista");
		if("INVALID_TYPE".equals(error))
			return new EgoiException("O tipo de campo extra não é válido");
		if("EMAIL_ALREADY_EXISTS".equals(error))
			return new EgoiException("O e-mail introduzido já existe");
		if("EMAIL_ADDRESS_INVALID_DOESNT_EXIST".equals(error))
			return new EgoiException("O e-mail introduzido não existe");
		if("EMAIL_ADDRESS_INVALID".equals(error))
			return new EgoiException("O e-mail introduzido tem um erro de sintaxe");
		if("EMAIL_ADDRESS_INVALID_MX_ERROR".equals(error))
			return new EgoiException("O e-mail introduzido tem um erro nos registos MX");
		if("INTERNAL_ERROR".equals(error))
			return new EgoiException("Ocorreu um problema no servidor");
		return new EgoiException("Erro Desconhecido");
	}
}
