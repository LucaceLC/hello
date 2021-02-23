package com.springboot.hello._20200104一种配置变量初始化的方法;

import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void valueFunction(){
        System.out.println(UrlConstants.RPC_PAY_URL);
    }

    @Test
    public void interfaceValueFunction(){
        System.out.println(RpcUrl.Pay.RPC_PAY_URL);
    }

}
