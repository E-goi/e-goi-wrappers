#include "egoi.h"

#include <iostream>

#include <xmlrpc-c/base.h>
#include <xmlrpc-c/client_simple.hpp>

#include "egoixmlrpc.h"

Egoi::Egoi()
{
}

EgoiApi * Egoi::getApi()
{
    return new EgoiApiXmlRpcImpl();
}
