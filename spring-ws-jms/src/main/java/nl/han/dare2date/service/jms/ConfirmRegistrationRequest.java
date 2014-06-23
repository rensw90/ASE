package nl.han.dare2date.service.jms;

import nl.han.dare2date.applyregistrationservice.Registration;

import java.io.Serializable;

/**
 * Created by samuel on 18/06/14.
 */
public class ConfirmRegistrationRequest implements Serializable {
    Registration registration;

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

}
