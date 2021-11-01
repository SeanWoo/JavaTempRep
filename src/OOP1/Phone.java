package OOP1;

public class Phone {
    private MobileOperator operator;
    private String serialNumber;
    public String model;
    public double weight;

    public Phone(MobileOperator opr, String number, String model){
        operator = opr;
        serialNumber = number;
        model = model;

        operator.registerPhone(this);
    }

    public String getNumber() {
        return serialNumber;
    }

    public void receiveCall(String name){
        var caller = operator.areCalling(this);

        if (caller != null){
            operator.takeCall(this, name);
            operator.send(this,"Отвечено от " + name);
        }
    }

    public void call(String number, String name){
        operator.call(this, number, name);
    }

    public void send(String message){
        operator.send(this, message);
    }

    public void say(String name, String message){
        System.out.println(name + ": " + message);
    }

    public void dropCall(){
        operator.dropCall(this);
    }
}
