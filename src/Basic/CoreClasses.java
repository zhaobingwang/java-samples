package Basic;

import java.util.StringJoiner;

public class CoreClasses {
    public static void main(String[] args) {
        String s1 = new String(new char[]{'h', 'i', '.'});
        String s2 = "HI.".toLowerCase();
        System.out.println(s1.toUpperCase());   // HI.
        System.out.println(s1 == s2);   // false
        System.out.println(s1.equals(s2));  // true 两个字符串比较，必须总是使用equals()方法
        System.out.println(s1.contains("i"));   // true
        System.out.println(s1.indexOf('i'));    // 1
        System.out.println(s1.lastIndexOf('.'));    // 2
        System.out.println(s1.startsWith("hi"));    // true
        System.out.println(s1.endsWith("i."));  // true
        System.out.println("hello".substring(2));   // llo
        System.out.println("hello".substring(2, 4));    // ll

        int n = 100;
        String s3 = String.valueOf(n);
        System.out.println(s3);

        Adder adder = new Adder();
        adder.add(10).add(23).inc();
        System.out.println(adder.value());

        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        System.out.println(
                "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)".equals(insert) ? "测试成功" : "测试失败");

        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ");
        StringJoiner sj2 = new StringJoiner(", ", "Hello, ", "!");
        for (String name : names) {
            sj.add(name);
            sj2.add(name);
        }
        System.out.println(sj.toString());
        System.out.println(sj2.toString());

        String s4 = String.join("-", names);
        System.out.println(s4);

        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ")
                .append(table)
                .append(" (");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(fields[i]);
        }
        sb.append(") VALUES (?, ?, ?)");
        return sb.toString();
    }

    static String buildSelectSql(String table, String[] fields) {
        StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        return sj.toString();
    }
}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}