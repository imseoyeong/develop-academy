import java.util.Scanner;

public class Main {
    // 1. 고객 정보 확인
    public static void menuGuestInfo(String name, String phone) {
        System.out.println("현재 고객 정보: \n" + "이름 " + name + "\t연락처 " + phone);
    }

    // 2. 장바구니 상품 목록
    public static void menuCartItemList() {
        System.out.println("장바구니 상품 목록입니다.");
    }

    // 3. 장바구니 비우기
    public static void menuCartClear() {
        System.out.println("장바구니 비우기입니다.");
    }

    // 4. 장바구니 항목 추가
    public static void menuCartAddItem(String[][] book) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i].length; j++) {
                System.out.print(book[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.print("장바구니에 추가할 도서의 ID를 입력하세요: ");
        String bookId = input.nextLine();
        boolean flag = false;

        for (int i = 0; i < book.length; i++) {
            if (book[i][0].equals(bookId)) {
                flag = true;
                System.out.println("장바구니에 추가하겠습니까? Y | N ");
                String addCart = input.nextLine();

                if (addCart.toUpperCase().equals("Y")) {
                    System.out.println(bookId + " 도서가 장바구니에 추가되었습니다.");
                } else {
                    System.out.println("취소되었습니다.");
                }
                break;
            }
        }

        if (!flag) {
            System.out.println("해당하는 도서 ID가 없습니다.");
        }
    }

    // 5. 장바구니 항목 수량 줄이기
    public static void menuCartRemoveItemCount() {
        System.out.println("장바구니 항목 수량 줄이기입니다.");
    }

    // 6. 장바구니 항목 삭제
    public static void menuCartRemoveItem() {
        System.out.println("장바구니 항목 삭제입니다.");
    }

    // 7. 영수증 표시
    public static void menuCartBill() {
        System.out.println("영수증 표시입니다.");
    }

    // 8. 종료
    public static void menuExit() {
        System.out.println("종료");
    }


//    -----------------------------------------------------------

    public static void main(String[] args) {
        String[][] book = new String[3][7];
        book[0][0] = "ISBN1234";
        book[0][1] = "쉽게 배우는 JSP 웹 프로그래밍";
        book[0][2] = "27000";
        book[0][3] = "송미영";
        book[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
        book[0][5] = "IT전문서";
        book[0][6] = "2018/10/08";

        book[1][0] = "ISBN1235";
        book[1][1] = "안드로이드 프로그래밍";
        book[1][2] = "33000";
        book[1][3] = "우재남";
        book[1][4] = "실습 단계별 명쾌한 멘토링!";
        book[1][5] = "IT전문서";
        book[1][6] = "2022/01/22";

        book[2][0] = "ISBN1236";
        book[2][1] = "스크래치";
        book[2][2] = "22000";
        book[2][3] = "고광일";
        book[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";
        book[2][5] = "컴퓨터입문";
        book[2][6] = "2019/06/10";

        Scanner input = new Scanner(System.in);

        int menuNum = 0;

        String welcomeMall = "Welcome to Shopping Mall";
        String welcomeMarket = "Welcome to Book Market";
        String star = "***************************************************";

        System.out.print("당신의 이름을 입력하세요: ");
        String name = input.nextLine();
        System.out.print("연락처를 입력하세요: ");
        String phone = input.nextLine();

        do {
            System.out.println(star + "\n \t\t" + welcomeMall);
            System.out.println("\t\t" + welcomeMarket + "\n" + star);

            System.out.println("1. 고객 정보 확인하기\t\t" + "4. 장바구니에 항목 추가하기");
            System.out.println("2. 장바구니 상품 목록 보기\t" + "5. 장바구니의 항목 수량 줄이기");
            System.out.println("3. 장바구니 비우기\t\t\t" + "6. 장바구니의 항목 삭제하기");
            System.out.println("7. 영수증 표시하기\t\t\t" + "8. 종료\n" + star);

            System.out.print("메뉴 번호를 선택해주세요 ");
            menuNum = input.nextInt();

            switch (menuNum) {
                case 1:
                    menuGuestInfo(name, phone);
                    break;
                case 2:
                    menuCartItemList();
                    break;
                case 3:
                    menuCartClear();
                    break;
                case 4:
                    menuCartAddItem(book);
                    break;
                case 5:
                    menuCartRemoveItemCount();
                    break;
                case 6:
                    menuCartRemoveItem();
                    break;
                case 7:
                    menuCartBill();
                    break;
                case 8:
                    menuExit();
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
        while (menuNum != 8);
    }
}