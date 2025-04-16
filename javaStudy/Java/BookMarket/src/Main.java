import java.util.Scanner;

public class Main {
    static String[][] mBook = new String[3][7];
    static CartItem[] mCart = new CartItem[3];
    static int mCartItemCount = 0;

    public static void main(String[] args) {
        mBook[0][0] = "ISBN1234";
        mBook[0][1] = "쉽게 배우는 JSP 웹프로그래밍";
        mBook[0][2] = "27000";
        mBook[0][3] = "송미영";
        mBook[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹프로그래밍 ";
        mBook[0][5] = "IT전문서";
        mBook[0][6] = "2018/10/08";

        mBook[1][0] = "ISBN1235";
        mBook[1][1] = "안드로이드 프로그래밍";
        mBook[1][2] = "33000";
        mBook[1][3] = "우재남";
        mBook[1][4] = "실습 단계별 명쾌한 멘토링!";
        mBook[1][5] = "IT전문서";
        mBook[1][6] = "2022/01/22";

        mBook[2][0] = "ISBN1236";
        mBook[2][1] = "스크래치";
        mBook[2][2] = "22000";
        mBook[2][3] = "고광일";
        mBook[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";
        mBook[2][5] = "컴퓨터 입문";
        mBook[2][6] = "2019/06/10";

        Scanner input = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요 : ");
        String name = input.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phone = input.nextLine();

        Person user = new Person(name, phone);

        while (true) {
            boolean endflag = false;
            menuIntroduction();
            System.out.print("메뉴 번호를 선택하세요: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    menuGuestInfo(user);
                    break;
                case 2:
                    menuCartItemList();
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
                    endflag = true;
                    System.out.println("종료");
                    break;
            }

            if (endflag) {
                break;
            }
        }
    }

    public static void menuIntroduction() {
        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market!";

        System.out.println("***********************************************");
        System.out.println("\t" + greeting);
        System.out.println("\t" + tagline);
        System.out.println("***********************************************");
        System.out.println("1. 고객정보 확인하기 \t\t\t4. 바구니에 황목 추가하기");
        System.out.println("2. 장바구니 상품 목록 보기\t\t5. 장바구니의 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기\t\t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println("7. 영수증 표시하기\t\t\t\t8. 종료");

        System.out.println("***********************************************");
    }

    public static void menuGuestInfo(Person user) {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 " + user.getName() +
                " 전화번호 " + user.getPhone());
    }

    public static void menuCartItemList() {

        System.out.println("장바구니 상품 목록 보기");
    }

    public static void menuCartClear() {

        System.out.println("장바구니 비우기");
    }

    public static void menuCartAddItem() {
        System.out.println("장바구니 항목 추가하기 ");

        for (int i = 0; i < mBook.length; i++) {
            for (int j = 0; j < mBook[i].length; j++) {
                System.out.print(mBook[i][j] + " | ");
            }
            System.out.println();
        }

        while (true) {
            boolean exit = false;
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");

            Scanner input = new Scanner(System.in);
            String bookid = input.nextLine();

            int index = -1;

            for (int i = 0; i < mBook.length; i++) {
                if (bookid.equals(mBook[i][0])) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("장바구니에 추가하겠습니까? Y|N");
                String yn = input.nextLine();

                if (yn.toUpperCase().equals("Y")) {
                    if (!isCartInBook(bookid)) {
                        mCart[mCartItemCount] = new CartItem(mBook[index]);
                        mCartItemCount++;
                    }
                    System.out.println(mBook[index][1] + "가 장바구니에 추가되었습니다.");
                }
                exit = true;
            } else {
                System.out.println("도서가 존재하지 않습니다.");
            }

            if (exit) {
                break;
            }

        }
    }

    public static boolean isCartInBook(String bookId) {
        for (int i = 0; i < mCartItemCount; i++) {
            if (bookId.equals(mCart[i].getBook()[0])) {
                mCart[i].setCount(mCart[i].getCount() + 1);
                return true;
            }
        }

        return false;
    }

    public static void menuCartRemoveItemCount() {
        System.out.println("장바구니에 항목 수량 줄이기");
    }

    public static void menuCartRemoveItem() {
        System.out.println("장바구니의 항목 삭제하기");
    }

    public static void menuCartBill() {
        System.out.println("영수증 표시하기");
    }

}