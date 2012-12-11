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

		EgoiMap addExtraField(EgoiMap & functionOptions) const;
		EgoiMap addSubscriber(EgoiMap & functionOptions) const;
		EgoiMap addSubscriberBulk(EgoiMap & functionOptions) const;
		EgoiMap checklogin(EgoiMap & functionOptions) const;
		EgoiMap createCampaignEmail(EgoiMap & functionOptions) const;
		EgoiMap createCampaignFAX(EgoiMap & functionOptions) const;
		EgoiMap createCampaignSMS(EgoiMap & functionOptions) const;
		EgoiMap createCampaignVoice(EgoiMap & functionOptions) const;
		EgoiMap createList(EgoiMap & functionOptions) const;
		EgoiMap createSegment(EgoiMap & functionOptions) const;
		EgoiMap deleteCampaign(EgoiMap & functionOptions) const;
		EgoiMap deleteSegment(EgoiMap & functionOptions) const;
		EgoiMap editCampaignEmail(EgoiMap & functionOptions) const;
		EgoiMap editCampaignSMS(EgoiMap & functionOptions) const;
		EgoiMap editExtraField(EgoiMap & functionOptions) const;
		EgoiMap editSubscriber(EgoiMap & functionOptions) const;
		EgoiMapList getCampaigns(EgoiMap & functionOptions) const;
		EgoiMap getClientData(EgoiMap & functionOptions) const;
		EgoiMap getCredits(EgoiMap & functionOptions) const;
		EgoiMapList getLists(EgoiMap & functionOptions) const;
		EgoiMap getReport(EgoiMap & functionOptions) const;
		EgoiMapList getSegments(EgoiMap & functionOptions) const;
		EgoiMapList getSenders(EgoiMap & functionOptions) const;
		EgoiMap getUserData(EgoiMap & functionOptions) const;
		EgoiMap removeSubscriber(EgoiMap & functionOptions) const;
		EgoiMap sendCall(EgoiMap & functionOptions) const;
		EgoiMap sendEmail(EgoiMap & functionOptions) const;
		EgoiMap sendFAX(EgoiMap & functionOptions) const;
		EgoiMap sendSMS(EgoiMap & functionOptions) const;
		EgoiMap subscriberData(EgoiMap & functionOptions) const;
		EgoiMap updateList(EgoiMap & functionOptions) const;


		xmlrpc_c::clientSimple * m_client;

	private:
		xmlrpc_c::paramList createParamList(EgoiMap & map) const;

		EgoiMap toMap(const xmlrpc_c::value & value) const;
		EgoiMapList toMapList(const xmlrpc_c::value & value) const;

		xmlrpc_c::value_struct toStruct(EgoiMap * value) const;
		xmlrpc_c::value_array toArray(EgoiMapList * value) const;
		xmlrpc_c::value_string toString(EgoiString * value) const;

		void checkError(const std::string & fname, xmlrpc_c::value & v) const;

		EgoiMap invokeMap(const std::string & fname, EgoiMap & functionOptions) const;
		EgoiMapList invokeMapList(const std::string & fname, EgoiMap & functionOptions) const;
};

