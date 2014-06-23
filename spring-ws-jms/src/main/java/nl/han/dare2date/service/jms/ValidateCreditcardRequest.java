package nl.han.dare2date.service.jms;

import nl.han.dare2date.applyregistrationservice.Creditcard;

import java.io.Serializable;

/**
 * Created by samuel on 16/06/14.
 */
public class ValidateCreditcardRequest implements Serializable {

    private Creditcard card;

    public ValidateCreditcardRequest(Creditcard card) {
        this.card = card;
    }

    public ValidateCreditcardRequest() {
    }

    public Creditcard getCard() {
        return card;
    }

    public void setCard(Creditcard card) {
        this.card = card;
    }


}
