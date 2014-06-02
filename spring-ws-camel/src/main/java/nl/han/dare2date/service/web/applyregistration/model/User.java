//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.01 at 05:10:31 PM CET 
//


package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>Java class for User complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="card" type="{http://www.han.nl/schemas/messages}Creditcard"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
        "firstname",
        "lastname",
        "card"
})
public class User implements Serializable {

    @XmlElement(required = true)
    protected String firstname;
    @XmlElement(required = true)
    protected String lastname;
    @XmlElement(required = true)
    protected Creditcard card;

    /**
     * Gets the value of the firstname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the card property.
     *
     * @return possible object is
     * {@link Creditcard }
     */
    public Creditcard getCard() {
        return card;
    }

    /**
     * Sets the value of the card property.
     *
     * @param value allowed object is
     *              {@link Creditcard }
     */
    public void setCard(Creditcard value) {
        this.card = value;
    }

}
