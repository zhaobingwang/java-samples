package snippets.book.javacore1.Ch09;

import java.util.*;

public class Ch09Main {
    public static void main(String[] args) {


        // 1.List
        linkedList();
        arrayList();

        // 2.Set
        hashSet();
        treeSet();
        treeSet2();

        // 3.Queue
        queue();
        priorityQueue();

        // 4. Map
        hashMap();
    }

    /**
     * 列表
     */
    static void linkedList() {
        List<String> list = new LinkedList<>();
    }

    /**
     * 数组列表
     */
    static void arrayList() {
        List<String> list = new ArrayList<>();
    }

    /**
     * 散列集
     */
    static void hashSet() {
        System.out.println("HashSet");
        Set<String> set = new HashSet();
        set.add("Jack");
        set.add("Alice");
        set.add("Mike");
        set.add("Alice");
        for (String str : set) {
            System.out.println(str);
        }
    }

    static void treeSet() {
        System.out.println("TreeSet...");
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Jack");
        sortedSet.add("Alice");
        sortedSet.add("Mike");
        for (String str : sortedSet) {
            System.out.println(str);
        }
    }

    static void treeSet2() {
        System.out.println("TreeSet2-1...");
        SortedSet<Item> sortedSet = new TreeSet<>();
        sortedSet.add(new Item("Jack", 123));
        sortedSet.add(new Item("Alice", 456));
        sortedSet.add(new Item("Mike", 789));
        for (Item item : sortedSet) {
            System.out.println(item);
        }
        // NavigableSet
        System.out.println("TreeSet2-2...\tNavigableSet...");
        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(x -> x.getDescription())
        );
        sortByDescription.addAll(sortedSet);
        System.out.println(sortByDescription);
    }

    static void queue() {
        // LinkedList即实现了List接口，又实现了Queue接口，
        // 在使用的时候，如果我们把它当作List，就获取List的引用，如果我们把它当作Queue，就获取Queue的引用
        // 这是一个List:
        List<String> list = new LinkedList<>();
        // 这是一个Queue:
        Queue<String> queue = new LinkedList<>();
    }

    static void priorityQueue() {
        System.out.println("PriorityQueue");
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // name:Boss,number:V1
        System.out.println(q.poll()); // name:Bob,number:A1
        System.out.println(q.poll()); // name:Alice,number:A2
        System.out.println(q.poll()); // null,因为队列为空
    }

    // 映射
    static void hashMap() {
        System.out.println("HashMap...");
        Map<String, Integer> wordCounter = new HashMap<>();
        String str = "Hi,Hello,Hi,你好 Hello";
        String[] array = str.split("\\,|\\s+");
        for (String item : array) {
            int currentWordCount = wordCounter.getOrDefault(item, 0);
            wordCounter.put(item, ++currentWordCount);
        }
        for (String key : wordCounter.keySet()) {
            int count = wordCounter.get(key);
            System.out.println("key:" + key + ",count:" + count);
        }
    }


}

