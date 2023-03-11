package org.practice2.example;

import java.util.concurrent.*;

public class ThreadPool {
    public static void ThreadPool() throws Exception {
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        ExecutorService es = Executors.newCachedThreadPool();

        ExecutorService es = new ThreadPoolExecutor(2, 3,
                1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 10; i++) {
            es.submit(new Task("Alex" + i));
        }
        es.shutdown();
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
            Thread.sleep(2);
        } catch (InterruptedException e) {

        }
        System.out.println("end task " + name);
    }

}