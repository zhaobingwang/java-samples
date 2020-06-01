package snippets.base;

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
}
