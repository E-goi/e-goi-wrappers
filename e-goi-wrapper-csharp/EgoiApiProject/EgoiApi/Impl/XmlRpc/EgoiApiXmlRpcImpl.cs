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
                else
                    // convert to string
                    ret[k] = value.ToString();


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

                    if(value is int)
                        map[k] = value as int?;

                    if (value is double)
                        map[k] = value as double?;

                    if (value is float)
                        map[k] = value as float?;

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
            else if (result is object[]) // occurs when response is empty
                return new EgoiMapList();
            else
                throw new EgoiException("The response is of unexpected type: " + result + ", expecting XmlRpcStruct[]");
        }

        ////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////

        public EgoiMap addExtraField(EgoiMap arguments)
        {
            return decodeResultMap(proxy.addExtraField(encodeMap(arguments)));
        }

        public EgoiMap addSubscriber(EgoiMap arguments)
        {
            return decodeResultMap(proxy.addSubscriber(encodeMap(arguments)));
        }

        public EgoiMap addSubscriberBulk(EgoiMap arguments)
        {
            return decodeResultMap(proxy.addSubscriberBulk(encodeMap(arguments)));
        }

        public EgoiMap checklogin(EgoiMap arguments)
        {
            return decodeResultMap(proxy.checklogin(encodeMap(arguments)));
        }

        public EgoiMap createCampaignEmail(EgoiMap arguments)
        {
            return decodeResultMap(proxy.createCampaignEmail(encodeMap(arguments)));
        }

        public EgoiMap createCampaignFAX(EgoiMap arguments)
        {
            return decodeResultMap(proxy.createCampaignFAX(encodeMap(arguments)));
        }

        public EgoiMap createCampaignSMS(EgoiMap arguments)
        {
            return decodeResultMap(proxy.createCampaignSMS(encodeMap(arguments)));
        }

        public EgoiMap createCampaignVoice(EgoiMap arguments)
        {
            return decodeResultMap(proxy.createCampaignVoice(encodeMap(arguments)));
        }

        public EgoiMap createList(EgoiMap arguments)
        {
            return decodeResultMap(proxy.createList(encodeMap(arguments)));
        }

        public EgoiMap createSegment(EgoiMap arguments)
        {
            return decodeResultMap(proxy.createSegment(encodeMap(arguments)));
        }

        public EgoiMap deleteCampaign(EgoiMap arguments)
        {
            return decodeResultMap(proxy.deleteCampaign(encodeMap(arguments)));
        }

        public EgoiMap deleteSegment(EgoiMap arguments)
        {
            return decodeResultMap(proxy.deleteSegment(encodeMap(arguments)));
        }

        public EgoiMap editCampaignEmail(EgoiMap arguments)
        {
            return decodeResultMap(proxy.editCampaignEmail(encodeMap(arguments)));
        }

        public EgoiMap editCampaignSMS(EgoiMap arguments)
        {
            return decodeResultMap(proxy.editCampaignSMS(encodeMap(arguments)));
        }

        public EgoiMap editExtraField(EgoiMap arguments)
        {
            return decodeResultMap(proxy.editExtraField(encodeMap(arguments)));
        }

        public EgoiMap editSubscriber(EgoiMap arguments)
        {
            return decodeResultMap(proxy.editSubscriber(encodeMap(arguments)));
        }

        public EgoiMapList getCampaigns(EgoiMap arguments)
        {
            return decodeResultMapList(proxy.getCampaigns(encodeMap(arguments)));
        }

        public EgoiMap getClientData(EgoiMap arguments)
        {
            return decodeResultMap(proxy.getClientData(encodeMap(arguments)));
        }

        public EgoiMap getCredits(EgoiMap arguments)
        {
            return decodeResultMap(proxy.getCredits(encodeMap(arguments)));
        }

        public EgoiMapList getLists(EgoiMap arguments)
        {
            return decodeResultMapList(proxy.getLists(encodeMap(arguments)));
        }

        public EgoiMap getReport(EgoiMap arguments)
        {
            return decodeResultMap(proxy.getReport(encodeMap(arguments)));
        }

        public EgoiMapList getSegments(EgoiMap arguments)
        {
            return decodeResultMapList(proxy.getSegments(encodeMap(arguments)));
        }

        public EgoiMapList getSenders(EgoiMap arguments)
        {
            return decodeResultMapList(proxy.getSenders(encodeMap(arguments)));
        }

        public EgoiMap getUserData(EgoiMap arguments)
        {
            return decodeResultMap(proxy.getUserData(encodeMap(arguments)));
        }

        public EgoiMap removeSubscriber(EgoiMap arguments)
        {
            return decodeResultMap(proxy.removeSubscriber(encodeMap(arguments)));
        }

        public EgoiMap sendCall(EgoiMap arguments)
        {
            return decodeResultMap(proxy.sendCall(encodeMap(arguments)));
        }

        public EgoiMap sendEmail(EgoiMap arguments)
        {
            return decodeResultMap(proxy.sendEmail(encodeMap(arguments)));
        }

        public EgoiMap sendFAX(EgoiMap arguments)
        {
            return decodeResultMap(proxy.sendFAX(encodeMap(arguments)));
        }

        public EgoiMap sendSMS(EgoiMap arguments)
        {
            return decodeResultMap(proxy.sendSMS(encodeMap(arguments)));
        }

        public EgoiMap subscriberData(EgoiMap arguments)
        {
            return decodeResultMap(proxy.subscriberData(encodeMap(arguments)));
        }

        public EgoiMap updateList(EgoiMap arguments)
        {
            return decodeResultMap(proxy.updateList(encodeMap(arguments)));
        }

    }
}
