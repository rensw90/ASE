package nl.ase.dare2date.webservice.registration;

import nl.ase.dare2date.webservice.Subscriber;

/**
 * Created by samuel on 2-6-14.
 */
public class VerifyRegistration implements IVerifyRegistration {
    private IVerifyEmail verifyEmail;

    public VerifyRegistration(IVerifyEmail verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public boolean verifyRegistration(Subscriber subscriber) {
        return verifyEmail.verifyEmail(subscriber.getEmail());
    }
}
