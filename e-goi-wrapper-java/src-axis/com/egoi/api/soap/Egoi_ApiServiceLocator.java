/**
 * Egoi_ApiServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.egoi.api.soap;

public class Egoi_ApiServiceLocator extends org.apache.axis.client.Service implements com.egoi.api.soap.Egoi_ApiService {

    public Egoi_ApiServiceLocator() {
    }


    public Egoi_ApiServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Egoi_ApiServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Egoi_ApiPort
    private java.lang.String Egoi_ApiPort_address = "http://api.e-goi.com/v2/soap.php";

    public java.lang.String getEgoi_ApiPortAddress() {
        return Egoi_ApiPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Egoi_ApiPortWSDDServiceName = "Egoi_ApiPort";

    public java.lang.String getEgoi_ApiPortWSDDServiceName() {
        return Egoi_ApiPortWSDDServiceName;
    }

    public void setEgoi_ApiPortWSDDServiceName(java.lang.String name) {
        Egoi_ApiPortWSDDServiceName = name;
    }

    public com.egoi.api.soap.Egoi_ApiPort getEgoi_ApiPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Egoi_ApiPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEgoi_ApiPort(endpoint);
    }

    public com.egoi.api.soap.Egoi_ApiPort getEgoi_ApiPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.egoi.api.soap.Egoi_ApiBindingStub _stub = new com.egoi.api.soap.Egoi_ApiBindingStub(portAddress, this);
            _stub.setPortName(getEgoi_ApiPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEgoi_ApiPortEndpointAddress(java.lang.String address) {
        Egoi_ApiPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.egoi.api.soap.Egoi_ApiPort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.egoi.api.soap.Egoi_ApiBindingStub _stub = new com.egoi.api.soap.Egoi_ApiBindingStub(new java.net.URL(Egoi_ApiPort_address), this);
                _stub.setPortName(getEgoi_ApiPortWSDDServiceName());
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
        if ("Egoi_ApiPort".equals(inputPortName)) {
            return getEgoi_ApiPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://api.e-goi.com/v2/soap.php", "Egoi_ApiService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://api.e-goi.com/v2/soap.php", "Egoi_ApiPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Egoi_ApiPort".equals(portName)) {
            setEgoi_ApiPortEndpointAddress(address);
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
