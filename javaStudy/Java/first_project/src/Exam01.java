import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Exam02 ex1 = new Exam02();
        ex1.testDisplay();
//        ex1.titleDisplay();
        Exam02.titleDisplay();


//        [숫자 10개 입력 후 최댓값, 최솟값 구하기]

//        #1
//        -----------------------------------------------------------

//        Scanner s = new Scanner(System.in);
//
//        System.out.println("숫자를 입력하세요.");
//        int num = s.nextInt();
//        int minNum = num;
//        int maxNum = num;
//
//        for (int i = 0; i < 9; i++) {
//            System.out.println("숫자를 입력하세요.");
//            num = s.nextInt();
//
//            if (minNum > num) {
//                minNum = num;
//            }
//            if (maxNum < num) {
//                maxNum = num;
//            }
//        }
//
//        System.out.println("⏫최댓값: " + maxNum);
//        System.out.println("⏬최솟값: " + minNum);

//        -----------------------------------------------------------


//        #2
//        -----------------------------------------------------------

        Scanner s = new Scanner(System.in);

        int num;
        int minNum = 0;
        int maxNum = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + "번째 숫자를 입력하세요.");
            num = s.nextInt();

            if (i == 0) {
                minNum = num;
                maxNum = num;
            } else {
                if (minNum > num) {
                    minNum = num;
                }
                if (maxNum < num) {
                    maxNum = num;
                }
            }
        }

        System.out.println("⏫최댓값: " + maxNum);
        System.out.println("⏬최솟값: " + minNum);

//        -----------------------------------------------------------
    }
}
