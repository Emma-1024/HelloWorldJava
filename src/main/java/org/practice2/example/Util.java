package org.practice2.example;

public class Util {
    public static String buildInsertSql(String table, String ... fields){
        StringBuilder str = new StringBuilder(1024);
        str.append("INSERT INTO ").append(table).append(" (");
        for(int i=0;i<fields.length;i++){
            str.append(fields[i]).append(i==fields.length-1?"":", ");
        }
        str.append(") VALUES (?, ?, ?)");
        return str.toString();
    }
}
