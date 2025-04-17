public class Book {
    private String id;
    private String name;
    private int price;
    private String writer;
    private String des;
    private String category;
    private String date;

    // 생성자
    public Book(String id, String name, int price, String
                writer, String des, String category, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.writer = writer;
        this.des = des;
        this.category = category;
        this.date = date;
    }

    // getter 읽기 접근자
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getWriter() {
        return writer;
    }

    public String getDes() {
        return des;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }
}
