package nl.han.dare2date.service.jms;

import nl.han.dare2date.service.jms.util.DurableObserver;

import java.util.Observable;

/**
 * Created by samuel on 18/06/14.
 */
public class SubscriberNotification implements DurableObserver {
    String user;

    public SubscriberNotification(String user) {
        this.user = user;
    }

    public void update(Observable arg0, Object arg1) {
        System.out.println(getClass().getName() + " Received a Notification " + arg1);
    }

    @Override
    public String getSubscriberName() {
        return user;
    }
}
