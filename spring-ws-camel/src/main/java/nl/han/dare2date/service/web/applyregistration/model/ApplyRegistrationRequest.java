//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.01 at 05:10:31 PM CET 
//


package nl.han.dare2date.service.web.applyregistration.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registration" type="{http://www.han.nl/schemas/messages}Registration"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "registration"
})
@XmlRootElement(name = "ApplyRegistrationRequest")
public class ApplyRegistrationRequest implements Serializable {

    @XmlElement(required = true)
    protected Registration registration;

    /**
     * Gets the value of the registration property.
     *
     * @return possible object is
     * {@link Registration }
     */
    public Registration getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     *
     * @param value allowed object is
     *              {@link Registration }
     */
    public void setRegistration(Registration value) {
        this.registration = value;
    }

}
