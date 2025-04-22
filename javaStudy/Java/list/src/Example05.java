import java.util.TreeSet;

public class Example05 {
    public static void main(String[] args) {
        TreeSet<String> cats = new TreeSet<String>();
        cats.add("페르시안");
        cats.add("러시안블루");
        System.out.println(cats);
        cats.add("샴");
        System.out.println(cats);
        cats.remove("페르시안");
        System.out.println(cats);
        System.out.println(cats.size());
        System.out.println(cats.contains("샴"));
        System.out.println(cats.first());
        System.out.println(cats.last());
    }
}
