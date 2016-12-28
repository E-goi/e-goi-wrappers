using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{
    public class EgoiMap : Dictionary<String, object>, EgoiType
    {

        public EgoiMap() { }
        
        public EgoiMap(Dictionary<string, object> other)
        {
            foreach (KeyValuePair<string, object> pair in other)
            {
                if(pair.Value is Dictionary<string, object>)
                    Add(pair.Key, new EgoiMap(pair.Value as Dictionary<string, object>));
                else
                    Add(pair.Key, pair.Value);
            }
        }

        public override string ToString()
        {
            StringBuilder s = new StringBuilder();
            s.Append("{");
            int idx = 0;
            foreach (string k in Keys)
            {
                if (idx++ > 0)
                    s.Append(", ");
                s.Append("\"").Append(k).Append("\"").Append(":");

                if ((this[k] is string))
                    s.Append("\"");

                s.Append(this[k]);

                if ((this[k] is string))
                    s.Append("\"");
            }
            s.Append("}");
            return s.ToString();
        }
        
    }
}
