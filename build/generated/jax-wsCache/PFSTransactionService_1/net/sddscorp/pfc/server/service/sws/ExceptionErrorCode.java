
package net.sddscorp.pfc.server.service.sws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exceptionErrorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="exceptionErrorCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHOW_ERROR_MESSAGE"/>
 *     &lt;enumeration value="UNKNOWN_EXCEPTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "exceptionErrorCode")
@XmlEnum
public enum ExceptionErrorCode {

    SHOW_ERROR_MESSAGE,
    UNKNOWN_EXCEPTION;

    public String value() {
        return name();
    }

    public static ExceptionErrorCode fromValue(String v) {
        return valueOf(v);
    }

}
