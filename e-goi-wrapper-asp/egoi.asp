<!--#include virtual="xmlrpc.asp" -->
<%

function processError(err)
	if "CANNOT_BE_DELETED" = err then
		processError = "A campanha é recorrente ou activada por evento e não pode ser eliminada por API"
	elseif "ALREADY_DELETED" = err then
		processError = "A campanha já foi eliminada"
	elseif "CAMPAIGN_NOT_FOUND" = err then
		processError = "A campanha não existe"
	elseif "CANNOT_EDIT_CAMPAIGN" = err then
		processError = "A campanha não pode ser editada neste momento (pode estar sendo enviada ou num estado que impossibilite a edição)"
	elseif "CAMPAIGN_NOT_VALID" = err then
		processError = "A campanha ou modelo de campanha não é válida"
	elseif "BIRTH_DATE_ALREADY_EXISTS" = err then
		processError = "A data de nascimento introduzida já existe na lista"
	elseif "LIST_NOT_FOUND" = err then
		processError = "A lista de distribuição não existe"
	elseif "MESSAGE_TO_LONG" = err then
		processError = "A mensagem tem mais que 160 caracteres"
	elseif "MESSAGE_TOO_LONG" = err then
		processError = "A mensagem tem mais que 160 caracteres"
	elseif "NO_ACCESS" = err then
		processError = "Falta a chave da API ou faltam permissões de acesso à lista"
	elseif "BIRTH_DATE_REQUIRED" = err then
		processError = "Falta a data de nascimento"
	elseif "LIST_MISSING" = err then
		processError = "Falta a lista de distribuição"
	elseif "NO_MESSAGE" = err then
		processError = "Falta a mensagem"
	elseif "NO_PASSWORD" = err then
		processError = "Falta a palavra-passe"
	elseif "SUBSCRIBER_MISSING" = err then
		processError = "Falta a referência do subscritor"
	elseif "NO_PASSWORD" = err then
		processError = "Falta a palavra-passe"
	elseif "FIELD_NAME_MISSING" = err then
		processError = "Falta dar um nome ao campo extra"
	elseif "SEGMENT_NAME_MISSING" = err then
		processError = "Falta dar um nome ao segmento"
	elseif "LIST_MISSING" = err then
		processError = "Falta definir a lista"
	elseif "NO_SUBSCRIBERS" = err then
		processError = "Falta definir os contactos a importar"
	elseif "NO_COMPARE_FIELD" = err then
		processError = "Falta definir um campo de comparação"
	elseif "NO_ZIP_FILE" = err then
		processError = "Falta o arquivo ZIP com o conteúdo do e-mail"
	elseif "NO_SUBJECT" = err then
		processError = "Falta o assunto"
	elseif "INVALID_FROM" = err then
		processError = "Falta o código do remetente (ou está incorrecto) ou o remetente ainda não foi validado no E-goi"
	elseif "NO_MESSAGE" = err then
		processError = "Falta o conteúdo do e-mail a enviar (não foi fornecido por arquivo ZIP ou por URL)"
	elseif "FAX_REQUIRED" = err then
		processError = "Falta o fax"
	elseif "NO_FAX_FILE" = err then
		processError = "Falta o ficheiro com o fax"
	elseif "NO_AUDIO_FILE" = err then
		processError = "Falta o ficheiro de áudio"
	elseif "NO_SUBJECT" = err then
		processError = "Falta o nome da campanha"
	elseif "NO_USERNAME" = err then
		processError = "Falta o nome de utilizador"
	elseif "NO_USERNAME_AND_PASSWORD" = err then
		processError = "Falta o nome de utilizador e a palavra-passe"
	elseif "NO_USERNAME" = err then
		processError = "Falta o nome de usuário"
	elseif "SEGMENT_NAME_MISSING" = err then
		processError = "Falta o nome do segmento"
	elseif "NO_CELLPHONE_OR_TELEPHONE" = err then
		processError = "Falta o número de celular ou telefone"
	elseif "FIRST_NAME_REQUIRED" = err then
		processError = "Falta o primeiro nome"
	elseif "SUBSCRIBER_MISSING" = err then
		processError = "Falta o subscritor"
	elseif "TELEPHONE_REQUIRED" = err then
		processError = "Falta o telefone"
	elseif "EMAIL_REQUIRED" = err then
		processError = "Falta o e-mail"
	elseif "NO_CAMPAIGN" = err then
		processError = "Falta o hash da campanha"
	elseif "LAST_NAME_REQUIRED" = err then
		processError = "Falta o sobrenome"
	elseif "NO_SEARCH_FIELDS" = err then
		processError = "Faltam os campos em que a pesquisa vai ser feita"
	elseif "CANNOT_ADD_MORE_SUBSCRIBERS" = err then
		processError = "Não é possível adicionar mais subscritores porque foi atingido o limite"
	elseif "SUBSCRIBER_DATA_CANNOT_BE_EDITED" = err then
		processError = "Não é possível editar os dados do subscritor porque o subscritor já foi removido"
	elseif "NO_SEGMENTS_FOUND" = err then
		processError = "Não foi encontrado nenhum segmento"
	elseif "INVALID_URL" = err then
		processError = "Não foi possível carregar o conteúdo do URL"
	elseif "NO_DATA_TO_INSERT" = err then
		processError = "Não foram introduzidos quaisquer dados"
	elseif "INVALID_FILE" = err then
		processError = "O arquivo ZIP importado não é válido"
	elseif "FILE_TOO_LARGE" = err then
		processError = "O arquivo ZIP tem mais de 8 MB"
	elseif "FIELD_NOT_FOUND" = err then
		processError = "O campo extra não foi encontrado"
	elseif "EXTRA_FIELD_XX_ALREADY_EXISTS" = err then
		processError = "O campo extra X já existe na lista"
	elseif "FAX_ALREADY_EXISTS" = err then
		processError = "O fax introduzido já existe na lista"
	elseif "INVALID_FILE" = err then
		processError = "O ficheiro de áudio não é válido ou não se encontra no formato correcto"
	elseif "FILE_TOO_LARGE" = err then
		processError = "O ficheiro de fax tem mais que 8 MB"
	elseif "INVALID" = err then
		processError = "O nome de utilizador não é válido"
	elseif "FIST_NAME_ALREADY_EXISTS" = err then
		processError = "O primeiro nome introduzido já existe na lista"
	elseif "SEGMENT_NOT_FOUND" = err then
		processError = "O segmento da lista de distribuição não existe"
	elseif "LAST_NAME_ALREADY_EXISTS" = err then
		processError = "O sobrenome introduzido já existe na lista"
	elseif "SUBSCRIBER_ALREADY_REMOVED" = err then
		processError = "O subscritor já foi removido"
	elseif "SUBSCRIBER_NOT_FOUND" = err then
		processError = "O subscritor não existe"
	elseif "TELEPHONE_ALREADY_EXISTS" = err then
		processError = "O telefone introduzido já existe na lista"
	elseif "INVALID_TYPE" = err then
		processError = "O tipo de campo extra não é válido"
	elseif "EMAIL_ALREADY_EXISTS" = err then
		processError = "O e-mail introduzido já existe"
	elseif "EMAIL_ADDRESS_INVALID_DOESNT_EXIST" = err then
		processError = "O e-mail introduzido não existe"
	elseif "EMAIL_ADDRESS_INVALID" = err then
		processError = "O e-mail introduzido tem um erro de sintaxe"
	elseif "EMAIL_ADDRESS_INVALID_MX_ERROR" = err then
		processError = "O e-mail introduzido tem um erro nos registos MX"
	elseif "INTERNAL_ERROR" = err then
		processError = "Ocorreu um problema no servidor"
	elseif "NO_USERNAME_AND_PASSWORD_AND_APIKEY" = err then
		processError = "Não foi especificado nenhum utilizador/password ou apikey"
	else
		processError = "Erro Desconhecido"
	end if
end function

class EgoiXmlRpc

	public function Dictionary()
		set Dictionary = Server.CreateObject("Scripting.Dictionary")
	end function

	private function go(fname, params)
		dim arr_params(0)
		set arr_params(0) = params
		xmlRPC "http://api.e-goi.com/v2/xmlrpc.php", fname, arr_params
		if TypeName(xmlRpcReturnValue) = "String" then
			response.write("Erro ao processar o pedido: " & processError(xmlRpcReturnValue))
			response.End
		else
			set go = xmlRpcReturnValue
		end if
	end function	

	public function addExtraField(params)
		set addExtraField = go("addExtraField", params)
	end function

	public function checklogin(params)
		set checklogin = go("checklogin", params)
	end function

	public function addSubscriber(params)
		set addSubscriber = go("addSubscriber", params)
	end function

	public function addSubscriberBulk(params)
		set addSubscriberBulk = go("addSubscriberBulk", params)
	end function

	public function createCampaignEmail(params)
		set createCampaignEmail = go("createCampaignEmail", params)
	end function

	public function createCampaignFAX(params)
		set createCampaignFAX = go("createCampaignFAX", params)
	end function

	public function createCampaignSMS(params)
		set createCampaignSMS = go("createCampaignSMS", params)
	end function

	public function createCampaignVoice(params)
		set createCampaignVoice = go("createCampaignVoice", params)
	end function

	public function createList(params)
		set createList = go("createList", params)
	end function

	public function createSegment(params)
		set createSegment = go("createSegment", params)
	end function

	public function deleteCampaign(params)
		set deleteCampaign = go("deleteCampaign", params)
	end function

	public function deleteSegment(params)
		set deleteSegment = go("deleteSegment", params)
	end function

	public function editCampaignEmail(params)
		set editCampaignEmail = go("editCampaignEmail", params)
	end function

	public function editCampaignSMS(params)
		set editCampaignSMS = go("editCampaignSMS", params)
	end function

	public function editExtraField(params)
		set editExtraField = go("editExtraField", params)
	end function

	public function editSubscriber(params)
		set editSubscriber = go("editSubscriber", params)
	end function

	public function getCampaigns(params)
		set getCampaigns = go("getCampaigns", params)
	end function

	public function getClientData(params)
		set getClientData = go("getClientData", params)
	end function

	public function getCredits(params)
		set getCredits = go("getCredits", params)
	end function

	public function getLists(params)
		set getLists = go("getLists", params)
	end function

	public function getReport(params)
		set getReport = go("getReport", params)
	end function

	public function getSegments(params)
		set getSegments = go("getSegments", params)
	end function

	public function getSenders(params)
		set getSenders = go("getSenders", params)
	end function

	public function getUserData(params)
		set getUserData = go("getUserData", params)
	end function

	public function removeSubscriber(params)
		set removeSubscriber = go("removeSubscriber", params)
	end function

	public function sendCall(params)
		set sendCall = go("sendCall", params)
	end function

	public function sendEmail(params)
		set sendEmail = go("sendEmail", params)
	end function

	public function sendFAX(params)
		set sendFAX = go("sendFAX", params)
	end function

	public function sendSMS(params)
		set sendSMS = go("sendSMS", params)
	end function

	public function subscriberData(params)
		set subscriberData = go("subscriberData", params)
	end function

	public function updateList(params)
		set updateList = go("updateList", params)
	end function
	
end class

' At the time being only XmlRpc is implemented
dim EgoiApi : set EgoiApi = new EgoiXmlRpc

%>
