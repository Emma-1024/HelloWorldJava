package org.practice2;

import org.practice2.example.ThreadCondition;
import org.practice2.example.ThreadPool;
import org.practice2.example.ThreadReadWriteLock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws Exception {
//        ThreadCondition.threadCondition();
//        ThreadReadWriteLock.threadReadWriteLock();
        ThreadPool.ThreadPool();

    }
}

