package OOP4;

import java.util.ArrayList;
import java.util.Random;

public class Coder {
    private ArrayList<String> _codes = new ArrayList<>();

    public void sendCode(){
        var rnd = new Random();
        var code = new StringBuilder();
        for(int i = 0; i < 6; i++){
            code.append(65 + rnd.nextInt(27));
        }
        _codes.add(code.toString());
    }
    public boolean checkCode(String code){
        for (var i: _codes) {
            if (i == code){
                return true;
            }
        }
        return false;
    }
}
