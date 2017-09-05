package APIGateway.Configuration;

import APIGateway.Middleware.AuthMiddleware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
    This file defined what URL will go through middleware.
    All of /v1/** API
 */

@Configuration
public class SecurityConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // v1 APIs will go through middleware
        registry.addInterceptor(new AuthMiddleware()).addPathPatterns("/v1/**");
    }
}

