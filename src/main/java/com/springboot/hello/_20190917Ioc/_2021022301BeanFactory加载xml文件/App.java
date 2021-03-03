package com.springboot.hello._20190917Ioc._2021022301BeanFactory加载xml文件;

import com.springboot.hello._20190917Ioc._20201202Constant.SpringConstants;
import com.springboot.hello._20190917Ioc._20201204赋值bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class App {
    /**
     * 什么是Ioc,什么是DI
     *
     * IOC是控制反转，将对象实例的创建交给spring容器，以前是自己new对象，现在spring容器初始化帮我们创建好了
     * DI是依赖注入，
     *  依赖：一个对象需要使用另一个对象
     *  注入，通过set方法进行成员变量的设置
     * 类中存在其他实力的依赖，再创建对象实例的时候，会先创建依赖的实例，然后调用set方法，注入进去
     */
    @Test
    public void fucIoc(){
        /**
         * 从路径下加载xml，应用上下文
         * 初始化spring容器
         * 获取id的实体bean，强转
         * 执行bean的方法
         * 关闭容器
         */
        BeanFactory beanFactory =new XmlBeanFactory(new ClassPathResource(SpringConstants.Ioc.XML_PATH)) ;
        Car car = (Car)beanFactory.getBean("car");
        System.out.println(car);

    }
}
