package APIGateway.Controller;

import RestfulClient.PrivateHttpClient;
import RestfulClient.RestfulResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

// Define and descript this controller
@Api(value = "Monitor", description = "Monitor Service", position = 0)
@RestController

// Define all of APIs under
@RequestMapping("/v1/monitor")
public class MonitorController {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

    // define service url
    private String service = "http://monitor-service:8082";

    // define other response
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Input")})

    // define API
    @RequestMapping(value="/report", consumes = { "application/json"}, method = RequestMethod.POST)

    // define API handler
    public ResponseEntity reportStatus(
            @ApiParam(name = "body", value = "Report a Status.", required = true) @RequestBody String body,
            @RequestHeader(value="Auth-Token") String token
    ) throws IOException {

        logger.info("Action Body: " + body);

        // send request to private service
        String url = this.service + "/report";
        RestfulResponse resp = PrivateHttpClient.post(url, body);
        return ResponseEntity.status(resp.getStatusCode()).body(resp.getBody());
    }
}