using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CookComputing.XmlRpc;

namespace Egoi
{
    [XmlRpcUrl("http://api.e-goi.com/v2/xmlrpc.php")]
    public interface EgoiApiXmlRpcProxy : IXmlRpcProxy
    {
        [XmlRpcMethod("getLists")]
        object getLists(XmlRpcStruct o);

        [XmlRpcMethod("getUserData")]
        object getUserData(XmlRpcStruct o);
    }
}
