package tutorials.base.collection;

import java.util.Arrays;
import java.util.List;

public class CollectionIntro {
    public static void main(String[] args) {
        System.out.println("collection intro.");
        overrideEqualsDemo();
    }

    public static void overrideEqualsDemo() {
        List<Person> list = Arrays.asList(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}
