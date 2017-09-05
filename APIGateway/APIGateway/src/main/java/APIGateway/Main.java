package APIGateway;

import APIGateway.Configuration.ApplicationConfiguration;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(ApplicationConfiguration.class)
public class Main {

    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) throws ParseException {

        // parse args
        ArgsParser parser = new ArgsParser(args);

        // set level
        logger.setLevel(parser.getLevel());

        // start application
        SpringApplication.run(Main.class, args);
    }
}
