package nl.han.dare2date.service.jms;

import nl.han.dare2date.applyregistrationservice.Creditcard;
import nl.han.dare2date.service.jms.util.Requestor;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;

/**
 * Created by samuel on 16/06/14.
 */
public class ValidateCreditcardRequestor extends Requestor {
    private Creditcard card;

    public ValidateCreditcardRequestor(Connection connection, String requestQueueName,
                                       String replyQueueName, String invalidQueueName,
                                       Creditcard card) throws JMSException, NamingException {
        super(connection, requestQueueName, replyQueueName, invalidQueueName);
        this.card = card;
    }

    /**
     * Override this method to provide an ObjectMessage that will be sent with the request
     *
     * @return
     */
    @Override
    public ObjectMessage getObjectMessage() {
        ObjectMessage msg;
        try {
            msg = getSession().createObjectMessage();
            msg.setObject(new ValidateCreditcardRequest(card));
            return msg;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Override this method to retrieve the response
     *
     * @return
     */
    @Override
    public ValidateCreditcardResponse getResponse() {
        ObjectMessage replyMessage = getReplyMessage();
        try {
            return (ValidateCreditcardResponse) replyMessage.getObject();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
