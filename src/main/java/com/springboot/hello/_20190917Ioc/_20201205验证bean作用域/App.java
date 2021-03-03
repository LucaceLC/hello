package com.springboot.hello._20190917Ioc._20201205验证bean作用域;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * 1所有bean管理
 * 2bean的默认作用域是单例的，原型是创建新的bean
 *      一共物种生命周期 单例 原型 request session global_session
 *      Spring应用的作用域: {@link ConfigurableBeanFactory} 类 标准作用域范围：singleton prototype
 *      只有Web应用才可以设置Web应用作用域：{@link WebApplicationContext}类 request-请求 session-会话 application-全局
 */
public class App {

    @Test
    public void fucConfig(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        /**
         * 两次bean都是新的，并且注入的person实例也是新的
         */
        PersonService oldPersonService = (PersonService)context.getBean("personService");
        oldPersonService.saveUser();

        PersonService newPersonService = (PersonService)context.getBean("personService");
        newPersonService.updateUser();

        context.close();
    }
}
