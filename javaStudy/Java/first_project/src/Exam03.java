public class Exam03 {
//    [매개변수가 없고 반환값이 있는 메서드 선언하고 호출하기]
//    -----------------------------------------------------------
//    public static int div() {
//        int a = 10, b = 5;
//        int result = a/b;
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int num = div ();
//        System.out.println(num);
//    -----------------------------------------------------------


//    [입력과 출력이 있는 메서드 예시]
//    -----------------------------------------------------------
//    public static int add(int x, int y) {
//        return x + y;
//    }
//
//    public static void main(String[] args) {
//        int a = 5, b = 6;
//        int sum = add(a, b);
//        System.out.println(a + "(와)과" + b + "의 합은" + sum + "입니다.");
//    }
//    -----------------------------------------------------------


//    [매개변수가 있고 반환값이 없는 메서드 선언하고 호출하기]
//    -----------------------------------------------------------
    public static void calculate(int x, double y) {
        System.out.println(2 * x * y);
    }

    public static void main(String[] args) {
        int a = 4;
        double pi = 3.14;
        System.out.println("원의 둘레 구하는 공식: 2 x 반지름 x 원주율");

        System.out.print("2 x " + a + " x " + pi + " = ");
        calculate(a, pi);
    }
//    -----------------------------------------------------------

}
