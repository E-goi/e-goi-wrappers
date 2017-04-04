package com.egoi.api.wrapper.api;

import com.egoi.api.wrapper.api.exceptions.EgoiException;

/**
 * @author Luís Lobo <lflobo@gmail.com>
 */
public interface EgoiApi {
    
        //<editor-fold defaultstate="collapsed" desc="Accounts">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#checklogin
	 */
	EgoiMap checklogin(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getclientdata
	 */
	EgoiMap getClientData(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getcredits
	 */
	EgoiMap getCredits(EgoiMap arguments) throws EgoiException;
        
        /**
	 * Obter os dados de um utilizador E-goi
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#getuserdata
	 */
	EgoiMap getUserData(EgoiMap arguments) throws EgoiException;

        //</editor-fold>
	
        //<editor-fold defaultstate="collapsed" desc="Automations">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getautobots
	 */
	EgoiMapList getAutobots(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#startautobot
	 */
	EgoiMap startAutobot(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Campaigns">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createcampaignemail
	 */
	EgoiMap createCampaignEmail(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createcampaignfax
	 */
	EgoiMap createCampaignFAX(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createcampaigngroup
	 */
        EgoiMap createCampaignGroup(EgoiMap arguments) throws EgoiException;

	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createcampaignsms
	 */
	EgoiMap createCampaignSMS(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createcampaignvoice
	 */
	EgoiMap createCampaignVoice(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#deletecampaign
	 */
	EgoiMap deleteCampaign(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editcampaignemail
	 */
	EgoiMap editCampaignEmail(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editcampaigngroup
	 */
        EgoiMap editCampaignGroup(EgoiMap arguments) throws EgoiException;
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editcampaignsms
	 */
	EgoiMap editCampaignSMS(EgoiMap arguments) throws EgoiException;
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getcampaigns
	 */
	EgoiMapList getCampaigns(EgoiMap arguments) throws EgoiException;
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getheaderfootertemplates
	 */
	EgoiMapList getHeaderFooterTemplates(EgoiMap arguments) throws EgoiException;
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#gettemplates
	 */
	EgoiMapList getTemplates(EgoiMap arguments) throws EgoiException;

	/**
	 * Enviar uma campanha de Voz
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#sendcall
	 */
	EgoiMap sendCall(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de email
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#sendemail
	 */
	EgoiMap sendEmail(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de Fax
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#sendfax
	 */
	EgoiMap sendFAX(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de SMS
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#sendsms
	 */
	EgoiMap sendSMS(EgoiMap arguments) throws EgoiException;

        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Common">
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editapicallback
	 */
	EgoiMap editApiCallback(EgoiMap arguments) throws EgoiException;
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getoperationsqueue
	 */
	EgoiMapList getOperationsQueue(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Forms">
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getforms
	 */
	EgoiMapList getForms(EgoiMap arguments) throws EgoiException;
        
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getformssubmissions
	 */
	EgoiMapList getFormsSubmissions(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Lists">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#addextrafield
	 */
        EgoiMap addExtraField(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createlist
	 */
	EgoiMap createList(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#deleteextrafield
	 */
	EgoiMap deleteExtraField(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#deletelist
	 */
	EgoiMap deleteList(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editextrafield
	 */
	EgoiMap editExtraField(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getextrafields
	 */
	EgoiMapList getextrafields(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getlists
	 */
	EgoiMapList getLists(EgoiMap arguments) throws EgoiException;
        
        /**
	 * Editar as opções de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#updatelist
	 */
	EgoiMap updateList(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Reports">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#generateadvancedreport
	 */
	EgoiMap generateAdvancedReport(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getadvancedreport
	 */
	EgoiMapList getAdvancedReport(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getreport
	 */
	EgoiMap getReport(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Segments">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createsegment
	 */
	EgoiMap createSegment(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#createsegmentadvanced
	 */
	EgoiMap createSegmentAdvanced(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#deletesegment
	 */
	EgoiMap deleteSegment(EgoiMap arguments) throws EgoiException;
        
        /**
	 * Ver os segmentos de uma lista
	 * @param arguments
	 * @return
	 * @see https://api-docs.e-goi.com/index.html#getsegments
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#getsegments
	 */
	EgoiMapList getSegments(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Senders">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#addcname
	 */
	EgoiMap addCname(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#addsender
	 */
	EgoiMap addSender(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#deletesender
	 */
	EgoiMap deleteSender(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editsender
	 */
	EgoiMap editSender(EgoiMap arguments) throws EgoiException;
        
        /**
	 * Obter uma listagem dos remetentes
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#getsenders
	 */
	EgoiMapList getSenders(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Subscribers">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#adicionar-subscritor
	 */
	EgoiMap addSubscriber(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#addsubscriberbulk
	 */
	EgoiMap addSubscriberBulk(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#editsubscriber
	 */
	EgoiMap editSubscriber(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#getsubscriberactivity
	 */
        EgoiMapList getSubscriberActivity(EgoiMap arguments) throws EgoiException;
        
        /**
	 * Remover um subscritor de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#removesubscriber
	 */
	EgoiMap removeSubscriber(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter os dados de um subscritor
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see https://api-docs.e-goi.com/index.html#subscriberdata
	 */
	EgoiMap subscriberData(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Tags">
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#addtag
	 */
	EgoiMap addTag(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#attachtag
	 */
	EgoiMap attachTag(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#deletetag
	 */
	EgoiMap deleteTag(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#detachtag
	 */
	EgoiMap detachTag(EgoiMap arguments) throws EgoiException;
        
        /* (non-Javadoc)
	 * @see https://api-docs.e-goi.com/index.html#gettags
	 */
        EgoiMapList getTags(EgoiMap arguments) throws EgoiException;
        
        //</editor-fold>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}