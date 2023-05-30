package com.springboot.hello._2023053001MQ._2023053002MQ的高可用架构;

public class APP {
    /**
     * rabbit mq的高可用架构
     *
     * 1单机、普通集群模式、镜像集群模式
     *
     * 普通集群模式，一个实例包含元数据和真实数据，其他实例只包含元数据，
     * 消费消费时，获取到其他实例上时，其他实例从主实例上拉取真实数据
     * 缺点是mq内部存在数据传输，还是有单点故障
     *
     * 镜像集群模式
     *
     * 所有实例都包含一份完整的mq数据，实例之间需要进行消息队列的同步
     * 缺点就是不是分布式的，数据量大时，耗费资源
     */

    /**
     * kafka mq的高可用架构
     *
     * 每个kafka都有一个broker进程，topic接受到消息后
     * 一个topic的消息被分布到多个partition上，每个partition包含数据的一部分
     * 一个实例时leader，对外读写，它有自己的follower副本，如果leader宕掉，自动选举出新的leader对外提供读写
     * leader负责对follower进行数据同步
     *
     * kafka每一个节点都是brocker进程，
     * 每个topic有多个parttion，
     * 消息分发到不同的brocker的不同partion上，
     * 所有节点存储消息的一部分，每一个节点可以配置leader和follower，
     * leader和follower会进行消息同步，只有leader可以进行读写，
     * follower作为mq的副本，leader宕机后，follower会被选举为leader进行读写，这个就是kafka的副本机制
     */

}
