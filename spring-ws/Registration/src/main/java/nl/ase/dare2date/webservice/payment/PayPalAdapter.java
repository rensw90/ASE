package nl.ase.dare2date.webservice.payment;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import nl.ase.dare2date.webservice.PaymentData;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;

/**
 * Created by Rens on 3-6-2014.
 */
public class PayPalAdapter implements IMakePayment {
    private final String USER_AGENT = "Mozilla/5.0";
    private String charset = "UTF-8";

    public PayPalAdapter() {
        String clientID = "Acd-OBCht6k0EBUrT0RH-gfSA9pjlWqLyflGslo-qBBEPoIfcp_mrlyHyGk9";
        String clientSecret = "EH7fahDhT6rHE6C-gX3v-sf-zv1pFIgC0kEGbf2B1V7UIDg4c9GBxAk9OvEv";
    }

    public boolean payment(PaymentData paymentData) {
        /*
        String baseUrl = "https://api.sandbox.paypal.com";
        String urlRequest = "/v1/vault/credit-card";
        String url = baseUrl + urlRequest;
        this.doGet(url);
        */
        String token = getPayPalAccessToken();
        System.out.println(token);
        System.out.println("TEST");

        return false;
    }

    public String getPayPalAccessToken() {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("Acd-OBCht6k0EBUrT0RH-gfSA9pjlWqLyflGslo-qBBEPoIfcp_mrlyHyGk9", "EH7fahDhT6rHE6C-gX3v-sf-zv1pFIgC0kEGbf2B1V7UIDg4c9GBxAk9OvEv"));

        WebResource webResource = client.resource("https://api.sandbox.paypal.com" +
                "/v1/oauth2/token");

        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("grant_type", "client_credentials");

        ClientResponse clientResponse = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, formData);
        String output = clientResponse.getEntity(String.class);
        JSONObject test = new JSONObject(output);

        return test.getString("access_token");
    }


}