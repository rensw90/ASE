package nl.han.dare2date.service.web.validateCreditcard;

/**
 * Created by samuel on 18/06/14.
 */
public class IValidateCreditcardServiceFactory {
    public static IValidateCreditcardService create() {

        return new ValidateCreditcardService();
    }
}
