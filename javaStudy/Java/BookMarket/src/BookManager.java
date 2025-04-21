import java.util.Scanner;

public class BookManager {
    // 멤버 변수
    private Book[] mBook = new Book[3];
    private Cart mCart = new Cart();
    Person mCurrentUser;

    // 생성자 (멤버 변수의 초기화가 주목적)
    public BookManager() {
        this.mBook[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹프로그래밍", "IT전문서", "2018/10/08");
        this.mBook[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22");
        this.mBook[2] = new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터 입문", "2019/06/10");
    }

    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요: ");
        String name = input.nextLine();
        System.out.print("연락처를 입력하세요: ");
        String phone = input.nextLine();

        Person user = new Person(name, phone);
        Admin admin = new Admin(name, phone);

        // 메뉴 선택
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
                case 9:
//                    menuAdminLogin(admin);
                    menuAdminLogin();
                    break;
            }

            if (endflag) {
                break;
            }
        }
    }

    // 메뉴 디자인
    public void menuIntroduction() {
        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market!";

        System.out.println("***********************************************");
        System.out.println("\t" + greeting);
        System.out.println("\t" + tagline);
        System.out.println("***********************************************");
        System.out.println("1. 고객 정보 확인하기 \t\t\t4. 장바구니에 항목 추가하기");
        System.out.println("2. 장바구니 상품 목록 보기\t\t5. 장바구니의 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기\t\t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println("7. 영수증 표시하기\t\t\t\t8. 종료");
        System.out.println("9. 관리자 로그인");

        System.out.println("***********************************************");
    }

    // 1. 고객 정보 확인하기
    public void menuGuestInfo(Person user) {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 " + user.getName() + " 전화번호 " + user.getPhone());
    }

    // 2. 장바구니 상품 목록
    public void menuCartItemList() {
        mCart.checkCart();
    }

    // 3. 장바구니 비우기
    public void menuCartClear() {
        System.out.println("장바구니 비우기");
        this.mCart.clearCart();
    }

    // 북리스트
    public void bookList() {
        for (int i = 0; i < mBook.length; i++) {
            System.out.print("도서 ID: ");
            System.out.println(this.mBook[i].getItemId());
            System.out.print("도서 이름: ");
            System.out.println(this.mBook[i].getName());
            System.out.print("도서 가격: ");
            System.out.println(this.mBook[i].getPrice());
            System.out.print("저자 : ");
            System.out.println(this.mBook[i].getWriter());
            System.out.print("도서 설명 : ");
            System.out.println(this.mBook[i].getDes());
            System.out.print("분류 : ");
            System.out.println(this.mBook[i].getCategory());
            System.out.print("출판일 : ");
            System.out.println(this.mBook[i].getDate());
            System.out.println("======================================");
        }
    }

    // 4. 장바구니 항목 추가
    public void menuCartAddItem() {
        System.out.println("장바구니 항목 추가하기 ");

        bookList();

        while (true) {
            boolean exit = false;
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");

            Scanner input = new Scanner(System.in);
            String bookid = input.nextLine();

            int index = -1;

            for (int i = 0; i < mBook.length; i++) {
                if (bookid.equals(mBook[i].getItemId())) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("장바구니에 추가하겠습니까? Y | N");
                String yn = input.nextLine();

                if (yn.toUpperCase().equals("Y")) {
                    if (!mCart.isCartInItem(bookid)) {
                        mCart.appendItem(mBook[index]);
                        System.out.println(mBook[index].getItemId() + "가 장바구니에 추가되었습니다.");
                    }else{
                        System.out.println(mBook[index].getItemId() + "가 장바구니에 추가되었습니다.");
                        mCart.inCreaseItemCount(bookid);
                    }

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

    // 5. 장바구니 항목 수량 줄이기
    public void menuCartRemoveItemCount() {
        System.out.println("장바구니에 항목 수량 줄이기");

        while (true) {
            mCart.checkCart();
            System.out.print("수량을 줄일 도서ID를 입력하세요 : ");

            Scanner input = new Scanner(System.in);
            String bookid = input.nextLine();

            if(!this.mCart.isCartInItem(bookid)){
                System.out.println("장바구니에 존해하는 도서가 아닙니다.");
                continue;
            }
            System.out.println(bookid + "의 수량을 줄이시겠습니까? Y | N");
            String yn = input.nextLine();
            if(yn.toUpperCase().equals("Y")){
                Book book = (Book)this.mCart.deCreaseItemCount(bookid); // 북의 원래 정체를 알고있을 때

                // 북의 정체가 확실하지 않을 때 이런 방법을 쓸 수 있음.
//                Book book = null;
//                Item item = this.mCart.deCreaseItemCount(bookid);
//                if (item instanceof Book) {
//                    book = (Book)item;
//                }

                System.out.println( book.getName() + " 한권이 장바구니에서 삭제되었습니다. ");
            }
            break;
        }
    }

    // 6. 장바구니 항목 삭제
    public void menuCartRemoveItem() {
        System.out.println("장바구니의 항목 삭제하기");
        this.mCart.checkCart();
        System.out.print("삭제할 항목의 도서ID를 입력하세요 : ");
        Scanner input = new Scanner(System.in);
        String bookid = input.nextLine();
        if(this.mCart.isCartInItem(bookid)){
            Book book = (Book)this.mCart.removeCartItem(bookid);
            System.out.println(book.getName() + "가 장바구니에서 삭제되었습니다.");
        }else{
            System.out.println("장바구니에 없는 책입니다.");
        }
    }

    // 7. 영수증 표시
    public void menuCartBill() {
        System.out.println("영수증 표시하기");
    }

    // 9. 관리자 로그인
//    public void menuAdminLogin(Admin admin) {
//        while (true) {
//            System.out.println("관리자 정보를 입력하세요");
//            Scanner input = new Scanner(System.in);
//            System.out.print("아이디 : ");
//            String adminId = input.nextLine();
//            System.out.print("비밀번호 : ");
//            String adminPw = input.nextLine();
//
//            if (adminId.equals(admin.getId()) && adminPw.equals(admin.getPw())) {
//                System.out.println("이름: " + admin.getName() + "\t연락처: " + admin.getPhone());
//                System.out.println("아이디: " + admin.getId() + "\t비밀번호: " + admin.getPw());
//                break;
//            } else {
//                System.out.println("관리자 계정과 일치하지 않습니다.");
//            }
//        }
//    }

    public void menuAdminLogin() {
        Admin login = new Admin(this.mCurrentUser.getName(), this.mCurrentUser.getPhone());
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("관리자 정보를 입력하세요.");
            System.out.print("ID: ");
            String id = input.nextLine();
            System.out.print("PW: ");
            String pw = input.nextLine();

            if (login.getId().equals(id) && login.getPw().equals(pw)) {
                System.out.println("로그인 성공");
                this.mCurrentUser = login;
                System.out.println("이름: " + login.getName() + "\n연락처: " + login.getPhone());
                System.out.println("ID: " + login.getId() + "\nPW: " + login.getPw());
                break;
            } else {
                System.out.println("로그인에 실패하였습니다. 다시 입력해주세요.");
            }
        }
    }
}
