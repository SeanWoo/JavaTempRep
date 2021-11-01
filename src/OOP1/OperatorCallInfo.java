package OOP1;

public class OperatorCallInfo {
    public Phone from;
    public Phone to;
    public String nameFrom;
    public String nameTo;
    public boolean callAccepted;

    public OperatorCallInfo(Phone fr, Phone t, String nf){
        from = fr;
        to = t;
        nameFrom = nf;
    }
}
