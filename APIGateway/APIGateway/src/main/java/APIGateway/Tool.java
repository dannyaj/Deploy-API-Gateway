//package APIGateway;
//
//import com.oracle.javafx.jmx.json.JSONException;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class Tool {
//    static public boolean isJSONValid(String test) {
//        // verify JSON string
//        System.out.println("QQQQQQQ");
//        try {
//            new JSONObject(test);
//        } catch (JSONException ex) {
//            try {
//                new JSONArray(test);
//            } catch (JSONException ex1) {
//                return false;
//            } catch (org.json.JSONException e) {
//                return false;
//            }
//        } catch (org.json.JSONException e) {
//            return false;
//        }
//        return true;
//    }
//
//    static public HttpServletResponse makeHttpServletResponse(HttpServletResponse response, Integer statusCode, String msg) throws IOException {
//        // make servlet response
//        response.setStatus(statusCode);
//        response.getOutputStream().println(msg);
//        return response;
//    }
//}
