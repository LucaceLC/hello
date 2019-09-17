package com.springboot.hello._20190910Value注解;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {

    /**
     * 使用@Value注解，使用注解值方式
     *  1直接填写字符串
     *  2使用SpEL表达式 #{}
     *  3使用${}表达式，@PropertySource 注解引入资源
     */

    @Value("张三")
    private String name1;

    @Value("#{20-1}")
    private String name2;

    @Value("${person.name}")
    private String name3;
}
