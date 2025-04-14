import java.util.Scanner;

public class Array0503 {
    public static void main(String[] args) {
//    [숫자 입력 -> 랜덤수로 바꾸기]
//    -----------------------------------------------------------
        int[] correct = new int[3];
        int[] answer = new int[3];
        Scanner input = new Scanner(System.in);

//        int index = 0;
//        while (true) {
//            int num = (int)(Math.random() * 10);
//            boolean exists = false;
//
//            for (int i = 0; i < index; i++) {
//                if (correct[i] == num) {
//                    exists = true;
//                    break;
//                }
//            }
//
//            if (exists) continue;
//
//            correct[index] = num;
//            index++;
//
//            if (index == 3) break;
//        }

        int count = 0;
        while (true) {
            boolean flag = false;
            int num = (int) (Math.random() * 9) + 1;
            for (int i = 0; i < count; i++) {
                if (correct[i] == num) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }

            correct[count++] = num;
            if (count == 3) {
                break;
            }
        }

        int answerCount = 0;

        while (true) {
            int strike = 0;
            int ball = 0;
            int out = 3;

            System.out.println("정답 시도(0~9)");
            for (int i = 0; i < answer.length; i++) {
                answer[i] = input.nextInt();
            }

            answerCount++;
            boolean flag = false;
            for (int i = 0; i < correct.length; i++) {
                for (int j = 0; j < answer.length; j++) {
                    if (correct[i] == answer[j]) {
                        flag = true;
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                        out--;
                        break;
                    }
                }
            }

            if (!flag) {
                System.out.println("Out!");
            } else {
                System.out.println("Strike: " + strike + "\tBall: " + ball);
            }

            if (strike == 3) {
                break;
            }
        }

        System.out.println("정답입니다! " + answerCount + "번 만에 정답을 맞췄습니다.");
    }
}
