package com.springboot.hello._20190917Ioc._03验证bean作用域;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person person2(){
        Person person = new Person();
        person.setId(1L);
        person.setName("第一个人");
        return person;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PersonService personService2(){
        return new PersonSerivceImpl();
    }
}
