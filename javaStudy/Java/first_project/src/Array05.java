import java.util.Scanner;

public class Array05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[3];
        int[] answer = new int[3];
        int count = 0;

        System.out.println("숫자 세 개를 입력하세요.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        while (true) {
            count++;
            int strike = 0;
            int ball = 0;
            int out = 3;

            for (int i = 0; i < answer.length; i++) {
                System.out.println("정답을 입력하세요.");
                answer[i] = s.nextInt();
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < answer.length; j++) {
                    //숫자가 같냐
                    if (arr[i] == answer[j]) {
                        //순서가 같냐
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                        out--;
                    }
                }
            }

            System.out.println("\n스트라이크: " + strike);
            System.out.println("볼: " + ball);
            System.out.println("아웃: " + out);
            System.out.println("\n총 입력 횟수: " + count + "\n");

            if (strike == 3) {
                System.out.println("정답입니다! 게임 종료");
                break;
            }
        }
    }
}
