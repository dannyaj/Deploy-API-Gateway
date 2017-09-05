package APIGateway.Controller;

import RestfulClient.PrivateHttpClient;
import RestfulClient.RestfulResponse;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Define and descript this controller
@Api(value = "DeviceMgt", description = "Device Management Service", position = 0)
@RestController

// Define all of APIs under
@RequestMapping("/v1/devicemgt")
public class DeviceManagerController {

    private static Logger logger = Logger.getRootLogger();

    // define service url
    private String service = "http://devicemgt-service:8081";

    // define other response
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Input")})

    // define API
    @RequestMapping(value="/register", consumes = { "application/json"}, method = RequestMethod.POST)

    // define API handler
    public ResponseEntity registerNewDevice(
            @ApiParam(name = "body", value = "Register a new device.", required = true) @RequestBody String body, // post body
            @RequestHeader(value="Auth-Token") String token // header token
    ) throws IOException {

        logger.info("Action Body: " + body);

        // send request to private service
        String url = this.service + "/register";
        RestfulResponse resp = PrivateHttpClient.post(url, body);
        return ResponseEntity.status(resp.getStatusCode()).body(resp.getBody());
    }
}