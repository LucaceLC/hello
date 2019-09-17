package com.springboot.hello._20190804Guava.Preconditinos;

import com.google.common.base.Preconditions;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *  校验方式，无分好坏，适合习惯最佳
 *  JUnit断言 Assert
 *  Spring断言 Assert
 *  JDK assert boolean expression : erroStrMessage;
 *  Guava Preconditions
 *
 * </p>
 */
public class PreconditionsTest {

    //带参数模版的异常检验  java.lang.IllegalArgumentException: 参数错误：hello,world
    //import org.springframework.util.Assert; 的不能带参数表达式
    @Test
    public void errorStrTemplate(){
        Preconditions.checkArgument(false,"参数错误：%s,%s","hello","world");
    }


    //jdk自带的断言机制
    @Test
    public void fucJdkAssert(){
        assert false : "assert exception !";
    }
}
