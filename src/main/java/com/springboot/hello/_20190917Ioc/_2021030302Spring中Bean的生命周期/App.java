package com.springboot.hello._20190917Ioc._2021030302Spring中Bean的生命周期;

public class App {

    /**
     * Spring中bean的生命周期是怎么样的
     *
     * 1创建实力new
     * 2注入属性
     * 3如果实现了各种*Aware接口，会进行各种设置，例如设置bean名称，类加载器，资源加载器，应用上下文等
     * 4如果spring配置了bean处理器，BeanPostProcess，调用前置处理方法
     * 5初始化中bean的after属性设置方法，intionling的aferPropertisSet方法 泼扑替si
     * 6调用初始化方法
     * 7调用bean处理器的，后置处理方法
     * 8实例化完成
     * 9如果工厂关闭，会执行3种销毁方法，如果实现接口
     * 方法销毁前置处理器，调用销毁方法
     * DispasebleBean的销毁方法
     * 自定义的销毁方法
     */
}
