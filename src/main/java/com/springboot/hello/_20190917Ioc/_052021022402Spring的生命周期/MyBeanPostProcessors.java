package com.springboot.hello._20190917Ioc._052021022402Spring的生命周期;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.stream.Stream;

public class MyBeanPostProcessors implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Annotation[] annotations = bean.getClass().getAnnotations();
        Stream.of(annotations).forEach(annotation -> {
            if(annotation instanceof Data){
                System.out.printf("有@Data注解");
            }
        });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        /**
         * 如果是return bean，初始化后，执行after方法，做一些处理，但是
         * 可以返回一个代理对象，newProxyInstance,返回的代理对象会替换目标对象
         * 当目标对象执行.method()方法时，此时将执行invoke()代理方法，那么就可以在代理方法里做一些处理
         */
        if(bean instanceof App){
            //生产jdk代理，生产代理对象，目的是在目标方法调用的前后执行（）
            return Proxy.newProxyInstance(MyBeanPostProcessors.class.getClassLoader(),
                    bean.getClass().getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //目标类的所有方法，都会进入代理
                            System.out.printf("开启事物");
                            //init方法
                            Object invokeObj = method.invoke(bean, args);
                            System.out.printf("关闭事物");
                            return invokeObj;
                        }
                    });
        }
        return bean;
    }
}
