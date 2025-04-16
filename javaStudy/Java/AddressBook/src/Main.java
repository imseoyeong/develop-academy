import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String[][] book = new String[3][5];

    public static void main(String[] args) {
        book[0][0] = "aa";
        book[0][1] = "11";
        book[0][2] = "임서영";
        book[0][3] = "부산";
        book[0][4] = "01040583640";

        book[1][0] = "bb";
        book[1][1] = "22";
        book[1][2] = "홍길동";
        book[1][3] = "경기도";
        book[1][4] = "01012345678";

        book[2][0] = "cc";
        book[2][1] = "33";
        book[2][2] = "홍길순";
        book[2][3] = "서울";
        book[2][4] = "01098765432";


        boolean isLogin = false; // 로그인 여부 저장

        firstMenu(); // 초기화면 출력
        int firstSelect = input.nextInt(); // 로그인, 종료 중에 선택
        input.nextLine();

        if (firstSelect == 1) { // 1번 선택 시 로그인 화면으로
            while (!isLogin) { // 로그인 성공할 때까지 반복 해야하니깐 while문 사용
                isLogin = login(); // 로그인 정보가 맞을 때 로그인을 한다!
            }
        } else {
            System.out.println("종료!");
            return;
        }

        while (isLogin) {
            boolean endflag = false; // 반복문 끝낼지 말지

            addressSetting(); // 주소록 관리 메뉴 노출
            int menuSelect = input.nextInt(); // 메뉴 번호 선택

            switch (menuSelect) {
                case 1:
                    searchAddress();
                    break;
                case 2:
                    allSearchAddress();
                    break;
                case 3:
                    myInfo();
                    break;
                case 4:
                    endflag = true;
                    firstMenu(); // 초기화면 노출
                    break;
            }

            if (endflag) {
                isLogin = false; // 로그아웃 선택 시 반복문 빠져나가기
            }
        }
    }
    // main end

    // 초기 화면
    public static void firstMenu() {
        System.out.println("<< 주소록 관리 >>");
        System.out.println("1. 로그인");
        System.out.println("2. 종료");
    }

    // 로그인 화면
    public static boolean login() { // 로그인 성공 여부 알기 위해 boolean 타입 사용
        System.out.print("ID: ");
        String id = input.nextLine();
        System.out.print("PW: ");
        String pw = input.nextLine();

        // 로그인 정보 일치 여부 확인, 아이디랑 패스워드 둘 다 맞아야 로그인 성공
        for (int i = 0; i < book.length; i++) {
            if (id.equals(book[i][0])) {
                if (pw.equals(book[i][1])) {
                    System.out.println("로그인 성공");
                    return true; // 로그인 성공
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                    return false; // 로그인 실패
                }
            }
        }
        System.out.println("존재하지 않는 아이디입니다.");
        return false; // 로그인 실패
    }

    // 주소록 관리 메뉴
    public static void addressSetting() {
        System.out.println("<< 주소록 관리 >>");
        System.out.println("1. 주소록 검색\n2. 전체 주소록 검색\n3. 내정보 변경\n4. 로그아웃");
    }

    // 1. 주소록 검색
    public static void searchAddress() {
        System.out.println("검색할 유저의 이름: ");
        String user = input.nextLine();

        for (int i = 0; i < book.length; i++) {
            if (user.equals(book[i][2])) {
                System.out.println(book[i][2] + "님의 주소: " + book[i][3]);
                System.out.println(book[i][2] + "님의 전화번호: " + book[i][4]);
                System.out.println();
            }
        }
    }

    // 2. 전체 주소록 검색
    public static void allSearchAddress() {
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i][2] + "님의 주소: " + book[i][3]);
            System.out.println(book[i][2] + "님의 전화번호: " + book[i][4]);
            System.out.println();
        }
    }

    // 3. 내정보 변경
    public static void myInfo() {
        System.out.println("내정보 변경");
    }
}