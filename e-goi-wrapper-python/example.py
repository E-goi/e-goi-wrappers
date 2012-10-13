# -*- coding: utf-8 -*-
#!/usr/bin/python

from EgoiApi import EgoiApiFactory, EgoiProtocol

ApiKey = '<api key>'

if __name__ == "__main__":
    api = EgoiApiFactory.getApi(EgoiProtocol.XmlRpc)
    ud = api.getUserData({'apikey': ApiKey})
    print ud
