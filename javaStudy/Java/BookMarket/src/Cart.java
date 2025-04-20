public class Cart {
    // 멤버 변수
    private CartItem[] mCart = new CartItem[3];
    private int mCartItemCount = 0;

    public boolean isCartInBook(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (bookId.equals(this.mCart[i].getBook().getId())) {
                return true; // 밑에 함수 호출
            }
        }
        return false;
    }

    public void clearCart() {
        this.mCart = new CartItem[3];
        this.mCartItemCount = 0;
    }

    public Book removeCartItem(String bookid) {
        Book book = null;
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getId().equals(bookid)) {
                book = this.mCart[i].getBook();
                this.removeCartItem(i);
                break;
            }
        }
        return book;
    }

    // false 리턴하면 얘가 호출
    public void appendBook(Book book) {
        this.mCart[this.mCartItemCount] = new CartItem(book);
        this.mCartItemCount++;
    }

    // true 리턴하면 얘가 호출
    public void inCreaseBookCount(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getId().equals(bookId)) {
                this.mCart[i].setCount(this.mCart[i].getCount() + 1);
                return;
            }
        }
    }

    public void checkCart() {
        System.out.println("장바구니 상품 목록 보기: ");
        System.out.println("---------------------------------------------");
        System.out.println(" 도서ID  | 수량 | 총 가격");
        for (int i = 0; i < mCartItemCount; i++) {
//            System.out.println(mCart[i].getBook().getName());
            System.out.println(
                    mCart[i].getBook().getId() + " | " +
                            mCart[i].getCount() + " | " +
                            mCart[i].getBook().getPrice()
            );
        }
        System.out.println("---------------------------------------------");
    }

    public int getmCartItemCount() {
        return mCartItemCount;
    }

    public Book deCreaseBookCount(String bookid) {
        Book book = null;
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getId().equals(bookid)) {
                book = this.mCart[i].getBook();
                this.mCart[i].setCount(this.mCart[i].getCount() - 1);
                if (this.mCart[i].getCount() == 0) {
                    System.out.println("수량이 0이 되어 항목을 장바구니에서 삭제합니다.");
                    this.removeCartItem(i);
                    break;
                }
            }
        }
        return book;
    }

    private void removeCartItem(int index){
        CartItem[] newCarItemList = new CartItem[3];
        int number = 0;
        for(int i =0; i<this.mCartItemCount; i++){
            if(i != index){
                newCarItemList[number++] = this.mCart[i];
            }
        }
        this.mCart=newCarItemList;
        this.mCartItemCount--;
    }
}
