import Lambda.ImageFunctionsImpl;
import Lambda.ImageOperation;
import Lambda.RgbMaster;
import OOP1.BabushkaPhone;
import OOP1.MobileOperator;
import OOP1.SmartPhone;
import OOP3.HubList;
import OOP3.HubStringComparator;
import OOP4.Auth;
import OOP5.AuthController;
import OOP5.JwtService;
import OOP5.UserRepository;

import java.io.IOException;

public class Main {
    public static void main(String argv[]) throws Exception {
        ExecuteLambdaTask();
    }

    public static void ExecuteLambdaTask() throws IOException {
        var rbgMaster = new RgbMaster("in.png");
        try {
            var functions = new ImageFunctionsImpl();
            rbgMaster.changeImage(rgb -> functions.inversion(rgb));
        }catch (Exception e){

        }

        rbgMaster.save("out_image.png");
    }

    public static void Execute1Task(){
        var operator = new MobileOperator();

        var phone1 = new BabushkaPhone(operator, "88003535555", "Nokia 3310");
        var phone2 = new SmartPhone(operator, "89003331124", "IPhone 13");

        phone1.call("89003331124", "Babuska");
        phone2.receiveCall("Smart");

        phone1.send("Hello 1");
        phone2.send("Hello 2");
        phone1.send("123");
        phone2.send("456");

        phone2.dropCall();
    }

    public static void Execute3Task(){
        HubList<String> youList = new HubList<String>();
        youList.add("b");
        youList.add("a");
        youList.add("c");
        System.out.println(youList); //[b, a, c]
        System.out.println(youList.find("b")); //0
        System.out.println(youList.find("s")); //-1
        youList.sort(new HubStringComparator());
        System.out.println(youList); //[a, b, c]
        System.out.println(youList.removeAt(1)); //b
        System.out.println(youList); //[a, c]
    }

    public static void Execute4Task(){

        var auth = new Auth();

        auth.fillLogin("+79663563322");
        System.out.println(auth.phone);

        auth.fillLogin("Auth20@gmail.com");
        System.out.println(auth.email);

        auth.sendCode();

        var result = auth.checkCode("QFARTB");

        System.out.println(result);
    }

    public static void Execute5Task(){
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
