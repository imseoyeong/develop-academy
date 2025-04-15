package classpackage;

public class Student {
    int id;
    String name;

    void insertRecord(int parm1, String parm2) {
        this.id = parm1;
        this.name = parm2;
    }

    Student(){}

    Student(int id , String name){
        this.id = id;
        this.name = name;
    }

    void printInfo() {
        System.out.println("아이디: " + id);
        System.out.println("이름: " + name);
    }
}
