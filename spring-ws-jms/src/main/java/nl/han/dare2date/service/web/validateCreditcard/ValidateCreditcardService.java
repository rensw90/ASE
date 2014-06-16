package nl.han.dare2date.service.web.validateCreditcard;


import nl.han.dare2date.applyregistrationservice.Creditcard;
import nl.han.dare2date.service.jms.util.JMSUtil;
import nl.han.dare2date.service.jms.util.Queues;
import nl.han.dare2date.service.jms.util.ValidateCreditcardRequestor;
import nl.han.dare2date.service.jms.util.ValidateCreditcardResponse;

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

        // Creditcard card = new Creditcard();
        // card.cvc = cc.getCvc();
        // card.Number = cc.getNumber();
        // card.validTrough = cc.getValidThrough();

        try {
            ValidateCreditcardRequestor requestor = new ValidateCreditcardRequestor(conn, requestQueueName, replyQueueName, invalidQueueName, cc);
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