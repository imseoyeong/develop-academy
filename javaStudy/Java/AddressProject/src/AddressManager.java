import java.util.Scanner;

public class AddressManager {
    // 멤버 변수
    private User[] userList = new User[3];
    User currentUser;

    // 생성자
    public AddressManager() {
        this.userList[0] = new User("aa", "11", "임서영", "부산", "01040583640");
        this.userList[1] = new User("bb", "22", "홍길동", "경기도", "01012345678");
        this.userList[2] = new User("cc", "33", "홍길순", "서울", "01098765432");
    }

    public void run() {
        while (true) {
            boolean endFlag = false; // 빠져나갈 구멍 만들어두기
            MenuManager.initMenu(); // MenuManager 클래스 initMenu 함수 불러오기
            int select = MenuManager.selectInitMenu();

            switch (select) {
                case MenuManager.LOGIN: // MenuManager에 정의되어 있는 LOGIN
                    if (this.login()) {
                        this.addressProcess(); // 이 함수가 종료했다는 것은 로그아웃을 했다는 것
                    }
                    break;
                case MenuManager.EXIT:
                    endFlag = true;
                    break;
            }
            if (endFlag) {
                break;
            }
        }
    }

    // 로그인 관련 함수 - 성공, 실패 값을 알려주기 위해 boolean 사용
    public boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.print("ID: ");
        String id = input.nextLine();
        System.out.print("PW: ");
        String pw = input.nextLine();

//        for (int i = 0; i < this.userList.length; i++) {
//            if (this.userList[i].getID().equals(id)) {
//                if (this.userList[i].getPW().equals(pw)) {
//                    System.out.println("로그인 성공");
//                    this.currentUser = this.userList[i];
//                    return true;
//                }
//            }
//        }
        for (User u : this.userList) {
            if (u.getID().equals(id)) {
                if (u.getPW().equals(pw)) {
                    System.out.println("로그인 성공");
                    this.currentUser = u;
                    return true;
                }
            }
        }
        System.out.println("계정정보가 틀렸습니다.");
        return false;
    }

    // 주소록 관리 메뉴
    public void addressProcess() {
        while (true) {
            boolean endFlag = false;
            MenuManager.addressMenu();
            int select = MenuManager.selectAddressMenu();

            switch (select) {
                case MenuManager.ADDRESS_SEARCH:
                    this.addressSearch();
                    break;
                case MenuManager.ADDRESS_SEARCH_ALL:
                    this.addressSearchAll();
                    break;
                case MenuManager.USER_INFO_UPDATE:
                    this.userInfoUpdate();
                    break;
                case MenuManager.LOGOUT:
                    endFlag = true;
                    this.currentUser = null; // 로그아웃이 되면 currentUser에 정보가 없음 = null
            }
            if (endFlag) {
                break;
            }
        }
    }

    // 1. 주소록 검색
    public void addressSearch() {
        Scanner input = new Scanner(System.in);
        System.out.print("🔍검색할 사용자 이름: ");
        String name = input.nextLine();

        for (User u : this.userList) {
            if (u.getName().equals(name)) {
                System.out.println("[" + u.getName() + "]님");
                System.out.println("주소: " + u.getAddress());
                System.out.println("전화번호: " + u.getPhone());
            }
        }
    }

    // 2. 전체 주소록 검색
    public void addressSearchAll() {
        for (User u : this.userList) {
            System.out.println("[" + u.getName() + "]님");
            System.out.println("주소: " + u.getAddress());
            System.out.println("전화번호: " + u.getPhone());
            System.out.println();
        }
    }

    // 3. 내정보 변경
    public void userInfoUpdate() {
        Scanner input = new Scanner(System.in);
        System.out.print("PW: ");
        String pw = input.nextLine();

        if (!this.currentUser.getPW().equals(pw)) {
            System.out.println("❌비밀번호가 틀렸습니다.");
            return; // 비밀번호 틀리면 여기서 함수 종료
        }

        System.out.print("Phone: ");
        String phone = input.nextLine();

        System.out.print("Address: ");
        String address = input.nextLine();

        // 정보를 바꿔야 하니깐 쓰기 접근자 사용: set~~
        this.currentUser.setAddress(address);
        this.currentUser.setPhone(phone);
        System.out.println("✅" + this.currentUser.getName() + "님의 정보가 변경되었습니다.");
    }

}
