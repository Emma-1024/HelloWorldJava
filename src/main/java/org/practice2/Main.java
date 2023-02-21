package org.practice2;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Alex", "Shanghai", 34);
        Person p2 = new Person("", "Shanghai", 20);
        Person p3 = new Person("Alice", "Shanghai", 199);
        for (Person p : new Person[]{p1, p2, p3}) {
            try {
                check(p);
                System.out.println("person:" + p + "checked ok.");
            } catch (IllegalArgumentException e) {
                System.out.println("person:" + p + "checked failed" + e);
            }
        }

    }

    //  字段长度和数字范围满足@Range的参数定义
    static void check(Person person) throws IllegalAccessException {
        for (Field field : person.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object value = field.get(person);
                if (value instanceof String) {
                    String s = (String) value;
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field:" + field.getName());
                    }
                } else if (value instanceof Integer) {
                    Integer i = (Integer) value;
                    if (i < range.min() || i > range.max()) {
                        throw new IllegalArgumentException("Invalid field:" + field.getName());
                    }
                }
            }
        }
    }

}


