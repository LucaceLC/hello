package com.springboot.hello._20191204JDK18新特性实践._20191204并行数组;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelSortApp {
    public static void main( String[] args ) {
        long startTime = System.currentTimeMillis();
        long[] arrayOfLong = new long [ 20000 ];

        /**
         * parallelSetAll(long[] array, IntToLongFunction generator)
         * 第一个参数：需要被set的数组
         * 第二个参数：一个方法，用来接受每个index下的数组元素，进行set值，然后返回
         */

        Arrays.parallelSetAll( arrayOfLong, index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(i -> System.out.print( i + " " ) );
        System.out.println();

        Arrays.parallelSort( arrayOfLong );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(i -> System.out.print( i + " " ) );
        System.out.println();
        long endTime = System.currentTimeMillis();

        StringFormattedMessage stringFormattedMessage = new StringFormattedMessage("use time %d ms", endTime - startTime);
        System.out.println(stringFormattedMessage);

    }

}
