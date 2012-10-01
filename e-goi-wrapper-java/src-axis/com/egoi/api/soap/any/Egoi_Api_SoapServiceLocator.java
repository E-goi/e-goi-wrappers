/**
 * Egoi_Api_SoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.egoi.api.soap.any;

public class Egoi_Api_SoapServiceLocator extends org.apache.axis.client.Service implements com.egoi.api.soap.any.Egoi_Api_SoapService {

    public Egoi_Api_SoapServiceLocator() {
    }


    public Egoi_Api_SoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Egoi_Api_SoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Egoi_Api_SoapPort
    private java.lang.String Egoi_Api_SoapPort_address = "http://api.e-goi.com/v2/soap_any.php";

    public java.lang.String getEgoi_Api_SoapPortAddress() {
        return Egoi_Api_SoapPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Egoi_Api_SoapPortWSDDServiceName = "Egoi_Api_SoapPort";

    public java.lang.String getEgoi_Api_SoapPortWSDDServiceName() {
        return Egoi_Api_SoapPortWSDDServiceName;
    }

    public void setEgoi_Api_SoapPortWSDDServiceName(java.lang.String name) {
        Egoi_Api_SoapPortWSDDServiceName = name;
    }

    public com.egoi.api.soap.any.Egoi_Api_SoapPort getEgoi_Api_SoapPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Egoi_Api_SoapPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEgoi_Api_SoapPort(endpoint);
    }

    public com.egoi.api.soap.any.Egoi_Api_SoapPort getEgoi_Api_SoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.egoi.api.soap.any.Egoi_Api_SoapBindingStub _stub = new com.egoi.api.soap.any.Egoi_Api_SoapBindingStub(portAddress, this);
            _stub.setPortName(getEgoi_Api_SoapPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEgoi_Api_SoapPortEndpointAddress(java.lang.String address) {
        Egoi_Api_SoapPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.egoi.api.soap.any.Egoi_Api_SoapPort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.egoi.api.soap.any.Egoi_Api_SoapBindingStub _stub = new com.egoi.api.soap.any.Egoi_Api_SoapBindingStub(new java.net.URL(Egoi_Api_SoapPort_address), this);
                _stub.setPortName(getEgoi_Api_SoapPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Egoi_Api_SoapPort".equals(inputPortName)) {
            return getEgoi_Api_SoapPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://api.e-goi.com/v2/soap_any.php", "Egoi_Api_SoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://api.e-goi.com/v2/soap_any.php", "Egoi_Api_SoapPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Egoi_Api_SoapPort".equals(portName)) {
            setEgoi_Api_SoapPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
