using System;
using System.Collections.Generic;
using System.Text;

namespace Egoi
{
	public class EgoiList  : List<Object>
	{
		public EgoiList ()
		{
		}

		public override string ToString()
		{
			StringBuilder s = new StringBuilder();
			s.Append("[\"");
			int idx = 0;
			foreach (Object k in this)
			{
				if (idx++ > 0)
					s.Append("\", \"");
				s.Append(k);
			}
			s.Append("\"]");
			return s.ToString();
		}
	}
}

