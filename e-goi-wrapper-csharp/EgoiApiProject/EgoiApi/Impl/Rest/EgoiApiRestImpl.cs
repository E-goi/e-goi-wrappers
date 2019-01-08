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

    public class EgoiApiRestImpl : EgoiApi
    {

        private static EgoiApiRestImpl instance;

        private static readonly string Url = "http://api.e-goi.com/v2/rest.php";

        private EgoiApiRestImpl()
        {
        }

        public static EgoiApiRestImpl getInstance()
        {
            if (instance == null)
                instance = new EgoiApiRestImpl();
            return instance;
        }

        public String buildPayload(String method, EgoiMap values) {
		    StringBuilder url = new StringBuilder();
		    url
                .Append("type=json&")
                .Append("method=").Append(method).Append("&")
                .Append(prepareMapPayload("functionOptions", values));
		    return url.ToString();
	    }

        public static String prepareMapPayload(String prepend, EgoiMap values)
        {
            StringBuilder q = new StringBuilder();
            foreach (String key in values.Keys)
            {
                Object value = values[key];
                String result = null;

                String prefix = String.Format("{0}[{1}]", prepend, key);

				if (value is EgoiMap) {
					EgoiMap map = (EgoiMap)value;
					result = prepareMapPayload (prefix, map);
				} else if (value is EgoiMapList) {
					EgoiMapList list = (EgoiMapList)value;
					result = prepareListPayload (prefix, list);
				} else if (value is EgoiList) {
					EgoiList list = (EgoiList)value;
					result = prepareGenericListPayload (prefix, list);
				} else {
                    result = String.Format("{0}={1}&", prefix, value.ToString());
                }

                q.Append(result);
            }
            return q.ToString();
        }

		private static String prepareGenericListPayload (String prepend, EgoiList list)
		{
			StringBuilder q = new StringBuilder();
			for (int i = 0; i < list.Count(); i++)
			{
				String prefix = String.Format("{0}[{1}]", prepend, i);
				Object value = list[i];
				String enc = HttpUtility.UrlEncode (value.ToString ());
				q.Append(String.Format("{0}={1}&", prefix, enc));
			}
			return q.ToString();
		}

        private static String prepareListPayload(String prepend, EgoiMapList list)
        {
            StringBuilder q = new StringBuilder();
            for (int i = 0; i < list.Count(); i++)
            {
                String prefix = String.Format("{0}[{1}]", prepend, i);
                EgoiMap value = list[i];
                q.Append(prepareMapPayload(prefix, value));
            }
            return q.ToString();
        }

	    protected EgoiType walkMap(Dictionary<string, object> map) {
		    EgoiType r = null;
		    if(map.ContainsKey("key_0")) {
			    EgoiMapList mrl = new EgoiMapList();
			    List<String> keys = map.Keys.ToList<string>();
                keys.Sort();
			    foreach(String k in keys) {
				    if(!k.StartsWith("key_"))
					    continue;
				    if (map [k] is Dictionary<string, object>) {
                        mrl.Add (walkValues (new EgoiMap (map [k] as Dictionary<string, object>)));
                    } else {
                        EgoiMap value = new EgoiMap (); value.Add ("value", map [k]); mrl.Add (value);
                    }
                }
                r = mrl;
		    } else {
			    r = walkValues(new EgoiMap(map));
		    }
			
		    return r;
	    }

	    private EgoiType walkArray(List<Dictionary<string, object>> list) {
		    EgoiMapList mrl = new EgoiMapList();
		    foreach(Dictionary<string, object> map in list)
			    mrl.Add(walkValues(new EgoiMap(map)));
		    return mrl;
	    }

        protected EgoiMap walkValues(EgoiMap map) {
            List<string> keys = map.Keys.ToList<string>();
		    foreach(string key in keys) {
			    object obj = map[key];
			    if (obj is Dictionary<string, object>) {
				    Dictionary<string, object> sm = obj as Dictionary<string, object>;
				    map[key] = walkMap(sm);
			    }
			
			    if(obj is object[]) {
				    List<Dictionary<string, object>> mapList = extractMapList((Object[]) obj);
				    map[key] = walkArray(mapList);
			    }
		    }
		    return map;
	    }

	    private List<Dictionary<string, object>> extractMapList(Object[] arr) {
		    List<Dictionary<string, object>> mapList = new List<Dictionary<string,object>>();
		    foreach(object o in arr) {
			    if (o is Dictionary<string, object>) {
                    Dictionary<string, object> m = o as Dictionary<string, object>;
				    mapList.Add(m);
			    }
		    }
		    return mapList;
	    }

        public string fetchResponse(string payload)
        {
            WebRequest request = WebRequest.Create(Url);
            request.Method = "POST";
            request.ContentType = "application/x-www-form-urlencoded";


            using (var stream = request.GetRequestStream())
            {
                using (var writer = new StreamWriter(stream))
                {
                    writer.Write(payload);
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

        public Dictionary<string, object> processResult(string method, EgoiMap arguments)
        {
            string payload = buildPayload(method, arguments);
            string json = fetchResponse(payload);
            JavaScriptSerializer s = new JavaScriptSerializer();

            /**
             * IT's A TRAP! 
             */
            Dictionary<string, object> response = s.Deserialize<Dictionary<string, object>>(json);
            Dictionary<string, object> r2 = response["Egoi_Api"] as Dictionary<string, object>;
            Dictionary<string, object> map = r2[method] as Dictionary<string, object>;

            //IF ERROR EXIST
            if (map.ContainsKey("ERROR"))
                throw new EgoiException(EgoiException.idToMessage(map["ERROR"] as string));

            //IF ERROR NOT EXIST AND RESPONSE NOT EXIST
            if (!map.ContainsKey("response"))
                throw new EgoiException(EgoiException.idToMessage(""));


            // Status not used
            map.Remove("status");

            return map;
        }

        public EgoiMap decodeMapResult(String method, EgoiMap arguments)
        {
            Dictionary<string, object> result = processResult(method, arguments);
            return walkMap(result) as EgoiMap;
        }

        public EgoiMapList decodeMapListResult(String method, EgoiMap arguments)
        {
            Dictionary<string, object> result = processResult(method, arguments);

            EgoiType et = walkMap(result);

            if(et is EgoiMap)
            {
                EgoiMapList eml = new EgoiMapList();

                eml.Add(et as EgoiMap);

                et = eml;
            }

            return et as EgoiMapList;
        }


        ///////////////////////////////////////////////////////////////////////////////////////
        
        public EgoiMap addExtraField(EgoiMap arguments)
        {
            return decodeMapResult("addExtraField", arguments);
        }

        public EgoiMap addSubscriber(EgoiMap arguments)
        {
            return decodeMapResult("addSubscriber", arguments);
        }

        public EgoiMap addSubscriberBulk(EgoiMap arguments)
        {
            return decodeMapResult("addSubscriberBulk", arguments);
        }

        public EgoiMap checklogin(EgoiMap arguments)
        {
            return decodeMapResult("checklogin", arguments);
        }

        public EgoiMap createCampaignEmail(EgoiMap arguments)
        {
            return decodeMapResult("createCampaignEmail", arguments);
        }

        public EgoiMap createCampaignFAX(EgoiMap arguments)
        {
            return decodeMapResult("createCampaignFAX", arguments);
        }

        public EgoiMap createCampaignSMS(EgoiMap arguments)
        {
            return decodeMapResult("createCampaignSMS", arguments);
        }

        public EgoiMap createCampaignVoice(EgoiMap arguments)
        {
            return decodeMapResult("createCampaignVoice", arguments);
        }

        public EgoiMap createList(EgoiMap arguments)
        {
            return decodeMapResult("createList", arguments);
        }

        public EgoiMap createSegment(EgoiMap arguments)
        {
            return decodeMapResult("createSegment", arguments);
        }

        public EgoiMap deleteCampaign(EgoiMap arguments)
        {
            return decodeMapResult("deleteCampaign", arguments);
        }

        public EgoiMap deleteSegment(EgoiMap arguments)
        {
            return decodeMapResult("deleteSegment", arguments);
        }

        public EgoiMap editCampaignEmail(EgoiMap arguments)
        {
            return decodeMapResult("editCampaignEmail", arguments);
        }

        public EgoiMap editCampaignSMS(EgoiMap arguments)
        {
            return decodeMapResult("editCampaignSMS", arguments);
        }

        public EgoiMap editExtraField(EgoiMap arguments)
        {
            return decodeMapResult("editExtraField", arguments);
        }

        public EgoiMap editSubscriber(EgoiMap arguments)
        {
            return decodeMapResult("editSubscriber", arguments);
        }

        public EgoiMapList getCampaigns(EgoiMap arguments)
        {
            return decodeMapListResult("getCampaigns", arguments);
        }

        public EgoiMap getClientData(EgoiMap arguments)
        {
            return decodeMapResult("getClientData", arguments);
        }

        public EgoiMap getCredits(EgoiMap arguments)
        {
            return decodeMapResult("getCredits", arguments);
        }

        public EgoiMapList getLists(EgoiMap arguments)
        {
            return decodeMapListResult("getLists", arguments);
        }

        public EgoiMap getReport(EgoiMap arguments)
        {
            return decodeMapResult("getReport", arguments);
        }

        public EgoiMapList getSegments(EgoiMap arguments)
        {
            return decodeMapListResult("getSegments", arguments);
        }

        public EgoiMapList getSenders(EgoiMap arguments)
        {
            return decodeMapListResult("getSenders", arguments);
        }

        public EgoiMap getUserData(EgoiMap arguments)
        {
            return decodeMapResult("getUserData", arguments);
        }

        public EgoiMap removeSubscriber(EgoiMap arguments)
        {
            return decodeMapResult("removeSubscriber", arguments);
        }

        public EgoiMap sendCall(EgoiMap arguments)
        {
            return decodeMapResult("sendCall", arguments);
        }

        public EgoiMap sendEmail(EgoiMap arguments)
        {
            return decodeMapResult("sendEmail", arguments);
        }

        public EgoiMap sendFAX(EgoiMap arguments)
        {
            return decodeMapResult("sendFAX", arguments);
        }

        public EgoiMap sendSMS(EgoiMap arguments)
        {
            return decodeMapResult("sendSMS", arguments);
        }

        public EgoiMapList subscriberData(EgoiMap arguments)
        {
            return decodeMapListResult("subscriberData", arguments);
        }

        public EgoiMap updateList(EgoiMap arguments)
        {
            return decodeMapResult("updateList", arguments);
        }

        public EgoiMap addTag(EgoiMap arguments)
        {
            return decodeMapResult ("addTag", arguments);
        }

		public EgoiMap attachTag(EgoiMap arguments)
		{
			return decodeMapResult ("attachTag", arguments);
		}

		public EgoiMapList getTags(EgoiMap arguments)
		{
			return decodeMapListResult("getTags", arguments);
        }

        public EgoiMapList getAutobots(EgoiMap arguments)
        {
            return decodeMapListResult("getAutobots", arguments);
        }

        public EgoiMap startAutobot(EgoiMap arguments)
        {
            return decodeMapResult("startAutobot", arguments);
        }

        public EgoiMap deleteTag(EgoiMap arguments)
        {
            return decodeMapResult("deleteTag", arguments);
        }

        public EgoiMap detachTag(EgoiMap arguments)
        {
            return decodeMapResult("detachTag", arguments);
        }

        public EgoiMap createCampaignGroup(EgoiMap arguments)
        {
            return decodeMapResult("createCampaignGroup", arguments);
        }

        public EgoiMap editCampaignGroup(EgoiMap arguments)
        {
            return decodeMapResult("editCampaignGroup", arguments);
        }

        public EgoiMapList getHeaderFooterTemplates(EgoiMap arguments)
        {
            return decodeMapListResult("getHeaderFooterTemplates", arguments);
        }

        public EgoiMapList getTemplates(EgoiMap arguments)
        {
            return decodeMapListResult("getTemplates", arguments);
        }

        public EgoiMap editApiCallback(EgoiMap arguments)
        {
            return decodeMapResult("editApiCallback", arguments);
        }

        public EgoiMapList getOperationsQueue(EgoiMap arguments)
        {
            return decodeMapListResult("getOperationsQueue", arguments);
        }

        public EgoiMapList getForms(EgoiMap arguments)
        {
            return decodeMapListResult("getForms", arguments);
        }

        public EgoiMapList getFormsSubmissions(EgoiMap arguments)
        {
            return decodeMapListResult("getFormsSubmissions", arguments);
        }

        public EgoiMap deleteExtraField(EgoiMap arguments)
        {
            return decodeMapResult("deleteExtraField", arguments);
        }

        public EgoiMap deleteList(EgoiMap arguments)
        {
            return decodeMapResult("deleteList", arguments);
        }

        public EgoiMapList getExtraFields(EgoiMap arguments)
        {
            return decodeMapListResult("getExtraFields", arguments);
        }

        public EgoiMap generateAdvancedReport(EgoiMap arguments)
        {
            return decodeMapResult("generateAdvancedReport", arguments);
        }

        public EgoiMapList getAdvancedReport(EgoiMap arguments)
        {
            return decodeMapListResult("getAdvancedReport", arguments);
        }

        public EgoiMap createSegmentAdvanced(EgoiMap arguments)
        {
            return decodeMapResult("createSegmentAdvanced", arguments);
        }

        public EgoiMap addCname(EgoiMap arguments)
        {
            return decodeMapResult("addCname", arguments);
        }

        public EgoiMap addSender(EgoiMap arguments)
        {
            return decodeMapResult("addSender", arguments);
        }

        public EgoiMap deleteSender(EgoiMap arguments)
        {
            return decodeMapResult("deleteSender", arguments);
        }

        public EgoiMap editSender(EgoiMap arguments)
        {
            return decodeMapResult("editSender", arguments);
        }

        public EgoiMap getSubscriberActivity(EgoiMap arguments)
        {
            return decodeMapResult("getSubscriberActivity", arguments);
        }
    }
}
