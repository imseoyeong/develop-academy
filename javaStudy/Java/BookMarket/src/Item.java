public class Item {
    String itemId;
    String name;
    int price;

    // 생성자
    public Item(String itemId, String name, int price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    // 읽기 접근자
    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // 쓰기 접근자
    public void setPrice(int price) {
        this.price = price;
    }
}
