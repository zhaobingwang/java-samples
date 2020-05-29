package Basic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.util.*;

public class CollectionSnippets {
    public static void main(String[] args) throws IOException {
        // 3种主要集合类：List,Set,Map
//        ListSnippets();
//        FindMissingNumber();
        FindMissingNumber2();

        // 编写equals方法
        List<Person2> person2List = List.of(
                new Person2("Jack", 23),
                new Person2("Mike", 32),
                new Person2("Nick", 26)
        );
        boolean exist = person2List.contains(new Person2("Mike", 32));
        System.out.println(exist ? "测试成功" : "测试失败");

        // Map
        MapSnippets();
        String str1 = "a";
        String str2 = new String("a");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        // EnumMap
        EnumMapSnippets();

        // TreeMap
        TreeMapSnippets();

        PropertiesSnippets();

        SetSnippets();

        QueueSnippets();
    }

    private static void ListSnippets() {
        List<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("张三");
        list.add(null);
        System.out.println(list.get(3));
        System.out.println(list.size());

        List<String> list2 = List.of("apple", "pear", "banana");
        for (Iterator<String> it = list2.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
        // 使用foreach替代Iterator
        for (String str : list2) {
            System.out.println(str);
        }

        // List转Array
        List<Integer> list3 = List.of(11, 24, 50);
        Integer[] array = list3.toArray(new Integer[3]);
        for (Integer n : array) {
            System.out.println(n);
        }
    }

    private static void FindMissingNumber() {
        // 构造10到20的序列
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除list中的一个元素
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing bumber: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    private static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int i = start; i <= end; i++) {
            if (list.indexOf(i) < 0)
                return i;
        }
        return 0;
    }

    private static void FindMissingNumber2() {
        // 构造10到20的序列
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list);
        // 随机删除list中的一个元素
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing bumber: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    private static int findMissingNumber2(int start, int end, List<Integer> list) {
        return 0;
    }

    // 使用Map时，任何依赖顺序的逻辑都是不可靠的
    private static void MapSnippets() {
        Student2 s = new Student2("Xiao Ming", 99);
        Map<String, Student2> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student2 target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student2 another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        System.out.println("************");
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        System.out.println(map2.get("apple")); // 123
        var replaced = map2.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println("repalced value: " + replaced);
        System.out.println(map2.get("apple")); // 789
        System.out.println(map2.size());

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("apple", 123);
        map3.put("pear", 456);
        map3.put("banana", 789);
        for (String key : map3.keySet()) {
            Integer value = map3.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("********");
        List<Student3> list = List.of(
                new Student3("Bob", 78),
                new Student3("Alice", 85),
                new Student3("Brush", 66),
                new Student3("Newton", 99));
        var holder = new Students3(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }

    private static void EnumMapSnippets() {
        System.out.println("EnumMap Start...");
        Map<DayOfWeek, String> map = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
        System.out.println("EnumMap End...");
    }

    private static void TreeMapSnippets() {
        System.out.println("TreeMap Start...");
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear
        System.out.println("TreeMap End...");
    }

    private static void PropertiesSnippets() throws IOException {
//        String f = "\\Basic\\setting.properties";
        String f = Thread.currentThread().getContextClassLoader()
                .getResource("Basic/setting.properties").getPath();
        Properties props = new Properties();
//        props.load(new java.io.FileInputStream(f));
        props.load(new FileReader(f, StandardCharsets.UTF_8));
        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");
        System.out.println("filepath: " + filepath);
        System.out.println("interval: " + interval);
        props.setProperty("language", "Java");
        props.setProperty("appname", "测试");
        props.store(new FileWriter(f, StandardCharsets.UTF_8), "这是写入的properties注释");
        System.out.println(props.getProperty("appname"));
    }

    private static void SetSnippets() {
        System.out.println("set start...");
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素

        System.out.println("*****无序*****");
        Set<String> set2 = new HashSet<>();
        set2.add("apple");
        set2.add("banana");
        set2.add("pear");
        set2.add("orange");
        for (String s : set2) {
            System.out.println(s);
        }

        System.out.println("*****有序*****");
        Set<String> set3 = new TreeSet<>();
        set3.add("apple");
        set3.add("banana");
        set3.add("pear");
        set3.add("orange");
        for (String s : set3) {
            System.out.println(s);
        }
        // 消息去重
        // 在聊天软件中，发送方发送消息时，遇到网络超时后就会自动重发，
        // 因此，接收方可能会收到重复的消息，在显示给用户看的时候，需要首先去重。请练习使用Set去除重复的消息：
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }

        System.out.println("set end...");
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> set = new TreeSet<Message>(new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                return Integer.compare(m1.sequence, m2.sequence);
            }
        });
        set.addAll(received);
        List<Message> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    private static void QueueSnippets() {
        System.out.println("*****Queue start*****");
        Queue<String> queue = new LinkedList<>();
        // enqueue
        System.out.println("enqueue...");
        var add = queue.add("apple");
        var add2 = queue.add(null);
        var offer = queue.offer("apple2");
        var offer2 = queue.offer(null);
        System.out.println(add);
        System.out.println(add2);
        System.out.println(offer);
        System.out.println(offer2);
        // dequeue
        System.out.println("dequeue...");
        var remove = queue.remove();
        var poll = queue.poll();
        System.out.println(remove);
        System.out.println(poll);

        // get
        System.out.println("get...");
        var element = queue.element();
        var peek = queue.peek();
        System.out.println(element);
        System.out.println(peek);
        System.out.println(peek);

        // 排队叫号
        System.out.println("排队叫号...");
        Queue<UserV2> q = new PriorityQueue<UserV2>(new UserV2Comparator());
        // 添加3个元素到队列:
        q.offer(new UserV2("Bob", "A1"));
        q.offer(new UserV2("Alice", "A2"));
        q.offer(new UserV2("Boss", "V1"));

        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
//        while (q.size() > 0) {
//            System.out.println(q.poll());
//        }
        System.out.println("排队叫号结束...");
        System.out.println("*****Queue end*****");
    }

    private static void StackSnippets() {
        
    }
}

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person2) {
            Person2 p2 = (Person2) obj;
            return Objects.equals(this.name, p2.name) && this.age == p2.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 0;
        h = 31 * h + name.hashCode();
        h = 31 * h + age;
        return h;
    }
}

class Student2 {
    public String name;
    public int score;

    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Students3 {
    List<Student3> list;
    Map<String, Integer> cache;

    Students3(List<Student3> list) {
        this.list = list;
        cache = new HashMap<>();
    }

    /**
     * 根据name查找score，找到返回score，未找到返回-1
     */
    int getScore(String name) {
        // 先在Map中查找:
        Integer score = this.cache.get(name);
        if (score == null) {
            score = this.findInList(name);
            // 如果在List中找到，更新到Map中。
            if (score != null) {
                cache.put(name, score);
            }
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student3 {
    String name;
    int score;

    Student3(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}

class UserV2 {
    public final String name;
    public final String number;

    public UserV2(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}


class UserV2Comparator implements Comparator<UserV2> {
    // compareTo:x.compareTo(y)
    // if x>y return 1
    // if x=y return 0
    // if x<y return -1
    public int compare(UserV2 u1, UserV2 u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两个人的号都是A开头或者V开头，比较号的大小
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头，最高优先级
            return -1;
        } else {
            return 1;
        }
    }

}