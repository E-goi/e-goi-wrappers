using System;

namespace Egoi
{

    public class EgoiException : Exception
    {

        public EgoiException(string message)
            : base(message)
        {
        }

        public EgoiException(string message, Exception inner)
            : base(message, inner)
        {
        }


        internal static string idToMessage(string error)
        {
            if ("CANNOT_BE_DELETED".Equals(error))
                return "A campanha � recorrente ou activada por evento e n�o pode ser eliminada por API";
            if ("ALREADY_DELETED".Equals(error))
                return "A campanha j� foi eliminada";
            if ("CAMPAIGN_NOT_FOUND".Equals(error))
                return "A campanha n�o existe";
            if ("CANNOT_EDIT_CAMPAIGN".Equals(error))
                return "A campanha n�o pode ser editada neste momento (pode estar sendo enviada ou num estado que impossibilite a edi��o)";
            if ("CAMPAIGN_NOT_VALID".Equals(error))
                return "A campanha ou modelo de campanha n�o � v�lida";
            if ("BIRTH_DATE_ALREADY_EXISTS".Equals(error))
                return "A data de nascimento introduzida j� existe na lista";
            if ("LIST_NOT_FOUND".Equals(error))
                return "A lista de distribui��o n�o existe";
            if ("MESSAGE_TO_LONG".Equals(error))
                return "A mensagem tem mais que 160 caracteres";
            if ("MESSAGE_TOO_LONG".Equals(error))
                return "A mensagem tem mais que 160 caracteres";
            if ("NO_ACCESS".Equals(error))
                return "Falta a chave da API ou faltam permiss�es de acesso � lista";
            if ("BIRTH_DATE_REQUIRED".Equals(error))
                return "Falta a data de nascimento";
            if ("LIST_MISSING".Equals(error))
                return "Falta a lista de distribui��o";
            if ("NO_MESSAGE".Equals(error))
                return "Falta a mensagem";
            if ("NO_PASSWORD".Equals(error))
                return "Falta a palavra-passe";
            if ("SUBSCRIBER_MISSING".Equals(error))
                return "Falta a refer�ncia do subscritor";
            if ("NO_PASSWORD".Equals(error))
                return "Falta a palavra-passe";
            if ("FIELD_NAME_MISSING".Equals(error))
                return "Falta dar um nome ao campo extra";
            if ("SEGMENT_NAME_MISSING".Equals(error))
                return "Falta dar um nome ao segmento";
            if ("LIST_MISSING".Equals(error))
                return "Falta definir a lista";
            if ("NO_SUBSCRIBERS".Equals(error))
                return "Falta definir os contactos a importar";
            if ("NO_COMPARE_FIELD".Equals(error))
                return "Falta definir um campo de compara��o";
            if ("NO_ZIP_FILE".Equals(error))
                return "Falta o arquivo ZIP com o conte�do do e-mail";
            if ("NO_SUBJECT".Equals(error))
                return "Falta o assunto";
            if ("INVALID_FROM".Equals(error))
                return "Falta o c�digo do remetente (ou est� incorrecto) ou o remetente ainda n�o foi validado no E-goi";
            if ("NO_MESSAGE".Equals(error))
                return "Falta o conte�do do e-mail a enviar (n�o foi fornecido por arquivo ZIP ou por URL)";
            if ("FAX_REQUIRED".Equals(error))
                return "Falta o fax";
            if ("NO_FAX_FILE".Equals(error))
                return "Falta o ficheiro com o fax";
            if ("NO_AUDIO_FILE".Equals(error))
                return "Falta o ficheiro de �udio";
            if ("NO_SUBJECT".Equals(error))
                return "Falta o nome da campanha";
            if ("NO_USERNAME".Equals(error))
                return "Falta o nome de utilizador";
            if ("NO_USERNAME_AND_PASSWORD".Equals(error))
                return "Falta o nome de utilizador e a palavra-passe";
            if ("NO_USERNAME".Equals(error))
                return "Falta o nome de usu�rio";
            if ("SEGMENT_NAME_MISSING".Equals(error))
                return "Falta o nome do segmento";
            if ("NO_CELLPHONE_OR_TELEPHONE".Equals(error))
                return "Falta o n�mero de celular ou telefone";
            if ("FIRST_NAME_REQUIRED".Equals(error))
                return "Falta o primeiro nome";
            if ("SUBSCRIBER_MISSING".Equals(error))
                return "Falta o subscritor";
            if ("TELEPHONE_REQUIRED".Equals(error))
                return "Falta o telefone";
            if ("EMAIL_REQUIRED".Equals(error))
                return "Falta o e-mail";
            if ("NO_CAMPAIGN".Equals(error))
                return "Falta o hash da campanha";
            if ("LAST_NAME_REQUIRED".Equals(error))
                return "Falta o sobrenome";
            if ("NO_SEARCH_FIELDS".Equals(error))
                return "Faltam os campos em que a pesquisa vai ser feita";
            if ("CANNOT_ADD_MORE_SUBSCRIBERS".Equals(error))
                return "N�o � poss�vel adicionar mais subscritores porque foi atingido o limite";
            if ("SUBSCRIBER_DATA_CANNOT_BE_EDITED".Equals(error))
                return "N�o � poss�vel editar os dados do subscritor porque o subscritor j� foi removido";
            if ("NO_SEGMENTS_FOUND".Equals(error))
                return "N�o foi encontrado nenhum segmento";
            if ("INVALID_URL".Equals(error))
                return "N�o foi poss�vel carregar o conte�do do URL";
            if ("NO_DATA_TO_INSERT".Equals(error))
                return "N�o foram introduzidos quaisquer dados";
            if ("INVALID_FILE".Equals(error))
                return "O arquivo ZIP importado n�o � v�lido";
            if ("FILE_TOO_LARGE".Equals(error))
                return "O arquivo ZIP tem mais de 8 MB";
            if ("FIELD_NOT_FOUND".Equals(error))
                return "O campo extra n�o foi encontrado";
            if ("EXTRA_FIELD_XX_ALREADY_EXISTS".Equals(error))
                return "O campo extra X j� existe na lista";
            if ("FAX_ALREADY_EXISTS".Equals(error))
                return "O fax introduzido j� existe na lista";
            if ("INVALID_FILE".Equals(error))
                return "O ficheiro de �udio n�o � v�lido ou n�o se encontra no formato correcto";
            if ("FILE_TOO_LARGE".Equals(error))
                return "O ficheiro de fax tem mais que 8 MB";
            if ("INVALID".Equals(error))
                return "O nome de utilizador n�o � v�lido";
            if ("FIST_NAME_ALREADY_EXISTS".Equals(error))
                return "O primeiro nome introduzido j� existe na lista";
            if ("SEGMENT_NOT_FOUND".Equals(error))
                return "O segmento da lista de distribui��o n�o existe";
            if ("LAST_NAME_ALREADY_EXISTS".Equals(error))
                return "O sobrenome introduzido j� existe na lista";
            if ("SUBSCRIBER_ALREADY_REMOVED".Equals(error))
                return "O subscritor j� foi removido";
            if ("SUBSCRIBER_NOT_FOUND".Equals(error))
                return "O subscritor n�o existe";
            if ("TELEPHONE_ALREADY_EXISTS".Equals(error))
                return "O telefone introduzido j� existe na lista";
            if ("INVALID_TYPE".Equals(error))
                return "O tipo de campo extra n�o � v�lido";
            if ("EMAIL_ALREADY_EXISTS".Equals(error))
                return "O e-mail introduzido j� existe";
            if ("EMAIL_ADDRESS_INVALID_DOESNT_EXIST".Equals(error))
                return "O e-mail introduzido n�o existe";
            if ("EMAIL_ADDRESS_INVALID".Equals(error))
                return "O e-mail introduzido tem um erro de sintaxe";
            if ("EMAIL_ADDRESS_INVALID_MX_ERROR".Equals(error))
                return "O e-mail introduzido tem um erro nos registos MX";
            if ("INTERNAL_ERROR".Equals(error))
                return "Ocorreu um problema no servidor";
            if ("NO_USERNAME_AND_PASSWORD_AND_APIKEY".Equals(error))
                return "N�o foi especificado nenhum utilizador/password ou apikey";
            return "Erro Desconhecido";
        }
    }

}