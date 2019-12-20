package com.springboot.hello._20191217反射机制._201912192001获取类的属性方法;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class App {

    @Test
    public void classMethodAndFieldFunction() throws Exception{
        String classPath  = "com.springboot.hello._20191217反射机制._201912192001获取类的属性方法.User";
        Class<User> userClazz = (Class<User>) Class.forName(classPath);

        /**
         * 获取类的所有属性
         * 方法
         * 构造器
         */

        //public属性
        Field[] publicFields = userClazz.getFields();
        assertEquals(1, publicFields.length);

        //所有属性
        Field[] declaredFields = userClazz.getDeclaredFields();
        assertEquals(3, declaredFields.length);

        //构造器
        //无参构造器
        Constructor<User> defaultConstructor = userClazz.getConstructor(null);
        User user = defaultConstructor.newInstance();
        user.setId(1L);
        user.setName("first Name");

        //有参构造器
        Constructor<User> allArgsConstructor = userClazz.getConstructor(Long.class, String.class);
        User secondUser= allArgsConstructor.newInstance(2L, "second name");

        //方法
        Method[] publicMethod = userClazz.getMethods();
        Method[] declaredMethods = userClazz.getDeclaredMethods();

        //反射调用public方法
        Method setNameMethod = userClazz.getMethod("setName", String.class);
        setNameMethod.invoke(secondUser,"three name");
        assertEquals("three name",secondUser.getName());

        //操作域
        Field publicVariable = userClazz.getField("publicVariable");
        publicVariable.set(user,"public variable");
        assertEquals("public variable",user.getPublicVariable());

    }
}
