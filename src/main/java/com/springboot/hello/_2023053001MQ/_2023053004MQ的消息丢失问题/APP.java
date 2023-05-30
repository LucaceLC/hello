package com.springboot.hello._2023053001MQ._2023053004MQ的消息丢失问题;

public class APP {
    /**
     * 如果保证mq消息不丢失，
     * 消息丢失会出现在哪些环节，消息生成者，消息中间件本身，消息消费者
     *
     * 以rabbit mq为例,
     * 消息方法方保证消息不丢失
     * 1 事物提交 ，txSelect
     * 事物提及是同步提交，会影响mq发送方的吞吐
     * 2 confirm应答，消息提交后，mq进行会回调通知，ack nack
     *
     * 消息中间件
     * 设置持久化
     *
     *
     * 消息消费方
     * 关闭自动ack，手动ack，确保业务逻辑处理完成后，ack应答
     *
     */
}
