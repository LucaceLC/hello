package com.springboot.hello._20191217反射机制._2019121701利用反射机制读取自定义注解;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

public class App {

    /**
     * https://www.jianshu.com/p/73a778c1b5b7
     **/
    @Test
    public void annotationFunction() throws Exception{

        Class<?> studentClass = Class.forName("com.springboot.hello._20191217反射机制._2019121701利用反射机制读取自定义注解.Student");

        AnnotatedType[] annotatedInterfaces = studentClass.getAnnotatedInterfaces();

        AnnotatedType annotatedSuperclass = studentClass.getAnnotatedSuperclass();

        //获取指定注解
        Table tableAnnotation = studentClass.getAnnotation(Table.class);

        //获取注解的集合
        Annotation[] annotations = studentClass.getAnnotations();

        Table[] annotationsByType = studentClass.getAnnotationsByType(Table.class);
        Arrays.stream(annotationsByType).forEach(System.out::println);
        System.out.println(annotationsByType.length);

        Table declaredAnnotation = studentClass.getDeclaredAnnotation(Table.class);
        Annotation[] declaredAnnotations = studentClass.getDeclaredAnnotations();
        Table[] declaredAnnotationsByType = studentClass.getDeclaredAnnotationsByType(Table.class);
    }
}
