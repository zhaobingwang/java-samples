package snippets.base.concurrency;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSnippets {
    public static void run() throws InterruptedException {
//        IdGenerator idGenerator = new IdGenerator();
//        long id = idGenerator.getNextId();
//        System.out.println(id);
//        id = idGenerator.getNextId();
//        System.out.println(id);

//        threadPool();
//        completableFuture();
        forkJoin();
    }

    public static void createThread() {
        Thread t = new Thread(() -> {
            System.out.println("A new thread is started");
        });
        t.setPriority(1);   // 线程的优先级,1~10,默认5
        t.start();
    }

    public static void syncThread() throws InterruptedException {
//        Thread add = new AddThread();
//        Thread dec = new DecThread();
//        add.start();
//        dec.start();
//        add.join();
//        dec.join();
//        System.out.println("sync thread end: " + Counter.count);
    }

    public static void threadPool() {
        ExecutorService executor = Executors.newFixedThreadPool(4);  // 线程数固定的线程池
//        executor=Executors.newCachedThreadPool();   // 线程数根据任务动态调整的线程池
//        executor=Executors.newSingleThreadExecutor();   // 仅单线程执行的线程池
//        executor.submit();

        for (int i = 0; i < 6; i++) {
            executor.submit(new Task("t" + i));
        }
        executor.shutdown();

        // 创建指定动态范围线程池
        int min = 4;
        int max = 10;
        ExecutorService executor2 = new ThreadPoolExecutor(
                min,
                max,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        // 定期反复执行任务
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        // 提交一次性任务，它会在指定延迟后只执行一次
        ses.schedule(new Task("run-one-time"), 1, TimeUnit.SECONDS);
        // 任务以固定的每3秒执行:指任务总是以固定时间间隔触发，不管任务执行多长时间
        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
        // 任务以固定的3秒为间隔执行:上一次任务执行完毕后，等待固定的时间间隔，再执行下一次任务
        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
    }

    // https://www.liaoxuefeng.com/wiki/1252599548343744/1306581182447650
    // 同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，
    // 查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作：
    public static void completableFuture() throws InterruptedException {
        // 两个CompletableFuture执行异步查询
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });

        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);


    }

    public static void forkJoin() {
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/Join sum: " + result + " in " + (endTime - startTime) + "ms");
    }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt();
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5 + Math.random() * 20;
    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}

class Counter2 {
    public static final Object lock = new Object();
    public static int count = 0;

    // 用synchronized修饰方法可以把整个方法变为同步代码块，synchronized方法加锁对象是this
    public synchronized void add(int n) {
        count += n;
    }

    public void dec(int n) {
        count -= n;
    }

    public int get() {
        return count;
    }
}

//class AddThread extends Thread {
//    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            synchronized (Counter.lock) {
//                Counter.count += 1;
//            }
//        }
//    }
//}
//
//class DecThread extends Thread {
//    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            synchronized (Counter.lock) {
//                Counter.count -= 1;
//            }
//        }
//    }
//}

class CounterWithReentrantLock {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }
}

class CounterWithReentrantLock2 {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                // DO SOMETHING
                count++;
            } finally {
                lock.unlock();
            }
        }
    }
}

class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("An exception occurred for task " + name);
        }
        System.out.println("end task " + name);
    }
}

class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 500;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小，直接计算
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                // 故意放慢计算速度:
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }
        // 大任务,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("Split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subTask1 = new SumTask(this.array, start, middle);
        SumTask subTask2 = new SumTask(this.array, middle, end);
        invokeAll(subTask1, subTask2);
        Long subResult1 = subTask1.join();
        Long subResult2 = subTask2.join();
        Long result = subResult1 + subResult2;
        System.out.println("result = " + subResult1 + " + " + subResult2 + " = " + result);
        return result;
    }
}