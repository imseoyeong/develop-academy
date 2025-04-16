public class CartItem {
    private String[] book;
    private int count;
    private int totalPrice;

    // 생성자 정의
    public CartItem(String[] book, int count) {
        this.book = book;
        this.count = count;
        this.updateTotalPrice();
    }

    // 오버로딩
    public CartItem(String[] book) {
        this.book = book;
        this.count = 1;
        this.updateTotalPrice();
    }

    // 계산하는 함수
    public void updateTotalPrice() {
        this.totalPrice = Integer.parseInt(this.book[2]) * this.count;
    }


    // 읽기 접근자
    public String[] getBook() {
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
