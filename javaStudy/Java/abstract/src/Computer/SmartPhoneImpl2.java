package Computer;

public class SmartPhoneImpl2 implements SmartDevice {
    boolean power;
    @Override
    public void call() {
        System.out.println("전화 통화를 합니다.");
    }
    @Override
    public void turnOn() {
        System.out.println("전원을 켭니다.");
    }
    @Override
    public void turnOff() {
        System.out.println("전원을 끕니다.");
    }
    @Override
    public void appRun() {
        System.out.println("앱을 실행합니다.");
    }
    @Override
    public void appStop() {
        System.out.println("입을 종료합니다.");
    }
}
