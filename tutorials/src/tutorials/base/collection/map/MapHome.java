package tutorials.base.collection.map;

import tutorials.base.collection.Student;
import tutorials.base.collection.Students;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHome {
    public static void main(String[] args) {
        SearchInStudent();
        ForeachKeySet();
        ForeachEntrySet();
        SearchInStudent2();
    }

    private static void SearchInStudent() {
        System.out.println("Search In Student: ");
        Student student = new Student("Zhang San", 85);
        Map<String, Student> hashMap = new HashMap<>();
        hashMap.put(student.getName(), student);

        Student target = hashMap.get(student.getName());
        System.out.println(target == student);
        System.out.println(target.getScore());
        Student another = hashMap.get("Li Si");
        System.out.println(another);
    }

    private static void ForeachKeySet() {
        System.out.println("Foreach KeySet: ");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }

    private static void ForeachEntrySet() {
        System.out.println("Foreach EntrySet: ");
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("pear", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }

    private static void SearchInStudent2() {
        System.out.println("Search In Student 2: ");
        List<Student> list = Arrays.asList(
                new Student("Zhang San", 82),
                new Student("Li Si", 59),
                new Student("Wang Wu", 95),
                new Student("Wang Er", 76)
        );
        Students holder = new Students(list);
        System.out.println(holder.getScore("Zhang San") == 82 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Wang Wu") == 95 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Zhao Liu") == -1 ? "测试成功!" : "测试失败!");
    }

}
