package com.springboot.leetcode.数._2021020403最大重复字子串滑动窗口解决;

import java.util.HashMap;
import java.util.Map;

public class App {

    public int findMaxStr(String str){
        if(str == null || str.isEmpty()) return 0;

        /**
         * HashMap作为容器，key 保存值，value 索引
         * 不管有没有出现，都有放入容器，如果存入过，重新放入会把最大索引值替换的
         * max = fast -slow +1
         *
         * 要防止abba的形式的出现，slow和max计算的新值，必须大于原来的值
         */
        char[] chars = str.toCharArray();
        Map<Character,Integer> lastOccurrenceMap = new HashMap<>();

        int fast =0, slow = 0,max = 0;
        for (; fast < chars.length; fast++){
            char element = chars[fast];
            if(lastOccurrenceMap.containsKey(element)){
                int currentSlow = lastOccurrenceMap.get(element) +1;
                if(slow < currentSlow){
                    slow = currentSlow;
                }
            }
            lastOccurrenceMap.put(element,fast);
            int currentMax = fast -slow +1;
            if(max < currentMax){
                max = currentMax;
            }
        }
        return max;
    }
}
