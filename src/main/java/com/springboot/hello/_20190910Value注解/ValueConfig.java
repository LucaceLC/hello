package com.springboot.hello._20190910Value注解;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class ValueConfig {

    @Bean
    public Person person(){
        return new Person();
    }


}
