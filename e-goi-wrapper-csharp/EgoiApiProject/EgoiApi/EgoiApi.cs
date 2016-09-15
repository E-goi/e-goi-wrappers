
namespace Egoi
{
    public interface EgoiApi
    {
        #region API Methods

        #region API Methods - Accounts
        EgoiMap checklogin(EgoiMap arguments);

        EgoiMap getClientData(EgoiMap arguments);

        EgoiMap getCredits(EgoiMap arguments);

        EgoiMap getUserData(EgoiMap arguments);
        #endregion

        #region API Methods - Automations
        EgoiMapList getAutobots(EgoiMap arguments);

        EgoiMap startAutobot(EgoiMap arguments);
        #endregion

        #region API Methods - Campaigns
        EgoiMap createCampaignEmail(EgoiMap arguments);

        EgoiMap createCampaignFAX(EgoiMap arguments);

        EgoiMap createCampaignGroup(EgoiMap arguments);

        EgoiMap createCampaignSMS(EgoiMap arguments);

        EgoiMap createCampaignVoice(EgoiMap arguments);

        EgoiMap deleteCampaign(EgoiMap arguments);

        EgoiMap editCampaignEmail(EgoiMap arguments);

        EgoiMap editCampaignGroup(EgoiMap arguments);

        EgoiMap editCampaignSMS(EgoiMap arguments);

        EgoiMapList getCampaigns(EgoiMap arguments);

        EgoiMapList getHeaderFooterTemplates(EgoiMap arguments);

        EgoiMapList getTemplates(EgoiMap arguments);

        EgoiMap sendCall(EgoiMap arguments);

        EgoiMap sendEmail(EgoiMap arguments);

        EgoiMap sendFAX(EgoiMap arguments);

        EgoiMap sendSMS(EgoiMap arguments);
        #endregion

        #region API Methods - Common
        EgoiMap editApiCallback(EgoiMap arguments);

        EgoiMapList getOperationsQueue(EgoiMap arguments);
        #endregion

        #region API Methods - Forms
        EgoiMapList getForms(EgoiMap arguments);

        EgoiMapList getFormsSubmissions(EgoiMap arguments);
        #endregion

        #region API Methods - Lists
        EgoiMap addExtraField(EgoiMap arguments);

        EgoiMap createList(EgoiMap arguments);

        EgoiMap deleteExtraField(EgoiMap arguments);

        EgoiMap deleteList(EgoiMap arguments);

        EgoiMap editExtraField(EgoiMap arguments);

        EgoiMapList getExtraFields(EgoiMap arguments);

        EgoiMapList getLists(EgoiMap arguments);

        EgoiMap updateList(EgoiMap arguments);
        #endregion

        #region API Methods - Reports
        EgoiMap generateAdvancedReport(EgoiMap arguments);

        EgoiMapList getAdvancedReport(EgoiMap arguments);

        EgoiMap getReport(EgoiMap arguments);
        #endregion

        #region API Methods - Segments
        EgoiMap createSegment(EgoiMap arguments);

        EgoiMap createSegmentAdvanced(EgoiMap arguments);

        EgoiMap deleteSegment(EgoiMap arguments);

        EgoiMapList getSegments(EgoiMap arguments);
        #endregion

        #region API Methods - Senders
        EgoiMap addCname(EgoiMap arguments);

        EgoiMap addSender(EgoiMap arguments);

        EgoiMap deleteSender(EgoiMap arguments);

        EgoiMap editSender(EgoiMap arguments);

        EgoiMapList getSenders(EgoiMap arguments);
        #endregion

        #region API Methods - Subscribers
        EgoiMap addSubscriber(EgoiMap arguments);

        EgoiMap addSubscriberBulk(EgoiMap arguments);

        EgoiMap editSubscriber(EgoiMap arguments);

        EgoiMap editSubscriberActivity(EgoiMap arguments);
        EgoiMap removeSubscriber(EgoiMap arguments);

        EgoiMap subscriberData(EgoiMap arguments);
        #endregion

        #region API Methods - Tags
        EgoiMap addTag(EgoiMap arguments);

        EgoiMap attachTag(EgoiMap arguments);

        EgoiMap deleteTag(EgoiMap arguments);

        EgoiMap detachTag(EgoiMap arguments);

        EgoiMapList getTags(EgoiMap arguments);
        #endregion

        #endregion
    }
}
