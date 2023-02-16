package org.practice2.example;

import java.util.StringJoiner;

public class Util {
    public static String buildInsertSql(String table, String... fields) {
        StringBuilder str = new StringBuilder(1024);
        str.append("INSERT INTO ").append(table).append(" (");
        for (int i = 0; i < fields.length; i++) {
            str.append(fields[i]).append(i == fields.length - 1 ? "" : ", ");
        }
        str.append(") VALUES (?, ?, ?)");
        return str.toString();
    }

    public static String buildSelectSql(String table, String... fields) {
        //"SELECT name, position, salary FROM employee".
//        method 1
//        var sj = new StringJoiner(", ", "SELECT "," FROM " + table);
//        for(String field: fields){
//            sj.add(field);
//        }
//        method 2
        return String.format("SELECT %s FROM %s", String.join(", ", fields), table);
    }
}
