package nl.han.dare2date.service.jms;

import nl.han.dare2date.service.jms.util.DurableObserver;
import nl.han.dare2date.service.jms.util.ObserverGateway;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * Created by samuel on 18/06/14.
 */
public class ConfirmRegistrationNotifiers {

    public static void main(String[] archs) {
        DurableObserver obs0 = new UserNotification("Michiel");
        DurableObserver obs1 = new SubscriberNotification("Samuel");
        DurableObserver obs2 = new PublisherNotification("Rens");
        try {
            ObserverGateway gtw0 = new ObserverGateway(obs0, Queues.UPDATE_TOPIC_NAME);
            ObserverGateway gtw1 = new ObserverGateway(obs1, Queues.UPDATE_TOPIC_NAME);
            ObserverGateway gtw2 = new ObserverGateway(obs2, Queues.UPDATE_TOPIC_NAME);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
