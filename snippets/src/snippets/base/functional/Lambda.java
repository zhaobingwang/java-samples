package snippets.base.functional;

import snippets.base.Tmp;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda {
    public static void run() {
        tmp();
    }

    public static void tmp() {
        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
//        Arrays.sort(array, new Comparator<String>() {
//            public int compare(String s1, String s2) {
//                return s1.compareTo(s2);
//            }
//        });

//        Arrays.sort(array, (s1, s2) -> {
//            return s1.compareTo(s2);
//        });

//        Arrays.sort(array, Comparator.naturalOrder());

//        Arrays.sort(array, Lambda::cmp);  // 静态方法

        // 实例方法有一个隐含的this参数，String类的compareTo()方法在实际调用的时候，
        // 第一个隐含参数总是传入this，相当于静态方法：public static int compareTo(this, String o);
        Arrays.sort(array, String::compareTo);  // 实例方法

        for (String item : array) {
            System.out.println(item);
        }
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
