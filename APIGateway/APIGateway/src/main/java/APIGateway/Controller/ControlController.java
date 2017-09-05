package APIGateway.Controller;

/*
    This file implemented device control API
 */

import RestfulClient.PrivateHttpClient;
import RestfulClient.RestfulResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

// Define and descript this controller
@Api(value = "ControlDevice", description = "Device Control Service", position = 0)
@RestController

// Define all of APIs under
@RequestMapping("/v1/devicectl")
public class ControlController {

    private static Logger logger = Logger.getRootLogger();

    // define service url
    private String service = "http://devicectl-service:8083";

    // define other response
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Input")})

    // define API
    @RequestMapping(value="/control", consumes = { "application/json"}, method = RequestMethod.POST)

    // define API handler
    public ResponseEntity controlDevice(
            @ApiParam(name = "body", value = "Control a device.", required = true) @RequestBody String body, // post body
            @RequestHeader(value="Auth-Token") String token // header token
    ) throws IOException {

        logger.info("Action Body: " + body);

        // send request to private service
        String url = this.service + "/control";
        RestfulResponse resp = PrivateHttpClient.post(url, body);
        return ResponseEntity.status(resp.getStatusCode()).body(resp.getBody());

    }
}