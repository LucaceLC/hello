package com.springboot.hello._20200328注解与反射._0328自定义注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {
    String value();
    String fieldType();
    int fieldLength() default 0;
}
