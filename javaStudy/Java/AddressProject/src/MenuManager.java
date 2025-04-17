import java.util.Scanner;

public class MenuManager {
    // final = const 같은 개념

    // [static으로 만드는 이유??]
    // final은 값이 바뀌지 않을 것들이라서 클래스가 번역될 때 처음부터 만들어놓고 외부에서 이 클래스로 객체를 안 만들어도 클래스명으로 앞에 명시하고 얘네를 쓸수 있게 하기 위해
    public final static int LOGIN = 1;
    public final static int EXIT = 2;
    public final static int ADDRESS_SEARCH = 1;
    public final static int ADDRESS_SEARCH_ALL = 2;
    public final static int USER_INFO_UPDATE = 3;
    public final static int LOGOUT = 4;

    public static void initMenu() {
        System.out.println("[📘주소록관리]");
        System.out.println("1. 로그인");
        System.out.println("2. 종료");
    }

    public static void addressMenu() {
        System.out.println("[📘주소록관리]");
        System.out.println("1. 주소록 검색");
        System.out.println("2. 전체 주소록 검색");
        System.out.println("3. 내정보 변경");
        System.out.println("4. 로그아웃");
    }

    // [void가 아니라 int를 쓰는 이유??]
    // 결과값을 돌려줘야 하기 때문. void는 실행만 하고 끝이지만 int는 숫자 결과를 돌려줌 -> 리턴해서 써 먹을 수 있다.
    public static int selectInitMenu() {
        Scanner input = new Scanner(System.in);
        int select;

        while (true) {
            select = input.nextInt();
            input.nextLine();

            if (select < LOGIN || select > EXIT) {
                System.out.println("❌잘못입력했습니다.");
                continue; // 다시 위로 올라가기
            }
            break;
        }
        return select;
    }

    public static int selectAddressMenu() {
        Scanner input = new Scanner(System.in);
        int select;

        while (true) {
            select = input.nextInt();
            input.nextLine();

            if (select < ADDRESS_SEARCH || select > LOGOUT) {
                System.out.println("❌잘못입력했습니다.");
                continue; // 다시 위로 올라가기
            }
            break;
        }
        return select;
    }
}
