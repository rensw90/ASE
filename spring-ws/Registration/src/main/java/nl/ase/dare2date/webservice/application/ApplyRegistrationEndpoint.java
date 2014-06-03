package nl.ase.dare2date.webservice.application;

import nl.ase.dare2date.webservice.RegistrationRequest;
import nl.ase.dare2date.webservice.RegistrationResponse;
import nl.ase.dare2date.webservice.RegistrationResult;
import nl.ase.dare2date.webservice.confirm.IConformRegistration;
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

    public ApplyRegistrationEndpoint(Marshaller marshaller, Unmarshaller unmarshaller, IVerifyRegistration verifyRegistration, IConformRegistration confirmRegistration) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
        this.verifyRegistration = verifyRegistration;
        this.conformRegistration = confirmRegistration;
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @PayloadRoot(localPart = "RegistrationRequest", namespace = "http://www.han.nl/schemas/messages")
    public RegistrationResponse calculateSumForName(RegistrationRequest req) {

        RegistrationResult result = new RegistrationResult();
        if (verifyRegistration.verifyRegistration(req.getInput().getSubscriber()) == true) {
            result.setSucceeded(true);
            conformRegistration.confirmNewSubscriber(req.getInput().getSubscriber());
        } else {
            result.setSucceeded(false);
        }

        result.setMessage("Here are the results of the jury for the calculation ");
        result.setSucceeded(false);
        RegistrationResponse resp = new RegistrationResponse();
        resp.setResult(result);

        return resp;
    }
}
