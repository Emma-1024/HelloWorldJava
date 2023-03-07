package org.practice2.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadReadWriteLock {
    public static void threadReadWriteLock() throws InterruptedException {
        var count = new Counter();
        for (int i = 0; i < 5; i++) {
            Thread gettingThread = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    int[] arrInt = count.get();
                    System.out.println("add: "+ Arrays.toString(arrInt));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            gettingThread.start();
        }
        Thread addingThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.inc(i);
                System.out.println("inc: " + i);
            }

        });
        addingThread.start();
    }
}

class Counter {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wLock.lock();
        try {
            counts[index] += 1;
        } finally {
            wLock.unlock();
        }
    }

    public int[] get() {
        rLock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rLock.unlock();
        }
    }
}


