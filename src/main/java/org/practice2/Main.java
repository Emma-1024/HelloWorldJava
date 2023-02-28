package org.practice2;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    private static String toHex(int i) {
        Deque<String> deque = new LinkedList<>();
        String s = Integer.toString(i);
        int hexBase = 16;
        while (i > hexBase || i % hexBase != 0) {
            int remainder = i % hexBase;
            if(remainder<10){
              deque.push(String.valueOf(remainder));
            }
            else if(remainder==10){
                deque.push("A");
            }
            else if(remainder==11){
                deque.push("B");
            }
            else if(remainder==12){
                deque.push("C");
            }
            else if(remainder==13){
                deque.push("D");
            }
            else if(remainder==14){
                deque.push("E");
            }
            else if(remainder==15){
                deque.push("F");
            }
//            deque.push(Integer.toHexString(i % hexBase));
            i = i / hexBase;
        }
        StringBuilder res = new StringBuilder();
        int len = deque.size();
        for (int k = 0; k < len; k++) {
            res.append(deque.pop());
        }
        return res.toString();
    }

}









