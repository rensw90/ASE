package nl.ase.dare2date.webservice.payment;

import nl.ase.dare2date.webservice.PaymentData;

import java.io.IOException;

/**
 * Created by Rens on 3-6-2014.
 */
public class VerifyPayment implements IVerifyPayment {

    private IMakePayment makePayment;

    public VerifyPayment(IMakePayment makePayment) {
        this.makePayment = makePayment;
    }

    public boolean verifyPaymentData(PaymentData paymentData) throws IOException {
        makePayment.payment(paymentData);
        return false;
    }
}
