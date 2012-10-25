#pragma once

#include "egoi.h"

#define XMLRPC_SERVER_URL  "http://api.e-goi.com/v2/xmlrpc.php"

namespace xmlrpc_c {
    class clientSimple;
    class paramList;
    class value;
    class value_struct;
    class value_array;
    class value_string;
}

class EgoiApiXmlRpcImpl : public EgoiApi {
    public:

        EgoiApiXmlRpcImpl();

        EgoiMap getUserData(EgoiMap & functionOptions) const;
        EgoiMapList getLists(EgoiMap &functionOptions) const;

        xmlrpc_c::clientSimple * m_client;

    private:
        xmlrpc_c::paramList createParamList(EgoiMap & map) const;

        EgoiMap toMap(const xmlrpc_c::value & value) const;
        EgoiMapList toMapList(const xmlrpc_c::value & value) const;

        xmlrpc_c::value_struct toStruct(EgoiMap * value) const;
        xmlrpc_c::value_array toArray(EgoiMapList * value) const;
        xmlrpc_c::value_string toString(EgoiString * value) const;

        void checkError(const std::string & fname, xmlrpc_c::value & v) const;
};

