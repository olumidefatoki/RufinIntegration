
package net.sddscorp.pfc.server.service.sws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pfstResData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pfstResData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="account_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accounttype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorization_num" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lbalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="logonmessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resp_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resp_message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statement" type="{http://sws.service.server.pfc.sddscorp.net/}pfsMiniStatements" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transaction_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transaction_message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transaction_status" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pfstResData", propOrder = {
    "abalance",
    "accountName",
    "accounttype",
    "authorizationNum",
    "lbalance",
    "logonmessage",
    "phoneno",
    "respCode",
    "respMessage",
    "statement",
    "transactionError",
    "transactionMessage",
    "transactionStatus"
})
@XmlSeeAlso({
    PfstReqData.class
})
public abstract class PfstResData {

    protected double abalance;
    @XmlElement(name = "account_name")
    protected String accountName;
    protected String accounttype;
    @XmlElement(name = "authorization_num")
    protected String authorizationNum;
    protected double lbalance;
    protected String logonmessage;
    protected String phoneno;
    @XmlElement(name = "resp_code")
    protected String respCode;
    @XmlElement(name = "resp_message")
    protected String respMessage;
    @XmlElement(nillable = true)
    protected List<PfsMiniStatements> statement;
    @XmlElement(name = "transaction_error")
    protected String transactionError;
    @XmlElement(name = "transaction_message")
    protected String transactionMessage;
    @XmlElement(name = "transaction_status")
    protected boolean transactionStatus;

    /**
     * Gets the value of the abalance property.
     * 
     */
    public double getAbalance() {
        return abalance;
    }

    /**
     * Sets the value of the abalance property.
     * 
     */
    public void setAbalance(double value) {
        this.abalance = value;
    }

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accounttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccounttype() {
        return accounttype;
    }

    /**
     * Sets the value of the accounttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccounttype(String value) {
        this.accounttype = value;
    }

    /**
     * Gets the value of the authorizationNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationNum() {
        return authorizationNum;
    }

    /**
     * Sets the value of the authorizationNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationNum(String value) {
        this.authorizationNum = value;
    }

    /**
     * Gets the value of the lbalance property.
     * 
     */
    public double getLbalance() {
        return lbalance;
    }

    /**
     * Sets the value of the lbalance property.
     * 
     */
    public void setLbalance(double value) {
        this.lbalance = value;
    }

    /**
     * Gets the value of the logonmessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogonmessage() {
        return logonmessage;
    }

    /**
     * Sets the value of the logonmessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogonmessage(String value) {
        this.logonmessage = value;
    }

    /**
     * Gets the value of the phoneno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * Sets the value of the phoneno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneno(String value) {
        this.phoneno = value;
    }

    /**
     * Gets the value of the respCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespCode() {
        return respCode;
    }

    /**
     * Sets the value of the respCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespCode(String value) {
        this.respCode = value;
    }

    /**
     * Gets the value of the respMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespMessage() {
        return respMessage;
    }

    /**
     * Sets the value of the respMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespMessage(String value) {
        this.respMessage = value;
    }

    /**
     * Gets the value of the statement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PfsMiniStatements }
     * 
     * 
     */
    public List<PfsMiniStatements> getStatement() {
        if (statement == null) {
            statement = new ArrayList<PfsMiniStatements>();
        }
        return this.statement;
    }

    /**
     * Gets the value of the transactionError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionError() {
        return transactionError;
    }

    /**
     * Sets the value of the transactionError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionError(String value) {
        this.transactionError = value;
    }

    /**
     * Gets the value of the transactionMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionMessage() {
        return transactionMessage;
    }

    /**
     * Sets the value of the transactionMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionMessage(String value) {
        this.transactionMessage = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     */
    public boolean isTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     */
    public void setTransactionStatus(boolean value) {
        this.transactionStatus = value;
    }

}
