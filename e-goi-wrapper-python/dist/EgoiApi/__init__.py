# -*- coding: utf-8 -*-

__version__ = '0.1'

__all__ = ["EgoiProtocol"]

class EgoiProtocol:
    """
    Contém os protocolos atualmente implementados na API
    """
    Soap = 'EgoiProtocol.Soap'
    XmlRpc = 'EgoiProtocol.XmlRpc'
    Rest = 'EgoiProtocol.Rest'