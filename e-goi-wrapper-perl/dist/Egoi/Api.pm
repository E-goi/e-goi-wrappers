package Egoi::Api;

my $mod;

if($INC{"Egoi/Api/XmlRpc.pm"}) {
	$mod = Egoi::Api::XmlRpc;
} elsif($INC{"Egoi/Api/Soap.pm"}) {
	$mod = Egoi::Api::Soap;
} else {
	print "Please use one of 'Egoi::Api::XmlRpc' or 'Egoi::Api::Soap' before 'Egoi::Api'\n";
}

sub decodeError {
	my $error = $_[0];

	if("CANNOT_BE_DELETED" eq $error) {
		return "A campanha Ž recorrente ou activada por evento e n‹o pode ser eliminada por API";
	}
	if("ALREADY_DELETED" eq $error) {
		return "A campanha j‡ foi eliminada";
	}
	if("CAMPAIGN_NOT_FOUND" eq $error) {
		return "A campanha n‹o existe";
	}
	if("CANNOT_EDIT_CAMPAIGN" eq $error) {
		return "A campanha n‹o pode ser editada neste momento (pode estar sendo enviada ou num estado que impossibilite a edi‹o)";
	}
	if("CAMPAIGN_NOT_VALID" eq $error) {
		return "A campanha ou modelo de campanha n‹o Ž v‡lida";
	}
	if("BIRTH_DATE_ALREADY_EXISTS" eq $error) {
		return "A data de nascimento introduzida j‡ existe na lista";
	}
	if("LIST_NOT_FOUND" eq $error) {
		return "A lista de distribui‹o n‹o existe";
	}
	if("MESSAGE_TO_LONG" eq $error) {
		return "A mensagem tem mais que 160 caracteres";
	}
	if("MESSAGE_TOO_LONG" eq $error) {
		return "A mensagem tem mais que 160 caracteres";
	}
	if("NO_ACCESS" eq $error) {
		return "Falta a chave da API ou faltam permiss›es de acesso ˆ lista";
	}
	if("BIRTH_DATE_REQUIRED" eq $error) {
		return "Falta a data de nascimento";
	}
	if("LIST_MISSING" eq $error) {
		return "Falta a lista de distribui‹o";
	}
	if("NO_MESSAGE" eq $error) {
		return "Falta a mensagem";
	}
	if("NO_PASSWORD" eq $error) {
		return "Falta a palavra-passe";
	}
	if("SUBSCRIBER_MISSING" eq $error) {
		return "Falta a referncia do subscritor";
	}
	if("NO_PASSWORD" eq $error) {
		return "Falta a palavra-passe";
	}
	if("FIELD_NAME_MISSING" eq $error) {
		return "Falta dar um nome ao campo extra";
	}
	if("SEGMENT_NAME_MISSING" eq $error) {
		return "Falta dar um nome ao segmento";
	}
	if("LIST_MISSING" eq $error) {
		return "Falta definir a lista";
	}
	if("NO_SUBSCRIBERS" eq $error) {
		return "Falta definir os contactos a importar";
	}
	if("NO_COMPARE_FIELD" eq $error) {
		return "Falta definir um campo de compara‹o";
	}
	if("NO_ZIP_FILE" eq $error) {
		return "Falta o arquivo ZIP com o conteœdo do e-mail";
	}
	if("NO_SUBJECT" eq $error) {
		return "Falta o assunto";
	}
	if("INVALID_FROM" eq $error) {
		return "Falta o c—digo do remetente (ou est‡ incorrecto) ou o remetente ainda n‹o foi validado no E-goi";
	}
	if("NO_MESSAGE" eq $error) {
		return "Falta o conteœdo do e-mail a enviar (n‹o foi fornecido por arquivo ZIP ou por URL)";
	}
	if("FAX_REQUIRED" eq $error) {
		return "Falta o fax";
	}
	if("NO_FAX_FILE" eq $error) {
		return "Falta o ficheiro com o fax";
	}
	if("NO_AUDIO_FILE" eq $error) {
		return "Falta o ficheiro de ‡udio";
	}
	if("NO_SUBJECT" eq $error) {
		return "Falta o nome da campanha";
	}
	if("NO_USERNAME" eq $error) {
		return "Falta o nome de utilizador";
	}
	if("NO_USERNAME_AND_PASSWORD" eq $error) {
		return "Falta o nome de utilizador e a palavra-passe";
	}
	if("NO_USERNAME" eq $error) {
		return "Falta o nome de usu‡rio";
	}
	if("SEGMENT_NAME_MISSING" eq $error) {
		return "Falta o nome do segmento";
	}
	if("NO_CELLPHONE_OR_TELEPHONE" eq $error) {
		return "Falta o nœmero de celular ou telefone";
	}
	if("FIRST_NAME_REQUIRED" eq $error) {
		return "Falta o primeiro nome";
	}
	if("SUBSCRIBER_MISSING" eq $error) {
		return "Falta o subscritor";
	}
	if("TELEPHONE_REQUIRED" eq $error) {
		return "Falta o telefone";
	}
	if("EMAIL_REQUIRED" eq $error) {
		return "Falta o e-mail";
	}
	if("NO_CAMPAIGN" eq $error) {
		return "Falta o hash da campanha";
	}
	if("LAST_NAME_REQUIRED" eq $error) {
		return "Falta o sobrenome";
	}
	if("NO_SEARCH_FIELDS" eq $error) {
		return "Faltam os campos em que a pesquisa vai ser feita";
	}
	if("CANNOT_ADD_MORE_SUBSCRIBERS" eq $error) {
		return "N‹o Ž poss’vel adicionar mais subscritores porque foi atingido o limite";
	}
	if("SUBSCRIBER_DATA_CANNOT_BE_EDITED" eq $error) {
		return "N‹o Ž poss’vel editar os dados do subscritor porque o subscritor j‡ foi removido";
	}
	if("NO_SEGMENTS_FOUND" eq $error) {
		return "N‹o foi encontrado nenhum segmento";
	}
	if("INVALID_URL" eq $error) {
		return "N‹o foi poss’vel carregar o conteœdo do URL";
	}
	if("NO_DATA_TO_INSERT" eq $error) {
		return "N‹o foram introduzidos quaisquer dados";
	}
	if("INVALID_FILE" eq $error) {
		return "O arquivo ZIP importado n‹o Ž v‡lido";
	}
	if("FILE_TOO_LARGE" eq $error) {
		return "O arquivo ZIP tem mais de 8 MB";
	}
	if("FIELD_NOT_FOUND" eq $error) {
		return "O campo extra n‹o foi encontrado";
	}
	if("EXTRA_FIELD_XX_ALREADY_EXISTS" eq $error) {
		return "O campo extra X j‡ existe na lista";
	}
	if("FAX_ALREADY_EXISTS" eq $error) {
		return "O fax introduzido j‡ existe na lista";
	}
	if("INVALID_FILE" eq $error) {
		return "O ficheiro de ‡udio n‹o Ž v‡lido ou n‹o se encontra no formato correcto";
	}
	if("FILE_TOO_LARGE" eq $error) {
		return "O ficheiro de fax tem mais que 8 MB";
	}
	if("INVALID" eq $error) {
		return "O nome de utilizador n‹o Ž v‡lido";
	}
	if("FIST_NAME_ALREADY_EXISTS" eq $error) {
		return "O primeiro nome introduzido j‡ existe na lista";
	}
	if("SEGMENT_NOT_FOUND" eq $error) {
		return "O segmento da lista de distribui‹o n‹o existe";
	}
	if("LAST_NAME_ALREADY_EXISTS" eq $error) {
		return "O sobrenome introduzido j‡ existe na lista";
	}
	if("SUBSCRIBER_ALREADY_REMOVED" eq $error) {
		return "O subscritor j‡ foi removido";
	}
	if("SUBSCRIBER_NOT_FOUND" eq $error) {
		return "O subscritor n‹o existe";
	}
	if("TELEPHONE_ALREADY_EXISTS" eq $error) {
		return "O telefone introduzido j‡ existe na lista";
	}
	if("INVALID_TYPE" eq $error) {
		return "O tipo de campo extra n‹o Ž v‡lido";
	}
	if("EMAIL_ALREADY_EXISTS" eq $error) {
		return "O e-mail introduzido j‡ existe";
	}
	if("EMAIL_ADDRESS_INVALID_DOESNT_EXIST" eq $error) {
		return "O e-mail introduzido n‹o existe";
	}
	if("EMAIL_ADDRESS_INVALID" eq $error) {
		return "O e-mail introduzido tem um erro de sintaxe";
	}
	if("EMAIL_ADDRESS_INVALID_MX_ERROR" eq $error) {
		return "O e-mail introduzido tem um erro nos registos MX";
	}
	if("INTERNAL_ERROR" eq $error) {
		return "Ocorreu um problema no servidor";
	}
	if("NO_USERNAME_AND_PASSWORD_AND_APIKEY" eq $error) {
		return "N‹o foi especificado nenhum utilizador/password ou apikey";
	}
	return $error;
}

sub addExtraField {
	return $mod->addExtraField($_[0]);
}

sub addSubscriber {
	return $mod->addSubscriber($_[0]);
}

sub addSubscriberBulk {
	return $mod->addSubscriberBulk($_[0]);
}

sub checklogin {
	return $mod->checklogin($_[0]);
}

sub createCampaignEmail {
	return $mod->createCampaignEmail($_[0]);
}

sub createCampaignFAX {
	return $mod->createCampaignFAX($_[0]);
}

sub createCampaignSMS {
	return $mod->createCampaignSMS($_[0]);
}

sub createCampaignVoice {
	return $mod->createCampaignVoice($_[0]);
}

sub createList {
	return $mod->createList($_[0]);
}

sub createSegment {
	return $mod->createSegment($_[0]);
}

sub deleteCampaign {
	return $mod->deleteCampaign($_[0]);
}

sub deleteSegment {
	return $mod->deleteSegment($_[0]);
}

sub editCampaignEmail {
	return $mod->editCampaignEmail($_[0]);
}

sub editCampaignSMS {
	return $mod->editCampaignSMS($_[0]);
}

sub editExtraField {
	return $mod->editExtraField($_[0]);
}

sub editSubscriber {
	return $mod->editSubscriber($_[0]);
}

sub getCampaigns {
	return $mod->getCampaigns($_[0]);
}

sub getClientData {
	return $mod->getClientData($_[0]);
}

sub getCredits {
	return $mod->getCredits($_[0]);
}

sub getLists {
	return $mod->getLists($_[0]);
}

sub getReport {
	return $mod->getReport($_[0]);
}

sub getSegments {
	return $mod->getSegments($_[0]);
}

sub getSenders {
	return $mod->getSenders($_[0]);
}

sub getUserData {
	return $mod->getUserData($_[0]);
}

sub removeSubscriber {
	return $mod->removeSubscriber($_[0]);
}

sub sendCall {
	return $mod->sendCall($_[0]);
}

sub sendEmail {
	return $mod->sendEmail($_[0]);
}

sub sendFAX {
	return $mod->sendFAX($_[0]);
}

sub sendSMS {
	return $mod->sendSMS($_[0]);
}

sub subscriberData {
	return $mod->subscriberData($_[0]);
}

sub updateList {
	return $mod->updateList($_[0]);
}

1;
__END__

Uma coisa do outro mundo!!!