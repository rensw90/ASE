//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.01 at 05:10:31 PM CET 
//


package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * <p>Java class for Creditcard complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Creditcard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="cvc" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="validThrough" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Creditcard", propOrder = {
        "number",
        "cvc",
        "validThrough"
})
public class Creditcard implements Serializable {

    @XmlElement(required = true)
    protected BigInteger number;
    @XmlElement(required = true)
    protected BigInteger cvc;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validThrough;

    /**
     * Gets the value of the number property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

    /**
     * Gets the value of the cvc property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getCvc() {
        return cvc;
    }

    /**
     * Sets the value of the cvc property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setCvc(BigInteger value) {
        this.cvc = value;
    }

    /**
     * Gets the value of the validThrough property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getValidThrough() {
        return validThrough;
    }

    /**
     * Sets the value of the validThrough property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setValidThrough(XMLGregorianCalendar value) {
        this.validThrough = value;
    }

}
