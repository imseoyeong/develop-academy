import java.util.Scanner;

public class Main {
    public static void menuGuestInfo(String name, String phone) {
        System.out.println("현재 고객 정보: \n" + "이름 " + name + "\t연락처 " + phone);
    }

    public static void menuCartItemList() {
        System.out.println("장바구니 상품 목록입니다.");
    }

    public static void menuCartClear() {
        System.out.println("장바구니 비우기입니다.");
    }

    public static void menuCartAddItem() {
        System.out.println("장바구니 항목 추가입니다.");
    }

    public static void menuCartRemoveItemCount() {
        System.out.println("장바구니 항목 수량 줄이기입니다.");
    }

    public static void menuCartRemoveItem() {
        System.out.println("장바구니 항목 삭제입니다.");
    }

    public static void menuCartBill() {
        System.out.println("영수증 표시입니다.");
    }

    public static void menuExit() {
        System.out.println("종료");
    }


    public static void main(String[] args) {
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
            System.out.println("\t\t"+ welcomeMarket + "\n" + star);

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
                    menuCartAddItem();
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