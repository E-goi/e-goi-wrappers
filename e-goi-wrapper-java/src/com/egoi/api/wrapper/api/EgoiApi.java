package com.egoi.api.wrapper.api;


import com.egoi.api.wrapper.api.exceptions.EgoiException;

/**
 * @author Luís Lobo <lflobo@gmail.com>
 *
 */
public interface EgoiApi {
	
	/**
	 * Adicionar um campo extra a uma lista
	 * @param apikey Chave da API <b>(Obrigatório)</b>
	 * @param listID Número da lista de distribuição <b>(Obrigatório)</b>
	 * @param name Nome a dar ao campo extra <b>(Obrigatório)</b>
	 * @param typeTipo de campo a criar (data = campo de data; texto = campo de texto; telefone = campo de telefone; telemovel = campo de telemóvel; fax = campo de fax; numero = campo de número; email = campo de e-mail; lista = campo de lista de valores) <b>(Obrigatório)</b>
	 * @return {@link EgoiMap} contendo o novo ID do extra field 
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/addextrafield/
	 */
	EgoiMap addExtraField(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Adicionar um subscritor a uma lista
	 * @param apikey Chave da API <b>(Obrigatório)</b>
	 * @param listID Número da lista de distribuição <b>(Obrigatório)</b>
	 * @param subscriber Referência do subscritor
	 * @param status Estado da conta (0 = por confirmar; 1 = activo; 2 = removido; 3 = convidado; 4 = inactivo)
	 * @param from Remetente usado nos e-mails de inscrição e de boas-vindas. Esta variável só aceita o código de um remetente previamente validado no E-goi (disponível na secção "Remetentes" ao editar uma lista)
	 * @param lang Idioma do subscritor (pt = português de Portugal; br = português do Brasil; en = inglês; es = espanhol; fr = francês; de = alemão)
	 * @param email E-mail Verificação automática do e-mail (0 = por sintaxe; 1 = por sintaxe e MX; 2 = por sintaxe, MX e verificação do endereço)
	 * @param validateEmail Verificação automática do e-mail (0 = por sintaxe; 1 = por sintaxe e MX; 2 = por sintaxe, MX e verificação do endereço)
	 * @param cellphone Telemóvel (indicativo e número separados por um traço; ex. 351-96XXXXXXX)
	 * @param telephoneTelefone (indicativo e número separados por um traço; ex. 351-21XXXXXXX)
	 * @param fax Fax (indicativo e número separados por um traço; ex. 351-21XXXXXXX)
	 * @param firstName Nome
	 * @param lastName Apelido
	 * @param birthDate Data de Nascimento
	 * @param extraX Campo extra X
	 * @param formID ID de um formulário da lista. Se o formulário existir, os e-mailsautomáticos de boas-vindas e confirmação de subscrição terão os estilos HTML que estão definidos nesse formulário
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/adicionar-subscritor/
	 */
	EgoiMap addSubscriber(EgoiMap arguments) throws EgoiException;
	
	/**
	 * @param apikey Chave da API <b>(Obrigatório)</b>
	 * @param listID Número da lista de distribuição <b>(Obrigatório)</b>
	 * @param compareField Campo de comparação a usar na importação (email = endereço de e-mail; cellphone = n.º de telemóvel; telephone = n.º de telefone; fax = n.º de fax; first_name = nome; last_name = apelido; birth_date = data de nascimento; extra_X = campo extra X) <b>(Obrigatório)</b>
	 * @param defaultStatus Estado a atribuir aos contactos importados (0 = por confirmar; 1 = activo; 2 = removido; 4 = inactivo). Se este parâmetro não for definido, os contactos serão importados com o estado 1 (activo)
	 * @param defaultCountryCode Prefixo telefónico a atribuir aos números importados (requer o sinal "+"). Se este parâmetro não for definido, os contactos serão importados com o prefixo +351
	 * @param operation Tipo de importação (1 = inserir contactos novos; 2 = actualizar os contactos existentes e inserir novos se existirem)
	 * @param subscribers {@link EgoiMapList} com os contactos a importar. Os parâmetros são os mesmos que os do comando {@link EgoiApi.addSubscriber()} <b>(Obrigatório)</b>
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/addsubscriberbulk/
	 */
	EgoiMap addSubscriberBulk(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Verificar se os dados de acesso à conta E-goi são válidos
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/checklogin/
	 */
	EgoiMap checklogin(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Criar uma campanha de email
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignemail/
	 */
	EgoiMap createCampaignEmail(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Criar uma campanha de Fax
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignfax/
	 */
	EgoiMap createCampaignFAX(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Criar uma campanha de SMS
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignsms/
	 */
	EgoiMap createCampaignSMS(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Criar uma campanha de Voz
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignvoice/
	 */
	EgoiMap createCampaignVoice(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Criar Lista de Contactos
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/createlist/
	 */
	EgoiMap createList(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Criar um segmento numa lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/createsegment/
	 */
	EgoiMap createSegment(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Eliminar uma campanha
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/deletecampaign/
	 */
	EgoiMap deleteCampaign(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Eliminar um segmento de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/deletesegment/
	 */
	EgoiMap deleteSegment(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Editar uma campanha de email
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/editcampaignemail/
	 */
	EgoiMap editCampaignEmail(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Editar uma campanha de SMS
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/editcampaignsms/
	 */
	EgoiMap editCampaignSMS(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Editar um campo extra
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/editextrafield/
	 */
	EgoiMap editExtraField(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Editar os dados de um subscritor
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/editsubscriber/
	 */
	EgoiMap editSubscriber(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter uma listagem das campanhas
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getcampaigns/
	 */
	EgoiMapList getCampaigns(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Ver os dados de uma conta E-goi
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getclientdata/
	 */
	EgoiMap getClientData(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Ver os créditos disponíveis numa conta E-goi
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getcredits/
	 */
	EgoiMap getCredits(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter Listagem das Listas
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getlists/
	 */
	EgoiMapList getLists(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter o relatório de uma campanha
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getreport/
	 */
	EgoiMap getReport(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Ver os segmentos de uma lista
	 * @param arguments
	 * @return
	 * @see http://www.e-goi.pt/pt/recursos/api/getsegments
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getsegments/
	 */
	EgoiMapList getSegments(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter uma listagem dos remetentes
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getsenders/
	 */
	EgoiMapList getSenders(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter os dados de um utilizador E-goi
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getuserdata/
	 */
	EgoiMap getUserData(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Remover um subscritor de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/removesubscriber/
	 */
	EgoiMap removeSubscriber(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de Voz
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendcall/
	 */
	EgoiMap sendCall(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de email
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendemail/
	 */
	EgoiMap sendEmail(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de Fax
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendfax/
	 */
	EgoiMap sendFAX(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de SMS
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendsms/
	 */
	EgoiMap sendSMS(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter os dados de um subscritor
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/subscriberdata/
	 */
	EgoiMap subscriberData(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Editar as opções de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/updatelist/
	 */
	EgoiMap updateList(EgoiMap arguments) throws EgoiException;

}