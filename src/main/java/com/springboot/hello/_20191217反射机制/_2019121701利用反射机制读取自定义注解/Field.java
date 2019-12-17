package com.springboot.hello._20191217反射机制._2019121701利用反射机制读取自定义注解;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
public @interface Field {
    String value() default "";
    String fieldType();
    int fieldLength();

}
