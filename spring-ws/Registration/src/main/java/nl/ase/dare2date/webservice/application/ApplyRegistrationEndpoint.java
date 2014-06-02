package nl.ase.dare2date.webservice.application;

import nl.ase.dare2date.webservice.RegistrationRequest;
import nl.ase.dare2date.webservice.RegistrationResponse;
import nl.ase.dare2date.webservice.RegistrationResult;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class ApplyRegistrationEndpoint {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public ApplyRegistrationEndpoint(Marshaller marshaller, Unmarshaller unmarshaller) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @PayloadRoot(localPart = "RegistrationRequest", namespace = "http://www.han.nl/schemas/messages")
    public RegistrationResponse calculateSumForName(RegistrationRequest req) {

        RegistrationResult result = new RegistrationResult();
        result.setMessage("Here are the results of the jury for the registration ");
        result.setSucceeded(true);
        RegistrationResponse resp = new RegistrationResponse();
        resp.setResult(result);
        System.out.print("TEST!!!!!!");

        return resp;
    }
}
