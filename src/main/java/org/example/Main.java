package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

    }

    /*commandLine*/
    public static void commandLine(String[] args) {
        for (String arg : args) {
            if ("-version".equals(arg)) {
                System.out.println("v 1.0");
                break;
            }
        }
    }

    /*towDimensional array*/
    /*
        用二维数组表示的学生成绩:
        int[][] scores = {{82, 90, 91}, {68, 72, 64}, {95, 91, 89}, {67, 52, 60}, {79, 81, 85},};
        allStudentAverageScore(scores);
    */
    public static void allStudentAverageScore(int[][] scores) {
        double average = 0;
        int studentCount = scores.length;
        int subjectsCategory = scores[0].length;
        int allStudentScoresCount = 0;
        for (int[] arr : scores) {
            for (int n : arr) {
                allStudentScoresCount += n;
            }
        }
        average = allStudentScoresCount * 1.0 / (studentCount * subjectsCategory);
        System.out.print(average);
        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }

    /*scanner*/
    public static void scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input your name: ");
        String name = scanner.nextLine();
        System.out.print("input your age: ");
        int age = scanner.nextInt();
        System.out.printf("Hi, %s, you are %d\n", name, age);
    }

    /* quicksort*/
    /*
        int[] ns = {100, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        System.out.println(Arrays.toString(quicksort(ns, 0, 9)));
     */
    public static int[] quicksort(int[] ary, int L, int R) {
        if (L >= R) return null;
        int left = L, right = R;
        int pivot = ary[left];
        while (left < right) { // 左右下标未重合
            while (left < right && ary[right] >= pivot) {
                right--;
            }
            if (left < right) {
                ary[left] = ary[right];
            }
            while (left < right && ary[left] <= pivot) {
                left++;
            }
            if (left < right) {
                ary[right] = ary[left];
            }
            if (left >= right) {
                ary[left] = pivot;
            }
        }
        quicksort(ary, L, right - 1);
        quicksort(ary, right + 1, R);
        return ary;
    }
}

