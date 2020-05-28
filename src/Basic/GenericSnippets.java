package Basic;

import java.util.ArrayList;

public class GenericSnippets {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        for (String value : strList) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
