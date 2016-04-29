
package net.sddscorp.pfc.server.service.sws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pfstReqData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pfstReqData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sws.service.server.pfc.sddscorp.net/}pfstResData">
 *       &lt;sequence>
 *         &lt;element name="accountno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feecharge" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="gatewayId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saccountname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saccountno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sbankname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taccountname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taccountno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tranDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranToken" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tranType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pfstReqData", propOrder = {
    "accountno",
    "feecharge",
    "gatewayId",
    "limit",
    "ode",
    "passId",
    "referenceno",
    "saccountname",
    "saccountno",
    "sbankname",
    "sequenceNo",
    "stan",
    "taccountname",
    "taccountno",
    "tranAmount",
    "tranDate",
    "tranDesc",
    "tranToken",
    "tranType"
})
public class PfstReqData
    extends PfstResData
{

    protected String accountno;
    protected Double feecharge;
    protected String gatewayId;
    protected int limit;
    protected String ode;
    protected String passId;
    protected String referenceno;
    protected String saccountname;
    protected String saccountno;
    protected String sbankname;
    protected String sequenceNo;
    protected String stan;
    protected String taccountname;
    protected String taccountno;
    protected Double tranAmount;
    protected String tranDate;
    protected String tranDesc;
    protected Integer tranToken;
    protected String tranType;

    /**
     * Gets the value of the accountno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountno() {
        return accountno;
    }

    /**
     * Sets the value of the accountno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountno(String value) {
        this.accountno = value;
    }

    /**
     * Gets the value of the feecharge property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFeecharge() {
        return feecharge;
    }

    /**
     * Sets the value of the feecharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFeecharge(Double value) {
        this.feecharge = value;
    }

    /**
     * Gets the value of the gatewayId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGatewayId() {
        return gatewayId;
    }

    /**
     * Sets the value of the gatewayId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGatewayId(String value) {
        this.gatewayId = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(int value) {
        this.limit = value;
    }

    /**
     * Gets the value of the ode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOde() {
        return ode;
    }

    /**
     * Sets the value of the ode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOde(String value) {
        this.ode = value;
    }

    /**
     * Gets the value of the passId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassId() {
        return passId;
    }

    /**
     * Sets the value of the passId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassId(String value) {
        this.passId = value;
    }

    /**
     * Gets the value of the referenceno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceno() {
        return referenceno;
    }

    /**
     * Sets the value of the referenceno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceno(String value) {
        this.referenceno = value;
    }

    /**
     * Gets the value of the saccountname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaccountname() {
        return saccountname;
    }

    /**
     * Sets the value of the saccountname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaccountname(String value) {
        this.saccountname = value;
    }

    /**
     * Gets the value of the saccountno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaccountno() {
        return saccountno;
    }

    /**
     * Sets the value of the saccountno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaccountno(String value) {
        this.saccountno = value;
    }

    /**
     * Gets the value of the sbankname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbankname() {
        return sbankname;
    }

    /**
     * Sets the value of the sbankname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbankname(String value) {
        this.sbankname = value;
    }

    /**
     * Gets the value of the sequenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceNo() {
        return sequenceNo;
    }

    /**
     * Sets the value of the sequenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceNo(String value) {
        this.sequenceNo = value;
    }

    /**
     * Gets the value of the stan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStan() {
        return stan;
    }

    /**
     * Sets the value of the stan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStan(String value) {
        this.stan = value;
    }

    /**
     * Gets the value of the taccountname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaccountname() {
        return taccountname;
    }

    /**
     * Sets the value of the taccountname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaccountname(String value) {
        this.taccountname = value;
    }

    /**
     * Gets the value of the taccountno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaccountno() {
        return taccountno;
    }

    /**
     * Sets the value of the taccountno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaccountno(String value) {
        this.taccountno = value;
    }

    /**
     * Gets the value of the tranAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTranAmount() {
        return tranAmount;
    }

    /**
     * Sets the value of the tranAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTranAmount(Double value) {
        this.tranAmount = value;
    }

    /**
     * Gets the value of the tranDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranDate() {
        return tranDate;
    }

    /**
     * Sets the value of the tranDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranDate(String value) {
        this.tranDate = value;
    }

    /**
     * Gets the value of the tranDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranDesc() {
        return tranDesc;
    }

    /**
     * Sets the value of the tranDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranDesc(String value) {
        this.tranDesc = value;
    }

    /**
     * Gets the value of the tranToken property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTranToken() {
        return tranToken;
    }

    /**
     * Sets the value of the tranToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTranToken(Integer value) {
        this.tranToken = value;
    }

    /**
     * Gets the value of the tranType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranType() {
        return tranType;
    }

    /**
     * Sets the value of the tranType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranType(String value) {
        this.tranType = value;
    }

}
