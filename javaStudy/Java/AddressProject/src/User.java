public class User {
    // private 하는 이유??
    // 1. 직접 접근을 막아 안전하게 데이터를 보호
    // 2. 데이터 수정하거나 꺼낼 때 통제할 수 있는 메서드를 통해 접근하게 함
    // 3. 클래스 내부 구조가 바뀌어도 외부 코드는 영향을 덜 받음 -> 유지보수에 용이
    private String ID;
    private String PW;
    private String name;
    private String address;
    private String phone;

    // 생성자
    public User(String ID, String PW, String name, String address, String phone) {
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // getter 읽기 접근자
    public String getID() {
        return ID;
    }

    public String getPW() {
        return PW;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // setter 쓰기 접근자
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
