package snippets.book.javacore1.Ch09;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            return -1;
        } else {
            return 1;
        }
    }
}
