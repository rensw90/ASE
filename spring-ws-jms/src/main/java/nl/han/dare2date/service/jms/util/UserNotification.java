package nl.han.dare2date.service.jms.util;

import java.util.Observable;

/**
 * Created by samuel on 16/06/14.
 */
public class UserNotification implements DurableObserver {
    public void update(Observable arg0, Object arg1) {
        System.out.println(getClass().getName() + " Received a Notification " + arg1);
    }

    @Override
    public String getSubscriberName() {
        return "User";
    }
}
