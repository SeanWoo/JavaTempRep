package OOP1;

public class BabushkaPhone extends Phone{
    public int volume;

    public BabushkaPhone(MobileOperator opr, String number, String model) {
        super(opr, number, model);
    }

    @Override
    public void receiveCall(String name) {

    }
}
