/**
 * Egoi_Api_SoapPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.egoi.api.soap.any;

public interface Egoi_Api_SoapPort extends java.rmi.Remote {

    /**
     * Testar o login
     */
    public java.lang.Object checkLogin(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter as campanhas de um determinado cliente
     */
    public java.lang.Object getCampaigns(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter os dados do utilizador
     */
    public java.lang.Object getUserData(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Actualizar os dados de uma lista
     */
    public java.lang.Object updateList(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter os remetentes de um determinado cliente
     */
    public java.lang.Object getSenders(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter o relatório de uma campanha
     */
    public java.lang.Object getReport(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter os dados do cliente
     */
    public java.lang.Object getClientData(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter os créditos
     */
    public java.lang.Object getCredits(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Enviar SMS
     */
    public java.lang.Object sendSMS(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Enviar email
     */
    public java.lang.Object sendEmail(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Enviar fax
     */
    public java.lang.Object sendFAX(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Enviar chamada de voz
     */
    public java.lang.Object sendCall(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Editar campanha de sms
     */
    public java.lang.Object editCampaignSMS(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Criar campanha de sms
     */
    public java.lang.Object createCampaignSMS(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Criar campanha de voz
     */
    public java.lang.Object createCampaignVoice(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Criar campanha de fax
     */
    public java.lang.Object createCampaignFAX(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Criar campanha de email
     */
    public java.lang.Object createCampaignEmail(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Apagar campanha
     */
    public java.lang.Object deleteCampaign(java.lang.Object functionOptions) throws java.rmi.RemoteException;
    
    /**
     * Apagar lista
     */
    public java.lang.Object deleteList(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Editar campanha de email
     */
    public java.lang.Object editCampaignEmail(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Adicionar novos subscritores
     */
    public java.lang.Object addSubscriberBulk(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Adicionar um novo subscritor
     */
    public java.lang.Object addSubscriber(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Remover subscritor
     */
    public java.lang.Object removeSubscriber(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Editar Dados de subscritor
     */
    public java.lang.Object editSubscriber(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter os dados do subscritor
     */
    public java.lang.Object subscriberData(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Criar Segmento
     */
    public java.lang.Object createSegment(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Apagar Segmento
     */
    public java.lang.Object deleteSegment(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter segmentos
     */
    public java.lang.Object getSegments(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter os headers e footers disponiveis para o cliente
     */
    public java.lang.Object getHeaderFooterTemplates(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Criar nova lista de subscritores
     *      stdClass $functionOptions opções da chamada à API
     */
    public java.lang.Object createList(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter as listas a que o utilizador tem acesso
     *      stdClass $functionOptions opções da chamada à API
     */
    public java.lang.Object getLists(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Adicionar campo extra
     */
    public java.lang.Object addExtraField(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Remover campo extra
     */
    public java.lang.Object deleteExtraField(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Editar campo extra
     */
    public java.lang.Object editExtraField(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Internal Function
     */
    public java.lang.Object createAccount(java.lang.Object functionOptions) throws java.rmi.RemoteException;

    /**
     * Internal Function
     */
    public java.lang.Object afiliado(java.lang.Object[] functionOptions) throws java.rmi.RemoteException;

    /**
     * Obter todos os erros ocorridos na ligação
     */
    public java.lang.Object getAllErrors() throws java.rmi.RemoteException;

    /**
     * Obter último erro ocorrido na ligação
     */
    public java.lang.Object getError() throws java.rmi.RemoteException;

    /**
     * Verificar se existe ligação
     */
    public boolean check_status() throws java.rmi.RemoteException;

    /**
     * Verifica se o email é válido
     */
    public boolean testEmailAddress(java.lang.String email) throws java.rmi.RemoteException;

    /**
     * Internal Function
     */
    public java.lang.Object checkUser(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getAutobots(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object startAutobot(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object createCampaignGroup(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object editCampaignGroup(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getTemplates(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object editApiCallback(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getOperationsQueue(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getForms(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getFormsSubmissions(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getExtraFields(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object generateAdvancedReport(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getAdvancedReport(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object createSegmentAdvanced(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object addCname(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object addSender(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object deleteSender(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object editSender(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getSubscriberActivity(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object addTag(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object attachTag(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object deleteTag(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object detachTag(java.lang.Object functionOptions) throws java.rmi.RemoteException;


    public java.lang.Object getTags(java.lang.Object functionOptions) throws java.rmi.RemoteException;
}
