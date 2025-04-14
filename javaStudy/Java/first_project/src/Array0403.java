import java.util.Scanner;

public class Array0403 {
    public static void main(String[] args) {
//    [선생님 코드]
//    -----------------------------------------------------------
        int[][] arr = new int[4][4];
        int rows = arr.length;
        int columns = arr[0].length;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                arr[i][columns - 1] += arr[i][j];
                arr[rows - 1][j] += arr[i][j];
                arr[rows - 1][columns - 1] += arr[i][j];
            }
        }

        System.out.print("행의 합계: ");
        for (int i = 0; i < rows - 1; i++) {
            System.out.print(i + "행 합계: " + arr[i][columns - 1] + " ");
        }
        System.out.println();

        System.out.print("열의 합계: ");
        for (int i = 0; i < columns - 1; i++) {
            System.out.print(i + "열 합계: " + arr[rows - 1][i] + " ");
        }
        System.out.println();
        System.out.println("전체 합계: " + arr[rows - 1][columns - 1]);
    }
}