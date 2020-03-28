package com.springboot.hello._20200328注解与反射._032802反射获取的类的类型;

import com.springboot.hello._20200328注解与反射._032801自定义注解.MyField;
import org.junit.jupiter.api.Test;

public class App {


    @Test
    public void reflentionTypeFunction() throws Exception{
        Class<Integer> intClazz = int.class;

        Class<Integer> integerClazz = Integer.class;

        Class<MyField> myFieldAnnotationClazz = MyField.class;

        Class<OrderType> enumTypeClazz = OrderType.class;

        Class<?> userClazz = Class.forName("com.springboot.hello._20200328注解与反射._032802反射获取的类的类型.User");

        Class<int[]> intArrayClazz = int[].class;

        Class<String[][]> stringArrayClazz = String[][].class;

        Class<Void> voidClazz = void.class;
    }
}
