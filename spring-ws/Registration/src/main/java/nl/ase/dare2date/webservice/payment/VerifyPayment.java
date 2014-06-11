package nl.ase.dare2date.webservice.payment;

import nl.ase.dare2date.webservice.PaymentData;

/**
 * Created by Rens on 3-6-2014.
 */
public class VerifyPayment implements IVerifyPayment {

    private IMakePayment makePayment;

    public VerifyPayment(IMakePayment makePayment) {
        this.makePayment = makePayment;
    }

    public boolean verifyPaymentData(PaymentData paymentData) {
        makePayment.payment(paymentData);
        return false;
    }
}
