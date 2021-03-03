package com.springboot.hello._20190917Ioc._2021030301典型的SpringMVC请求流程;

public class App {
    /**
     * spring mvc请求模型是什么，流程是什么
     *
     * 客户端请求进来，
     * 到前端控制器dispacterServlet
     * 交给handlerMapping找到对用的handler
     * 由hanlderAdapter适配器调用真正的controller真正去处理业务逻辑
     * 得到数据后，返回一个ModelAndView
     * 根据view逻辑视图
     * viewResover视图解析器进行视图渲染，数据和页面的渲染
     * 最后交给前端控制器，返回客户端
     */
}
