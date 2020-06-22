package snippets.book.javacore1.Ch09;

public class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "name:" + name + ",number:" + number;
    }
}
