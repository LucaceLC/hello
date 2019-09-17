package com.springboot.hello._20190917Ioc._01注册bean;

import com.springboot.hello._20190917Ioc._00Constant.SpringConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

@Slf4j
public class App {
    @Test
    public void fucIoc(){
        /**
         * 从路径下加载xml，应用上下文
         * 初始化spring容器
         * 获取id的实体bean，强转
         * 执行bean的方法
         * 关闭容器
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(SpringConstants.Ioc.XML_PATH);

        int beanCount = context.getBeanDefinitionCount();
        System.out.println("beanCount = " + beanCount);

        String[] beanNames = context.getBeanDefinitionNames();
        Stream.of(beanNames).forEach(System.out::println);

        try {
            PersonService personService = (PersonService)context.getBean("personService");
            personService.saveUser();
        }finally {
            context.close();
        }
    }
}
