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
                return "A campanha é recorrente ou activada por evento e não pode ser eliminada por API";
            if ("ALREADY_DELETED".Equals(error))
                return "A campanha já foi eliminada";
            if ("CAMPAIGN_NOT_FOUND".Equals(error))
                return "A campanha não existe";
            if ("CANNOT_EDIT_CAMPAIGN".Equals(error))
                return "A campanha não pode ser editada neste momento (pode estar sendo enviada ou num estado que impossibilite a edição)";
            if ("CAMPAIGN_NOT_VALID".Equals(error))
                return "A campanha ou modelo de campanha não é válida";
            if ("BIRTH_DATE_ALREADY_EXISTS".Equals(error))
                return "A data de nascimento introduzida já existe na lista";
            if ("LIST_NOT_FOUND".Equals(error))
                return "A lista de distribuição não existe";
            if ("MESSAGE_TO_LONG".Equals(error))
                return "A mensagem tem mais que 160 caracteres";
            if ("MESSAGE_TOO_LONG".Equals(error))
                return "A mensagem tem mais que 160 caracteres";
            if ("NO_ACCESS".Equals(error))
                return "Falta a chave da API ou faltam permissões de acesso à lista";
            if ("BIRTH_DATE_REQUIRED".Equals(error))
                return "Falta a data de nascimento";
            if ("LIST_MISSING".Equals(error))
                return "Falta a lista de distribuição";
            if ("NO_MESSAGE".Equals(error))
                return "Falta a mensagem";
            if ("NO_PASSWORD".Equals(error))
                return "Falta a palavra-passe";
            if ("SUBSCRIBER_MISSING".Equals(error))
                return "Falta a referência do subscritor";
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
                return "Falta definir um campo de comparação";
            if ("NO_ZIP_FILE".Equals(error))
                return "Falta o arquivo ZIP com o conteúdo do e-mail";
            if ("NO_SUBJECT".Equals(error))
                return "Falta o assunto";
            if ("INVALID_FROM".Equals(error))
                return "Falta o código do remetente (ou está incorrecto) ou o remetente ainda não foi validado no E-goi";
            if ("NO_MESSAGE".Equals(error))
                return "Falta o conteúdo do e-mail a enviar (não foi fornecido por arquivo ZIP ou por URL)";
            if ("FAX_REQUIRED".Equals(error))
                return "Falta o fax";
            if ("NO_FAX_FILE".Equals(error))
                return "Falta o ficheiro com o fax";
            if ("NO_AUDIO_FILE".Equals(error))
                return "Falta o ficheiro de áudio";
            if ("NO_SUBJECT".Equals(error))
                return "Falta o nome da campanha";
            if ("NO_USERNAME".Equals(error))
                return "Falta o nome de utilizador";
            if ("NO_USERNAME_AND_PASSWORD".Equals(error))
                return "Falta o nome de utilizador e a palavra-passe";
            if ("NO_USERNAME".Equals(error))
                return "Falta o nome de usuário";
            if ("SEGMENT_NAME_MISSING".Equals(error))
                return "Falta o nome do segmento";
            if ("NO_CELLPHONE_OR_TELEPHONE".Equals(error))
                return "Falta o número de celular ou telefone";
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
                return "Não é possível adicionar mais subscritores porque foi atingido o limite";
            if ("SUBSCRIBER_DATA_CANNOT_BE_EDITED".Equals(error))
                return "Não é possível editar os dados do subscritor porque o subscritor já foi removido";
            if ("NO_SEGMENTS_FOUND".Equals(error))
                return "Não foi encontrado nenhum segmento";
            if ("INVALID_URL".Equals(error))
                return "Não foi possível carregar o conteúdo do URL";
            if ("NO_DATA_TO_INSERT".Equals(error))
                return "Não foram introduzidos quaisquer dados";
            if ("INVALID_FILE".Equals(error))
                return "O arquivo ZIP importado não é válido";
            if ("FILE_TOO_LARGE".Equals(error))
                return "O arquivo ZIP tem mais de 8 MB";
            if ("FIELD_NOT_FOUND".Equals(error))
                return "O campo extra não foi encontrado";
            if ("EXTRA_FIELD_XX_ALREADY_EXISTS".Equals(error))
                return "O campo extra X já existe na lista";
            if ("FAX_ALREADY_EXISTS".Equals(error))
                return "O fax introduzido já existe na lista";
            if ("INVALID_FILE".Equals(error))
                return "O ficheiro de áudio não é válido ou não se encontra no formato correcto";
            if ("FILE_TOO_LARGE".Equals(error))
                return "O ficheiro de fax tem mais que 8 MB";
            if ("INVALID".Equals(error))
                return "O nome de utilizador não é válido";
            if ("FIST_NAME_ALREADY_EXISTS".Equals(error))
                return "O primeiro nome introduzido já existe na lista";
            if ("SEGMENT_NOT_FOUND".Equals(error))
                return "O segmento da lista de distribuição não existe";
            if ("LAST_NAME_ALREADY_EXISTS".Equals(error))
                return "O sobrenome introduzido já existe na lista";
            if ("SUBSCRIBER_ALREADY_REMOVED".Equals(error))
                return "O subscritor já foi removido";
            if ("SUBSCRIBER_NOT_FOUND".Equals(error))
                return "O subscritor não existe";
            if ("TELEPHONE_ALREADY_EXISTS".Equals(error))
                return "O telefone introduzido já existe na lista";
            if ("INVALID_TYPE".Equals(error))
                return "O tipo de campo extra não é válido";
            if ("EMAIL_ALREADY_EXISTS".Equals(error))
                return "O e-mail introduzido já existe";
            if ("EMAIL_ADDRESS_INVALID_DOESNT_EXIST".Equals(error))
                return "O e-mail introduzido não existe";
            if ("EMAIL_ADDRESS_INVALID".Equals(error))
                return "O e-mail introduzido tem um erro de sintaxe";
            if ("EMAIL_ADDRESS_INVALID_MX_ERROR".Equals(error))
                return "O e-mail introduzido tem um erro nos registos MX";
            if ("INTERNAL_ERROR".Equals(error))
                return "Ocorreu um problema no servidor";
            if ("NO_USERNAME_AND_PASSWORD_AND_APIKEY".Equals(error))
                return "Não foi especificado nenhum utilizador/password ou apikey";
            return "Erro Desconhecido";
        }
    }

}