# -*- coding: utf-8 -*-
from xmlrpclib import ServerProxy

class EgoiApiXmlRpc:
    
    def __init__(self, url):
        self.client = ServerProxy(url) 
    
    def getLists(self, functionOptions):
        return self.client.getLists(functionOptions)

    def addExtraField(self, functionOptions):
        return self.client.addExtraField(functionOptions)

    def addSubscriber(self, functionOptions):
        return self.client.addSubscriber(functionOptions)

    def addSubscriberBulk(self, functionOptions):
        return self.client.addSubscriberBulk(functionOptions)

    def checklogin(self, functionOptions):
        return self.client.checklogin(functionOptions)

    def createCampaignEmail(self, functionOptions):
        return self.client.createCampaignEmail(functionOptions)

    def createCampaignFAX(self, functionOptions):
        return self.client.createCampaignFAX(functionOptions)

    def createCampaignSMS(self, functionOptions):
        return self.client.createCampaignSMS(functionOptions)

    def createCampaignVoice(self, functionOptions):
        return self.client.createCampaignVoice(functionOptions)

    def createList(self, functionOptions):
        return self.client.createList(functionOptions)

    def createSegment(self, functionOptions):
        return self.client.createSegment(functionOptions)

    def deleteCampaign(self, functionOptions):
        return self.client.deleteCampaign(functionOptions)

    def deleteSegment(self, functionOptions):
        return self.client.deleteSegment(functionOptions)

    def editCampaignEmail(self, functionOptions):
        return self.client.editCampaignEmail(functionOptions)

    def editCampaignSMS(self, functionOptions):
        return self.client.editCampaignSMS(functionOptions)

    def editExtraField(self, functionOptions):
        return self.client.editExtraField(functionOptions)

    def editSubscriber(self, functionOptions):
        return self.client.editSubscriber(functionOptions)

    def getCampaigns(self, functionOptions):
        return self.client.getCampaigns(functionOptions)

    def getClientData(self, functionOptions):
        return self.client.getClientData(functionOptions)

    def getCredits(self, functionOptions):
        return self.client.getCredits(functionOptions)

    def getReport(self, functionOptions):
        return self.client.getReport(functionOptions)

    def getSegments(self, functionOptions):
        return self.client.getSegments(functionOptions)

    def getSenders(self, functionOptions):
        return self.client.getSenders(functionOptions)

    def getUserData(self, functionOptions):
        return self.client.getUserData(functionOptions)

    def removeSubscriber(self, functionOptions):
        return self.client.removeSubscriber(functionOptions)

    def sendCall(self, functionOptions):
        return self.client.sendCall(functionOptions)

    def sendEmail(self, functionOptions):
        return self.client.sendEmail(functionOptions)

    def sendFAX(self, functionOptions):
        return self.client.sendFAX(functionOptions)

    def sendSMS(self, functionOptions):
        return self.client.sendSMS(functionOptions)

    def subscriberData(self, functionOptions):
        return self.client.subscriberData(functionOptions)

    def updateList(self, functionOptions):
        return self.client.updateList(functionOptions)

