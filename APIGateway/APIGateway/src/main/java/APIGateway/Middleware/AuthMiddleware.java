package APIGateway.Middleware;

/*
    This file implemented middleware by HandlerInterceptor
*/

import APIGateway.TokenValidator.ApacheHttpClient;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthMiddleware implements HandlerInterceptor {

    private static Logger logger = Logger.getRootLogger();
    private String authKey = "Auth-Token";

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // Get token
        String token = request.getHeader(this.authKey);

        // Get action name
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String actionName = handlerMethod.getMethod().getName();

        logger.info("Action: " + actionName + " Token: " + token);

        // Filter invalid request
        if (token == null) {
            response.setStatus(400);
            response.getOutputStream().println("Missing request header '" + this.authKey + "' for method parameter of type String");
            return false;
        }

        // Validate token
        if (!ApacheHttpClient.validateToken(token, actionName)) {
            response.setStatus(403);
            response.getOutputStream().println("UNauthorized");
            return false;
        }

        return true;

    }
}
