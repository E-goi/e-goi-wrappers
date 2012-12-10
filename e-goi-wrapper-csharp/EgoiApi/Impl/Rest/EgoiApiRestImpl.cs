using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{

    public class EgoiApiRestImpl
    {

        private static EgoiApiRestImpl instance;

        private static readonly string Url = "http://api.e-goi.com/v2/rest.php?type=json";

        public static EgoiApiRestImpl getInstance()
        {
            if (instance == null)
                instance = new EgoiApiRestImpl();
            return instance;
        }

        public String buildUrl(String method, EgoiMap values) {
		    StringBuilder url = new StringBuilder(Url);
		    url.Append("&method=").Append(method);
		    foreach (String key in values.Keys)
			    url.Append("&functionOptions[").Append(key).Append("]=").Append(values[key]);
		    return url.ToString();
	    }

    }
}
