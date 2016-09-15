using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CookComputing.XmlRpc;

namespace Egoi
{
    [XmlRpcUrl("http://api.e-goi.com/v2/xmlrpc.php")]
    public interface EgoiApiXmlRpcProxy : IXmlRpcProxy
    {
        [XmlRpcMethod("addExtraField")]
        object addExtraField(XmlRpcStruct o);

        [XmlRpcMethod("addSubscriber")]
        object addSubscriber(XmlRpcStruct o);

        [XmlRpcMethod("addSubscriberBulk")]
        object addSubscriberBulk(XmlRpcStruct o);

        [XmlRpcMethod("checklogin")]
        object checklogin(XmlRpcStruct o);

        [XmlRpcMethod("createCampaignEmail")]
        object createCampaignEmail(XmlRpcStruct o);

        [XmlRpcMethod("createCampaignFAX")]
        object createCampaignFAX(XmlRpcStruct o);

        [XmlRpcMethod("createCampaignSMS")]
        object createCampaignSMS(XmlRpcStruct o);

        [XmlRpcMethod("createCampaignVoice")]
        object createCampaignVoice(XmlRpcStruct o);

        [XmlRpcMethod("createList")]
        object createList(XmlRpcStruct o);

        [XmlRpcMethod("createSegment")]
        object createSegment(XmlRpcStruct o);

        [XmlRpcMethod("deleteCampaign")]
        object deleteCampaign(XmlRpcStruct o);

        [XmlRpcMethod("deleteSegment")]
        object deleteSegment(XmlRpcStruct o);

        [XmlRpcMethod("editCampaignEmail")]
        object editCampaignEmail(XmlRpcStruct o);

        [XmlRpcMethod("editCampaignSMS")]
        object editCampaignSMS(XmlRpcStruct o);

        [XmlRpcMethod("editExtraField")]
        object editExtraField(XmlRpcStruct o);

        [XmlRpcMethod("editSubscriber")]
        object editSubscriber(XmlRpcStruct o);

        [XmlRpcMethod("getCampaigns")]
        object getCampaigns(XmlRpcStruct o);

        [XmlRpcMethod("getClientData")]
        object getClientData(XmlRpcStruct o);

        [XmlRpcMethod("getCredits")]
        object getCredits(XmlRpcStruct o);

        [XmlRpcMethod("getLists")]
        object getLists(XmlRpcStruct o);

        [XmlRpcMethod("getReport")]
        object getReport(XmlRpcStruct o);

        [XmlRpcMethod("getSegments")]
        object getSegments(XmlRpcStruct o);

        [XmlRpcMethod("getSenders")]
        object getSenders(XmlRpcStruct o);

        [XmlRpcMethod("getUserData")]
        object getUserData(XmlRpcStruct o);

        [XmlRpcMethod("removeSubscriber")]
        object removeSubscriber(XmlRpcStruct o);

        [XmlRpcMethod("sendCall")]
        object sendCall(XmlRpcStruct o);

        [XmlRpcMethod("sendEmail")]
        object sendEmail(XmlRpcStruct o);

        [XmlRpcMethod("sendFAX")]
        object sendFAX(XmlRpcStruct o);

        [XmlRpcMethod("sendSMS")]
        object sendSMS(XmlRpcStruct o);

        [XmlRpcMethod("subscriberData")]
        object subscriberData(XmlRpcStruct o);

        [XmlRpcMethod("updateList")]
        object updateList(XmlRpcStruct o);

		[XmlRpcMethod("addTag")]
		object addTag(XmlRpcStruct o);

		[XmlRpcMethod("attachTag")]
		object attachTag(XmlRpcStruct o);

        [XmlRpcMethod("getTags")]
        object getTags(XmlRpcStruct o);

        [XmlRpcMethod("getAutobots")]
        object getAutobots(XmlRpcStruct o);

        [XmlRpcMethod("startAutobot")]
        object startAutobot(XmlRpcStruct o);

        [XmlRpcMethod("deleteTag")]
        object deleteTag(XmlRpcStruct o);

        [XmlRpcMethod("detachTag")]
        object detachTag(XmlRpcStruct o);

        [XmlRpcMethod("createCampaignGroup")]
        object createCampaignGroup(XmlRpcStruct o);

        [XmlRpcMethod("editCampaignGroup")]
        object editCampaignGroup(XmlRpcStruct o);

        [XmlRpcMethod("getHeaderFooterTemplates")]
        object getHeaderFooterTemplates(XmlRpcStruct o);

        [XmlRpcMethod("getTemplates")]
        object getTemplates(XmlRpcStruct o);

        [XmlRpcMethod("editApiCallback")]
        object editApiCallback(XmlRpcStruct o);

        [XmlRpcMethod("getOperationsQueue")]
        object getOperationsQueue(XmlRpcStruct o);

        [XmlRpcMethod("getForms")]
        object getForms(XmlRpcStruct o);

        [XmlRpcMethod("getFormsSubmissions")]
        object getFormsSubmissions(XmlRpcStruct o);

        [XmlRpcMethod("deleteExtraField")]
        object deleteExtraField(XmlRpcStruct o);

        [XmlRpcMethod("deleteList")]
        object deleteList(XmlRpcStruct o);

        [XmlRpcMethod("getExtraFields")]
        object getExtraFields(XmlRpcStruct o);

        [XmlRpcMethod("generateAdvancedReport")]
        object generateAdvancedReport(XmlRpcStruct o);

        [XmlRpcMethod("getAdvancedReport")]
        object getAdvancedReport(XmlRpcStruct o);

        [XmlRpcMethod("createSegmentAdvanced")]
        object createSegmentAdvanced(XmlRpcStruct o);

        [XmlRpcMethod("addCname")]
        object addCname(XmlRpcStruct o);

        [XmlRpcMethod("addSender")]
        object addSender(XmlRpcStruct o);

        [XmlRpcMethod("deleteSender")]
        object deleteSender(XmlRpcStruct o);

        [XmlRpcMethod("editSender")]
        object editSender(XmlRpcStruct o);

        [XmlRpcMethod("editSubscriberActivity")]
        object editSubscriberActivity(XmlRpcStruct o);
    }
}
