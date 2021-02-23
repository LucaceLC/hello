package com.springboot.hello._20200328注解与反射._033001通过反射操作类;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    @Test
    public void useClassFunction() throws Exception{
        String path = "com.springboot.hello._20200328注解与反射._033001通过反射操作类.User";
        Class<?> userClazz = Class.forName(path);
        //1操作类，操作构造器，操作方法，操作属性
        String userClazzPath = userClazz.getName();
        String userClazzName = userClazz.getSimpleName();
        System.out.println(userClazzPath);
        System.out.println(userClazzName);

        //调用有参构造器
        Constructor<?> userConstructor = userClazz.getDeclaredConstructor(Long.class, String.class);
        User jack = (User)userConstructor.newInstance(1L, "jack");
        System.out.println(jack);

        //默认构造器
        Constructor<?> defaultConstructor = userClazz.getConstructor();
        User defaultUser = (User)defaultConstructor.newInstance();
        System.out.println(defaultUser);

        //直接调用无参构造器
        User noUseDefaultUser = (User)userClazz.newInstance();

        //调用方法,只能是公有方法
        Method setUserNameMethod = userClazz.getMethod("setUserName", String.class);
        setUserNameMethod.invoke(noUseDefaultUser,"jack2");

        //直接调用私有方法跑出异常NoSuchMethodException
        Assertions.assertThrows(NoSuchMethodException.class,()->{userClazz.getMethod("setDefaultUserName");});

        //调用私有方法
        User defaultUser2 = (User)userClazz.newInstance();
        Method setDefaultUserNameMethod = userClazz.getDeclaredMethod("setDefaultUserName");
        setDefaultUserNameMethod.setAccessible(true);
        setDefaultUserNameMethod.invoke(defaultUser2);
        System.out.println(defaultUser2);

        //直接操作属性,getField只能获取公有属性
        User defaultUser3 = (User)userClazz.newInstance();
        Field userNameField = userClazz.getDeclaredField("userName");
        userNameField.setAccessible(true);
        userNameField.set(defaultUser3,"jack3");
        System.out.println(defaultUser3);

    }
}
