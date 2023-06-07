package com.springboot.hello._2023060501互联网高并发设计题._2023060702session过期如何处理;

public class App {
    /**
     * 用户登陆成功，生成sessionId
     *
     * 利用分布式缓存存储sessionId, 关联用户信息，设置过期时间，下发前端sessionid
     *
     * 前端在请求头中携带sessionid
     *
     * 服务端验证有效性，过期时间
     *
     * 如果过期， 1直接拒绝请求，前端提示
     *          2重定向到登陆页面
     *          3自动刷新过期时间，继续处理请求
     *
     * 还要考虑定期清理过期一段时间的sessionid, 是否有必要考虑数据备份
     */
}
