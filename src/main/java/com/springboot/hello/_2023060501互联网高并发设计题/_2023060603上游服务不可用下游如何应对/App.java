package com.springboot.hello._2023060501互联网高并发设计题._2023060603上游服务不可用下游如何应对;

public class App {

    /**
     *
     * 上游服务的故障原因
     *  1中间件基础设施故障
     *  2机房故障，机房不可用
     *  3流量徒增压力，引发性能问题，耗时徒增
     *
     *
     * 上游服务
     *  1主备切换，备用服务切换到对外服务，如果是多机房服务，需要评估对流量进行切走
     *  2降级，丢弃请求，快速失败，缓解服务器压力
     *  3扩容，最好是根据上报的业务指标，机器指标进行弹性伸缩，自动扩容/缩容
     *
     * 下游服务
     *      发生前   1上游服务缓存结果，对实时性要求不高的场景，进行数据本地备份
     *              2业务指标、机器指标数据上报，根据上报数据进行监控，建立告警机制
     *              3全链路追踪，分析业务主链路是哪个服务挂掉了
     *
     *      发生中   服务降级，丢低部分请求，可以按业务场景丢弃
     *              服务熔断，不请求三方接口，缓解上游服务压力
     *              超时失败，快速失败
     *              异步化处理，非主流程服务要进行异步化处理，不能影响主链路
     *              如果是对数据一致性有要求的服务，保存请求，异步化处理，失败重试
     *
     *      发生后   失败重试补偿
     */
}
