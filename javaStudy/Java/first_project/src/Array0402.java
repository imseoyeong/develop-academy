import java.util.Scanner;

public class Array0402 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] arr = new int[4][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(i + "행 " + j + "열 " + "숫자를 입력하세요: ");
                arr[i][j] = s.nextInt();
                arr[i][3] += arr[i][j]; //행의 합계
                arr[3][i] += arr[i][j]; //열의 합계
                arr[3][3] += arr[i][j]; //총 합게
            }
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <  arr[i].length; j++) {
                System.out.print("[" + arr[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }
}

