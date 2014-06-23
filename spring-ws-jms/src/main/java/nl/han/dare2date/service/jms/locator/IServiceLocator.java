package nl.han.dare2date.service.jms.locator;

/**
 * Created by samuel on 18/06/14.
 */
public interface IServiceLocator {
    public <T> T getService(Class<T> key);
}
