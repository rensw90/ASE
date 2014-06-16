package nl.creditcheck.service.jms;

import nl.han.dare2date.applyregistrationservice.Creditcard;
import nl.han.dare2date.service.jms.util.Replier;
import nl.han.dare2date.service.jms.util.ValidateCreditcardRequest;
import nl.han.dare2date.service.jms.util.ValidateCreditcardResponse;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.Serializable;

/**
 * Created by samuel on 16/06/14.
 */
public class ExternalValidateCreditcardReplier extends Replier {
    private Creditcard card;

    protected ExternalValidateCreditcardReplier(Connection connection, String requestQueueName, String invalidQueueName) throws JMSException, NamingException {
        super(connection, requestQueueName, invalidQueueName);
    }

    /**
     * Override this method to provide an ObjectMessage with the reply
     *
     * @return
     */
    @Override
    public ObjectMessage getReplyMessage() {
        ObjectMessage msg = null;
        try {
            msg = getSession().createObjectMessage();
            boolean isValid = false;
            if (card.getCvc() == 1234 && card.getNumber() == 4321) {
                isValid = true;
            }
            ValidateCreditcardResponse response = new ValidateCreditcardResponse(isValid);
            msg.setObject(response);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * Override this method to implement how the incoming message should be handled
     *
     * @param contents
     */
    @Override
    public void handleMessage(Serializable contents) {
        ValidateCreditcardRequest request = (ValidateCreditcardRequest) contents;
        this.card = request.getCard();
    }
}
