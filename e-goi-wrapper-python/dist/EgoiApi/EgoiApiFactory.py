# -*- coding: utf-8 -*-
from EgoiApi import EgoiProtocol
from EgoiApi.RestImpl import EgoiApiRestImpl
from EgoiApi.XmlRpcImpl import EgoiApiXmlRpc

__all__ = ["getApi"]

def getApi(protocol = EgoiProtocol.XmlRpc):
    if protocol == EgoiProtocol.XmlRpc:
        return EgoiApiXmlRpc('http://api.e-goi.com/v2/xmlrpc.php')
    if protocol == EgoiProtocol.Rest:
        return EgoiApiRestImpl('http://api.e-goi.com/v2/rest.php')
    raise Exception('O protocolo solicitado não está implementado: %s' % protocol)