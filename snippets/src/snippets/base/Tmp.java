package snippets.base;

import snippets.base.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tmp {
    public static String SayHi() {
        return "Hi";
    }

    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }

    public static void mapSnippets() {

        List<User> users = getUserFakeData(10);
        Map<String, List<User>> groupedUser = users.stream().collect(Collectors.groupingBy(c -> c.getCategory()));
        Map<String, Long> groupedCount = users.stream()
                .collect(Collectors.groupingBy(c -> c.getCategory(), Collectors.counting()));
        long c0 = groupedCount.get("C0");
        long c1 = groupedCount.get("C1");
        long c2 = groupedCount.get("C2");
        System.out.println(c0);
        System.out.println(c1);
        System.out.println(c2);

        for (Map.Entry<String, List<User>> gu : groupedUser.entrySet()) {
            String key = gu.getKey();
            List<User> gus = gu.getValue();
            System.out.println("key: " + key);
            for (User u : gus) {
                System.out.println("\t" + u.getName());
            }
        }
    }

    private static List<User> getUserFakeData(int count) {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < count; i++) {
//            User user = new User();
//            user.setId(i);
//            user.setName("测试" + i);
//            user.setCategory("C" + i % 3);
//            users.add(user);

            // use lombok builder
            User user = User.builder()
                    .id(i)
                    .name("测试" + i)
                    .category("C" + i % 3)
                    .build();
            users.add(user);
        }
        return users;
    }
}

