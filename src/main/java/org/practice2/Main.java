package org.practice2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Person[] ps = new Person[]{
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 89),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
        List<Number> list = new ArrayList<Number>();
        list.add(123);
        list.add(12.3);
        Number first = list.get(0);
        Number second = list.get(1);
        System.out.println("first:" + first.toString() + ",second:" + second.toString());


    }

}



