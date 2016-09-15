using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{
    public class EgoiApiFactory
    {

        public static EgoiApi getApi()
        {
            return getApi(Protocol.Default);
        }

        public static EgoiApi getApi(Protocol protocol)
        {
            switch (protocol)
            {
                default:
                case Protocol.XmlRpc:
                    return EgoiApiXmlRpcImpl.getInstance();
                case Protocol.Rest:
                    return EgoiApiRestImpl.getInstance();
            }
        }

    }
}
