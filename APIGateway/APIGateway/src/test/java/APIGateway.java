package APIGateway;

import org.apache.log4j.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import APIGateway.Configuration.ApplicationConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.apache.log4j.Logger;


@SpringBootApplication
@EnableSwagger2
@Import(ApplicationConfiguration.class)
public class APIGateway {

    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        logger.setLevel(Level   .DEBUG);
        SpringApplication.run(APIGateway.class, args);
    }

}
