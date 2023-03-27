package org.practice2.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadThreadLocal {
    public static void threadThreadLocal() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(3);
        String[] users = new String[] { "Bob", "Alice", "Tim", "Mike", "Lily", "Jack", "Bush" };
        for (String user : users) {
            es.submit(new Tltask(user));
        }
        es.awaitTermination(3, TimeUnit.SECONDS);
        es.shutdown();
    }
}


class UserContext implements AutoCloseable {
    private static final java.lang.ThreadLocal<String> userThreadLocal = new java.lang.ThreadLocal<>();

    public UserContext(String name) {
        userThreadLocal.set(name);
        System.out.printf("[%s] init user %s...\n", Thread.currentThread().getName(), UserContext.getCurrentUser());
    }

    public static String getCurrentUser() {
        return userThreadLocal.get();
    }

    @Override
    public void close() {
        System.out.printf("[%s] cleanup for user %s...\n", Thread.currentThread().getName(),
                UserContext.getCurrentUser());
        userThreadLocal.remove();
    }
}

class Tltask implements Runnable {

    final String username;

    public Tltask(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        try (var ctx = new UserContext(this.username)) {
            new Tltask1().process();
            new Tltask2().process();
            new Tltask3().process();
        }
    }
}
class Tltask1 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] check user %s...\n", Thread.currentThread().getName(), UserContext.getCurrentUser());
    }
}

class Tltask2 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] %s registered ok.\n", Thread.currentThread().getName(), UserContext.getCurrentUser());
    }
}

class Tltask3 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] work of %s has done.\n", Thread.currentThread().getName(),
                UserContext.getCurrentUser());
    }
}

