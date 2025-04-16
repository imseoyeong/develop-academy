

public class User {
    String ID;
    int PW;
    String name;
    String address;
    String phone;

    //생성자
    User(String ID,int PW,String name,String address,String phone){
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //함수
    void setInfo(int pw , String address , String phone){
        this.PW = pw;
        this.address = address;
        this.phone = phone;
        System.out.println(this.name + "님의 정보가 변경되었습니다.");
    }
}
