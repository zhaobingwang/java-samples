package Basic;

public class OperatorSnippets {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int x = 2 * ++a;
        int y = 2 * b++;

        System.out.println("a=" + a + ",x=" + x);
        System.out.println("b=" + b + ",y=" + y);
    }
}
