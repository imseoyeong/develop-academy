import java.util.Scanner;

public class Array0502 {
    public static void main(String[] args) {
//    [선생님 코드]
//    -----------------------------------------------------------
        int[] correct = new int[3];
        int[] answer = new int[3];
        Scanner input = new Scanner(System.in);

        System.out.println("숫자 세 개를 입력하세요.");
        for (int i = 0; i < correct.length; i++) {
            correct[i] = input.nextInt();
        }

        int answerCount = 0;

        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.println("정답 시도");
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
