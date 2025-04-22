import java.util.ArrayList;

public class Example01 {
    public static void main(String[] args) {
        ArrayList<String> cats = new ArrayList<String>();
        cats.add("페르시안");
        cats.add("null");
        System.out.println(cats);

        cats.add(1, "샴");
        System.out.println(cats);

        cats.set(2, "러시안블루");
        System.out.println(cats);

        cats.remove("페르시안");
        System.out.println(cats);

        cats.remove(1);
        System.out.println(cats);

        System.out.println(cats.size());

        System.out.println(cats.get(0));

        System.out.println(cats.contains("샴"));

        System.out.println(cats.indexOf("샴"));
    }
}
