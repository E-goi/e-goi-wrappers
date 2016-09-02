using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;
using System.Web;

namespace Egoi
{

    public class EgoiSlingshotRestImpl : EgoiSlingshot
    {

        private static EgoiSlingshotRestImpl instance;

        private static readonly string Url = "https://www51.e-goi.com/api/";

        private EgoiSlingshotRestImpl()
        {
        }

        public static EgoiSlingshotRestImpl getInstance()
        {
            if (instance == null)
                instance = new EgoiSlingshotRestImpl();
            return instance;
        }

        public String buildPayload(EgoiMap values) {
            if (values != null)
                return values.ToString();

            return "";
	    }
        

        public string fetchResponse(string payload, string method, string methodType)
        {
            WebRequest request = WebRequest.Create(Url + method);
            request.Method = methodType;
            request.ContentType = "application/json";

            if (!string.IsNullOrEmpty(payload))
            {
                using (var stream = request.GetRequestStream())
                {
                    using (var writer = new StreamWriter(stream))
                    {
                        writer.Write(payload);
                    }
                }
            }
            
            try
            {
                WebResponse response = request.GetResponse();
                StreamReader reader = new StreamReader(response.GetResponseStream());
                StringBuilder lines = new StringBuilder();
                string line;
                while ((line = reader.ReadLine()) != null)
                    lines.Append(line).Append("\n");
                return lines.ToString();
            }
            catch (WebException e)
            {
                StreamReader r = new StreamReader(e.Response.GetResponseStream());
                String message = r.ReadToEnd();
                throw new EgoiException("Error processing Rest request: " + message);
            }
        }

        public string processResult(string method, string methodType, EgoiMap arguments)
        {
            string payload = buildPayload(arguments);
            string json = fetchResponse(payload, method, methodType);

            return json;
        }


        ///////////////////////////////////////////////////////////////////////////////////////

        public string getCampaignData(EgoiMap arguments)
        {
            return processResult("public/campaign/data", "POST", arguments);
        }

        public string getCampaignGroupData(EgoiMap arguments)
        {
            return processResult("public/campaign/groupData", "POST", arguments);
        }

        public string countries()
        {
            return processResult("public/commons/countries", "GET", null);
        }

        public string ping(EgoiMap arguments)
        {
            return processResult("public/commons/ping", "POST", arguments);
        }

        public string getMailDomains(EgoiMap arguments)
        {
            return processResult("public/mail/domains", "POST", arguments);
        }

        public string addMailDomains(EgoiMap arguments)
        {
            return processResult("public/mail/domains/add", "POST", arguments);
        }

        public string getMailDefaultDomain(EgoiMap arguments)
        {
            return processResult("public/mail/domains/default", "POST", arguments);
        }

        public string setMailDefaultDomain(EgoiMap arguments)
        {
            return processResult("public/mail/domains/default/set", "POST", arguments);
        }

        public string setMailFallbackurlDomain(EgoiMap arguments)
        {
            return processResult("public/mail/domains/fallbackurl/set", "POST", arguments);
        }

        public string validateMailDomain(EgoiMap arguments)
        {
            return processResult("public/mail/domains/validate", "POST", arguments);
        }

        public string getMailQueue(EgoiMap arguments)
        {
            return processResult("public/mail/queue", "POST", arguments);
        }

        public string sendMail(EgoiMap arguments)
        {
            return processResult("public/mail/send", "POST", arguments);
        }

        public string getMailSenders(EgoiMap arguments)
        {
            return processResult("public/mail/senders", "POST", arguments);
        }

        public string getMailBouncesStats(EgoiMap arguments)
        {
            return processResult("public/stats/mail/bounces", "POST", arguments);
        }

        public string getMailDailyStats(EgoiMap arguments)
        {
            return processResult("public/stats/mail/daily", "POST", arguments);
        }

        public string getMailEventsStats(EgoiMap arguments)
        {
            return processResult("public/stats/mail/events", "POST", arguments);
        }

        public string getMailRemovesStats(EgoiMap arguments)
        {
            return processResult("public/stats/mail/removes", "POST", arguments);
        }

        public string getMailSendsStats(EgoiMap arguments)
        {
            return processResult("public/stats/mail/sends", "POST", arguments);
        }

        public string getMailSummaryStats(EgoiMap arguments)
        {
            return processResult("public/stats/mail/summary", "POST", arguments);
        }

        public string getSmsQueue(EgoiMap arguments)
        {
            return processResult("public/sms/queue", "POST", arguments);
        }

        public string sendSms(EgoiMap arguments)
        {
            return processResult("public/sms/send", "POST", arguments);
        }

        public string getSmsSenders(EgoiMap arguments)
        {
            return processResult("public/sms/senders", "POST", arguments);
        }

        public string validateSmsPhone(string countryCode, string phoneNumber)
        {
            return processResult("public/sms/validatePhone/" + countryCode + "-" + phoneNumber, "GET", null);
        }

        public string getSmsDailyStats(EgoiMap arguments)
        {
            return processResult("public/stats/sms/daily", "POST", arguments);
        }

        public string getSmsDailyprefixStats(EgoiMap arguments)
        {
            return processResult("public/stats/sms/dailyprefix", "POST", arguments);
        }

        public string getSmsSendsStats(EgoiMap arguments)
        {
            return processResult("public/stats/sms/sends", "POST", arguments);
        }

        public string getSmsSummaryStats(EgoiMap arguments)
        {
            return processResult("public/stats/sms/summary", "POST", arguments);
        }

        public string getStatsGroups(EgoiMap arguments)
        {
            return processResult("public/stats/groups", "POST", arguments);
        }

        public string addWebhooksMail(EgoiMap arguments)
        {
            return processResult("public/webhooks/mail/add", "POST", arguments);
        }

        public string getWebhooksMail(EgoiMap arguments)
        {
            return processResult("public/webhooks/mail/list", "POST", arguments);
        }

        public string removeWebhooksMail(EgoiMap arguments)
        {
            return processResult("public/webhooks/mail/remove", "POST", arguments);
        }

        public string addWebhooksSms(EgoiMap arguments)
        {
            return processResult("public/webhooks/sms/add", "POST", arguments);
        }

        public string getWebhooksSms(EgoiMap arguments)
        {
            return processResult("public/webhooks/sms/list", "POST", arguments);
        }

        public string removeWebhooksSms(EgoiMap arguments)
        {
            return processResult("public/webhooks/sms/remove", "POST", arguments);
        }
    }
}
