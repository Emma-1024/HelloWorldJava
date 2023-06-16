package org.practice2.example;

public class TestForThread {
    private int a = 0;
    static Object lock = new Object();

    public int count() {
        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
                a += 1;
            }
            return a;
        }
    }

    public int test() {
        TestForThread t2 = new TestForThread();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                this.count();
            }).start();
        }
        return this.a;
    }
}
