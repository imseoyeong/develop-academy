import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hashmap01 {
    public static void main(String[] args) {
        HashMap<Integer, String> cats = new HashMap<Integer, String>();

        cats.put(1, "a");
        cats.put(2, "b");
        cats.put(3, "c");
        System.out.println(cats);
        System.out.println(cats.get(2));

        for (Entry<Integer, String> entry : cats.entrySet()) {
            System.out.print(" (" + entry.getKey() + "," + entry.getValue() + ")");
        }

        Iterator<Entry<Integer, String>> entries = cats.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<Integer, String> entry = entries.next();
            System.out.print(" (" + entry.getKey() + "," + entry.getValue() + ")");
        }

        for (Integer i : cats.keySet()) {
            System.out.println(" (" + i + "," + cats.get(i) + ") ");
        }

        Iterator<Integer> keys = cats.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println(" (" + key  + "," + cats.get(key) + ") ");
        }
    }
}
