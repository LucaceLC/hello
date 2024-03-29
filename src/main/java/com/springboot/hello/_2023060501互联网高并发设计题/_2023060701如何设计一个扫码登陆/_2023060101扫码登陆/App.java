package com.springboot.hello._2023060501互联网高并发设计题._2023060701如何设计一个扫码登陆._2023060101扫码登陆;

public class App {
    /**
     * 如何设计一个扫码登陆
     *
     * 三端
     * 服务后端，网页前端，手机客户端
     *
     * 服务端生成二维码id，记录过期时间，有效性状态
     * 网页前端获取到二维码id，根据二维码id自行生成二维码，
     * 也可以是二维码图片是后端下发，一个oss对象存储的url也可以
     * 根据实际场景选择
     *
     * 手机客户端扫码
     * 获取到二维码id，携带token请求服务后端
     *
     * 服务后端验证token有效性，二维码有效性，在网页前端轮训的接口下发pc token
     * 登陆成功
     */


}
