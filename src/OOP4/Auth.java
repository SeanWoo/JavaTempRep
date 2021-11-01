package OOP4;

import java.util.regex.Pattern;

public class Auth {
    private final Coder _coder = new Coder();
    public String phone;
    public String email;
    public String code;

    public void fillLogin(String login){
        if (login.contains("@") && Pattern.matches("^\\w+@\\w+\\.\\w+$", login)){
            email = login;
        }
        else if (Pattern.matches("^\\+\\d{11}$|^\\d{11}$", login)){
            phone = login;
        }
    }

    public void sendCode(){
        _coder.sendCode();
    }
    public boolean checkCode(String code){
        if (code.length() == 6){
            return _coder.checkCode(code);
        }
        return false;
    }
}
