import java.util.Scanner;

public class Array04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] arr = new int[4][4];
        int firstRow = 0;
        int secondRow = 0;
        int thirdRow = 0;
        int firstColumn = 0;
        int secondColumn = 0;
        int thirdColumn = 0;
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(i + "행 " + j + "열 " + "숫자를 입력하세요: ");
                arr[i][j] = s.nextInt();

                firstRow = (arr[0][0] + arr[0][1] + arr[0][2]);
                arr[0][3] = firstRow;

                secondRow = (arr[1][0] + arr[1][1] + arr[1][2]);
                arr[1][3] = secondRow;

                thirdRow = (arr[2][0] + arr[2][1] + arr[2][2]);
                arr[2][3] = thirdRow;

                firstColumn = (arr[0][0] + arr[1][0] + arr[2][0]);
                arr[3][0] = firstColumn;

                secondColumn = (arr[0][1] + arr[1][1] + arr[2][1]);
                arr[3][1] = secondColumn;

                thirdColumn = (arr[0][2] + arr[1][2] + arr[2][2]);
                arr[3][2] = thirdColumn;

                sum = firstRow + secondRow + thirdRow + firstColumn + secondColumn + thirdColumn;
                arr[3][3] = sum;
            }
        }

        System.out.println();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + arr[i][j] + "]" + " ");
            }
            System.out.println();
        }

        System.out.println("\n0행의 합계: " + firstRow);
        System.out.println("1행의 합계: " + secondRow);
        System.out.println("2행의 합계: " + thirdRow);
        System.out.println("\n0열의 합계: " + firstColumn);
        System.out.println("1열의 합계: " + secondColumn);
        System.out.println("2열의 합계: " + thirdColumn);
        System.out.println("\n총합계: " + sum);
    }
}