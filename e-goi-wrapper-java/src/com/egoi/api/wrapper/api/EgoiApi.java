package com.egoi.api.wrapper.api;

import com.egoi.api.wrapper.api.exceptions.EgoiException;

/**
 * @author Luís Lobo <lflobo@gmail.com>
 */
public interface EgoiApi {
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/addextrafield/
	 */
	EgoiMap addExtraField(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/adicionar-subscritor/
	 */
	EgoiMap addSubscriber(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/addsubscriberbulk/
	 */
	EgoiMap addSubscriberBulk(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/checklogin/
	 */
	EgoiMap checklogin(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignemail/
	 */
	EgoiMap createCampaignEmail(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignfax/
	 */
	EgoiMap createCampaignFAX(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignsms/
	 */
	EgoiMap createCampaignSMS(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/createcampaignvoice/
	 */
	EgoiMap createCampaignVoice(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/createlist/
	 */
	EgoiMap createList(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/createsegment/
	 */
	EgoiMap createSegment(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/deletecampaign/
	 */
	EgoiMap deleteCampaign(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/deletelist/
	 */
	EgoiMap deleteList(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/deletesegment/
	 */
	EgoiMap deleteSegment(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/editcampaignemail/
	 */
	EgoiMap editCampaignEmail(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/editcampaignsms/
	 */
	EgoiMap editCampaignSMS(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/editextrafield/
	 */
	EgoiMap editExtraField(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/editsubscriber/
	 */
	EgoiMap editSubscriber(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/getcampaigns/
	 */
	EgoiMapList getCampaigns(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/getclientdata/
	 */
	EgoiMap getClientData(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/getcredits/
	 */
	EgoiMap getCredits(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/getlists/
	 */
	EgoiMapList getLists(EgoiMap arguments) throws EgoiException;
	
	/* (non-Javadoc)
	 * @see http://www.e-goi.pt/pt/recursos/api/getreport/
	 */
	EgoiMap getReport(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Ver os segmentos de uma lista
	 * @param arguments
	 * @return
	 * @see http://www.e-goi.pt/pt/recursos/api/getsegments
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getsegments/
	 */
	EgoiMapList getSegments(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter uma listagem dos remetentes
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getsenders/
	 */
	EgoiMapList getSenders(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter os dados de um utilizador E-goi
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/getuserdata/
	 */
	EgoiMap getUserData(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Remover um subscritor de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/removesubscriber/
	 */
	EgoiMap removeSubscriber(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de Voz
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendcall/
	 */
	EgoiMap sendCall(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de email
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendemail/
	 */
	EgoiMap sendEmail(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de Fax
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendfax/
	 */
	EgoiMap sendFAX(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Enviar uma campanha de SMS
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/sendsms/
	 */
	EgoiMap sendSMS(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Obter os dados de um subscritor
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/subscriberdata/
	 */
	EgoiMap subscriberData(EgoiMap arguments) throws EgoiException;
	
	/**
	 * Editar as opções de uma lista
	 * @param arguments
	 * @return
	 * @throws EgoiException
	 * @see http://www.e-goi.pt/pt/recursos/api/updatelist/
	 */
	EgoiMap updateList(EgoiMap arguments) throws EgoiException;

}