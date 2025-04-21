package Computer;

public class SmartPhoneImpl extends Computer implements Phone {
    boolean power;
    @Override
    public void call() {
        String number1 = String.valueOf(PHONE_NUM_1);
        String number2 = String.valueOf(PHONE_NUM_1);
        String number3 = String.valueOf(PHONE_NUM_9);
        System.out.println(number1 + number2 + number3 + "에 전화합니다.");
    }

    @Override
    public void turnOn() {
        if(!power) {
            power = true;
        }
    }
    @Override
    public void turnOff() {
        if(power) {
            power = false;
        }
    }
}
