package org.practice2.example;

public class ThreadLocalExample {
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public void runExample(){
        // 创建一个新的 StringBuilder 对象
        StringBuilder sb = new StringBuilder();


        // 在同一个线程中将 sb 对象传递给两个方法

        new Thread(()->{
            method1(sb);
        }).start();
        new Thread(()->{
            method2(sb);
        }).start();
    }



    public static void method1(StringBuilder sb) {
        // 向 sb 对象中添加一些文本
        sb.append("Hello, ");


        // 打印 sb 对象的当前状态
        System.out.println("method1: " + sb.toString());
    }

    public static void method2(StringBuilder sb) {
        // 向 sb 对象中添加一些文本
        sb.append("world!");

        // 打印 sb 对象的当前状态
        System.out.println("method2: " + sb.toString());
    }

}


