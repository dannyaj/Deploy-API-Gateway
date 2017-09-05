package APIGateway.Configuration;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

/*
*  This file defined what swagger of URL will be created
*  Swagger will create /v1.*
* */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationConfiguration {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(paths())
                .build();
    }

    private Predicate<String> paths() {
        return regex("/v1.*");
    }
}
