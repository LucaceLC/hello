package com.springboot.hello._20191217反射机制._20191217自定义注解;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = METHOD)
@Retention(value = RUNTIME)
public @interface MyAnnotation {
    /**
     * 可以作用的范围
     * Target
     *   常用的是Type 类
     *          METHOD 方法
     *          PARAMETER 方法参数
     *          FIELD 成员变量上
     */

    /**
     * 注解的保留策略
     * Retention
     *  RUNTIME 常用  运行时保存，可以利用反射机制读取注解，来完成切面操作
     *  SOURCE  只在java文件中保存
     *  CLASS   只在class文件中保存
     */

    /**
     * 注解有属性值
     * String[] 第一个参数表示属性值类型，
     * value 属性名称
     * default 属性值是否拥有默认值
     */
    String[] value() default "";
}
