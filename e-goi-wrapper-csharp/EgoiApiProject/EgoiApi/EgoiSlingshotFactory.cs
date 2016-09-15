using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Egoi
{
    public class EgoiSlingshotFactory
    {

        public static EgoiSlingshot getApi()
        {
            return getApi(Protocol.Default);
        }

        public static EgoiSlingshot getApi(Protocol protocol)
        {
            switch (protocol)
            {
                default:
                //case Protocol.XmlRpc:
                    //return EgoiSlingshotXmlRpcImpl.getInstance();
                case Protocol.Rest:
                    return EgoiSlingshotRestImpl.getInstance();
            }
        }

    }
}
