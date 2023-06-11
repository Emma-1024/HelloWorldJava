package org.example;

public class DumplingCalorie {
    //总共多少个饺子皮
    public int totalDumplingWrapper = 0;
    // 包了多少个饺子皮
    public int wrappedDumpling = 0;
    // 吃了几个饺子
    public Double ateDumpling = 0.0;

    // 克
    public int dumplingWrapper = 0;
    public int chive = 0;
    public int pork = 0;
    public int shrimp = 0;

    public DumplingCalorie() {
    }

    public DumplingCalorie(int totalDumplingWrapper, int wrappedDumpling, Double ateDumpling, int dumplingWrapper, int chive, int pork, int shrimp) {
        this.totalDumplingWrapper = totalDumplingWrapper;
        this.wrappedDumpling = wrappedDumpling;
        this.ateDumpling = ateDumpling;
        this.dumplingWrapper = dumplingWrapper;
        this.chive = chive;
        this.pork = pork;
        this.shrimp = shrimp;
    }

    public void printEachFoodCalorie() {
        // 一个饺子包含多少克原料
        double eachDumplingContainsChive = (double) chive / wrappedDumpling;
        double eachDumplingContainsPork = (double) pork / wrappedDumpling;
        double eachDumplingContainsShrimp = (double) shrimp / wrappedDumpling;
        double eachDumplingContainsDumplingWrapper = (double) dumplingWrapper / totalDumplingWrapper;
        double ateDumplingContainChive = ateDumpling * eachDumplingContainsChive;
        double ateDumplingContainPork = ateDumpling * eachDumplingContainsPork;
        double ateDumplingContainShrimp = ateDumpling * eachDumplingContainsShrimp;
        double ateDumplingContainDumplingWrapper = ateDumpling * eachDumplingContainsDumplingWrapper;
        System.out.println("Chive:" + String.format("%.2f", ateDumplingContainChive) + "g");
        System.out.println("Pork:" + String.format("%.2f", ateDumplingContainPork) + "g");
        System.out.println("Shrimp:" + String.format("%.2f", ateDumplingContainShrimp) + "g");
        System.out.println("dumplingWrapper:" + String.format("%.2f", ateDumplingContainDumplingWrapper) + "g");
    }
}
