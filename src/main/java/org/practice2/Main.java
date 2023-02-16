package org.practice2;

import java.beans.*;
import org.practice2.example.*;

public class Main {
    public static void main(String[] args) throws IntrospectionException {
//        Adder adder = new Adder();
//        adder.add(2).add(3).inc().add(5);
//        System.out.println(adder.value());

//        String[] fields = { "name", "position", "salary" };
//        String table = "employee";
//        String insert = Util.buildInsertSql(table, fields);
//        String select = Util.buildSelectSql(table, fields);
//        System.out.println(insert);
//        System.out.println(select);
//        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
//        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
        Weekday day = Weekday.SUN;
        System.out.println(day);
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }

    }


}



