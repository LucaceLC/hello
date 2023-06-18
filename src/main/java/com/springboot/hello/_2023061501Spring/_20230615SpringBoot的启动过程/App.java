package com.springboot.hello._2023061501Spring._20230615SpringBoot的启动过程;

public class App {
    /**
     * Springboot启动过程
     *
     * 1、找到SpringBootApplication注解的启动类的main方法，启动程序
     * 2、
     *
     * 2通过调用SpringApplication类的run方法构建SpringApplication对象，并进行以下初始化操作：
     *      2.1 如果primarySources不为空，将启动类赋值给primarySources对象。
     *      2.2 从classpath类路径推断Web应用类型，有三种类型：NONE、SERVLET、REACTIVE。
     *      2.3 初始化bootstrapRegistryInitializers，获取BootstrapRegistryI0nitializer接口的实例对象列表。
     *      2.4 初始化ApplicationContextInitializer集合，获取ApplicationContextInitializer接口的实例对象列表。
     *      2.5 初始化ApplicationListener集合，获取ApplicationListener接口的实例对象列表。
     *      2.6 获取StackTraceElement数组，并通过反射获取堆栈中具有main方法的类。
     * 3调用SpringBootApplication类的run方法。
     * 4记录项目启动时间。
     * 5通过BootstrapRegistryInitializer初始化DefaultBootstrapContext。
     * 6获取SpringApplicationRunListeners监听器。
     * 7调用listeners.starting()方法，触发ApplicationStartingEvent事件。
     * 8准备环境，将配置文件读取到容器中，返回ConfigurableEnvironment对象。
     * 9打印Banner图案。
     * 10根据WebApplicationType从ApplicationContextFactory工厂创建ConfigurableApplicationContext，并设置ApplicationStartup为DefaultApplicationStartup。
     * 11调用prepareContext()方法，初始化上下文，打印启动日志信息，启动Profile日志信息，并为BeanFactory中的部分属性赋值。
     * 12刷新容器，包括集成Tomcat容器。
     * 13加载SpringMVC。
     * 14执行刷新后的方法（空方法，可以由用户自定义重写）。
     * 15计算启动花费的时间。
     * 16打印启动日志信息，包括应用程序的启动时间。
     * 17调用listeners.started()方法，触发ApplicationStartedEvent事件，表示上下文已刷新，应用程序已启动。
     * 18执行ApplicationRunner和CommandLineRunner的run方法。
     * 19返回上下文对象。
     * 20这是Spring Boot应用程序的典型启动过程，其中涉及到了环境准备、配置加载、上下文初始化、容器刷新、Spring MVC加载等步骤。每个步骤都有特定的功能和事件触发，确保应用程序正确启动和初始化。
     */
}
