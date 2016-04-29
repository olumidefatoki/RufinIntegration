
package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SmartMicroTransactionGate", targetNamespace = "http://tempuri.org/", wsdlLocation = "https://www.newconsole.smartmicrosystemsng.net/CellulantLive/transactionGate.svc?wsdl")
public class SmartMicroTransactionGate
    extends Service
{

    private final static URL SMARTMICROTRANSACTIONGATE_WSDL_LOCATION;
    private final static WebServiceException SMARTMICROTRANSACTIONGATE_EXCEPTION;
    private final static QName SMARTMICROTRANSACTIONGATE_QNAME = new QName("http://tempuri.org/", "SmartMicroTransactionGate");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www.newconsole.smartmicrosystemsng.net/CellulantLive/transactionGate.svc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SMARTMICROTRANSACTIONGATE_WSDL_LOCATION = url;
        SMARTMICROTRANSACTIONGATE_EXCEPTION = e;
    }

    public SmartMicroTransactionGate() {
        super(__getWsdlLocation(), SMARTMICROTRANSACTIONGATE_QNAME);
    }

    public SmartMicroTransactionGate(WebServiceFeature... features) {
        super(__getWsdlLocation(), SMARTMICROTRANSACTIONGATE_QNAME, features);
    }

    public SmartMicroTransactionGate(URL wsdlLocation) {
        super(wsdlLocation, SMARTMICROTRANSACTIONGATE_QNAME);
    }

    public SmartMicroTransactionGate(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SMARTMICROTRANSACTIONGATE_QNAME, features);
    }

    public SmartMicroTransactionGate(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SmartMicroTransactionGate(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ITransactionGate
     */
    @WebEndpoint(name = "BasicHttpBinding_iTransactionGate")
    public ITransactionGate getBasicHttpBindingITransactionGate() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_iTransactionGate"), ITransactionGate.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ITransactionGate
     */
    @WebEndpoint(name = "BasicHttpBinding_iTransactionGate")
    public ITransactionGate getBasicHttpBindingITransactionGate(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_iTransactionGate"), ITransactionGate.class, features);
    }

    /**
     * 
     * @return
     *     returns ITransactionGate
     */
    @WebEndpoint(name = "BasicHttpsBinding_iTransactionGate")
    public ITransactionGate getBasicHttpsBindingITransactionGate() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpsBinding_iTransactionGate"), ITransactionGate.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ITransactionGate
     */
    @WebEndpoint(name = "BasicHttpsBinding_iTransactionGate")
    public ITransactionGate getBasicHttpsBindingITransactionGate(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpsBinding_iTransactionGate"), ITransactionGate.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SMARTMICROTRANSACTIONGATE_EXCEPTION!= null) {
            throw SMARTMICROTRANSACTIONGATE_EXCEPTION;
        }
        return SMARTMICROTRANSACTIONGATE_WSDL_LOCATION;
    }

}