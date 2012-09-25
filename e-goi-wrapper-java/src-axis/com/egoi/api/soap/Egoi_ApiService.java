/**
 * Egoi_ApiService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.egoi.api.soap;

public interface Egoi_ApiService extends javax.xml.rpc.Service {
    public java.lang.String getEgoi_ApiPortAddress();

    public com.egoi.api.soap.Egoi_ApiPort getEgoi_ApiPort() throws javax.xml.rpc.ServiceException;

    public com.egoi.api.soap.Egoi_ApiPort getEgoi_ApiPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
