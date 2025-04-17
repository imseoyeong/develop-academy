public class CartItem {
    private Book book;
    private int count;
    private int totalPrice;

    // 생성자 정의
    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
        this.updateTotalPrice();
    }

    // 오버로딩
    public CartItem(Book book) {
        this.book = book;
        this.count = 1;
        this.updateTotalPrice();
    }

    // 계산하는 함수
    public void updateTotalPrice() {
        this.totalPrice = this.book.getPrice() * this.count;
    }


    // 읽기 접근자
    public Book getBook() {
        return this.book;
    }

    public int getCount() {
        return this.count;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    // 쓰기 접근자
    public void setCount(int count) {
        this.count = count;
        this.updateTotalPrice(); // 수량이 바뀌면 가격도 바뀌니깐 얘도 넣어줘야 함.
    }
}
