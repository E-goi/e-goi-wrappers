package com.egoi.api.wrapper.impl.rest;

import com.egoi.api.wrapper.api.EgoiMap;
import com.egoi.api.wrapper.api.EgoiMapList;
import com.egoi.api.wrapper.api.exceptions.EgoiException;

public class EgoiApiRestImpl extends AbstractRestEgoiApi {

	private static final String ServiceUrl = "http://api.e-goi.com/v2/rest.php?type=json";

	public EgoiApiRestImpl() {
		super(ServiceUrl);
	}

//	private static final Logger log = LoggerFactory.getLogger(EgoiApiRestImpl.class);

	@Override
	public EgoiMap addExtraField(EgoiMap arguments) throws EgoiException {
		return decodeResult("addExtraField", arguments, EgoiMap.class);
	}
	
	@Override
	public EgoiMap getUserData(EgoiMap arguments) throws EgoiException {
		return decodeResult("getUserData", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMapList getLists(EgoiMap arguments) throws EgoiException {
		return decodeResult("getLists", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMap addSubscriber(EgoiMap arguments) throws EgoiException {
		return decodeResult("addSubscriber", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap addSubscriberBulk(EgoiMap arguments) throws EgoiException {
		return decodeResult("addSubscriberBulk", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap checklogin(EgoiMap arguments) throws EgoiException {
		return decodeResult("checklogin", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignEmail(EgoiMap arguments) throws EgoiException {
		return decodeResult("createCampaignEmail", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignFAX(EgoiMap arguments) throws EgoiException {
		return decodeResult("createCampaignFAX", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignSMS(EgoiMap arguments) throws EgoiException {
		return decodeResult("createCampaignSMS", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createCampaignVoice(EgoiMap arguments) throws EgoiException {
		return decodeResult("createCampaignVoice", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createList(EgoiMap arguments) throws EgoiException {
		return decodeResult("createList", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap createSegment(EgoiMap arguments) throws EgoiException {
		return decodeResult("createSegment", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap deleteCampaign(EgoiMap arguments) throws EgoiException {
		return decodeResult("deleteCampaign", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap deleteList(EgoiMap arguments) throws EgoiException {
		return decodeResult("deleteList", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap deleteSegment(EgoiMap arguments) throws EgoiException {
		return decodeResult("deleteSegment", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editCampaignEmail(EgoiMap arguments) throws EgoiException {
		return decodeResult("editCampaignEmail", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editCampaignSMS(EgoiMap arguments) throws EgoiException {
		return decodeResult("editCampaignSMS", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editExtraField(EgoiMap arguments) throws EgoiException {
		return decodeResult("editExtraField", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap editSubscriber(EgoiMap arguments) throws EgoiException {
		return decodeResult("editSubscriber", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMapList getCampaigns(EgoiMap arguments) throws EgoiException {
		return decodeResult("getCampaigns", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMap getClientData(EgoiMap arguments) throws EgoiException {
		return decodeResult("getCampaigns", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap getCredits(EgoiMap arguments) throws EgoiException {
		return decodeResult("getCredits", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap getReport(EgoiMap arguments) throws EgoiException {
		return decodeResult("getReport", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMapList getSegments(EgoiMap arguments) throws EgoiException {
		return decodeResult("getSegments", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMapList getSenders(EgoiMap arguments) throws EgoiException {
		return decodeResult("getSenders", arguments, EgoiMapList.class);
	}

	@Override
	public EgoiMap removeSubscriber(EgoiMap arguments) throws EgoiException {
		return decodeResult("removeSubscriber", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendCall(EgoiMap arguments) throws EgoiException {
		return decodeResult("sendCall", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendEmail(EgoiMap arguments) throws EgoiException {
		return decodeResult("sendEmail", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendFAX(EgoiMap arguments) throws EgoiException {
		return decodeResult("sendFAX", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap sendSMS(EgoiMap arguments) throws EgoiException {
		return decodeResult("sendSMS", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap subscriberData(EgoiMap arguments) throws EgoiException {
		return decodeResult("subscriberData", arguments, EgoiMap.class);
	}

	@Override
	public EgoiMap updateList(EgoiMap arguments) throws EgoiException {
		return decodeResult("updateList", arguments, EgoiMap.class);
	}

}
