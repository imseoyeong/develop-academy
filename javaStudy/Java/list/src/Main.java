import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cats = new ArrayList<String>();

        cats.add("페르시안");
        cats.add("샴");
        cats.add("러시안블루");

        System.out.println(cats.get(0));

        for (String cat : cats) {
            System.out.println(cat);
        }

        Iterator<String> iter = cats.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}