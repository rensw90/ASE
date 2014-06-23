package nl.han.dare2date.service.jms;

import java.io.Serializable;

/**
 * Created by samuel on 16/06/14.
 */
public class ValidateCreditcardResponse implements Serializable {
    private boolean valid;

    public ValidateCreditcardResponse(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
