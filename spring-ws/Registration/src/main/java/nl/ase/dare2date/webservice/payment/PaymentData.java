package nl.ase.dare2date.webservice.payment;

import java.util.Date;

/**
 * Created by Rens on 3-6-2014.
 */
public class PaymentData {
    private int creditCardNumber;
    private Date expireDate;
    private String name;
    private String securityCode;
    private String creditcardType;

    public PaymentData(int creditCardNumber, Date expireDate, String name, String securityCode, String creditcardType) {
        this.creditCardNumber = creditCardNumber;
        this.expireDate = expireDate;
        this.name = name;
        this.securityCode = securityCode;
        this.creditcardType = creditcardType;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCreditcardType() {
        return creditcardType;
    }

    public void setCreditcardType(String creditcardType) {
        this.creditcardType = creditcardType;
    }
}
