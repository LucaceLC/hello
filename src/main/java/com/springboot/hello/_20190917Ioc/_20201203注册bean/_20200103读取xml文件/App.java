package com.springboot.hello._20190917Ioc._20201203注册bean._20200103读取xml文件;

import com.springboot.hello._20190917Ioc._20201202Constant.SpringConstants;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    @Test
    public void iocWithXmlFunction(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(SpringConstants.Ioc.XML_PATH_20200103_01);
        UserService userService = (UserService)context.getBean("userService");
        userService.insertUser();
    }
}
