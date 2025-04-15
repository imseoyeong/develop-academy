public class String01 {
    public static void main(String[] args) {
//    [문자열 선언]
//    -----------------------------------------------------------
//        String s1 = "Java";
//        String s2 = "Java";
//        String s3 = new String("Java");
//        String s4 = new String("Java");
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//    -----------------------------------------------------------


//    [String을 이용하여 문자열 저장하고 출력]
//    -----------------------------------------------------------
//        String s1 = "Java Programming";
//        String s2 = new String("Java Programming");
//        System.out.println(s1);
//        System.out.println(s2);
//    -----------------------------------------------------------


//    [문자열 메서드 사용]
//    -----------------------------------------------------------
//        String s = " Java Programming ";
//        System.out.println("s.length() : " + s.length());
//        System.out.println("s.charAt(1) : " + s.charAt(1));
//        System.out.println("s.substring(6) : " + s.substring(6));
//        System.out.println("s.substring(5,13) : " + s.substring(5,13));
//        System.out.println("s.indexOf('P') : " + s.indexOf("P"));
//        System.out.println("s.toLowerCase() : " + s.toLowerCase());
//        System.out.println("s.toUpperCase() : " + s.toUpperCase());
//    -----------------------------------------------------------


//    [String 클래스 메서드 이용]
//    -----------------------------------------------------------
        String s = " Java Programming ";
        String s1 = "Java";
        String s2 = " Programming";
        String s3 = s1.concat(s2);
        String s4 = s.trim();

        System.out.println("s3 " + s3);
        System.out.println("s4 " + s4);
        System.out.println("s3.equals(s4) " + s3.equals(s4));
//    -----------------------------------------------------------

    }
}
