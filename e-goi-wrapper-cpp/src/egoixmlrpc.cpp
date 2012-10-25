#include "egoixmlrpc.h"

#include <exception>
#include <vector>
#include <xmlrpc-c/base.h>
#include <xmlrpc-c/client_simple.hpp>

std::string xmlRpcTypeToString(xmlrpc_c::value::type_t type) {
    switch(type) {
        case xmlrpc_c::value::TYPE_INT: return "TYPE_INT";
        case xmlrpc_c::value::TYPE_BOOLEAN: return "TYPE_BOOLEAN";
        case xmlrpc_c::value::TYPE_DOUBLE: return "TYPE_DOUBLE";
        case xmlrpc_c::value::TYPE_DATETIME: return "TYPE_DATETIME";
        case xmlrpc_c::value::TYPE_STRING: return "TYPE_STRING";
        case xmlrpc_c::value::TYPE_BYTESTRING: return "TYPE_BYTESTRING";
        case xmlrpc_c::value::TYPE_ARRAY: return "TYPE_ARRAY";
        case xmlrpc_c::value::TYPE_STRUCT: return "TYPE_STRUCT";
        case xmlrpc_c::value::TYPE_C_PTR: return "TYPE_C_PTR";
        case xmlrpc_c::value::TYPE_NIL: return "TYPE_NIL";
        case xmlrpc_c::value::TYPE_I8: return "TYPE_I8";
        case xmlrpc_c::value::TYPE_DEAD: return "TYPE_DEAD";
        default:
            return "Unknown XmlRpc Type";
    }
}

EgoiApiXmlRpcImpl::EgoiApiXmlRpcImpl()
    : m_client(new xmlrpc_c::clientSimple())
{
}

xmlrpc_c::paramList EgoiApiXmlRpcImpl::createParamList(EgoiMap & functionOptions) const {
    xmlrpc_c::paramList params;

    std::map<std::string, xmlrpc_c::value> map;

    EgoiMap::iterator it;

    for(it = functionOptions.begin(); it != functionOptions.end(); it++) {
        std::string key = (*it).first;
        EgoiValue * value = (*it).second;
        switch(value->egoiType()) {
            // String
            case EgoiValue::EGOI_TYPE_STRING:
                map[key] = toString(value->asString());
            break;

            // Map
            case EgoiValue::EGOI_TYPE_MAP:
                map[key] = toStruct(value->asMap());
            break;

            // List
            case EgoiValue::EGOI_TYPE_MAP_LIST:
                map[key] = toArray(value->asMapList());
            break;
        }
    }

    xmlrpc_c::value_struct options(map);
    params.add(options);

    return params;
}

EgoiMap EgoiApiXmlRpcImpl::toMap(const xmlrpc_c::value & value) const {

    // MUST BE A STRUCT
    if(value.type() != xmlrpc_c::value::TYPE_STRUCT)
        throw EgoiException("Unexpected value type: " + xmlRpcTypeToString(value.type()));

    std::map<std::string, xmlrpc_c::value> v(static_cast<xmlrpc_c::value_struct>(value));

    EgoiMap map;

    std::map<std::string, xmlrpc_c::value>::iterator it;
    for(it = v.begin(); it != v.end(); it++) {
        std::string _k = (*it).first;
        xmlrpc_c::value _v = (*it).second;

        // String
        if(_v.type() == xmlrpc_c::value::TYPE_STRING) {
            std::string _s = static_cast<xmlrpc_c::value_string>(_v).crlfValue();
            map[_k] = new EgoiString(_s);
        }

        // Struct
        if(_v.type() == xmlrpc_c::value::TYPE_STRUCT) {
            map[_k] = new EgoiMap(toMap(_v));
        }

        // Array
        if(_v.type() == xmlrpc_c::value::TYPE_ARRAY) {
            map[_k] = new EgoiMapList(toMapList(_v));
        }

    }

    return map;
}

EgoiMapList EgoiApiXmlRpcImpl::toMapList(const xmlrpc_c::value & value) const {

    // MUST BE AN ARRAY
    if(value.type() != xmlrpc_c::value::TYPE_ARRAY)
        throw EgoiException("Unexpected value type: " + xmlRpcTypeToString(value.type()));

    std::vector<xmlrpc_c::value> v = static_cast<xmlrpc_c::value_array>(value).vectorValueValue();
    std::vector<xmlrpc_c::value>::iterator it;

    EgoiMapList list;

    for(it=v.begin(); it!=v.end(); it++) {
        xmlrpc_c::value _v = (*it);

        // std::cout << "Found type "  << xmlRpcTypeToString(_v.type()) << std::endl;

        // String
        if(_v.type() == xmlrpc_c::value::TYPE_STRING) {
            std::string _s = static_cast<xmlrpc_c::value_string>(_v).crlfValue();
            list << new EgoiString(_s);
        }

        // Struct
        if(_v.type() == xmlrpc_c::value::TYPE_STRUCT) {
            list << new EgoiMap(toMap(_v));
        }

        // Array
        if(_v.type() == xmlrpc_c::value::TYPE_ARRAY) {
            list << new EgoiMapList(toMapList(_v));
        }

    }

    return list;
}

xmlrpc_c::value_struct EgoiApiXmlRpcImpl::toStruct(EgoiMap * value) const
{
    std::map<std::string, xmlrpc_c::value> map;

    EgoiMap::iterator it;
    for(it=value->begin(); it!=value->end(); it++) {
        std::string key = (*it).first;
        EgoiValue * value = (*it).second;

        switch(value->egoiType()) {
            // String
            case EgoiValue::EGOI_TYPE_STRING:
                map[key] = toString(value->asString());
            break;

            // Map
            case EgoiValue::EGOI_TYPE_MAP:
                map[key] = toStruct(value->asMap());
            break;

            // List
            case EgoiValue::EGOI_TYPE_MAP_LIST:
                map[key] = toArray(value->asMapList());
            break;

        }
    }

    return xmlrpc_c::value_struct(map);
}

xmlrpc_c::value_array EgoiApiXmlRpcImpl::toArray(EgoiMapList * value) const
{
    std::vector<xmlrpc_c::value> vector;

    EgoiMapList::iterator it;

    for(it=value->begin(); it!=value->end(); it++) {
        EgoiValue * value = (*it);

        switch(value->egoiType()) {
            // String
            case EgoiValue::EGOI_TYPE_STRING:
                vector.push_back(toString(value->asString()));
            break;

            // Map
            case EgoiValue::EGOI_TYPE_MAP:
                vector.push_back(toStruct(value->asMap()));
            break;

            // List
            case EgoiValue::EGOI_TYPE_MAP_LIST:
                vector.push_back(toArray(value->asMapList()));
            break;

        }
    }

    return xmlrpc_c::value_array(vector);
}

xmlrpc_c::value_string EgoiApiXmlRpcImpl::toString(EgoiString * value) const
{
    return xmlrpc_c::value_string(value->value());
}

void EgoiApiXmlRpcImpl::checkError(const std::string & fname, xmlrpc_c::value &v) const
{
    if(v.type() == xmlrpc_c::value::TYPE_STRING) { // Ocorreu um erro
        std::string error = xmlrpc_c::value_string(v).crlfValue();
        std::string r("An error occurred invoking '");
        r.append(fname).append("': ");
        r.append(Egoi::decodeError(error));
        throw EgoiException(r);
    }
}

EgoiMap EgoiApiXmlRpcImpl::getUserData(EgoiMap & functionOptions) const
{
    xmlrpc_c::value v;
    std::string fname = "getUserData";
    m_client->call(XMLRPC_SERVER_URL, fname, createParamList(functionOptions), &v);
    checkError(fname, v);
    return toMap(v);
}

EgoiMapList EgoiApiXmlRpcImpl::getLists(EgoiMap & functionOptions) const
{
    xmlrpc_c::value v;
    std::string fname = "getLists";
    m_client->call(XMLRPC_SERVER_URL, fname, createParamList(functionOptions), &v);
    checkError(fname, v);
    return toMapList(v);
}

