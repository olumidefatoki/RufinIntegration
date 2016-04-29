
package net.sddscorp.pfc.server.service.sws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pfsMiniStatements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pfsMiniStatements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tranAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tranDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pfsMiniStatements", propOrder = {
    "tranAmount",
    "tranDate",
    "tranDesc",
    "tranType",
    "tranref"
})
public class PfsMiniStatements {

    protected double tranAmount;
    protected String tranDate;
    protected String tranDesc;
    protected String tranType;
    protected String tranref;

    /**
     * Gets the value of the tranAmount property.
     * 
     */
    public double getTranAmount() {
        return tranAmount;
    }

    /**
     * Sets the value of the tranAmount property.
     * 
     */
    public void setTranAmount(double value) {
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

    /**
     * Gets the value of the tranref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranref() {
        return tranref;
    }

    /**
     * Sets the value of the tranref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranref(String value) {
        this.tranref = value;
    }

}
