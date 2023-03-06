package org.practice2;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

}

class Counter {
    public static final Object lock = new Object();
    public static final Lock lock2 = new ReentrantLock();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {

        for (int i = 0; i < 5; i++) {
//            synchronized(Counter.lock2) {
//                Counter.count += 1;
//            }
            Counter.lock2.lock();
            try {
                Counter.count += 1;
                Thread.sleep(1005);
                System.out.println("waiting" + (i + 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                Counter.lock2.unlock();
            }


        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
//            Counter.lock2.lock();
//            synchronized(Counter.lock) {
//                Counter.count -= 1;
//            }
            try {
                if (Counter.lock2.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("start");
                    try {
                        Counter.count -= 1;
                    } finally {
                        Counter.lock2.unlock();
                    }
                } else {
                    System.out.println("give up");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

