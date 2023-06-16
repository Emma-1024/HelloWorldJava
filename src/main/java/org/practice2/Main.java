package org.practice2;

import org.practice2.example.*;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
//        ThreadCondition.threadCondition();
//        ThreadReadWriteLock.threadReadWriteLock();
//        ThreadPool.ThreadPool();
//        ThreadFuture.ThreadFuture();
//        ThreadCompletableFuture.ThreadCompletableFuture();
//        ThreadForkJoin.threadForkJoin();
//        ThreadThreadLocal.threadThreadLocal();
//        ThreadVirtualThread.main();
//        Lambda.main();
//        TestAnnotation.testMethod();
//        FibonacciStream.main();
//        FunctionalProgrammingStreamFilter.main();
//        FunctionalProgrammingStreamReduce.main();
        TestForThread t1 = new TestForThread();
        System.out.println(t1.test());
    }
}