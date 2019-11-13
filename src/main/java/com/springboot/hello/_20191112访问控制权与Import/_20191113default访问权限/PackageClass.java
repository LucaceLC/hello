package com.springboot.hello._20191112访问控制权与Import._20191113default访问权限;

import org.junit.jupiter.api.Test;

public class PackageClass {

    @Test
    public void defaultFuc(){
        /**
         * 编译错误：
         *  MyDefaultClass  myDefaultClass = new MyDefaultClass();
         *
         *  MyDefaultClass 没有public访问修饰符，使用默认包访问权限限制，所以作为其他包下的类，使用import无法引用
         *  编译器报错：Cannot be accessed from outside package
         *  不能从外部包访问类
         */
    }
}
