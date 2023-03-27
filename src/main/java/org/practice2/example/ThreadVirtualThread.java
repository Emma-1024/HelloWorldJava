package org.practice2.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVirtualThread {
    public static void main() throws InterruptedException {
        // 使用虚拟线程
        ExecutorService es = Executors.newVirtualThreadPerTaskExecutor();
        // 使用线程池
//        ExecutorService es = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            es.submit(() -> {
                Thread.sleep(1000);
                return 0;
            });
        }
        // 使用虚拟线程
        es.close();
        // 使用线程池
//        es.shutdown();
        long end = System.currentTimeMillis();
        System.out.printf("All virtual threads end at %s ms.\n", end - start);
    }
}
