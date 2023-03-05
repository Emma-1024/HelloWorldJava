package org.practice2;

public class Main {
    public static void main(String[] args) throws Exception {
        var c1 = new Counter();

        new Thread(() -> {
            c1.add(2);
        }).start();
        new Thread(() -> {
            c1.decrease(2);
        }).start();
    }
}

class Counter {
    private int value = 0;
    private int another = 0;
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();

    public void add(int m) {
        synchronized (lockA) {
            this.value += m;
            System.out.println("add value" + this.value);
            synchronized (lockB) {
                this.another += m;
                System.out.println("add another" + this.another);
            }
        }
        System.out.println("add");
    }

    public void decrease(int m) {
        synchronized (lockA) {
            this.value -= m;
            System.out.println("dec value" + this.value);
            synchronized (lockB) {
                this.another -= m;
                System.out.println("dec another" + this.another);
            }
        }
        System.out.println("decrease");
    }

}

