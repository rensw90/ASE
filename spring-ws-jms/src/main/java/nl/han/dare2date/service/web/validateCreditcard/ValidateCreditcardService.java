package nl.han.dare2date.service.web.validateCreditcard;


import nl.han.dare2date.applyregistrationservice.Creditcard;
import nl.han.dare2date.service.jms.Queues;
import nl.han.dare2date.service.jms.ValidateCreditcardRequestor;
import nl.han.dare2date.service.jms.ValidateCreditcardResponse;
import nl.han.dare2date.service.jms.util.JMSUtil;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * @author mdkr
 *         <p/>
 *         Is used as a JMS client using request-reply
 */
public class ValidateCreditcardService implements Queues, IValidateCreditcardService {

    public boolean validate(Creditcard cc) {
        Connection conn = JMSUtil.getConnection();

        String requestQueueName = Queues.REQUEST_QUEUE;
        String replyQueueName = Queues.REPLY_QUEUE;
        String invalidQueueName = Queues.INVALID_QUEUE;

        Creditcard card = new Creditcard();
        card.setCvc(cc.getCvc());
        card.setNumber(cc.getNumber());
        card.setValidThrough(cc.getValidThrough());

        try {
            ValidateCreditcardRequestor requestor = new ValidateCreditcardRequestor(conn, requestQueueName, replyQueueName, invalidQueueName, card);
            requestor.send();

            requestor.receiveSync();
            ValidateCreditcardResponse response = requestor.getResponse();
            conn.close();
            return response.isValid();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return false;
    }
}