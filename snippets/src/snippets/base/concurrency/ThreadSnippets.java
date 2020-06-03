package snippets.base.concurrency;

import java.util.Objects;

public class ThreadSnippets {
    public static void createThread() {
        Thread t = new Thread(() -> {
            System.out.println("A new thread is started");
        });
        t.setPriority(1);   // 线程的优先级,1~10,默认5
        t.start();
    }

    public static void syncThread() throws InterruptedException {
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println("sync thread end: " + Counter.count);
    }

}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}