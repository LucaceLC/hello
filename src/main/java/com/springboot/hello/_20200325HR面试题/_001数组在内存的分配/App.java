package com.springboot.hello._20200325HR面试题._001数组在内存的分配;

import org.junit.jupiter.api.Test;

public class App {

    //在堆上一组连续的内存存储空间
    @Test
    public void arrayFunction(){
        int[]  intArray = new int[1];

        Integer[] integersArray =  new Integer[1];

        double[][] double2Array = new double[1][1];

        String[]  stringArray = new String[1];
    }
}
