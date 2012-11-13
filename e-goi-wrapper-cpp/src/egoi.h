#pragma once

#include <map>
#include <string>

#include "egoimap.h"

class EgoiException : public std::exception
{
	public:
		EgoiException(std::string message) : m_error(message) {

		}

		virtual ~EgoiException() throw() {}

		const char* what() const throw() { return m_error.c_str(); }

	private:
		std::string m_error;

};


class EgoiApi {

	public:
		virtual EgoiMap addExtraField(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap addSubscriber(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap addSubscriberBulk(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap checklogin(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap createCampaignEmail(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap createCampaignFAX(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap createCampaignSMS(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap createCampaignVoice(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap createList(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap createSegment(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap deleteCampaign(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap deleteSegment(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap editCampaignEmail(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap editCampaignSMS(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap editExtraField(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap editSubscriber(EgoiMap & functionOptions) const = 0;
		virtual EgoiMapList getCampaigns(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap getClientData(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap getCredits(EgoiMap & functionOptions) const = 0;
		virtual EgoiMapList getLists(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap getReport(EgoiMap & functionOptions) const = 0;
		virtual EgoiMapList getSegments(EgoiMap & functionOptions) const = 0;
		virtual EgoiMapList getSenders(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap getUserData(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap removeSubscriber(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap sendCall(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap sendEmail(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap sendFAX(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap sendSMS(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap subscriberData(EgoiMap & functionOptions) const = 0;
		virtual EgoiMap updateList(EgoiMap & functionOptions) const = 0;

};


class Egoi
{

	Egoi();

	public:

		static EgoiApi * getApi();

		static std::string decodeError(std::string error);

};
