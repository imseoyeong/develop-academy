public class String02 {
    public static void main(String[] args) {
//    [문자열 메서드 연산]
//    -----------------------------------------------------------
//        String s1 = "Java";
//        String s2 = "Java";
//        String s3 = "java";
//        System.out.println(s1 == s2);
//        System.out.println(s1 != s2);
//        System.out.println(s2 == s3);
//        System.out.println(s2 != s3);
//        String s4 = s2 + s3;
//        System.out.println(s4);
//    -----------------------------------------------------------


//    [문자열 연산자를 이용하여 두 문자열 비교]
//    -----------------------------------------------------------
        String s1 = new String("Java");
        String s2 = new String("Java");
        String s3 = s1;

        if (s1 == s2) {
            System.out.println("s1과 s2는 같다");
        } else {
            System.out.println("s1과 s2는 같지 않다");
        }

        if (s1 == s3) {
            System.out.println("s1과 s3은 같다");
        } else {
            System.out.println("s1과 s3은 같지 않다");
        }

        if (s1.equals(s2)) {
            System.out.println("s1과 s2의 값은 같다");
        } else {
            System.out.println("s1과 s2의 값은 같지 않다");
        }
//    -----------------------------------------------------------
    }
}
