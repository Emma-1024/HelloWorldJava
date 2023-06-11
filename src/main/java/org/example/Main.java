package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

import org.example.DumplingCalorie;

public class Main {

    public static void main(String[] args) {
        DumplingCalorie c = new DumplingCalorie();
        c.totalDumplingWrapper = 116;
        c.wrappedDumpling = 106;
        c.ateDumpling = 17.5;
        c.dumplingWrapper = 1200;
        c.chive = 1064;
        c.pork = 960;
        c.shrimp = 1200;
        c.printEachFoodCalorie();
//        Person p = new Person("xiaoming", 12);
//        p.setName("Huang", "xiaoming");
//        System.out.println(p.getName());
//        p.setName("Huang");
//
//        p.setAge(12);
//        System.out.println(p.getName());
//        System.out.println(p.getAge());
//        Student s = new Student("Xiao Ming", 12, 89);
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

/*class person*/
class Person {
    protected String name;
    private int age = 9;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 18);
    }

    public String getName() {
        return name;
    }

//    public Person() {
//        this("unNamed");
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String firstName, String lastName) {
        this.name = firstName + lastName;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }
}

class Student extends Person {
    private int score;
    protected Book book;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String Hello() {
        return name;
    }

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }
}

class Book {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

