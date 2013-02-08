# -*- coding: utf-8 -*-
#!/usr/bin/python

from EgoiApi import EgoiApiFactory, EgoiProtocol

ApiKey = '<api key>'

if __name__ == "__main__":
    # Example on how to add bulk subscribers
    args = {
        "apikey" : ApiKey,
        "listID": 2,
        "compareField": "email",
        "subscribers": [
            {"email": "email1@domain1.com", "status": 4},
            {"email": "email2@domain2.com", "status": 4},
            {"email": "email3@domain3.com", "status": 4},
        ]
    }
    
    api = EgoiApiFactory.getApi(EgoiProtocol.Rest) # or XmlRpc
    result = api.addSubscriberBulk(args)
    print result
