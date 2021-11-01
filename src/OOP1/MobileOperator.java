package OOP1;

import java.util.ArrayList;

public class MobileOperator {
    private ArrayList<OperatorCallInfo> calls = new ArrayList<>();
    private ArrayList<Phone> numbers = new ArrayList<>();

    public void registerPhone(Phone phone){
        numbers.add(phone);
    }

    public void call(Phone from, String number, String name){
        for (var nmb : numbers) {
            if (number == nmb.getNumber()){
                calls.add(new OperatorCallInfo(from, nmb, name));
                break;
            }
        }
    }

    public Phone areCalling(Phone phone){
        for (var call : calls) {
            if (call.to.getNumber() == phone.getNumber()){
                return call.from;
            }
        }
        return null;
    }

    public void send(Phone phone, String message){
        for (var call : calls) {
            if (call.from.getNumber() == phone.getNumber() && call.callAccepted){
                call.to.say(call.nameFrom, message);
            }else if (call.to.getNumber() == phone.getNumber() && call.callAccepted){
                call.from.say(call.nameTo, message);
            }
        }
    }

    public void takeCall(Phone phone, String name){
        for (var call : calls) {
            if (call.to.getNumber() == phone.getNumber()){
                call.nameTo = name;
                call.callAccepted = true;
            }
        }
    }

    public void dropCall(Phone phone){
        for(int i = 0; i < calls.size(); i++){
            if (calls.get(i).from.getNumber() == phone.getNumber() || calls.get(i).to.getNumber() == phone.getNumber()){
                calls.remove(i);
                break;
            }
        }
    }
}
