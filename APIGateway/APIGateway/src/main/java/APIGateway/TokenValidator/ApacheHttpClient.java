package APIGateway.TokenValidator;

/*
    Implemented token validator by Apache HTTP Client
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ApacheHttpClient implements  TokenValidator {

    private static Logger logger = Logger.getRootLogger();
    private static String authServer = "http://auth-server:5000/auth/action";

    public static boolean validateToken(String token, String action) throws IOException {

        // Prepare Body
        String param = "{\"token\":\"" + token + "\", \"action\": \"" + action + "\"}";

        // Create Apache Client
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(authServer);

        // Set Headers
        request.addHeader("Auth-Token", token);
        request.addHeader("ContentType", "application/json");

        // Set Body
        StringEntity body = new StringEntity(param);
        request.setEntity(body);

        // Get Response
        HttpResponse response = client.execute(request);

        // Verify Status Code
        int responseCode = response.getStatusLine().getStatusCode();
        if (responseCode == 200)
            return true;
        return false;
    }

}
