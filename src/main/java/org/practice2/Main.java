package org.practice2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        Integer removed = list.remove((int) (Math.random() * list.size()));
        System.out.println(list.toString());
        int found = findMissingNumber(start, end, list);
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int res = 0;
        //         有序
//        for(int i: list){
//            if(i!=start++){
//                res = --start;
//                break;
//            }
//        }
        // 无序
        for (int i = start; i <= end; i++) {
            if (!list.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

}




