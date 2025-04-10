import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Welcome to Shopping Mall");
//        System.out.println("Welcome to Book Market");
        Scanner input = new Scanner(System.in);

        String welcomeMall = "Welcome to Shopping Mall";
        String welcomeMarket = "Welcome to Book Market";
        String star = "***************************************************";

        System.out.print("당신의 이름을 입력하세요: ");
        String name = input.nextLine();
        System.out.print("연락처를 입력하세요: ");
        String phone = input.nextLine();

        System.out.println(star + "\n \t\t" + welcomeMall);
        System.out.println("\t\t"+ welcomeMarket + "\n" + star);

        System.out.println("1. 고객 정보 확인하기\t\t" + "4. 장바구니에 항목 추가하기");
        System.out.println("2. 장바구니 상품 목록 보기\t" + "5. 장바구니의 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기\t\t\t" + "6. 장바구니의 항목 삭제하기");
        System.out.println("7. 영수증 표시하기\t\t\t" + "8. 종료\n" + star);

        System.out.print("메뉴 번호를 선택해주세요 ");
        int menuNem = input.nextInt();
        System.out.println(menuNem + "번을 선택했습니다");
    }
}