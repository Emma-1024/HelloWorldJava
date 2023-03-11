package org.practice2.example;

import java.util.concurrent.*;

public class ThreadPool {
    public static void ThreadPool() throws Exception {
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        ExecutorService es = Executors.newCachedThreadPool();

//        ExecutorService es = new ThreadPoolExecutor(2, 3,
//                1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//        for (int i = 0; i < 10; i++) {
//            es.submit(new Task("Alex" + i));
//        }
//        es.shutdown();

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
//        for (int i = 0; i < 100; i++) {
//            // 1秒后执行一次性任务:
//            ses.schedule(new Task("one-time"+i), 1, TimeUnit.SECONDS);
//        }
        // 0秒后开始执行定时任务，每1秒执行:
//        ses.scheduleAtFixedRate(new Task("fixed-rate"),0, 1, TimeUnit.SECONDS);
        // 0秒后开始执行定时任务，以1秒为间隔执行:
        ses.scheduleWithFixedDelay(new Task("fixed-delay"),0,1,TimeUnit.SECONDS);
//        ses.shutdown();
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
//        if (name.equals("one-time")) {
//            System.out.println("xxxxxx");
//            throw new IllegalArgumentException();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//
//        }
        System.out.println("end task " + name);
    }

}