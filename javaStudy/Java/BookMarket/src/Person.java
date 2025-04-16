public class Person {
    private String name;
    private String phone;

    // 생성자 정의
    public Person(String name, String phone) {
        this.name = name; //this에 전달받은 name 넣음
        this.phone = phone;
    }


    // private으로 잡아놓았기 때문에 외부에서 쓸 수 있도록 읽기 접근자, 쓰기 접근자 정의!

    // 읽기 접근자
    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    // 쓰기 접근자 - 꼭 필요한 건 아님. 이유는?..........
    public void setName(String name) { // 리턴 값이 없기 때문에 void
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
