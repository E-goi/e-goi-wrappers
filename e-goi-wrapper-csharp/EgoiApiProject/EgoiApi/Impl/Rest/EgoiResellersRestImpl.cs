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

    public class EgoiResellersRestImpl : EgoiResellers
    {
        private static EgoiResellersRestImpl instance;

        private static readonly string Url = "https://api.egoiapp.com/api/";

        private EgoiResellersRestImpl()
        {
        }

        public static EgoiResellersRestImpl getInstance()
        {
            if (instance == null)
                instance = new EgoiResellersRestImpl();
            return instance;
        }

        public String buildPayload(EgoiMap values)
        {
            StringBuilder url = new StringBuilder();

            int i = 0;

            foreach (String key in values.Keys)
            {
                Object value = values[key];

                if (i > 0)
                    url.Append("&");

                if(value is Array)
                {
                    string valueToAppend = string.Empty;

                    foreach(var val in (Array)value)
                    {
                        valueToAppend += val.ToString() + ",";
                    }

                    if (!string.IsNullOrEmpty(valueToAppend))
                    {
                        valueToAppend = valueToAppend.Trim(',');
                        url.Append(String.Format("{0}={1}", key, valueToAppend));
                    }

                }
                else
                {
                    url.Append(String.Format("{0}={1}", key, value.ToString()));
                }

                i++;
            }

            return url.ToString();
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


        public string getPartnersProducts(EgoiMap arguments)
        {
            return processResult("partners/products", "GET", arguments);
        }


        public string getPartnersProductsById(string id, EgoiMap arguments)
        {
            return processResult("partners/products/" + id, "GET", arguments);
        }

        public string getSubaccountsBalanceById(string id, EgoiMap arguments)
        {
            return processResult("subaccounts/balance/" + id, "GET", arguments);
        }

        public string blockSubaccounts(EgoiMap arguments)
        {
            return processResult("subaccounts/block", "POST", arguments);
        }

        public string unblockSubaccounts(EgoiMap arguments)
        {
            return processResult("subaccounts/unblock", "POST", arguments);
        }

        public string getSubaccounts(EgoiMap arguments)
        {
            return processResult("subaccounts", "GET", arguments);
        }

        public string addSubaccounts(EgoiMap arguments)
        {
            return processResult("subaccounts", "POST", arguments);
        }

        public string deleteSubaccounts(string id, EgoiMap arguments)
        {
            return processResult("subaccounts/" + id, "DELETE", arguments);
        }

        public string getSubaccountsById(string id, EgoiMap arguments)
        {
            return processResult("subaccounts/" + id, "GET", arguments);
        }

        public string updateSubaccounts(string id, EgoiMap arguments)
        {
            return processResult("subaccounts/" + id, "PUT", arguments);
        }

        public string addSubaccountsProducts(EgoiMap arguments)
        {
            return processResult("subaccounts/products/assign", "POST", arguments);
        }

        public string deleteSubaccountsProducts(string id, EgoiMap arguments)
        {
            return processResult("subaccounts/products/assign/" + id, "DELETE", arguments);
        }

        public string topupSubaccountsProducts(EgoiMap arguments)
        {
            return processResult("subaccounts/products/topup", "GET", arguments);
        }

        public string getSubaccountsProperties(EgoiMap arguments)
        {
            return processResult("subaccounts/properties", "GET", arguments);
        }

        public string getSubaccountsPropertiesById(string id, EgoiMap arguments)
        {
            return processResult("subaccounts/properties/" + id, "GET", arguments);
        }
    }
}
