package classpackage;

public class Object01 {
    public static void main(String[] args) {
        Student stObj1 = new Student();
        stObj1.id = 20221004;
        stObj1.name = "홍길순";
        stObj1.printInfo();

        Student stObj2 = new Student();
        stObj2.insertRecord(20021005, "홍길동");
        stObj2.printInfo();

        Student seoYeong = new Student(11,"임서영");
        seoYeong.printInfo();
    }
}
