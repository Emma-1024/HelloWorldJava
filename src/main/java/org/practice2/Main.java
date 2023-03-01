package org.practice2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public int age;

    public static void main(String[] args) throws Exception {
        Pattern pattern = Pattern.compile("([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)");
        System.out.println(pattern.matcher("23:01:59").matches()); // true
        Matcher matcher = pattern.matcher("23:01:59");
        if (matcher.matches()) {
            String whole = matcher.group(0);
            String hour = matcher.group(1);
            String minutes = matcher.group(2);
            String second = matcher.group(3);
            System.out.println(whole);
            System.out.println(hour);
            System.out.println(minutes);
            System.out.println(second);
        }

    }

}










