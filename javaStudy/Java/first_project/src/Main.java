import java.util.Scanner;

public class Main { // main: 클래스명
    public static void main(String[] args) { // main: 메서드명
        final int SPEED = 20;
        int count = 10;
//        SPEED = 40;
        count = 11;

        System.out.println("상수 SPEED 값은");
        System.out.println(SPEED);
        System.out.println("변수 count 값은");
        System.out.println(count);

//        정수 자료형
        int a = 10;
        short s = 2;
        byte b = 6;
        long l = 125362133223L;
        System.out.println(a);
        System.out.println(s);
        System.out.println(b);
        System.out.println(l);

//        실수 자료형
        float f = 65.20298f;
        double d = 876.765d;
        System.out.println(f);
        System.out.println(d);

        char ch = 'j';
        char ch2 = 'a';
        char ch3 = 'v';
        char ch4 = 'a';
        System.out.println(ch);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(ch4);

//        문자열 자료형
        String str = "Java";
        String str2 = "Program";

        System.out.println(str);
        System.out.println(str2);

//        불리언 자료형
//        boolean t = true;
//        boolean f = false;
//
//        System.out.println(t);
//        System.out.println(f);

//        문자열 출력
        System.out.println("Java " + "program");

//        문자열과 변수 결합 출력
//        String myName = "임서영";
//        int myAge = 20;
//
//        System.out.println("이름: " + myName);
//        System.out.println("나이: " + myAge);

//        이스케이프 문자 출력
        String myName = "임서영";
        int myAge = 20;

        System.out.println("이름: \t" + myName + "\n");
        System.out.println("나이: \t" + myAge + "\n") ;


//        int x = 10;
//        System.out.println(x++);
//        System.out.println(++x);
//        System.out.println(x--);
//        System.out.println(--x);
//
//
//        System.out.println(star);
//
//
//        int a = 10, b = 10, c = 10, d = 10;
//        System.out.println("a++ => " + (a++));
//        System.out.println("a => " + a);
//        System.out.println("++b => " + (++b));
//        System.out.println("c-- => " + (c--));
//        System.out.println("--d => " + (--d));


//        캐스팅 형 변환
        int x = 10;
        double y = 3.0;

        System.out.println(x / y);
        System.out.println(x / (int) y);
        System.out.println((int) (x / y));


//        Scanner 클래스 사용
//        Scanner input =  new Scanner(System.in);
//
//        System.out.println("당신의 이름을 입력하세요.");
//        String name = input.nextLine();
//        System.out.println("당신의 이름: " + name);


//        Scanner 클래스를 이용하여 정수와 실수 입력
        Scanner s1 = new Scanner(System.in);
        System.out.println("정수값 입력하기");
        int n = s1.nextInt();

        System.out.println("실수값 입력하기");
        double db = s1.nextDouble();
        System.out.println("정수값: " + n);
        System.out.println("실수값: " + db);
    }
}