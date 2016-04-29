
package net.sddscorp.pfc.server.service.sws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.sddscorp.pfc.server.service.sws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetP2435_QNAME = new QName("http://sws.service.server.pfc.sddscorp.net/", "getP2435");
    private final static QName _PFCSException_QNAME = new QName("http://sws.service.server.pfc.sddscorp.net/", "PFCSException");
    private final static QName _GetP2435Response_QNAME = new QName("http://sws.service.server.pfc.sddscorp.net/", "getP2435Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.sddscorp.pfc.server.service.sws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetP2435 }
     * 
     */
    public GetP2435 createGetP2435() {
        return new GetP2435();
    }

    /**
     * Create an instance of {@link PFCSException }
     * 
     */
    public PFCSException createPFCSException() {
        return new PFCSException();
    }

    /**
     * Create an instance of {@link GetP2435Response }
     * 
     */
    public GetP2435Response createGetP2435Response() {
        return new GetP2435Response();
    }

    /**
     * Create an instance of {@link PfstReqData }
     * 
     */
    public PfstReqData createPfstReqData() {
        return new PfstReqData();
    }

    /**
     * Create an instance of {@link PfsMiniStatements }
     * 
     */
    public PfsMiniStatements createPfsMiniStatements() {
        return new PfsMiniStatements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetP2435 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sws.service.server.pfc.sddscorp.net/", name = "getP2435")
    public JAXBElement<GetP2435> createGetP2435(GetP2435 value) {
        return new JAXBElement<GetP2435>(_GetP2435_QNAME, GetP2435 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PFCSException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sws.service.server.pfc.sddscorp.net/", name = "PFCSException")
    public JAXBElement<PFCSException> createPFCSException(PFCSException value) {
        return new JAXBElement<PFCSException>(_PFCSException_QNAME, PFCSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetP2435Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sws.service.server.pfc.sddscorp.net/", name = "getP2435Response")
    public JAXBElement<GetP2435Response> createGetP2435Response(GetP2435Response value) {
        return new JAXBElement<GetP2435Response>(_GetP2435Response_QNAME, GetP2435Response.class, null, value);
    }

}
