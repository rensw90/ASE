/*
    Copyright (C) [2013] by [Rody Middelkoop, HAN University]

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
*/

package nl.han.dare2date.service.web.confirmregistration;

import nl.han.dare2date.applyregistrationservice.Registration;
import nl.han.dare2date.service.jms.ConfirmRegistrationRequest;
import nl.han.dare2date.service.jms.Queues;
import nl.han.dare2date.service.jms.util.SubjectGateway;

import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 * @author mdkr
 *         <p/>
 *         Is used as a JMS publisher
 */
public class ConfirmRegistrationService implements IConfirmRegistrationService {
    public void confirm(Registration reg) {
        ConfirmRegistrationRequest request = new ConfirmRegistrationRequest();
        try {

            SubjectGateway gateway = new SubjectGateway(Queues.UPDATE_TOPIC_NAME);
            gateway.notifyObservers(request);

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

