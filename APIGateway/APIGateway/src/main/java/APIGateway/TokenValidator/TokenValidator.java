package APIGateway.TokenValidator;

public interface TokenValidator {
    public static boolean validateToken(String token, String action) { return true; };
}
