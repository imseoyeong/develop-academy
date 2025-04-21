package Computer;

public class SmartPhoneMain2 {
    public static void main(String[] args) {
        SmartPhoneImpl2 phone = new SmartPhoneImpl2();

        SmartDevice s = phone;
        s.turnOn();
        Phone p = phone;
        p.call();
        Application a = phone;
        a.appRun();
    }
}
