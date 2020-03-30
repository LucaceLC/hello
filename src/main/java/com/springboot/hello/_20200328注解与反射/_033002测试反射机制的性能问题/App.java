package com.springboot.hello._20200328注解与反射._033002测试反射机制的性能问题;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class App {

    /**
     * 21991 ms
     * 24869 ms
     * 14516 ms
     *
     * 100亿次
     * 环境jdk11，并没有感觉反射影响性能，放开安全检查后
     */
    @Test
    public void useTimeFunction() throws Exception{
        defaultUsingFunction();
        reflentionUsingFunction();
        reflentionUsingFunctionWithTrue();
    }


    public long defaultUsingFunction(){
        long startTime = System.currentTimeMillis();
        User user = new User();
        for (long i = 0; i < 10000000000L; i++) {
            user.getUserName();
        }
        long usingTime = System.currentTimeMillis() - startTime;
        System.out.println(usingTime);
        return usingTime;
    }

    public long reflentionUsingFunction() throws Exception{
        User user = new User();
        Class<? extends User> userClazz = user.getClass();
        Method getUserName = userClazz.getDeclaredMethod("getUserName");
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < 10000000000L; i++) {
            getUserName.invoke(user);
        }
        long usingTime = System.currentTimeMillis() - startTime;
        System.out.println(usingTime);
        return usingTime;
    }

    public long reflentionUsingFunctionWithTrue() throws Exception{
        User user = new User();
        Class<? extends User> userClazz = user.getClass();
        Method getUserName = userClazz.getDeclaredMethod("getUserName");
        getUserName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (long i = 0; i < 10000000000L; i++) {
            getUserName.invoke(user);
        }
        long usingTime = System.currentTimeMillis() - startTime;
        System.out.println(usingTime);
        return usingTime;
    }
}
