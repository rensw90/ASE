package nl.han.dare2date.service.jms.locator;

import nl.han.dare2date.service.web.confirmregistration.IConfirmRegistrationService;
import nl.han.dare2date.service.web.confirmregistration.IConformRegistrationServiceFactory;
import nl.han.dare2date.service.web.validateCreditcard.IValidateCreditcardService;
import nl.han.dare2date.service.web.validateCreditcard.IValidateCreditcardServiceFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samuel on 18/06/14.
 */
public class ServiceLocator implements IServiceLocator {
    private final Map<Class, Object> services = new HashMap<Class, Object>();

    ServiceLocator() {
        //services.put(IConfirmRegistrationService.class, new ConfirmRegistrationService());
        //services.put(IValidateCreditcardService.class, new ValidateCreditcardService());

        services.put(IConfirmRegistrationService.class, IConformRegistrationServiceFactory.create());
        services.put(IValidateCreditcardService.class, IValidateCreditcardServiceFactory.create());
    }

    public <T> T getService(Class<T> key) {
        return (T) services.get(key);
    }
}
