package classpackage;

public class MemberChain {
    String firstName;
    String country;
    int age;

    public  MemberChain() {
        this("홍길순");
    }

    public MemberChain(String mName) {
        this(mName, 20);
    }

    public MemberChain(String mName, int mAge) {
        this(mName, mAge, "대한민국");
    }

    public MemberChain(String mName, int mAge, String mCountry) {
        firstName = mName;
        age = mAge;
        country = mCountry;
    }
    void printInfo() {
        System.out.println("이름 : " + firstName );
        System.out.println("국적 : " + country );
        System.out.println("나이 : " + age );
    }

}
