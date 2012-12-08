using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CookComputing.XmlRpc;

namespace Egoi
{
    public class EgoiApiXmlRpcImpl : EgoiApi
    {

        private static EgoiApi instance;

        private EgoiApiXmlRpcProxy proxy;

        private EgoiApiXmlRpcImpl() {
            proxy = XmlRpcProxyGen.Create<EgoiApiXmlRpcProxy>();
        }

        public static EgoiApi getInstance()
        {
            if (instance == null)
                instance = new EgoiApiXmlRpcImpl();
            return instance;
        }

        private XmlRpcStruct[] encodeMapList(EgoiMapList list)
        {
            List<XmlRpcStruct> slist = new List<XmlRpcStruct>();

            foreach (EgoiMap map in list)
                slist.Add(encodeMap(map));

            return slist.ToArray<XmlRpcStruct>();
        }

        private XmlRpcStruct encodeMap(EgoiMap map)
        {
            XmlRpcStruct ret = new XmlRpcStruct();
            foreach (String k in map.Keys)
            {
                object value = map[k];
                if (value is string)
                    ret[k] = value;

                else if (value is EgoiMap)
                    ret[k] = encodeMap(value as EgoiMap);

                else if (value is EgoiMapList)
                    ret[k] = encodeMapList(value as EgoiMapList);

                // ignore other types

            }
            return ret;
        }

        private void checkResult(object result)
        {
            if (result == null)
                throw new EgoiException("The response from the server was null");

            if (result is string)
                throw new EgoiException(EgoiException.idToMessage(result as string));
        }

        private EgoiMap decodeMap(XmlRpcStruct result)
        {
            EgoiMap map = new EgoiMap();
            foreach (object _k in result.Keys)
            {
                if (_k is string)
                {
                    string k = _k as string;
                    object value = result[_k];
                    if (value is string)
                        map[k] = value as string;

                    if (value is XmlRpcStruct)
                        map[k] = decodeMap(value as XmlRpcStruct);

                    if (value is XmlRpcStruct[])
                        map[k] = decodeMapList(value as XmlRpcStruct[]);

                }
            }

            return map;
        }

        private EgoiMap decodeResultMap(object result)
        {
            checkResult(result);

            if (result is XmlRpcStruct)
                return decodeMap(result as XmlRpcStruct);
            else
                throw new EgoiException("The response is of unexpected type: " + result + ", expecting XmlRpcStruct");
        }

        private EgoiMapList decodeMapList(XmlRpcStruct[] result)
        {
            EgoiMapList list = new EgoiMapList();
            foreach (XmlRpcStruct value in result)
                list.Add(decodeMap(value));
            return list;
        }

        private EgoiMapList decodeResultMapList(object result)
        {
            checkResult(result);

            if (result is XmlRpcStruct[])
                return decodeMapList(result as XmlRpcStruct[]);
            else
                throw new EgoiException("The response is of unexpected type: " + result + ", expecting XmlRpcStruct[]");
        }

        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////

        public EgoiMapList getLists(EgoiMap arguments)
        {
            return decodeResultMapList(proxy.getLists(encodeMap(arguments)));
        }

        public EgoiMap getUserData(EgoiMap arguments)
        {
            return decodeResultMap(proxy.getUserData(encodeMap(arguments)));
        }

    }
}
