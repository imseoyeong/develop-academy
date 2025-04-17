import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static User[] users = new User[3];
    static User user;

    public static void main(String[] args) {
        users[0] = new User("aa", "11", "임서영", "부산", "01040583640");
        users[1] = new User("bb", "22", "홍길동", "경기도", "01012345678");
        users[2] = new User("cc", "33", "홍길순", "서울", "01098765432");

        while (true) {
            firstMenu(); // 초기화면 출력
            int firstSelect = input.nextInt(); // 로그인, 종료 중에 선택

            if (firstSelect == 1) { // 1번 선택 시 로그인 화면으로
                user = login(); // 찾은 유저의 정보를 user에 넣었다.
                if (user == null) {
                    continue; // 로그인 실패 시 처음으로
                }

                while (true) {
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
                            System.out.print("pw: ");
                            String pw = input.next();

                            System.out.print("address: ");
                            String address = input.next();

                            System.out.print("phone: ");
                            String phone = input.next();

                            user.setInfo(pw, address, phone);
                            break;
                        case 4:
                            logout();
                            break;
                    }
                    if (menuSelect == 4) {
                        break;
                    }
                }
            } else if (firstSelect == 2) {
                System.out.println("종료!");
                break;
            } else {
                System.out.println("잘못 입력했써요");
            }
        }
    }
    // main end

    // 초기 화면
    public static void firstMenu() {
        System.out.println("1. 로그인");
        System.out.println("2. 종료");
    }

    // 로그인 화면
    public static User login() {
        User userExist = null; // 초기값은 찾은 유저가 없음.
        while (userExist == null) {
            System.out.print("ID: ");
            String id = input.next();
            System.out.print("PW: ");
            String pw = input.next();

            // 로그인 정보 일치 여부 확인, 아이디랑 패스워드 둘 다 맞아야 로그인 성공
            for (User u : users) { // 향상된 for문 활용
                if (id.equals(u.getID()) && pw.equals(u.getPW())) {
                    System.out.println("로그인 성공");
                    userExist = u; // 유저를 찾았다. u의 객체를 찾았따
                    return userExist; // 그 객체를 리턴 -> 로그인 성공. null 일때만 반복인데 null이 아니어서 반복문 종료
                }
            }
            System.out.println("로그인 실패");
        }
        return null;
    }

    // 주소록 관리 메뉴
    public static void addressSetting() {
        System.out.println("<< 주소록 관리 >>");
        System.out.println("1. 주소록 검색\n2. 전체 주소록 검색\n3. 내정보 변경\n4. 로그아웃");
    }

    // 1. 주소록 검색
    public static void searchAddress() {
        System.out.print("검색할 유저의 이름: ");
        String user = input.next();

        for (int i = 0; i < users.length; i++) {
            if (user.equals(users[i].getName())) {
                System.out.println(users[i].getName() + "님의 주소: " + users[i].getAddress());
                System.out.println(users[i].getName() + "님의 전화번호: " + users[i].getPhone());
                return;
            }
        }
        System.out.println("존재하지 않는 유저입니다.");
    }

    // 2. 전체 주소록 검색
    public static void allSearchAddress() {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getName() + "님의 주소: " + users[i].getAddress());
            System.out.println(users[i].getName() + "님의 전화번호: " + users[i].getPhone());
            System.out.println();
        }
    }

    public static void logout() {
        user = null;
    }
}