package nl.ase.dare2date.webservice.payment;

import nl.ase.dare2date.webservice.PaymentData;

/**
 * Created by Rens on 3-6-2014.
 */
public interface IMakePayment {

    public boolean payment(PaymentData paymentData);
}
