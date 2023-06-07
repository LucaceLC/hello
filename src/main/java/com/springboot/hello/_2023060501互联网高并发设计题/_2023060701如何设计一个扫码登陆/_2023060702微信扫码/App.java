package com.springboot.hello._2023060501互联网高并发设计题._2023060701如何设计一个扫码登陆._2023060702微信扫码;

public class App {
    /**
     * 微信扫码登陆流程
     *
     * 前期准备，企业向微信开发平台申请appid和密钥
     * 核心是获取微信openId
     *
     * 前端用appId + 重定向地址获取到微信登陆二维码，可以是二维码页面也可以是嵌入式页面
     *
     * 微信客户端扫码登陆，授权确认，请求微信开发者后台，获取到临时授权码code，然后访问重定向地址
     * 前端把临时授权从的，去请求后端
     *
     * 后端拿到临时授权码code + appid + 密钥，获取用户的openId
     *
     * 后端拿到openId,去用户系统模块查询，用户是否已存在，存在则下发系统token，否则下发特殊状态码
     *
     * 前端获取到token，登陆成功，跳转到首页，否则是特殊状态码跳转到注册页面
     */
}
