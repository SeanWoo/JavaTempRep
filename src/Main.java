import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String argv[]) throws Exception {
        var userRepository = new UserRepository();
        var jwtService = new JwtService();
        var controller = new AuthController(userRepository, jwtService);

        // is null
        var resultSignIn = controller.SignIn("testNotValidEmail", "123");

        System.out.println("1 result: " + resultSignIn);

        var resultSignUp = controller.SignUp("testValidEmail", "123");

        System.out.println("2 result: " + resultSignUp.accessToken);

        var resultSignInTwo = controller.SignIn("testValidEmail", "123");

        System.out.println("3 result: " + resultSignInTwo.accessToken);

        // is null
        var resultSignInThree = controller.SignIn("testValidEmail", "12345678");

        System.out.println("4 result: " + resultSignInThree);
    }
}
