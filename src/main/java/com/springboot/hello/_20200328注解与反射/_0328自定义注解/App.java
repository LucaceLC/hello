package com.springboot.hello._20200328注解与反射._0328自定义注解;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class App {

    @Test
    public void annotationFunction() throws Exception{
        Class<?> studentClazz = Class.forName("com.springboot.hello._20200328注解与反射._0328自定义注解.Student");

        //获取这个类的所有注解
        Annotation[] annotations = studentClazz.getAnnotations();

        //获取指定类型的注解
        MyTable annotation = studentClazz.getAnnotation(MyTable.class);
        Assertions.assertEquals("tbl_student",annotation.value());

        /**
         * 在field上的注解获取，要先获取字段，然后通过字段来获取属性注解
         */
        Field studentName = studentClazz.getDeclaredField("studentName");
        Annotation[] fieldAnnotation = studentName.getAnnotations();

        //获取属性上的注解内容
        MyField myField = studentName.getAnnotation(MyField.class);
        System.out.println(myField.value() +  myField.fieldType() + myField.fieldLength());
    }
}
