package snippets.geektime.concurrency;

public class GeekTimeConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("GeekTime Java concurrent programming...");
        long count = Test.calc();
        System.out.println(count);
    }
}
