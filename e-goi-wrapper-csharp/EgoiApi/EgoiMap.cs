using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;

namespace Egoi
{
    public class EgoiMap : Dictionary<String, object>, EgoiType
    {

        public override string ToString()
        {
            StringBuilder s = new StringBuilder();
            s.Append("{");
            int idx = 0;
            foreach (string k in Keys)
            {
                if (idx++ > 0)
                    s.Append(", ");
                s.Append(k).Append("=").Append(this[k]);
            }
            s.Append("}");
            return s.ToString();
        }
        
    }
}
