public class Admin extends Person { // Person을 상속 받음
    private String id = "admin";
    private String pw = "1111";

    public Admin(String name, String phone) {
        super(name, phone);
    }

    // 읽기 접근자
    public String getId() {
        return this.id;
    }

    public String getPw() {
        return this.pw;
    }
}
