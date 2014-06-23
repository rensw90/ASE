package nl.creditcheck.service.jms;

import nl.han.dare2date.service.jms.Queues;
import nl.han.dare2date.service.jms.util.JMSUtil;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.NamingException;


/**
 * Created by samuel on 16/06/14.
 */
public class ExternalValidateCreditcardService {

    public static void main(String args[]) {
        new ExternalValidateCreditcardService().initialize();
    }

    public void initialize() {
        try {
            Connection conn = JMSUtil.getConnection();
            new ExternalValidateCreditcardReplier(conn, Queues.REQUEST_QUEUE, Queues.INVALID_QUEUE);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
