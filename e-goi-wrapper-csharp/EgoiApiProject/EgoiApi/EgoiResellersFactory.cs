using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{
    public class EgoiResellersFactory
    {

        public static EgoiResellers getApi()
        {
            return getApi(Protocol.Default);
        }

        public static EgoiResellers getApi(Protocol protocol)
        {
            switch (protocol)
            {
                default:
                case Protocol.Rest:
                    return EgoiResellersRestImpl.getInstance();
            }
        }

    }
}
