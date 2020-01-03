package com.springboot.hello._20190917Ioc._01注册bean._20200103读取xml文件;

import com.springboot.hello._20190917Ioc._00Constant.SpringConstants;
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
