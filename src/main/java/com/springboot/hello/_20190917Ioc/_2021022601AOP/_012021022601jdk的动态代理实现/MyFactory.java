package com.springboot.hello._20190917Ioc._2021022601AOP._012021022601jdk的动态代理实现;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactory {

    public UserService createUserService(){
        /**
         * 目标类
         * 切面类
         * 工厂生产代理对象，把目标类和切面类结合
         */
        final UserService userService = new UserServiceImpl();
        MyAspect aspect = new MyAspect();
        /**
         * 参数，当前类的类加载器
         * 参数2，目标类的所有接口
         * 参数3，invocationHandler处理器对象
         */
        Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * @param proxy 在运行期创建的代理对象
             * @param method 代理对象当前运行的方法,代理类的每一个方法在执行时，都会调用一次invoke方法
             * @param args 参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                aspect.before();
                Object obj = method.invoke(userService, args);
                aspect.after();
                return obj;
            }
        });

        return (UserService)proxyInstance;
    }
}
