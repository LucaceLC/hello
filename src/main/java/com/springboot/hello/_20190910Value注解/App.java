package com.springboot.hello._20190910Value注解;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class App {

    AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(ValueConfig.class);

    @Test
    public void fucValueAnnotation(){
        //获取bean的名称
        String[] contextBeanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(contextBeanDefinitionNames).forEach(System.out::println);

        Person person = context.getBean(Person.class);
        System.out.println(person);

        context.close();
    }
}
