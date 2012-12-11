using System.Collections.Generic;
using System.Text;

namespace Egoi
{
    public class EgoiMapList : List<EgoiMap>, EgoiType
    {
        public override string ToString()
        {
            StringBuilder s = new StringBuilder();
            s.Append("[");
            int idx = 0;
            foreach (EgoiMap value in this)
            {
                if (idx++ > 0)
                    s.Append(", ");
                s.Append(value);
            }
            s.Append("]");
            return s.ToString();
        }
    }
}
