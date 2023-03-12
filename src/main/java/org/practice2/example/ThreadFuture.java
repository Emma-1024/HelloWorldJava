package org.practice2.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

public class ThreadFuture {
    public static void ThreadFuture() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task1("1111"));
        System.out.println(future.get());
        es.shutdown();
    }
}

class Task1 implements Callable<BigDecimal> {
    public String code;

    public Task1(String code) {
        this.code = code;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(4000);
        System.out.println(code + " Waited 4 minutes");
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(4, RoundingMode.DOWN);
    }
}
