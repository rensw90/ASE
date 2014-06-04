package nl.ase.dare2date.webservice.payment;

import nl.ase.dare2date.webservice.PaymentData;

import java.io.IOException;

/**
 * Created by Rens on 3-6-2014.
 */
public interface IMakePayment {

    public boolean payment(PaymentData paymentData) throws IOException;
}
