package Basic;

import java.lang.reflect.Field;

public class ReflectionSnippets {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        printClassInfo("".getClass());
//        printClassInfo(Runnable.class);
//        printClassInfo(java.time.Month.class);
//        printClassInfo(String[].class);
//        printClassInfo(int.class);

        Object user = new User(1, "Jack");
        Class c = user.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(user);
        System.out.println(value);
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}