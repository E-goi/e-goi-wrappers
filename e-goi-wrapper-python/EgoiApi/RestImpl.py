# -*- coding: utf-8 -*-

from EgoiApi import decodeError
import EgoiApi
import json
import urllib

ApiName = 'Egoi_Api'

class EgoiApiRestImpl:
    
    url = ''
    
    def __init__(self, url):
        self.url = url

    def prepareMapUrl(self, prepend, params):
        q = ""
        for key in params.keys():
            value = params[key]
            result = ""
            
            prefix = "%s[%s]" % (prepend, key)
            if isinstance(value, dict):
                result = self.prepareMapUrl(prefix, value)
            elif isinstance(value, list):
                result = self.prepareListUrl(prefix, value)
            else:
                result = "%s=%s&" % (prefix, value)
            
            q = q + result
        return q
    
    def prepareListUrl(self, prepend, values):
        q = ""
        i = 0
        for value in values:
            prefix = "%s[%s]" % (prepend, i)
            q = q + self.prepareMapUrl(prefix, value)
            i=i+1
        return q
    
    def call(self, method, functionOptions):
        p = 'method=%s&type=json&%s' % (method, self.prepareMapUrl('functionOptions', functionOptions))
        u = urllib.urlopen(self.url, p)
        j = json.loads(u.read())[ApiName][method]
        res = self.walkMap(j)
        
        if 'response' in res:
            if res['response'] != 'OK':
                raise EgoiApi.EgoiException(decodeError(res['response']))
                  
        if 'status' in res:
            del res['status']
        
        return res
    
    def walkMap(self, m):
        if 'key_0' in m:
            mrl = []
            for k, v in m.items():
                if k.find('key_') != 0:
                    continue
                mrl.append(self.walkValues(v))
            return mrl
        else:
            return self.walkValues(m)

    def walkValues(self, m):
        for k, v in m.items():
            if type(v) == type({}):
                m[k] = self.walkMap(v)
        return m
        
    def getLists(self, functionOptions):
        return self.call('getLists', functionOptions)

    def addExtraField(self, functionOptions):
        return self.call('addExtraField', functionOptions)

    def addSubscriber(self, functionOptions):
        return self.call('addSubscriber', functionOptions)

    def addSubscriberBulk(self, functionOptions):
        return self.call('addSubscriberBulk', functionOptions)

    def checklogin(self, functionOptions):
        return self.call('checklogin', functionOptions)

    def createCampaignEmail(self, functionOptions):
        return self.call('createCampaignEmail', functionOptions)

    def createCampaignFAX(self, functionOptions):
        return self.call('createCampaignFAX', functionOptions)

    def createCampaignSMS(self, functionOptions):
        return self.call('createCampaignSMS', functionOptions)

    def createCampaignVoice(self, functionOptions):
        return self.call('createCampaignVoice', functionOptions)

    def createList(self, functionOptions):
        return self.call('createList', functionOptions)

    def createSegment(self, functionOptions):
        return self.call('createSegment', functionOptions)

    def deleteCampaign(self, functionOptions):
        return self.call('deleteCampaign', functionOptions)

    def deleteSegment(self, functionOptions):
        return self.call('deleteSegment', functionOptions)

    def editCampaignEmail(self, functionOptions):
        return self.call('editCampaignEmail', functionOptions)

    def editCampaignSMS(self, functionOptions):
        return self.call('editCampaignSMS', functionOptions)

    def editExtraField(self, functionOptions):
        return self.call('editExtraField', functionOptions)

    def editSubscriber(self, functionOptions):
        return self.call('editSubscriber', functionOptions)

    def getCampaigns(self, functionOptions):
        return self.call('getCampaigns', functionOptions)

    def getClientData(self, functionOptions):
        return self.call('getClientData', functionOptions)

    def getCredits(self, functionOptions):
        return self.call('getCredits', functionOptions)

    def getReport(self, functionOptions):
        return self.call('getReport', functionOptions)

    def getSegments(self, functionOptions):
        return self.call('getSegments', functionOptions)

    def getSenders(self, functionOptions):
        return self.call('getSenders', functionOptions)

    def getUserData(self, functionOptions):
        return self.call('getUserData', functionOptions)

    def removeSubscriber(self, functionOptions):
        return self.call('removeSubscriber', functionOptions)

    def sendCall(self, functionOptions):
        return self.call('sendCall', functionOptions)

    def sendEmail(self, functionOptions):
        return self.call('sendEmail', functionOptions)

    def sendFAX(self, functionOptions):
        return self.call('sendFAX', functionOptions)

    def sendSMS(self, functionOptions):
        return self.call('sendSMS', functionOptions)

    def subscriberData(self, functionOptions):
        return self.call('subscriberData', functionOptions)

    def updateList(self, functionOptions):
        return self.call('updateList', functionOptions)

