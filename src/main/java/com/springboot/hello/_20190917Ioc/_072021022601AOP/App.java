package com.springboot.hello._20190917Ioc._072021022601AOP;

public class App {
    /**
     * aop的实现方式
     * 什么是aop 面向切面编程
     *
     * 横向抽取，相同功能的横向抽取，代理类实现功能，事件/缓存/监控/缓存
     *
     * aop的实现原理：

     * aop底层是使用代理实现的
     * 一、手动代理
     *      1jdk的动态代理
     *      接口+实现
     *      2cglib字节码增强
     *      实现
     * 3aop术语
     * 目标类，target，需要被代理的类
     * 连接点，指那些可能被拦截的方法 joinPoint，例如：一个service的所有方法
     * 切入点，pointCut，已经被增强的连接点，例如：一个特定的方法
     * 增强/通知，advice，增强的功能代码，例如aftre before
     *      前置通知，后置通知，环绕通知,异常抛出通知，引介通知
     *
     * 织入，weaving，把增强advice应用到目标类target创建代理对象的过程
     * 代理，proxy
     * 切面，aspect,切入点pointCut和通知advice的结合
     * 特殊：引介introduction，特殊的增强，在不修改代码的前台下，引介可以在运行期间，动态的添加一些方法和属性
     *
     * 完成一个aop切面有哪些要素：
     * 首先要有目标类target
     * 然后目标类中的所有方法叫，连接点JoinPoint
     * 选择特定的方法，进行切面增强，这个方法叫PointCut，切入点
     * 增强的功能代码切面类，叫做advice，通知/增强，
     * 把增强和切入点整合，生成代理对象的过程叫做织入，weaving
     * 生成的对象叫做代理对象proxy
     * 切入点，被增强的方法和advice增强的结合，叫做切面
     *
     * 1jdk的动态代理，是对装饰者的简化
     * 必须要有接口+实现类
     *      目标类
     *      切面类
     *      工厂类生产代理对象：目标类和切面的结合，换句话说，切入点与增强的结合
     * 2cglib字节码增强
     *  原理，采用字节码增强框架，在运行时，创建目标的子类，从而对目标类进行增强
     *  spring-core核心包，已经整合了cglib和asm.jar包
     *  cglib字节码增强，只有实现类，原理是在代码运行期间，创建目标类的子类对象，进行增强
     *      1增强列enhancer
     *      2设置目标类为父类
     *      3设置回调方法，MethodInterceptor方法拦截器，
     *          参数1 代理对象，参数二 当前执行的方法，参数三传参，参数4方法的代理
     *      4创建代理对象，object需要强转
     * 二、半自动
     *     利用spring的配置文件进行配置
     *     首先配置
     *     1配置目标类bean
     *     2配置切面类，同时，切面类实现MethodInterceptor方法，实现invoke方法，invocation.proceed()，实现增强
     *     3配置代理工厂Bean ProxyFactoryBean，调用的getObject创建代理类对象
     *        属性：1目标类
     *             2接入点配置拦截的接口，目标类继承的接口
     *             3配置拦截器们，切面类
     *             4是否默认使用cglib字节码增强实现，
     *                  如果目标类有接口，使用jdk的动态代理实现
     *                  如果没有接口，使用cglib字节码增强实现
     *                  optimize=true时，无论有没有接口，都使用cglib字节码增强
     * 三、全自动
     *
     * aspectJ
     */
}
