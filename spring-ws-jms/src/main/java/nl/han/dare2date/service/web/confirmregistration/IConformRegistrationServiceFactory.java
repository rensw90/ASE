package nl.han.dare2date.service.web.confirmregistration;

/**
 * Created by samuel on 18/06/14.
 */
public class IConformRegistrationServiceFactory {
    public static IConfirmRegistrationService create() {

        return new ConfirmRegistrationService();
    }
}
