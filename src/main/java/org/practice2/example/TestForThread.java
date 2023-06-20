package org.practice2.example;

import java.util.concurrent.atomic.AtomicInteger;

public class TestForThread {
    private int a = 0;
    static final Object lock = new Object();

    public void count() {
        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
                a += 1;
            }
        }
    }

    public void atomicCount(AtomicInteger aa) {
        for (int i = 0; i < 10000; i++) {
            this.a = aa.incrementAndGet();
        }
    }

    public int test() throws InterruptedException {
        AtomicInteger aa = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
//                this.count();
                this.atomicCount(aa);
            });
            thread.start();
            thread.join();
        }
        return this.a;
    }
}
