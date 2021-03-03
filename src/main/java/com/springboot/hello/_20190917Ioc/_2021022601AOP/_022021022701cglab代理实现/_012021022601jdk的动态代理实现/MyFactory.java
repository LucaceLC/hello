package com.springboot.hello._20190917Ioc._2021022601AOP._022021022701cglab代理实现._012021022601jdk的动态代理实现;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyFactory {

    public UserServiceImpl createUserServiceImpl(){
        /**
         * 目标类
         * 切面类
         * 工厂生产代理对象，把目标类和切面类结合
         */
        final UserServiceImpl userService = new UserServiceImpl();
        MyAspect aspect = new MyAspect();
        /**
         * 核心类
         * 设置代理的父类方法
         * 设置回调方法
         * 创建代理对象
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * @param obj 代理对象
             * @param method 代理方法
             * @param objects 参数
             * @param methodProxy 方法的代理
             */
            @Override
            public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                aspect.before();
                //调用目标类的== methodProxy.invokeSuper(obj,objects);
                Object invoke = method.invoke(userService, objects);
                aspect.after();
                return invoke;

            }
        });
        UserServiceImpl proxy = (UserServiceImpl)enhancer.create();
        return proxy;
    }
}
