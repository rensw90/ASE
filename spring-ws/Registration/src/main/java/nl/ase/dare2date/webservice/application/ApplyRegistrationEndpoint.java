package nl.ase.dare2date.webservice.application;

import nl.ase.dare2date.webservice.RegistrationRequest;
import nl.ase.dare2date.webservice.RegistrationResponse;
import nl.ase.dare2date.webservice.RegistrationResult;
import nl.ase.dare2date.webservice.confirm.IConformRegistration;
import nl.ase.dare2date.webservice.payment.IVerifyPayment;
import nl.ase.dare2date.webservice.persistence.ISaveRegistration;
import nl.ase.dare2date.webservice.registration.IVerifyRegistration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class ApplyRegistrationEndpoint {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private IVerifyRegistration verifyRegistration;
    private IConformRegistration conformRegistration;
    private ISaveRegistration saveRegistration;
    private IVerifyPayment verifyPayment;

    public ApplyRegistrationEndpoint(Marshaller marshaller, Unmarshaller unmarshaller, IVerifyRegistration verifyRegistration, IConformRegistration confirmRegistration, ISaveRegistration saveRegistration, IVerifyPayment verifyPayment) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
        this.verifyRegistration = verifyRegistration;
        this.conformRegistration = confirmRegistration;
        this.saveRegistration = saveRegistration;
        this.verifyPayment = verifyPayment;
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @PayloadRoot(localPart = "RegistrationRequest", namespace = "http://www.han.nl/schemas/messages")
    public RegistrationResponse applyRegistration(RegistrationRequest req) {

        RegistrationResult result = new RegistrationResult();
        result.setSucceeded(false);
        if (verifyRegistration.verifyRegistration(req.getInput().getSubscriber()) == true) {
            result.setSucceeded(true);
            result.setMessage("invalid payment data");
            if (verifyPayment.verifyPaymentData(req.getInput().getPaymentData())) {
                result.setMessage("Could not save your registration");
                if (saveRegistration.saveSubscriber(req.getInput().getSubscriber())) {
                    result.setMessage("succeeded");
                    result.setSucceeded(true);
                    conformRegistration.confirmNewSubscriber(req.getInput().getSubscriber());
                }
            }

            //conformRegistration.confirmNewSubscriber(req.getInput().getSubscriber());
        } else {

            result.setMessage("ïnvalid email");
        }

        RegistrationResponse resp = new RegistrationResponse();
        resp.setResult(result);

        return resp;
    }
}