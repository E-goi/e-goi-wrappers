
namespace Egoi
{
    public interface EgoiApi
    {

        EgoiMap addExtraField(EgoiMap arguments);

        EgoiMap addSubscriber(EgoiMap arguments);

        EgoiMap addSubscriberBulk(EgoiMap arguments);

        EgoiMap checklogin(EgoiMap arguments);

        EgoiMap createCampaignEmail(EgoiMap arguments);

        EgoiMap createCampaignFAX(EgoiMap arguments);

        EgoiMap createCampaignSMS(EgoiMap arguments);

        EgoiMap createCampaignVoice(EgoiMap arguments);

        EgoiMap createList(EgoiMap arguments);

        EgoiMap createSegment(EgoiMap arguments);

        EgoiMap deleteCampaign(EgoiMap arguments);

        EgoiMap deleteSegment(EgoiMap arguments);

        EgoiMap editCampaignEmail(EgoiMap arguments);

        EgoiMap editCampaignSMS(EgoiMap arguments);

        EgoiMap editExtraField(EgoiMap arguments);

        EgoiMap editSubscriber(EgoiMap arguments);

        EgoiMapList getCampaigns(EgoiMap arguments);

        EgoiMap getClientData(EgoiMap arguments);

        EgoiMap getCredits(EgoiMap arguments);

        EgoiMapList getLists(EgoiMap arguments);

        EgoiMap getReport(EgoiMap arguments);

        EgoiMapList getSegments(EgoiMap arguments);

        EgoiMapList getSenders(EgoiMap arguments);

        EgoiMap getUserData(EgoiMap arguments);

        EgoiMap removeSubscriber(EgoiMap arguments);

        EgoiMap sendCall(EgoiMap arguments);

        EgoiMap sendEmail(EgoiMap arguments);

        EgoiMap sendFAX(EgoiMap arguments);

        EgoiMap sendSMS(EgoiMap arguments);

        EgoiMap subscriberData(EgoiMap arguments);

        EgoiMap updateList(EgoiMap arguments);

    }
}
