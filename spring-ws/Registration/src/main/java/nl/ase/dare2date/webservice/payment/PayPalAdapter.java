package nl.ase.dare2date.webservice.payment;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import nl.ase.dare2date.webservice.PaymentData;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;

/**
 * Created by Rens on 3-6-2014.
 */
public class PayPalAdapter implements IMakePayment {
    private final String USER_AGENT = "Mozilla/5.0";
    private String charset = "UTF-8";
    private String accessToken = "";
    private String clientID;
    private String clientSecret;

    public PayPalAdapter(String clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    public boolean payment(PaymentData paymentData) {
        return getPayPalAccessToken();
    }

    public boolean getPayPalAccessToken() throws JSONException {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(clientID, clientSecret));

        WebResource webResource = client.resource("https://api.sandbox.paypal.com" + "/v1/oauth2/token");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("grant_type", "client_credentials");

        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);

        JSONObject jsonResponse = new JSONObject(clientResponse.getEntity(String.class));
        try {
            this.accessToken = jsonResponse.getString("access_token");
        } catch (JSONException e) {
            return false;
        }
        return true;
    }
}