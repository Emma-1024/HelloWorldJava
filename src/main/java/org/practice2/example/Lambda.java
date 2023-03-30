package org.practice2.example;

import java.util.Arrays;

public class Lambda {
    public static void main(){
        String[] array = new String[] {"apple", "Orange", "banana", "Lemon"};
        Arrays.sort(array, ((o1, o2) -> o1.compareToIgnoreCase(o2)));
//        Arrays.sort(array, (String::compareToIgnoreCase));
        //    public static int compareToIgnoreCase(String this, String str) {
        System.out.println(String.join(", ", array));
    }
}
