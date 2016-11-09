package com.egoi.api.wrapper.impl.xmlrpc;

import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.api.exceptions.EgoiException;

public class EgoiApiXmlRpcImpl extends AbstractXmlRpcEgoiApi {

	private static final String ServiceUrl = "http://api.e-goi.com/v2/xmlrpc.php";

	public EgoiApiXmlRpcImpl() throws EgoiException {
		super(ServiceUrl);
	}

	@Override
	public EgoiMap addExtraField(EgoiMap arguments) throws EgoiException {
		return processRequest("addExtraField", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap addSubscriber(EgoiMap arguments) throws EgoiException {
		return processRequest("addSubscriber", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap addSubscriberBulk(EgoiMap arguments) throws EgoiException {
		return processRequest("addSubscriberBulk", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap getUserData(EgoiMap arguments) throws EgoiException {
		return processRequest("getUserData", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMapList getLists(EgoiMap arguments) throws EgoiException {
		return processRequest("getLists", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMap checklogin(EgoiMap arguments) throws EgoiException {
		return processRequest("checklogin", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignEmail(EgoiMap arguments) throws EgoiException {
		return processRequest("createCampaignEmail", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignFAX(EgoiMap arguments) throws EgoiException {
		return processRequest("createCampaignFAX", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignSMS(EgoiMap arguments) throws EgoiException {
		return processRequest("createCampaignSMS", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignVoice(EgoiMap arguments) throws EgoiException {
		return processRequest("createCampaignVoice", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createList(EgoiMap arguments) throws EgoiException {
		return processRequest("createList", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createSegment(EgoiMap arguments) throws EgoiException {
		return processRequest("createSegment", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap deleteCampaign(EgoiMap arguments) throws EgoiException {
		return processRequest("deleteCampaign", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap deleteList(EgoiMap arguments) throws EgoiException {
		return processRequest("deleteList", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap deleteSegment(EgoiMap arguments) throws EgoiException {
		return processRequest("deleteSegment", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editCampaignEmail(EgoiMap arguments) throws EgoiException {
		return processRequest("editCampaignEmail", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editCampaignSMS(EgoiMap arguments) throws EgoiException {
		return processRequest("editCampaignSMS", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editExtraField(EgoiMap arguments) throws EgoiException {
		return processRequest("editExtraField", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editSubscriber(EgoiMap arguments) throws EgoiException {
		return processRequest("editSubscriber", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMapList getCampaigns(EgoiMap arguments) throws EgoiException {
		return processRequest("getCampaigns", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMap getClientData(EgoiMap arguments) throws EgoiException {
		return processRequest("getClientData", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap getCredits(EgoiMap arguments) throws EgoiException {
		return processRequest("getCredits", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap getReport(EgoiMap arguments) throws EgoiException {
		return processRequest("getReport", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMapList getSegments(EgoiMap arguments) throws EgoiException {
		return processRequest("getSegments", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMapList getSenders(EgoiMap arguments) throws EgoiException {
		return processRequest("getSenders", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMap removeSubscriber(EgoiMap arguments) throws EgoiException {
		return processRequest("removeSubscriber", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendCall(EgoiMap arguments) throws EgoiException {
		return processRequest("sendCall", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendEmail(EgoiMap arguments) throws EgoiException {
		return processRequest("sendEmail", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendFAX(EgoiMap arguments) throws EgoiException {
		return processRequest("sendFAX", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendSMS(EgoiMap arguments) throws EgoiException {
		return processRequest("sendSMS", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap subscriberData(EgoiMap arguments) throws EgoiException {
		return processRequest("subscriberData", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap updateList(EgoiMap arguments) throws EgoiException {
		return processRequest("updateList", arguments, EgoiMap.class);
	}

}
