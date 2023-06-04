package com.springboot.hello._2023053001MQ._2023053101MQ的顺序性;

public class APP {
    /**
     *
     * rabbit mq
     * 保证有序的消息，都进入一个mq的队列
     *
     * 确保一个消费者只从一个topic中消费
     */

    /**
     * kafka mq
     * 一个topic有多个partition，插入的时候一定时有序的
     * 取出的时候，可以指定key进入partition，然后消费者从对应的partition消费
     * 一个消费者多线程消费的情况时，根据hash指定到内存队列中，然后按入队列取
     */
}