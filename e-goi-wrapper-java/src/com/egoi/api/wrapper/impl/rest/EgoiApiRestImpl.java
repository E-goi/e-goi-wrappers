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

    //NEW STUFF
    @Override
    public EgoiMapList getAutobots(EgoiMap arguments) throws EgoiException {
        return decodeResult("getAutobots", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMap startAutobot(EgoiMap arguments) throws EgoiException {
        return decodeResult("startAutobot", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap createCampaignGroup(EgoiMap arguments) throws EgoiException {
        return decodeResult("createCampaignGroup", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap editCampaignGroup(EgoiMap arguments) throws EgoiException {
        return decodeResult("editCampaignGroup", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMapList getHeaderFooterTemplates(EgoiMap arguments) throws EgoiException {
        return decodeResult("getHeaderFooterTemplates", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMapList getTemplates(EgoiMap arguments) throws EgoiException {
        return decodeResult("getTemplates", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMap editApiCallback(EgoiMap arguments) throws EgoiException {
        return decodeResult("editApiCallback", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMapList getOperationsQueue(EgoiMap arguments) throws EgoiException {
        return decodeResult("getOperationsQueue", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMapList getForms(EgoiMap arguments) throws EgoiException {
        return decodeResult("getForms", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMapList getFormsSubmissions(EgoiMap arguments) throws EgoiException {
        return decodeResult("getFormsSubmissions", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMap deleteExtraField(EgoiMap arguments) throws EgoiException {
        return decodeResult("deleteExtraField", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMapList getextrafields(EgoiMap arguments) throws EgoiException {
        return decodeResult("getextrafields", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMap generateAdvancedReport(EgoiMap arguments) throws EgoiException {
        return decodeResult("generateAdvancedReport", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMapList getAdvancedReport(EgoiMap arguments) throws EgoiException {
        return decodeResult("getAdvancedReport", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMap createSegmentAdvanced(EgoiMap arguments) throws EgoiException {
        return decodeResult("createSegmentAdvanced", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap addCname(EgoiMap arguments) throws EgoiException {
        return decodeResult("addCname", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap addSender(EgoiMap arguments) throws EgoiException {
        return decodeResult("addSender", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap deleteSender(EgoiMap arguments) throws EgoiException {
        return decodeResult("deleteSender", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap editSender(EgoiMap arguments) throws EgoiException {
        return decodeResult("editSender", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMapList getSubscriberActivity(EgoiMap arguments) throws EgoiException {
        return decodeResult("getSubscriberActivity", arguments, EgoiMapList.class);
    }

    @Override
    public EgoiMap addTag(EgoiMap arguments) throws EgoiException {
        return decodeResult("addTag", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap attachTag(EgoiMap arguments) throws EgoiException {
        return decodeResult("attachTag", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap deleteTag(EgoiMap arguments) throws EgoiException {
        return decodeResult("deleteTag", arguments, EgoiMap.class);
    }

    @Override
    public EgoiMap detachTag(EgoiMap arguments) throws EgoiException {
        return decodeResult("detachTag", arguments, EgoiMap.class);
    }
    
    @Override
    public EgoiMapList getTags(EgoiMap arguments) throws EgoiException {
        return decodeResult("getTags", arguments, EgoiMapList.class);
    }
}
