using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{
    public interface EgoiSlingshot
    {
        #region API Methods

        #region campaign
        string getCampaignData(EgoiMap arguments);
        string getCampaignGroupData(EgoiMap arguments);
        #endregion

        #region commons        
        string countries();

        string ping(EgoiMap arguments);
        #endregion

        #region mail
        string getMailDomains(EgoiMap arguments);
        string addMailDomains(EgoiMap arguments);
        string getMailDefaultDomain(EgoiMap arguments);
        string setMailDefaultDomain(EgoiMap arguments);
        string setMailFallbackurlDomain(EgoiMap arguments);
        string validateMailDomain(EgoiMap arguments);
        string getMailQueue(EgoiMap arguments);
        string sendMail(EgoiMap arguments);
        string getMailSenders(EgoiMap arguments);
        #endregion

        #region mailStats
        string getMailBouncesStats(EgoiMap arguments);
        string getMailDailyStats(EgoiMap arguments);
        string getMailEventsStats(EgoiMap arguments);
        string getMailRemovesStats(EgoiMap arguments);
        string getMailSendsStats(EgoiMap arguments);
        string getMailSummaryStats(EgoiMap arguments);

        #endregion

        #region sms
        string getSmsQueue(EgoiMap arguments);
        string sendSms(EgoiMap arguments);
        string getSmsSenders(EgoiMap arguments);
        string validateSmsPhone(string countryCode, string phoneNumber);
        #endregion

        #region smsStats
        string getSmsDailyStats(EgoiMap arguments);
        string getSmsDailyprefixStats(EgoiMap arguments);
        string getSmsSendsStats(EgoiMap arguments);
        string getSmsSummaryStats(EgoiMap arguments);
        #endregion

        #region stats
        string getStatsGroups(EgoiMap arguments);
        #endregion

        #region webhooks
        string addWebhooksMail(EgoiMap arguments);
        string getWebhooksMail(EgoiMap arguments);
        string removeWebhooksMail(EgoiMap arguments);
        string addWebhooksSms(EgoiMap arguments);
        string getWebhooksSms(EgoiMap arguments);
        string removeWebhooksSms(EgoiMap arguments);
        #endregion

        #endregion
    }
}
