package tutorials.base.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListHome {
    public static void main(String[] args) {
        System.out.println("Collection List Demo");
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("apple");
        System.out.println(list.size());
    }
}
