package org.practice2;
import org.practice2.example.Adder;
import org.practice2.example.Util;

public class Main {
    public static void main(String[] args) {
        Adder adder = new Adder();
        adder.add(2).add(3).inc().add(5);
        System.out.println(adder.value());

        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = Util.buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }


}
