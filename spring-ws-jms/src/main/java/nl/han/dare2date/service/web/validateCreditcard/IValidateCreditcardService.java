package nl.han.dare2date.service.web.validateCreditcard;

import nl.han.dare2date.applyregistrationservice.Creditcard;

public interface IValidateCreditcardService {

    public boolean validate(Creditcard cc);
}